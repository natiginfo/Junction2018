package com.hackjunction.mobility

import android.app.Application
import com.fleetboard.sdk.lib.android.common.SDKInitializer
import timber.log.Timber

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        try {
            SDKInitializer.INSTANCE.init(this)
        } catch (e: Exception) {
            Timber.i(e)
        }


    }
}
