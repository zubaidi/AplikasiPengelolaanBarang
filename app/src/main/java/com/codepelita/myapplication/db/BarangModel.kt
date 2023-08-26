package com.codepelita.myapplication.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BarangModel(
    @PrimaryKey(autoGenerate = true)
    var id_barang: Int?,
    @ColumnInfo(name = "kdBrg")
    var kodeBarang: Int,
    @ColumnInfo(name = "namaBrg")
    var namaBarang: String,
    @ColumnInfo(name = "stokBrg")
    var stokBarang: Int,
    @ColumnInfo(name = "hargaBeli")
    var hargaBeli: Int,
)
