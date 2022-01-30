package com.wixsite.mupbam1.resume.navcomponent.di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivityViewModel: MainActivityViewModel)
}