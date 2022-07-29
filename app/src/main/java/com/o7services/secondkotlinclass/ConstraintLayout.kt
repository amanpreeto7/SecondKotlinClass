package com.o7services.secondkotlinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.ContextCompat

class ConstraintLayout : AppCompatActivity() {
    lateinit var  ivTwo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        ivTwo = findViewById(R.id.ivTwo)
        ivTwo.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_launcher_foreground))
    }
}