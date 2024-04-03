package com.example.commonlisttask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.commonlisttask.Model.UsersSource
import com.example.commonlisttask.RecyclerViewAdapters.FirstRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.SecondRecyclerViewAdapter

class PageFragment : Fragment() {

    private var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG.POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        when(position){
            0 -> setRecyclerViewForFirstList(recyclerView)
            1 -> setRecyclerViewForSecondList(recyclerView)
        }
    }

    private fun setRecyclerViewForFirstList(recyclerView: RecyclerView) {
        val firstRecyclerViewAdapter = FirstRecyclerViewAdapter(requireActivity(), UsersSource(requireActivity()).users)
        recyclerView.adapter = firstRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
    }

    private fun setRecyclerViewForSecondList(recyclerView: RecyclerView) {
        val secondRecyclerViewAdapter = SecondRecyclerViewAdapter(requireActivity(), UsersSource(requireActivity()).users)
        recyclerView.adapter = secondRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            PageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG.POSITION, position)
                }
            }
    }
}

object ARG{
    const val POSITION = "position"
}