package com.o7services.secondkotlinclass.Recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.o7services.secondkotlinclass.customlist.StudentInfo
import com.o7services.secondkotlinclass.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter: RecyclerClass
    lateinit var layoutManager: LinearLayoutManager
    var array: ArrayList<StudentInfo> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        array.add(StudentInfo(1,"Abhijeet","123"))
        array.add(StudentInfo(1,"Japnoor","123"))
        adapter = RecyclerClass(array)
        layoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter


    }
}