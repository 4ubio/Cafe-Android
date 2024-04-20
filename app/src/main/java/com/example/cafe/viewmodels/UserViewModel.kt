package com.example.cafe.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.API.APIService
import com.example.cafe.models.User
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private var _user = User("", "", "", "")
    var errorMessage_user: String by mutableStateOf("")
    var isAuthed: Boolean by mutableStateOf(false)
    var isAuthing: Boolean by mutableStateOf(false)
    var isAuthFailed: Boolean by mutableStateOf(false)
    val user: User get() = _user

    fun authCafeUser(email: String, password: String) {
        viewModelScope.launch {
            val route = "authUser.php/"
            val apiService = APIService.getInstance(route)
            isAuthing = true
            isAuthFailed = false
            try {
                _user = apiService.authUser(email, password)
                isAuthed = true
                isAuthing = false
            } catch (e: Exception) {
                errorMessage_user = e.message.toString()
                isAuthFailed = true
                isAuthing = false
            }
        }
    }
}