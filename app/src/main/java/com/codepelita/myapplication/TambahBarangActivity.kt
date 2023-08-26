package com.codepelita.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepelita.myapplication.databinding.ActivityTambahBarangBinding
import com.codepelita.myapplication.db.BarangModel
import com.codepelita.myapplication.db.DBBarang
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TambahBarangActivity : AppCompatActivity() {

    private val tambahBarangBinding: ActivityTambahBarangBinding by lazy {
        ActivityTambahBarangBinding.inflate(layoutInflater)
    }
    private val db by lazy { DBBarang(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tambahBarangBinding.root)
        tambahBarangBinding.btnSimpan.setOnClickListener {
            this.simpanDataBarang()
        }
    }

    private fun simpanDataBarang() {
        CoroutineScope(Dispatchers.IO).launch {
            db.barangDao().insertBarang(
                BarangModel(
                    null,
                    tambahBarangBinding.editInputKodeBarang.text.toString().toInt(),
                    tambahBarangBinding.editInputNamaItem.text.toString(),
                    tambahBarangBinding.editInputStok.text.toString().toInt(),
                    tambahBarangBinding.editInputHarga.text.toString().toInt()
                )
            )
            finish()
        }
    }
}