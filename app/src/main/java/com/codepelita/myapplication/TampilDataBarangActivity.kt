package com.codepelita.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepelita.myapplication.adapter.AdapterBarang
import com.codepelita.myapplication.databinding.ActivityTampilDataBarangBinding
import com.codepelita.myapplication.db.DBBarang
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TampilDataBarangActivity : AppCompatActivity() {

    private val tampilDataBarangBinding: ActivityTampilDataBarangBinding by lazy {
        ActivityTampilDataBarangBinding.inflate(layoutInflater)
    }
    private val db by lazy { DBBarang(this) }
    private lateinit var adapterBarang: AdapterBarang

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tampilDataBarangBinding.root)
        adapterBarang = AdapterBarang(arrayListOf())
        tampilDataBarangBinding.ivKembali.setOnClickListener {
            startActivity(Intent(
                this, BarangActivity::class.java
            ))
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        this.getDataBarang()
    }

    private fun getDataBarang() {
        tampilDataBarangBinding.listDataBarang.layoutManager = LinearLayoutManager(this)
        CoroutineScope(Dispatchers.IO).launch {
            val dataBarang = db.barangDao().getAllDataBarang()
            adapterBarang.setData(dataBarang)
            withContext(Dispatchers.Main) {
                adapterBarang.notifyDataSetChanged()
            }
        }
        tampilDataBarangBinding.listDataBarang.adapter = adapterBarang
    }
}