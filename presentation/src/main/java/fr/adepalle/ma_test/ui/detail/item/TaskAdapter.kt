package fr.adepalle.ma_test.ui.detail.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.wrapper.TaskViewDataWrapper
import javax.inject.Inject

class TaskAdapter @Inject constructor() : RecyclerView.Adapter<TaskViewHolder>() {

    private var items = mutableListOf<TaskViewDataWrapper>()

    fun setItems(newItems: List<TaskViewDataWrapper>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_task,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position])
    }
}