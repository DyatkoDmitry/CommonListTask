package com.example.commonlisttask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.commonlisttask.Model.UsersSource
import com.example.commonlisttask.RecyclerViewAdapters.FirstRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.FourthRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.SecondRecyclerViewAdapter
import com.example.commonlisttask.RecyclerViewAdapters.ThirdRecyclerViewAdapter
import com.example.commonlisttask.databinding.FragmentPageBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PageFragment : Fragment() {

    private var position: Int? = null
    private lateinit var binding: FragmentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG.POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        when(position){
            0 -> setRecyclerViewForFirstList()
            1 -> setRecyclerViewForSecondList()
            2 -> setRecyclerViewForThirdList()
            3 -> setRecyclerViewForFourthList()
            4 -> setRecyclerViewForFifthList()
        }
    }

    private fun setRecyclerViewForFirstList() {
        val firstRecyclerViewAdapter = FirstRecyclerViewAdapter(requireActivity(), UsersSource(requireActivity()).users)
        binding.recyclerView.adapter = firstRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.addItemDecoration(DividerItemDecoration(binding.recyclerView.context, DividerItemDecoration.VERTICAL))
    }

    private fun setRecyclerViewForSecondList() {
        val secondRecyclerViewAdapter = SecondRecyclerViewAdapter(requireActivity(), UsersSource(requireActivity()).users)
        binding.recyclerView.adapter = secondRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.recyclerView.layoutManager = linearLayoutManager
    }

    private fun setRecyclerViewForThirdList(){
        val thirdRecyclerViewAdapter = ThirdRecyclerViewAdapter(requireActivity())
        binding.recyclerView.adapter = thirdRecyclerViewAdapter
        val gridLayoutManager = GridLayoutManager(activity,2)
        binding.recyclerView.layoutManager = gridLayoutManager
        val thirdListItemDecoration = ThirdListItemDecoration(resources.getDimensionPixelSize(R.dimen.third_list_space))
        binding.recyclerView.addItemDecoration(thirdListItemDecoration)
        binding.recyclerView.setPadding(resources.getDimensionPixelSize(R.dimen.third_list_space)/2,0,resources.getDimensionPixelSize(R.dimen.third_list_space)/2,0)
    }

    private fun setRecyclerViewForFourthList(){
        val fourthRecyclerViewAdapter = FourthRecyclerViewAdapter(requireActivity())
        binding.recyclerView.adapter = fourthRecyclerViewAdapter
        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.recyclerView.layoutManager = linearLayoutManager
        val fourthListItemDecoration = FourthListItemDecoration(resources.getDimensionPixelSize(R.dimen.fourth_list_space))
        binding.recyclerView.addItemDecoration(fourthListItemDecoration)
    }

    private fun setRecyclerViewForFifthList(){

        showLoading()

        binding.appBarLayout.visibility = View.VISIBLE

        val firstRecyclerViewAdapter = FirstRecyclerViewAdapter(requireActivity(), UsersSource(requireActivity()).users)
        binding.recyclerView.adapter = firstRecyclerViewAdapter

        val emptyDataObserver = EmptyDataObserver(binding.recyclerView,binding.swipeRefresh)
        firstRecyclerViewAdapter.registerAdapterDataObserver(emptyDataObserver)

        binding.toolBar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.clear_recycler_view -> {
                    firstRecyclerViewAdapter.setRecyclerViewAdapterisEmpty()
                    true
                }
                else -> {
                    true
                }
            }
        }

        val linearLayoutManager = LinearLayoutManager(activity).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.recyclerView.layoutManager = linearLayoutManager

        binding.recyclerView.addItemDecoration(DividerItemDecoration(binding.recyclerView.context, DividerItemDecoration.VERTICAL))

        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                binding.emptyView.root.visibility = View.GONE
                delay(CONST.TIME_TO_REFRESH)
                firstRecyclerViewAdapter.setNewData(UsersSource(requireActivity()).users)
                binding.swipeRefresh.isRefreshing = false
                binding.emptyView.root.visibility = View.VISIBLE
            }
        }
    }

    private fun showLoading(){
        binding.recyclerView.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE

        lifecycleScope.launch{
            delay(CONST.TIME_TO_LOADING)
            binding.recyclerView.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
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

object CONST{
    const val TIME_TO_LOADING = 6000L
    const val TIME_TO_REFRESH = 3000L
}