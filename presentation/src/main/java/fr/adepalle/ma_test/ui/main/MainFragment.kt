package fr.adepalle.ma_test.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.adepalle.domain.model.User
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.databinding.FragmentMainBinding
import fr.adepalle.ma_test.ui.main.item.UserAdapter

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), UserAdapter.OnUserClickListener {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userAdapter = UserAdapter(requireContext(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        binding.usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecyclerView.adapter = userAdapter

        viewModel.usersLiveData.observe(viewLifecycleOwner, ::usersListUpdated)
        viewModel.getAllUsers()
    }

    private fun usersListUpdated(result: List<User>) {
        userAdapter.setUserList(result)
    }

    override fun onUserClick(user: User, position: Int) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToTodoFragment(user.id))
    }
}