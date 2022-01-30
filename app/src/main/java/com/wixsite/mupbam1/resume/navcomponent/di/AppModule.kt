package com.wixsite.mupbam1.resume.navcomponent.di

import android.app.Application
import android.content.Context
import com.wixsite.mupbam1.resume.navcomponent.database.AppDatabase
import com.wixsite.mupbam1.resume.navcomponent.database.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Singleton
    @Provides
    fun getUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun getRoomDBInstance():AppDatabase{
        return AppDatabase.getAppDatabaseInstance(provideAppContext())
    }

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return application.applicationContext

    }
}