package com.caren.androidbasicsproject3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        fun getTasks(): List<String> {
            val templateTasks = mutableListOf<String>()
            templateTasks.add("Pay Rent")
            templateTasks.add("Get haircut")
            templateTasks.add("Buy mom birthday present")
            templateTasks.add("Water plants")
            return templateTasks
        }
    }

    val tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        tasks.addAll(getTasks())

        val adapter = TaskItemAdapter(tasks,
            object: TaskItemAdapter.OnItemClickedListener {
                override fun onItemClicked(position: Int) {
                    // 1. Launch EditTaskActivity
                    val intent = Intent(this@MainActivity,
                        EditTaskActivity::class.java)
                    startActivity(intent)

                    // 2. Pass in data for EditTaskActivity to populate EditText field
                }
            })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        findViewById<View>(R.id.addTaskButton).setOnClickListener {
            val taskEntryEditTextField = findViewById<EditText>(R.id.taskEntry)

            // Get the new task entered
            val newTask = taskEntryEditTextField.text.toString()
            // Clear the EditText field
            taskEntryEditTextField.text.clear()

            tasks.add(newTask)
            adapter.notifyItemChanged(tasks.size - 1)
        }

        // Be able to click on an item in the list
           // Launch EditTaskActivity with the string of the task
    }
}