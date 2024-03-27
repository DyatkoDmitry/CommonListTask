package com.example.commonlisttask

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.commonlisttask.Model.UsersSource
import com.example.commonlisttask.RecyclerViewAdapters.FirstRecyclerViewAdapter

class MainActivityViewModel(app: Application): AndroidViewModel(app) {

    private val usersSource = UsersSource(app)

    private val firstRecyclerViewAdapter = lazy {FirstRecyclerViewAdapter(usersSource.users)}

    init{

    }

}