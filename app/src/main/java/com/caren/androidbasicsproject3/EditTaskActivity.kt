package com.caren.androidbasicsproject3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)

        val taskClickedOn = intent.getStringExtra("task")
        findViewById<EditText>(R.id.editText).setText(taskClickedOn)

        // Pass back the edited task to MainActivity
        findViewById<Button>(R.id.button).setOnClickListener {
            // Grab the text in EditText view
            val newlyEditedTask = findViewById<EditText>(R.id.editText).text.toString()

            val intent = Intent()
            intent.putExtra("newlyEditedTask", newlyEditedTask)

            setResult(RESULT_OK, intent)

            // Close out this activity
            finish()
        }
    }
}