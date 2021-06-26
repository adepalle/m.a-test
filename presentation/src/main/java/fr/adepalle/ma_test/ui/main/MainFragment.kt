package fr.adepalle.ma_test.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.databinding.FragmentMainBinding
import fr.adepalle.ma_test.ui.main.item.UserAdapter
import fr.adepalle.ma_test.wrapper.UserViewDataWrapper
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userAdapter = UserAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        with(binding) {
            usersRecyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext()).apply {
                    orientation = RecyclerView.VERTICAL
                }
                adapter = userAdapter
            }
            userAdapter.onItemClicked = ::onUserClicked
        }

        viewModel.usersLiveData.observe(viewLifecycleOwner, ::usersListUpdated)
        viewModel.getAllUsers()
    }

    private fun usersListUpdated(result: List<UserViewDataWrapper>) {
        userAdapter.setItems(result)
    }

    private fun onUserClicked(userId: Int) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToTodoFragment(userId))
    }
}