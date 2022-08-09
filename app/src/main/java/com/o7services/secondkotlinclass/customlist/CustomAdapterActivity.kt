package com.o7services.secondkotlinclass.customlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.o7services.secondkotlinclass.R
import com.o7services.secondkotlinclass.databinding.ActivityCustomAdapterBinding

class CustomAdapterActivity : AppCompatActivity(), ClickInterface {
    lateinit var binding: ActivityCustomAdapterBinding
    lateinit var adapterClass: BaseAdapterClass
    var studentInfo: ArrayList<StudentInfo> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentInfo.add(StudentInfo(1,"Parampreet", "1234567890"))
        studentInfo.add(StudentInfo(2,"Ayush", "1234567891"))
        adapterClass = BaseAdapterClass(studentInfo, this)
        binding.listView.adapter = adapterClass

    }

    override fun OnClick(studentInfo: StudentInfo) {
        System.out.println("in click ${studentInfo.id} ${studentInfo.name}")
    }

    override fun OnPhoneClicked(phone: String) {
        System.out.println("in click $phone")
    }
}