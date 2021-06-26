package fr.adepalle.ma_test.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.databinding.FragmentDetailBinding
import fr.adepalle.ma_test.ui.detail.item.TodoAdapter
import fr.adepalle.ma_test.wrapper.TodoViewDataWrapper

const val BUNDLE_TODO_USER_ID = "bundleTodoUserId"

@AndroidEntryPoint
class TodoFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: TodoViewModel by viewModels()
    private lateinit var todoAdapter: TodoAdapter

    private var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        todoAdapter = TodoAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentDetailBinding.bind(view)

        binding.todoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.todoRecyclerView.adapter = todoAdapter

        viewModel.todosLiveData.observe(viewLifecycleOwner, ::usersListUpdated)

        arguments?.getInt(BUNDLE_TODO_USER_ID)?.let {
            userId = it
            
            viewModel.getAllTodosByUserId(it)
        }
    }

    private fun usersListUpdated(result: List<TodoViewDataWrapper>) {
        todoAdapter.setItems(result)
    }
}