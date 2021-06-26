package fr.adepalle.ma_test.ui.main.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.wrapper.UserViewDataWrapper
import javax.inject.Inject

class UserAdapter @Inject constructor() : RecyclerView.Adapter<UserViewHolder>() {

    private var items = listOf<UserViewDataWrapper>()

    var onItemClicked: (Int) -> Unit = {}

    fun setItems(newItems: List<UserViewDataWrapper>) {
        this.items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position], onItemClicked)
    }
}
