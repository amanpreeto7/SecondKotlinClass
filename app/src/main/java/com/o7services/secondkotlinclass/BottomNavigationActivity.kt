package com.o7services.secondkotlinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNav= findViewById(R.id.bottomNav)
        navController =findNavController(R.id.navController)

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    navController.navigate(R.id.firstFragment)
                }
                R.id.category->{
                    navController.navigate(R.id.secondFragment)

                }
                R.id.profile->{
                    Toast.makeText(this, "Third clicked", Toast.LENGTH_SHORT).show()
                }
                else->{}

            }
            return@setOnItemSelectedListener true
        }

    }
}