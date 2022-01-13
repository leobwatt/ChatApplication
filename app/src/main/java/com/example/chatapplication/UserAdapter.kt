package com.example.chatapplication

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textName = itemView.findViewById<TextView>(R.id.txt_name)

    }

}