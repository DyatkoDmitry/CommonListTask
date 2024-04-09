package com.example.commonlisttask.RecyclerViewAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.commonlisttask.R

class FourthRecyclerViewAdapter(val context: Context): RecyclerView.Adapter<BaseVH>() {

    private val allHolders = arrayOf(HOLDERS.RIGHT_BAR, HOLDERS.NO_BAR, HOLDERS.LEFT_BAR, HOLDERS.NO_BAR)

    override fun getItemViewType(position: Int): Int {

        val positionInAllHolders = position % allHolders.size

        return when(positionInAllHolders){
            0 -> HOLDERS.RIGHT_BAR.value
            1 -> HOLDERS.NO_BAR.value
            2 -> HOLDERS.LEFT_BAR.value
            3 -> HOLDERS.NO_BAR.value
            else -> -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH {

        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType){
            HOLDERS.RIGHT_BAR.value -> RightBarVH(layoutInflater.inflate(R.layout.fourth_screen_right_bar_item, parent,false))
            HOLDERS.NO_BAR.value -> NoBarVH(layoutInflater.inflate(R.layout.fourth_screen_no_bar_item, parent,false))
            HOLDERS.LEFT_BAR.value -> LeftBarVH(layoutInflater.inflate(R.layout.fourth_screen_left_bar_item, parent,false))
            else -> NoBarVH(layoutInflater.inflate(R.layout.fourth_screen_no_bar_item, parent,false))
        }
    }

    override fun getItemCount(): Int = CONST_FOURTH_LIST.AMOUNT_ITEMS

    override fun onBindViewHolder(holder: BaseVH, position: Int) {

        if( holder is RightBarVH ){
            holder.upperView.background = ContextCompat.getDrawable(context, R.drawable.background_view1)
            holder.lowerView.background = ContextCompat.getDrawable(context, R.drawable.background_view2)
            holder.frameLayoutRightBar.background = ContextCompat.getDrawable(context, R.drawable.background_view3)
        }
        if(holder is LeftBarVH){
            holder.upperView.background = ContextCompat.getDrawable(context, R.drawable.background_view3)
            holder.lowerView.background = ContextCompat.getDrawable(context, R.drawable.background_view2)
            holder.frameLayoutLeftBar.background = ContextCompat.getDrawable(context, R.drawable.background_view1)
        }
        if( holder is NoBarVH){
            holder.frameLayoutNoBar.background = ContextCompat.getDrawable(context, R.drawable.background_view4)
        }
    }
}

abstract class BaseVH(itemView: View): RecyclerView.ViewHolder(itemView)

class RightBarVH(itemView: View): BaseVH(itemView){
    val frameLayoutRightBar = itemView.findViewById<FrameLayout>(R.id.frame_layout_right_bar)
    val upperView = itemView.findViewById<View>(R.id.upper_view)
    val lowerView = itemView.findViewById<View>(R.id.lower_view)
}

class NoBarVH(itemView: View): BaseVH(itemView){
    val frameLayoutNoBar = itemView.findViewById<FrameLayout>(R.id.frame_layout_no_bar)
}

class LeftBarVH(itemView: View): BaseVH(itemView){
    val frameLayoutLeftBar = itemView.findViewById<FrameLayout>(R.id.frame_layout_left_bar)
    val upperView = itemView.findViewById<View>(R.id.upper_view)
    val lowerView = itemView.findViewById<View>(R.id.lower_view)
}

enum class HOLDERS(val value:Int){
    RIGHT_BAR(0), NO_BAR(1), LEFT_BAR(2)
}

object CONST_FOURTH_LIST{
    const val AMOUNT_ITEMS = 20
}
