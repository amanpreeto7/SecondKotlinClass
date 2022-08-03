package com.o7services.secondkotlinclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.o7services.secondkotlinclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnMove.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("value", 1)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        System.out.println("on resume called")
    }
}