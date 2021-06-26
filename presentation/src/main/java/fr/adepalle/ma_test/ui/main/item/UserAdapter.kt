package fr.adepalle.ma_test.ui.main.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.domain.model.User
import fr.adepalle.ma_test.BaseViewHolder
import fr.adepalle.ma_test.databinding.ViewUserBinding

class UserAdapter(
    private val context: Context,
    private val itemClickListener: OnUserClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var userList = listOf<User>()

    interface OnUserClickListener {
        fun onUserClick(user: User, position: Int)
    }

    fun setUserList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ViewUserBinding.inflate(LayoutInflater.from(context), parent, false)
        val holder = UserViewHolder(itemBinding)

        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener

            itemClickListener.onUserClick(userList[position], position)
        }

        return holder
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind(userList[position])
        }
    }
}
