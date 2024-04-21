package com.example.commonlisttask

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class EmptyDataObserver(val recyclerView:RecyclerView, val emptyView: View): RecyclerView.AdapterDataObserver() {

    private fun checkIfEmpty() {
        val emptyViewVisible = recyclerView.adapter!!.itemCount == 0
        emptyView.visibility = if (emptyViewVisible) View.VISIBLE else View.GONE
        recyclerView.visibility = if (emptyViewVisible) View.GONE else View.VISIBLE
    }

    override fun onChanged() {
        super.onChanged()
        checkIfEmpty()
    }
}