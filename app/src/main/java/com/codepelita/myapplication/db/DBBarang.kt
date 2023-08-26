package com.codepelita.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BarangModel::class, UserModel::class], version = 1, exportSchema = false)
abstract class DBBarang : RoomDatabase(){

    abstract fun barangDao(): BarangDAO
    companion object {
        @Volatile
        private var instance: DBBarang?= null
        private var key = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(key) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, DBBarang::class.java, "DBBarang"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

}