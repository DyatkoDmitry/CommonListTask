package com.example.commonlisttask.RecyclerViewAdapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.commonlisttask.Model.Sex
import com.example.commonlisttask.Model.User
import com.example.commonlisttask.R

class FirstRecyclerViewAdapter(val context: Context, var users: List<User>): RecyclerView.Adapter<FirstRecyclerViewAdapter.VH>() {

    private var itemNumber = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.first_screen_item, parent,false)
        val viewHolder = VH(itemView)
        return viewHolder
    }

    override fun getItemCount(): Int = itemNumber

    override fun onBindViewHolder(holder: VH, position: Int) {
        val user = users.get(position)
        Glide.with(context).load(user.squareAvatarURI).centerCrop().into(holder.imageUser)
        holder.firstLine.text = "${user.firstName} ${user.lastName}"
        holder.secondLine.text = user.age.toString()

        when(user.sex){
            Sex.MALE -> Glide.with(context).load(R.drawable.baseline_face_24).into(holder.sideIcon)
            Sex.FEMALE -> Glide.with(context).load(R.drawable.baseline_face_3_24).into(holder.sideIcon)
        }
    }

    class VH(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageUser = itemView.findViewById<ImageView>(R.id.image_user)
        val firstLine = itemView.findViewById<TextView>(R.id.first_line)
        val secondLine = itemView.findViewById<TextView>(R.id.second_line)
        val sideIcon = itemView.findViewById<ImageView>(R.id.side_icon)
    }

    fun setRecyclerViewAdapterisEmpty(){
        itemNumber = 0
        notifyDataSetChanged()
    }

    fun setNewData(newUsers: List<User>){
        users = newUsers
        itemNumber = users.size
        notifyDataSetChanged()
    }
}