package com.codepelita.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepelita.myapplication.databinding.ActivityBarangBinding

class BarangActivity : AppCompatActivity() {
    private val binding: ActivityBarangBinding by lazy {
        ActivityBarangBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnTambahDataBarang.setOnClickListener {
            startActivity(Intent(
                this, TambahBarangActivity::class.java
            ))
            finish()
        }
        binding.btnTampilDataBarang.setOnClickListener {
            startActivity(Intent(
                this, TampilDataBarangActivity::class.java
            ))
            finish()
        }
        binding.imageView.setOnClickListener {
            startActivity(Intent(
                this, MainActivity::class.java
            ))
            finish()
        }
    }
}