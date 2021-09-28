package com.caren.androidbasicsproject3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TaskListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TaskListFragment : Fragment() {

    private val viewModel: TaskListViewModel by activityViewModels()

    var adapter: TaskItemAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        adapter = TaskItemAdapter(viewModel.tasks,
            object : TaskItemAdapter.OnItemClickedListener {
                override fun onItemClicked(position: Int) {
                    val taskToEditString = viewModel.tasks[position]
                    val action = TaskListFragmentDirections.actionTaskListFragmentToEditTaskFragment(taskToEditString)
                    viewModel.positionOfTaskBeingEdited = position
                    findNavController().navigate(action)
                }
            })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        view.findViewById<View>(R.id.addTaskButton).setOnClickListener {
            val taskEntryEditTextField = view.findViewById<EditText>(R.id.taskEntry)

            // Get the new task entered
            val newTask = taskEntryEditTextField.text.toString()
            // Clear the EditText field
            taskEntryEditTextField.text.clear()

            viewModel.tasks.add(newTask)
            adapter?.notifyItemChanged(viewModel.tasks.size - 1)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("Caren", "onResume TaskListFragment")
        arguments?.let {
            val newlyEditedTask = it.getString("newlyEditedTask")
            if (newlyEditedTask != null) {
                viewModel.tasks[viewModel.positionOfTaskBeingEdited] = newlyEditedTask
                adapter?.notifyDataSetChanged()
            }
        }
    }
}