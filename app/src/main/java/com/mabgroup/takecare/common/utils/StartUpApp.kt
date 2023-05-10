package com.mabgroup.takecare.common.utils

import android.content.Context

interface StartUpApp {

    fun prepareDependencyInjection(androidContext:Context)
}