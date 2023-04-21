package com.maldur94.lirycsbar.util

object ViewModel {

    private var isRefreshing = false

    fun startRefreshingAndInvokeAction(action: () -> Unit) {
        isRefreshing = true
        action.invoke()
    }

    fun stopRefreshing() {
        isRefreshing = false
    }
}
