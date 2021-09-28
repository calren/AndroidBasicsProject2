package com.caren.androidbasicsproject3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditTaskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditTaskFragment : Fragment() {

    private lateinit var taskToEdit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            taskToEdit = it.getString("taskToEdit").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val taskClickedOn = intent.getStringExtra("task")
        view.findViewById<EditText>(R.id.editText).setText(taskToEdit)
//
//        // Pass back the edited task to MainActivity
//        findViewById<Button>(R.id.button).setOnClickListener {
//            // Grab the text in EditText view
//            val newlyEditedTask = findViewById<EditText>(R.id.editText).text.toString()
//
//            val intent = Intent()
//            intent.putExtra("newlyEditedTask", newlyEditedTask)
//
//            setResult(AppCompatActivity.RESULT_OK, intent)
//
//            // Close out this activity
//            finish()
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditTaskFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditTaskFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}