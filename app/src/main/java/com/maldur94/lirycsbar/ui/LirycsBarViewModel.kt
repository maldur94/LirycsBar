package com.maldur94.lirycsbar.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.maldur94.database.model.Liryc
import com.maldur94.domain.lirycs.LirycsUseCase
import com.maldur94.lirycsbar.util.ViewModel.startRefreshingAndInvokeAction
import com.maldur94.lirycsbar.util.ViewModel.stopRefreshing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LirycsBarViewModel @Inject constructor(private val lirycsUseCase: LirycsUseCase) :
    ViewModel(),
    SwipeRefreshLayout.OnRefreshListener {

    private val _lirycs = MutableStateFlow<List<Liryc>>(emptyList())
    val lirycs = _lirycs

    override fun onRefresh() {
        startRefreshingAndInvokeAction {
            getLirycs()
        }
    }

    fun getLirycs() {
        viewModelScope.launch {
            lirycsUseCase.execute()?.let { _lirycs.emit(it) }
            stopRefreshing()
        }
    }
}
