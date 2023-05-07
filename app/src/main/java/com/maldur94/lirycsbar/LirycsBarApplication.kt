package com.maldur94.lirycsbar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import kotlin.system.exitProcess

private const val EXIT_STATUS = 2

@HiltAndroidApp
class LirycsBarApplication : Application() {

    init {
        initTimber()
        setDefaultExceptionHandler()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setDefaultExceptionHandler() {
        val oldHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Timber.e(throwable)
            if (oldHandler != null) {
                oldHandler.uncaughtException(thread, throwable)
            } else {
                exitProcess(EXIT_STATUS)
            }
        }
    }
}
