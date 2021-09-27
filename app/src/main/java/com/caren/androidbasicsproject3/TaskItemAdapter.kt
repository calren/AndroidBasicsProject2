package com.caren.androidbasicsproject3

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskItemAdapter(private val tasks: List<String>,
                      private val onItemClickListener: OnItemClickedListener) :
    RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {

    interface OnItemClickedListener {
        fun onItemClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val taskItemView = inflater.inflate(R.layout.item_task, parent, false)
        return ViewHolder(taskItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks.get(position)
        holder.summaryTextView.text = task
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val summaryTextView = itemView.findViewById<TextView>(R.id.task)

        init {
            itemView.setOnClickListener {
                onItemClickListener.onItemClicked(adapterPosition)
            }
        }
    }
}