package fr.adepalle.ma_test.ui.main.item

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.adepalle.ma_test.R
import fr.adepalle.ma_test.extensions.setOnClickDelayListener
import fr.adepalle.ma_test.wrapper.UserViewDataWrapper

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        item: UserViewDataWrapper,
        onItemClicked: (Int) -> Unit
    ) {
        with(itemView) {
            val nameLabel = findViewById<TextView>(R.id.user_name)
            val userNameLabel = findViewById<TextView>(R.id.user_user_name)
            val userMail = findViewById<TextView>(R.id.user_email)

            nameLabel.text = item.getName()
            userNameLabel.text = item.getUserName()
            userMail.text = item.getMail()

            setOnClickDelayListener {
                onItemClicked(item.getId())
            }
        }
    }
}