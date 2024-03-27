package com.example.commonlisttask.RecyclerViewAdapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.commonlisttask.Model.User

class FirstRecyclerViewAdapter(users: List<User>): RecyclerView.Adapter<FirstRecyclerViewAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        TODO("Not yet implemented")
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}