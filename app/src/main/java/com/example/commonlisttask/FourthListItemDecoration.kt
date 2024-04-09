package com.example.commonlisttask

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FourthListItemDecoration (val space:Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildViewHolder(view).adapterPosition

        if(position == 0){
            outRect.top = space
        }

        val lastIndex = state.itemCount - 1
        if(position == lastIndex){
            outRect.bottom = space
        }
    }
}