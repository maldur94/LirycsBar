package com.maldur94.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.SetOptions
import com.maldur94.database.model.Constants.TITLE
import com.maldur94.database.model.Liryc
import com.maldur94.database.model.Response
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LirycsRepositoryImpl @Inject constructor(private val lirycsRef: CollectionReference) :
    LirycsRepository {

    override suspend fun getLirycsFromFirebase() = callbackFlow {
        val snapshotListener = lirycsRef.orderBy(TITLE).addSnapshotListener { snapshot, e ->
            val booksResponse = if (snapshot != null) {
                val books = snapshot.toObjects(Liryc::class.java)
                Response.Success(books)
            } else {
                Response.Failure(e)
            }
            trySend(booksResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override suspend fun addLirycToFirebase(liryc: Liryc) = try {
        lirycsRef.document(getLirycId()).set(liryc.copy(id = getLirycId())).await()
        Response.Success(true)
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun editLirycToFirebase(oldAndNewLirycs: Pair<Liryc, Liryc>): StatusResponse {
        val mapOfValues = getMapOfValues(oldAndNewLirycs.second)
        val lirycQuery = getQuerySnapshot(oldAndNewLirycs.first)
        if (lirycQuery.documents.isNotEmpty()) {
            for (document in lirycQuery) {
                return try {
                    lirycsRef.document(document.id).set(
                        mapOfValues,
                        SetOptions.merge()
                    ).await()
                    Response.Success(true)
                } catch (e: Exception) {
                    Response.Failure(e)
                }
            }
            return Response.Success(true)
        } else {
            return Response.Failure(Exception("No items the document"))
        }
    }

    override suspend fun removeLirycFromFirebase(liryc: Liryc): StatusResponse {
        val lirycQuery = getQuerySnapshot(liryc)
        if (lirycQuery.documents.isNotEmpty()) {
            for (document in lirycQuery) {
                return try {
                    lirycsRef.document(document.id).delete().await()
                    Response.Success(true)
                } catch (e: Exception) {
                    Response.Failure(e)
                }
            }
            return Response.Success(true)
        } else {
            return Response.Failure(Exception("No items the document"))
        }
    }

    private fun getMapOfValues(liryc: Liryc): MutableMap<String, Any> {
        val id = liryc.id
        val title = liryc.title
        val description = liryc.description
        val iconUrl = liryc.iconUrl
        val map = mutableMapOf<String, Any>()
        if (id?.isNotEmpty() == true) {
            map["id"] = id
        }
        if (title.isNotEmpty()) {
            map["title"] = title
        }
        if (description.isNotEmpty()) {
            map["description"] = description
        }
        if (iconUrl?.isNotEmpty() == true) {
            map["iconUrl"] = title
        }
        return map
    }

    private suspend fun getQuerySnapshot(liryc: Liryc) = lirycsRef
        .whereEqualTo("id", liryc.id)
        .whereEqualTo("title", liryc.title)
        .whereEqualTo("description", liryc.description)
        .whereEqualTo("iconUrl", liryc.iconUrl)
        .get()
        .await()

    private fun getLirycId() = lirycsRef.document().id
}
