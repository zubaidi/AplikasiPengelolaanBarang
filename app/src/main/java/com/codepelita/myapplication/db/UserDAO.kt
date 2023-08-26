package com.codepelita.myapplication.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface UserDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(userModel: UserModel)

    @Update
    suspend fun updateUser(userModel: UserModel)

    @Delete
    suspend fun deleteUser(userModel: UserModel)

    @Query("SELECT * FROM usermodel")
    fun getAllUser() : List<UserModel>

}