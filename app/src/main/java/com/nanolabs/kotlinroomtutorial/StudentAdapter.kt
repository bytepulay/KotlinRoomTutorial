package com.nanolabs.kotlinroomtutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.inner.view.*

class StudentAdapter(val items:List<StudentDataClass>,val context: Context): RecyclerView.Adapter<StudentAdapter.MyViewHolder>() {
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
   val studentname :TextView= itemView.studentname
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.inner,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.studentname.text = items.get(position).studentName
    }
}