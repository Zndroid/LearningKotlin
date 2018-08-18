package com.hakz.learningkotlin.ui

import android.app.Application
import com.hakz.learningkotlin.extensions.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}