package com.codepelita.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepelita.myapplication.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(
                this, TambahUserActivity::class.java
            ))
        }
    }
}