package com.example.commonlisttask.RecyclerViewAdapters

import android.content.Context
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

class SecondRecyclerViewAdapter(val context: Context, val users:List<User>): RecyclerView.Adapter<SecondRecyclerViewAdapter.VH>() {

    class VH(itemView: View): RecyclerView.ViewHolder(itemView){
        val firstLine = itemView.findViewById<TextView>(R.id.first_line)
        val secondLine = itemView.findViewById<TextView>(R.id.second_line)
        val thirdLine = itemView.findViewById<TextView>(R.id.third_line)
        val imageUser = itemView.findViewById<ImageView>(R.id.image_user)
        val sideIcon = itemView.findViewById<ImageView>(R.id.side_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(context).inflate(R.layout.second_screen_item, parent,false)
        val vh = VH(itemView)
        return vh
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val user = users.get(position)
        holder.firstLine.text = "${user.firstName} ${user.lastName}"
        holder.secondLine.text = user.age.toString()
        holder.thirdLine.text = user.description.toString()
        Glide.with(context).load(user.squareAvatarURI).into(holder.imageUser)

        when(user.sex){
            Sex.MALE -> Glide.with(context).load(R.drawable.baseline_face_24).into(holder.sideIcon)
            Sex.FEMALE -> Glide.with(context).load(R.drawable.baseline_face_3_24).into(holder.sideIcon)
        }
    }
}