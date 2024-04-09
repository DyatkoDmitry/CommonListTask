package com.example.commonlisttask

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.commonlisttask.Model.UsersSource
import com.example.commonlisttask.RecyclerViewAdapters.FirstRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.FourthRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.SecondRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.ThirdRecyclerViewAdapter

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
            2 -> setRecyclerViewForThirdList(recyclerView)
            3 -> setRecyclerViewForFourthList(recyclerView)
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
    }

    private fun setRecyclerViewForThirdList(recyclerView: RecyclerView){
        val thirdRecyclerViewAdapter = ThirdRecyclerViewAdapter(requireActivity())
        recyclerView.adapter = thirdRecyclerViewAdapter
        val gridLayoutManager = GridLayoutManager(activity,2)
        recyclerView.layoutManager = gridLayoutManager
        val thirdListItemDecoration = ThirdListItemDecoration(resources.getDimensionPixelSize(R.dimen.third_list_space))
        recyclerView.addItemDecoration(thirdListItemDecoration)
        recyclerView.setPadding(resources.getDimensionPixelSize(R.dimen.third_list_space)/2,0,resources.getDimensionPixelSize(R.dimen.third_list_space)/2,0)
    }

    private fun setRecyclerViewForFourthList(recyclerView: RecyclerView){
        val fourthRecyclerViewAdapter = FourthRecyclerViewAdapter(requireActivity())
        recyclerView.adapter = fourthRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recyclerView.layoutManager = linearLayoutManager
        val fourthListItemDecoration = FourthListItemDecoration(resources.getDimensionPixelSize(R.dimen.fourth_list_space))
        recyclerView.addItemDecoration(fourthListItemDecoration)
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