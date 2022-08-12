package com.o7services.secondkotlinclass

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.o7services.secondkotlinclass.databinding.ActivitySharedPrefsBinding

class SharedPrefsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySharedPrefsBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(
            resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if(sharedPreferences.contains("date")){
            binding.et.setText(sharedPreferences.getString("date",""))
        }

        binding.btnSave.setOnClickListener {
            if(binding.et.text.isNullOrEmpty()){
                binding.et.error = "Enter value to save"
            }else{
               editor.putString("date", binding.et.text.toString())
                editor.commit()
            }
        }

        binding.btnRemove.setOnClickListener {
            editor.clear()
            //to remove a specific value
            editor.remove("date")
            editor.commit()
        }


    }
}