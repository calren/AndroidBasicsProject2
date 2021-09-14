package com.caren.androidbasicsproject3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        fun getTasks(): List<TaskItem> {
            val templateTasks = mutableListOf<TaskItem>()
            templateTasks.add(TaskItem("Pay Rent"))
            templateTasks.add(TaskItem("Get haircut"))
            templateTasks.add(TaskItem("Buy mom birthday present"))
            templateTasks.add(TaskItem("Water plants"))
            return templateTasks
        }
    }

    val tasks = mutableListOf<TaskItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        tasks.addAll(getTasks())
        val adapter = TaskItemAdapter(tasks)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        findViewById<View>(R.id.addTaskButton).setOnClickListener {
            val taskEntryEditTextField = findViewById<EditText>(R.id.taskEntry)

            // Get the new task entered
            val newTask = taskEntryEditTextField.text.toString()
            // Clear the EditText field
            taskEntryEditTextField.text.clear()

            tasks.add(TaskItem(newTask))
            adapter.notifyItemChanged(tasks.size - 1)
        }
    }
}