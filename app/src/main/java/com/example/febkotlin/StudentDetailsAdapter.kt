package com.example.febkotlin

import android.R.attr.text
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentDetailsAdapter(private val studentList: List<StudentData>) :
    RecyclerView.Adapter<StudentDetailsAdapter.StudentDetailsViewHolder>() {

        class StudentDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvname: TextView = itemView.findViewById(R.id.tvname)
            val tvenoll: TextView = itemView.findViewById(R.id.tvenoll)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentDetailsViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rvlist_item, parent, false)
        return StudentDetailsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentDetailsViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.tvname.text = currentItem.fullname
        holder.tvenoll.text = currentItem.enrollment

    }

    override fun getItemCount(): Int {
        return studentList.size;
    }
}