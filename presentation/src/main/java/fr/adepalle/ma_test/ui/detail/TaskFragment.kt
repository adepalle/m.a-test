package fr.adepalle.ma_test.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import fr.adepalle.ma_test.BaseViewState
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.component.snackbar.SnackbarComponent
import fr.adepalle.ma_test.databinding.FragmentDetailBinding
import fr.adepalle.ma_test.extensions.getColorFromAttr
import fr.adepalle.ma_test.extensions.observeSafe
import fr.adepalle.ma_test.ui.detail.item.TaskAdapter
import javax.inject.Inject

const val BUNDLE_TASK_USER_ID = "bundleTaskUserId"

@AndroidEntryPoint
class TaskFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: TaskViewModel by viewModels()

    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var taskAdapter: TaskAdapter

    @Inject
    lateinit var snackbarComponent: SnackbarComponent

    private var userId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskAdapter = TaskAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setTranslationZ(requireView(), 100f)

        binding = FragmentDetailBinding.bind(view)

        arguments?.getInt(BUNDLE_TASK_USER_ID)?.let {
            userId = it
            viewModel.refreshTaskList(it)
            viewModel.retrieveTaskList(it)
        }

        setupView()
        observeUserList()
        observeViewState()
    }

    private fun setupView() {
        with(binding) {
            taskRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext()).apply {
                    orientation = RecyclerView.VERTICAL
                }
                adapter = taskAdapter
            }
            taskListSwipeRefresh.setOnRefreshListener {
                viewModel.refreshTaskList(userId)
            }
            taskListSwipeRefresh.setColorSchemeColors(requireContext().getColorFromAttr(R.attr.colorPrimary))
        }
    }

    private fun observeUserList() {
        viewModel.getTasksListLiveEvent().observeSafe(viewLifecycleOwner) {
            taskAdapter.setItems(it)
        }
        viewModel.getErrorLiveEvent().observeSafe(viewLifecycleOwner) {
            snackbarComponent.displayError(requireContext(), it, requireView())
        }
    }

    private fun observeViewState() {
        viewModel.getViewState().observeSafe(viewLifecycleOwner) { state ->
            when (state) {
                BaseViewState.WAITING -> {
                    binding.taskListSwipeRefresh.isRefreshing = false
                }
                BaseViewState.LOADING -> {
                    binding.taskListSwipeRefresh.isRefreshing = true
                }
            }
        }
    }
}