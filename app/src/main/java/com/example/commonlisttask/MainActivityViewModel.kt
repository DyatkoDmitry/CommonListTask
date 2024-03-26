package com.example.commonlisttask

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.commonlisttask.Model.UsersSource

class MainActivityViewModel(app: Application): AndroidViewModel(app) {

    private val usersSource = UsersSource(app)

}