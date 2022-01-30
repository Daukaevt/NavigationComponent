package com.wixsite.mupbam1.resume.navcomponent.di

import android.app.Application

class MyApp: Application() {

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
    fun getAppComponent():AppComponent{
        return appComponent
    }




}