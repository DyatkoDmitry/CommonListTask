package com.example.commonlisttask

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ThirdListItemDecoration(val space:Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildViewHolder(view).adapterPosition

        outRect.top = space
        outRect.left = space/2
        outRect.right = space/2

        val lastIndex = state.itemCount - 1
        val lastOneIndex = state.itemCount - 2

        if((position == lastIndex) || (position == lastOneIndex)){
            outRect.bottom = space
        }
    }
}