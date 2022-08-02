package com.o7services.secondkotlinclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class FragmentActivity : AppCompatActivity() {
    lateinit var activityInterface: ActivityInterface
    lateinit var btn: Button
    lateinit var btnAlertDialog: Button
    var i = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        btn = findViewById(R.id.btn)

        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btn.setOnClickListener {
            Snackbar.make(btn,
                "Snack bar",
                Snackbar.LENGTH_SHORT)
                .setAction(resources.getString(R.string.ok)){
                    activityInterface.ActivityInterface(1, i)
                    Toast.makeText(this, "Toast from snackbar", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, ConstraintLayout::class.java)
                    startActivity(intent)
                }
                .show()
        }

        btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setCancelable(false)
                setTitle("Select Color")
                setMessage("Select a color that you want to set as fragment background")
                    setPositiveButton("Red"){_,_->
                        activityInterface.ActivityInterface(1, i)
                        i++
                    }
                setNegativeButton("Green"){_,_->
                        activityInterface.ActivityInterface(2, i)
                    i++
                }
                setNeutralButton("Yellow"){_,_->
                        activityInterface.ActivityInterface(3, i)
                    i++
                }
            }.show()
//            alertDialog.setCancelable(false)
//            alertDialog.setTitle("Title")
//            alertDialog.setMessage("this is message")
//            alertDialog.setPositiveButton("Positive"){_,_->
//                Toast.makeText(this, "Positive button clicked", Toast.LENGTH_SHORT).show()
//            }
//            alertDialog.setNegativeButton("Negative"){_,_->
//                Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
//            }
//            alertDialog.setNeutralButton("Neutral"){_,_->
//                Toast.makeText(this, "Neutral button clicked", Toast.LENGTH_SHORT).show()
//            }
            //alertDialog.show()


        }
    }

    fun showToast() {
        Toast.makeText(this, " Invoked from fragment", Toast.LENGTH_SHORT).show()
    }
}