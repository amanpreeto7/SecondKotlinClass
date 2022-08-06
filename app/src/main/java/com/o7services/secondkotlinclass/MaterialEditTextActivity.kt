package com.o7services.secondkotlinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.o7services.secondkotlinclass.databinding.ActivityMaterialEditTextBinding

class MaterialEditTextActivity : AppCompatActivity() {
    lateinit var binding: ActivityMaterialEditTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etEmail.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)==0){
                binding.tilEmail.error = resources.getString(R.string.enter_email)
            }
        }

        binding.etPassword.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)<6){
                binding.tilPassword.error = resources.getString(R.string.enter_password)
            }else{
                binding.tilPassword.error = null
            }
        }
    }
}