package fr.adepalle.ma_test.wrapper

import android.content.Context
import fr.adepalle.domain.model.Task
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.extensions.getColorFromAttr

class TaskViewDataWrapper(private val task: Task) {

    fun getTitle() = task.title

    fun getStatusText(context: Context): String {
        return if (task.completed) {
            context.getString(R.string.status_ended)
        } else {
            context.getString(R.string.status_pending)
        }
    }

    fun getStatusIcon(): Int {
        return if (task.completed) {
            R.drawable.task_done
        } else {
            R.drawable.task_pending
        }
    }

    fun getStatusColor(context: Context) = context.getColorFromAttr(
        if (task.completed) {
            R.attr.taskStatusDone
        } else {
            R.attr.taskStatusPending
        }
    )
}