package com.codepelita.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.codepelita.myapplication.databinding.ActivityTambahUserBinding

class TambahUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cbShowPass.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                binding.editInputPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                binding.editInputPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }
}