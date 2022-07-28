package com.o7services.secondkotlinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    var intentValue = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        intent?.let {
            intentValue = it.getIntExtra("value", 0)
            System.out.println("intent value "+intentValue)
        }
    }
}