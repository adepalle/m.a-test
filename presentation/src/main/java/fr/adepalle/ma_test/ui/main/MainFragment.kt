package fr.adepalle.ma_test.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import fr.adepalle.ma_test.BaseViewState
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.component.snackbar.SnackbarComponent
import fr.adepalle.ma_test.databinding.FragmentMainBinding
import fr.adepalle.ma_test.extensions.getColorFromAttr
import fr.adepalle.ma_test.extensions.observeSafe
import fr.adepalle.ma_test.ui.main.item.UserAdapter
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: FragmentMainBinding

    @Inject
    lateinit var userAdapter: UserAdapter

    @Inject
    lateinit var snackbarComponent: SnackbarComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userAdapter = UserAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        viewModel.refreshUserList()
        viewModel.retrieveUserList()

        setupView()
        observeUserList()
        observeViewState()
    }

    private fun setupView() {
        with(binding) {
            usersRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext()).apply {
                    orientation = RecyclerView.VERTICAL
                }
                adapter = userAdapter
            }
            userAdapter.onItemClicked = ::onUserClicked

            userListSwipeRefresh.setOnRefreshListener {
                viewModel.refreshUserList()
            }
            userListSwipeRefresh.setColorSchemeColors(requireContext().getColorFromAttr(R.attr.colorPrimary))
        }
    }

    private fun observeUserList() {
        viewModel.getUserListLiveEvent().observeSafe(viewLifecycleOwner) {
            userAdapter.setItems(it)
        }
        viewModel.getErrorLiveEvent().observeSafe(viewLifecycleOwner) {
            snackbarComponent.displayError(requireContext(), it, requireView())
        }
    }

    private fun observeViewState() {
        viewModel.getViewState().observeSafe(viewLifecycleOwner) { state ->
            when (state) {
                BaseViewState.WAITING -> {
                    binding.userListSwipeRefresh.isRefreshing = false
                }
                BaseViewState.LOADING -> {
                    binding.userListSwipeRefresh.isRefreshing = true
                }
            }
        }
    }

    private fun onUserClicked(userId: Int) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToTaskFragment(userId))
    }
}