package com.example.cafe.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.API.APIService
import com.example.cafe.models.Food
import kotlinx.coroutines.launch

class FoodViewModel : ViewModel() {

    private val _menu = mutableStateListOf<Food>()
    var errorMessage: String by mutableStateOf("")

    val menu: List<Food> get() = _menu

    fun getMenuList(area: String) {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _menu.clear()
                _menu.addAll(apiService.getMenu(area))
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}