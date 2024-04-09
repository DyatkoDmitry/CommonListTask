package com.example.commonlisttask.RecyclerViewAdapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.commonlisttask.R

class ThirdRecyclerViewAdapter(val context: Context): RecyclerView.Adapter<ThirdRecyclerViewAdapter.VH>() {
    val dataHolderThirdScreen = DataHolderThirdScreen(context)

    class VH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardViewBackgroundcolor = itemView.findViewById<CardView>(R.id.third_screen_card_view)
        val icon = itemView.findViewById<ImageView>(R.id.third_screen_icon)
        val title = itemView.findViewById<TextView>(R.id.third_screen_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView = LayoutInflater.from(context).inflate(R.layout.third_screen_item, parent,false)
        return VH(itemView)
    }

    override fun getItemCount(): Int = CONST.itemsAmount

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.cardViewBackgroundcolor.setCardBackgroundColor(dataHolderThirdScreen.getColorByPosition(position))
        holder.title.setText(dataHolderThirdScreen.getTitleByPosition(position))
        holder.icon.setImageDrawable(ContextCompat.getDrawable(context, dataHolderThirdScreen.getIconByPosition(position)))
    }
}

object CONST{
    const val itemsAmount = 20
}

class DataHolderThirdScreen(context: Context){
    private val titles = context.resources.getStringArray(R.array.third_list_titles)
    private val colors = context.resources.getIntArray(R.array.third_list_colors)
    private val icons = getIcons()

    fun getTitleByPosition(position:Int):String{
        val positionInArray = position % titles.size
        return titles.get(positionInArray)
    }

    fun getColorByPosition(position: Int): Int{
        val positionInArray = position % colors.size
        return colors.get(positionInArray)
    }

    fun getIconByPosition(position: Int):Int{
        val positionInArray = position % icons.size
        return icons.get(positionInArray)
    }

    private fun getIcons():Array<Int>{
        return arrayOf(R.drawable.baseline_person_24,
            R.drawable.baseline_medical_information_24,
            R.drawable.baseline_assignment_turned_in_24,
            R.drawable.baseline_featured_play_list_24,
            R.drawable.baseline_medication_24,
            R.drawable.baseline_shopping_basket_24)
    }
}