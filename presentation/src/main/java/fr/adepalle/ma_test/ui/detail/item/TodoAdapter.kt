package fr.adepalle.ma_test.ui.detail.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.wrapper.TodoViewDataWrapper
import javax.inject.Inject

class TodoAdapter @Inject constructor() : RecyclerView.Adapter<TodoViewHolder>() {

    private var items = mutableListOf<TodoViewDataWrapper>()

    fun setItems(newItems: List<TodoViewDataWrapper>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_todo,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position])
    }
}