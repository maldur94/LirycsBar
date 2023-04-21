package com.maldur94.lirycsbar.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.maldur94.lirycsbar.util.ViewModel.startRefreshingAndInvokeAction
import com.maldur94.lirycsbar.util.ViewModel.stopRefreshing
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LirycsBarViewModel @Inject constructor() : ViewModel(), SwipeRefreshLayout.OnRefreshListener {

    private val _lirycs = MutableStateFlow<List<String>>(emptyList())
    val lirycs = _lirycs

    override fun onRefresh() {
        startRefreshingAndInvokeAction {
            getLirycs()
        }
    }

    fun getLirycs() {
        viewModelScope.launch {
            _lirycs.emit(listOf("test1, test2, test3"))
            stopRefreshing()
        }
    }
}
