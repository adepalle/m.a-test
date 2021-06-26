package fr.adepalle.ma_test.wrapper

import android.content.Context
import fr.adepalle.domain.model.Todo
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.extensions.getColorFromAttr

class TodoViewDataWrapper(private val todo: Todo) {

    fun getTitle() = todo.title

    fun getStatusText(context: Context): String {
        return if (todo.completed) {
            context.getString(R.string.status_ended)
        } else {
            context.getString(R.string.status_pending)
        }
    }

    fun getStatusIcon(): Int {
        return if (todo.completed) {
            R.drawable.todo_done
        } else {
            R.drawable.todo_pending
        }
    }

    fun getStatusColor(context: Context) = context.getColorFromAttr(
        if (todo.completed) {
            R.attr.todoStatusDone
        } else {
            R.attr.todoStatusPending
        }
    )
}