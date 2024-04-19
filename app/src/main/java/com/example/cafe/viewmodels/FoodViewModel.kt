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
    var errorMessage_menu: String by mutableStateOf("")
    var isLoading_menu: Boolean by mutableStateOf(true)
    val menu: List<Food> get() = _menu

    private val _food = mutableStateListOf<Food>()
    var errorMessage_food: String by mutableStateOf("")
    var isLoading_food: Boolean by mutableStateOf(true)
    val food: List<Food> get() = _food

    fun getMenuList(area: String) {
        viewModelScope.launch {
            val route = "getMenu.php/"
            val apiService = APIService.getInstance(route)
            try {
                _menu.clear()
                _menu.addAll(apiService.getMenu(area))
                isLoading_menu = false
            } catch (e: Exception) {
                errorMessage_menu = e.message.toString()
            }
        }
    }

    fun getFoodItem(id: String) {
        viewModelScope.launch {
            val route = "getFood.php/"
            val apiService = APIService.getInstance(route)
            try {
                _food.clear()
                _food.addAll(apiService.getFood(id))
                isLoading_food = false
            } catch (e: Exception) {
                errorMessage_food = e.message.toString()
            }
        }
    }
}