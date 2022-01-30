package com.wixsite.mupbam1.resume.navcomponent.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.wixsite.mupbam1.resume.navcomponent.database.UserDao
import com.wixsite.mupbam1.resume.navcomponent.database.UserEntity
import javax.inject.Inject

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    @Inject
    lateinit var userDao: UserDao
    lateinit var allUserList: MutableLiveData<List<UserEntity>>
    init {
        (application as MyApp).getAppComponent().inject(this)

        allUserList= MutableLiveData()
        getAllRecords()
    }

    fun getRecordsObserver(): MutableLiveData<List<UserEntity>> {
        return allUserList
    }

    fun getAllRecords(){
        val list=userDao.getAllRecordsFromDB()
        allUserList.postValue(list)
    }

    fun insertRecord(userEntity: UserEntity){
        userDao.insertRecord(userEntity)
        getAllRecords()
    }
}
