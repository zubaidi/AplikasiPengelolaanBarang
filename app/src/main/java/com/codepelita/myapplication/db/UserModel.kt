package com.codepelita.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    @ColumnInfo(name = "nama_user")
    var namaUser: String,
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "password")
    var password: String
)
