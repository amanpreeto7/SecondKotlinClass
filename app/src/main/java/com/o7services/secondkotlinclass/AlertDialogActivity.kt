package com.o7services.secondkotlinclass

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.o7services.secondkotlinclass.databinding.LayoutCustomBinding

class AlertDialogActivity : AppCompatActivity() {
    lateinit var fabCustomDialog: FloatingActionButton
    lateinit var btnCustomLayout: Button
    lateinit var tvText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        fabCustomDialog = findViewById(R.id.fabCustomDialog)
        btnCustomLayout = findViewById(R.id.btnCustomLayout)
        tvText = findViewById(R.id.tvText)
        fabCustomDialog.setOnClickListener {
            var arrayList = arrayOf("qwerty","uiop","asdf")
            var alertDialog = AlertDialog.Builder(this).apply {
                setTitle("Title")
              //  setMessage("Message")
                setItems(arrayList,{_,position->
                    Toast.makeText(this@AlertDialogActivity, "position ${arrayList[position]}", Toast.LENGTH_SHORT).show()
                })
                setCancelable(false)
            }.show()
        }

        btnCustomLayout.setOnClickListener {
            var dialogBinding = LayoutCustomBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.etAmount.setText(tvText.text.toString())
            dialogBinding.btnOk.setOnClickListener {
                if(dialogBinding.etAmount.text.toString().isNullOrEmpty()){
                    Toast.makeText(this, "enter amount", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                tvText.setText(dialogBinding.etAmount.text.toString())
                dialog.dismiss()
            }

            dialog.show()
        }
    }
}