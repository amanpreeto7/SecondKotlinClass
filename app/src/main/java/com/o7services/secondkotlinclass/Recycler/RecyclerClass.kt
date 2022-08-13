package com.o7services.secondkotlinclass.Recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.o7services.secondkotlinclass.R
import com.o7services.secondkotlinclass.customlist.StudentInfo

class RecyclerClass(var array: ArrayList<StudentInfo>) :RecyclerView.Adapter<RecyclerClass.ViewHolder>(){
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var tvId: TextView = view.findViewById(R.id.tvId)
        var tvPhone: TextView = view.findViewById(R.id.tvPhone)
        var tvName: TextView = view.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : RecyclerClass.ViewHolder {
        var initView = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_layout, parent, false)
        return ViewHolder(initView)
    }

    override fun onBindViewHolder(holder: RecyclerClass.ViewHolder, position: Int) {
        holder.tvId.setText(array[position].id.toString())
        holder.tvName.setText(array[position].name.toString())
        holder.tvPhone.setText(array[position].phone.toString())
    }

    override fun getItemCount(): Int {
        return array.size
    }
}