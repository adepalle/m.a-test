package fr.adepalle.ma_test.ui.detail.item

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.wrapper.TaskViewDataWrapper

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: TaskViewDataWrapper) = with(itemView) {
        val taskTitleLabel = findViewById<TextView>(R.id.task_title_label)
        val taskStatusLabel = findViewById<TextView>(R.id.task_status_label)
        val taskStatusIcon = findViewById<ImageView>(R.id.task_status_icon)

        taskTitleLabel.text = item.getTitle()
        taskStatusLabel.text = item.getStatusText(context)
        taskStatusLabel.setTextColor(item.getStatusColor(context))
        taskStatusIcon.setImageResource(item.getStatusIcon())
        taskStatusIcon.setColorFilter(item.getStatusColor(context))
    }
}