package com.caren.androidbasicsproject3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class EditTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)

        val taskClickedOn = intent.getStringExtra("task")
        findViewById<EditText>(R.id.editText).setText(taskClickedOn)
    }
}