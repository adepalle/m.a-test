package fr.adepalle.ma_test.ui.detail.item

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.wrapper.TodoViewDataWrapper

class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: TodoViewDataWrapper) = with(itemView) {
        val todoTitleLabel = findViewById<TextView>(R.id.todo_title_label)
        val todoStatusLabel = findViewById<TextView>(R.id.todo_status_label)
        val todoStatusIcon = findViewById<ImageView>(R.id.todo_status_icon)

        todoTitleLabel.text = item.getTitle()
        todoStatusLabel.text = item.getStatusText(context)
        todoStatusLabel.setTextColor(item.getStatusColor(context))
        todoStatusIcon.setImageResource(item.getStatusIcon())
        todoStatusIcon.setColorFilter(item.getStatusColor(context))
    }
}