package fr.adepalle.ma_test.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.databinding.FragmentDetailBinding
import fr.adepalle.ma_test.ui.detail.item.TaskAdapter
import fr.adepalle.ma_test.wrapper.TaskViewDataWrapper

const val BUNDLE_TASK_USER_ID = "bundleTaskUserId"

@AndroidEntryPoint
class TaskFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: TaskViewModel by viewModels()
    private lateinit var taskAdapter: TaskAdapter

    private var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskAdapter = TaskAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)

        binding.taskRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.taskRecyclerView.adapter = taskAdapter

        viewModel.tasksLiveData.observe(viewLifecycleOwner, ::usersListUpdated)

        arguments?.getInt(BUNDLE_TASK_USER_ID)?.let {
            userId = it
            viewModel.getAllTasksByUserId(it)
        }
    }

    private fun usersListUpdated(result: List<TaskViewDataWrapper>) {
        taskAdapter.setItems(result)
    }
}