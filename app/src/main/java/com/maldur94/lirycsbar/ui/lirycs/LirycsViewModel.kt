package com.maldur94.lirycsbar.ui.lirycs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.maldur94.database.model.Liryc
import com.maldur94.database.model.Response
import com.maldur94.domain.lirycs.AddLirycUseCase
import com.maldur94.domain.lirycs.EditLirycUseCase
import com.maldur94.domain.lirycs.GetLirycsUseCase
import com.maldur94.domain.lirycs.RemoveLirycUseCase
import com.maldur94.lirycsbar.model.LirycActions
import com.maldur94.lirycsbar.util.ViewModel.startRefreshingAndInvokeAction
import com.maldur94.lirycsbar.util.ViewModel.stopRefreshing
import com.maldur94.repository.LirycsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LirycsViewModel @Inject constructor(
    private val getLirycsUseCase: GetLirycsUseCase,
    private val addLirycUseCase: AddLirycUseCase,
    private val editLirycUseCase: EditLirycUseCase,
    private val removeLirycUseCase: RemoveLirycUseCase
) : ViewModel(), LirycActions, SwipeRefreshLayout.OnRefreshListener {

    private val _lirycs = MutableStateFlow<LirycsResponse>(Response.Success(emptyList()))
    val lirycs = _lirycs

    override fun onRefresh() {
        startRefreshingAndInvokeAction {
            getLirycs()
        }
    }

    fun getLirycs() {
        viewModelScope.launch {
            getLirycsUseCase.execute()?.let {
                it.collect { lirycsResponse ->
                    _lirycs.emit(lirycsResponse)
                }
            }
            stopRefreshing()
        }
    }

    override fun addLiryc(liryc: Liryc) {
        viewModelScope.launch {
            addLirycUseCase.execute(liryc)?.let { if (it.isSucceed()) getLirycs() }
            stopRefreshing()
        }
    }

    override fun editLiryc(oldLiryc: Liryc, newLiryc: Liryc) {
        viewModelScope.launch {
            editLirycUseCase.execute(Pair(oldLiryc, newLiryc))?.let {
                if (it.isSucceed()) getLirycs()
            }
            stopRefreshing()
        }
    }

    override fun removeLiryc(liryc: Liryc) {
        viewModelScope.launch {
            removeLirycUseCase.execute(liryc)?.let { if (it.isSucceed()) getLirycs() }
            stopRefreshing()
        }
    }
}
