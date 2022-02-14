package com.mltec.lib_application

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}