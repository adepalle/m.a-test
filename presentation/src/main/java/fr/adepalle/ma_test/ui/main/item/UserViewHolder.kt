package fr.adepalle.ma_test.ui.main.item

import fr.adepalle.domain.model.User
import fr.adepalle.ma_test.BaseViewHolder
import fr.adepalle.ma_test.databinding.ViewUserBinding

class UserViewHolder(private val binding: ViewUserBinding) : BaseViewHolder<User>(binding.root) {

    override fun bind(item: User) = with(binding) {
        binding.userName.text = "Name: ${item.name}"
        binding.userUserName.text = "UserName: ${item.username}"
        binding.userEmail.text = "Mail: ${item.email}"
    }
}