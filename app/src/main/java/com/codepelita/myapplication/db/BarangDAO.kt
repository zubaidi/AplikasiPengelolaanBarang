package com.codepelita.myapplication.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BarangDAO {

    @Query("SELECT * FROM barangmodel")
    fun getAllDataBarang() : List<BarangModel>

    @Insert(onConflict = REPLACE)
    suspend fun insertBarang(barangModel: BarangModel)

    @Update
    suspend fun updateBarang(barangModel: BarangModel)

    @Delete
    suspend fun deleteBarang(barangModel: BarangModel)

}