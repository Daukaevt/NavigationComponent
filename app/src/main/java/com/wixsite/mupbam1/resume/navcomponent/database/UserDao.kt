package com.wixsite.mupbam1.resume.navcomponent.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_entity ORDER BY id DESC")
    fun getAllRecordsFromDB():List<UserEntity>?

    @Insert
    fun insertRecord(userEntity: UserEntity)
}