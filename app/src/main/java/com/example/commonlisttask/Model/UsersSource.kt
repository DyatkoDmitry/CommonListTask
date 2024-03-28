package com.example.commonlisttask.Model

import android.content.Context
import com.example.commonlisttask.R
import kotlin.random.Random

class UsersSource(val context: Context) {
    private val firstNames = getRandomFirstNames()
    private val lastNames = getRandomLastNames()
    private val descriptions = getRandomDescriptions()

    val users = getRandomUsers()

    private fun getRandomFirstNames():List<String>{
        return context.resources.getStringArray(R.array.first_name).asList().shuffled()
    }

    private fun getRandomLastNames():List<String>{
        return context.resources.getStringArray(R.array.last_name).asList().shuffled()
    }

    private fun getRandomDescriptions():List<String>{
        return context.resources.getStringArray(R.array.description).asList().shuffled()
    }

    private fun getRandomUsers():List<User>{
        val users:MutableList<User> = mutableListOf()

        val usersAmount = firstNames.size
        (0 until usersAmount).forEach { i ->
            val firstName = firstNames.get(i)
            val lastName = lastNames.get(i)
            val age = Random.nextInt(18,70)
            val sex = Sex.values().random()
            val description = descriptions.get(i)
            val user = User(firstName = firstName, lastName = lastName, age = age, sex = sex, description = description)
            users.add(user)
        }
        return users
    }
}