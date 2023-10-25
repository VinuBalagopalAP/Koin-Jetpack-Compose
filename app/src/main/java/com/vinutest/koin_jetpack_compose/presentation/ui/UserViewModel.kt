package com.vinutest.koin_jetpack_compose.presentation.ui

import androidx.lifecycle.ViewModel
import com.vinutest.koin_jetpack_compose.data.UserRepository

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}