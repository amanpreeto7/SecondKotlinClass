package com.o7services.secondkotlinclass

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class PermissionsActivity : AppCompatActivity() {
    lateinit var btnPermission: Button
    lateinit var btnMulPermissions: Button
    lateinit var image: ImageView
    var requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission())
        {isGranted->
            if(isGranted){
                getImage.launch("image/*")
                Toast.makeText(this, " permission granted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, " permission denied", Toast.LENGTH_SHORT).show()
            }
    }

    var requestMulPermissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()){

    }

    var getImage = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ){
        System.out.println("uri $it")
        image.setImageURI(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        btnPermission = findViewById(R.id.btnPermission)
        btnMulPermissions = findViewById(R.id.btnMulPermissions)
        image = findViewById(R.id.image)
        btnPermission.setOnClickListener {
            when{
                ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED->
            {
                getImage.launch("image/*")
            }
            shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE) -> {
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Testing")
                alertDialog.show()
            }
            else ->
                requestPermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

        }

    }
    }
}