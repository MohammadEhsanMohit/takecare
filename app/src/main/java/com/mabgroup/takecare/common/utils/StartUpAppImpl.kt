package com.mabgroup.takecare.common.utils

import android.content.Context
import com.mabgroup.takecare.di.dataBase
import com.mabgroup.takecare.di.appModule
import com.mabgroup.takecare.di.repositoryModule
import com.mabgroup.takecare.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StartUpAppImpl : StartUpApp {

    override fun prepareDependencyInjection(appCtx: Context) {
        startKoin {
            androidContext(appCtx)
            modules(
                listOf(
                    appModule,
                    dataBase,
                    repositoryModule,
                    useCaseModule
                )
            )
        }
    }
}