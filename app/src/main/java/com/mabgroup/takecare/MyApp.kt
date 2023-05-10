package com.mabgroup.takecare

import android.app.Application
import com.mabgroup.takecare.common.utils.StartUpApp
import com.mabgroup.takecare.common.utils.StartUpAppImpl

class MyApp : Application() {

    private val applicationSetUp : StartUpApp by lazy { StartUpAppImpl() }

    override fun onCreate() {
        super.onCreate()
        applicationSetUp.prepareDependencyInjection(this@MyApp)
    }
}