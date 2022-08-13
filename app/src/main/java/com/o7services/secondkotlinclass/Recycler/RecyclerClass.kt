package com.o7services.secondkotlinclass.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.o7services.secondkotlinclass.R
import com.o7services.secondkotlinclass.customlist.StudentInfo

class RecyclerClass(var array: ArrayList<StudentInfo>) :RecyclerView.Adapter<RecyclerClass.ViewHolder>(){
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : RecyclerClass.ViewHolder {
        var initView = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_layout, parent, false)
        return ViewHolder(initView)
    }

    override fun onBindViewHolder(holder: RecyclerClass.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }
}