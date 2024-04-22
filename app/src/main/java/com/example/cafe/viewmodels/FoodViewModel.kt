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
    var isLoaded_menu: Boolean by mutableStateOf(false)
    val menu: List<Food> get() = _menu

    private var _food = Food("", "", "", "", "", "", "", "", "", "00:00:00", "00:00:00")
    var errorMessage_food: String by mutableStateOf("")
    var isLoaded_food: Boolean by mutableStateOf(false)
    val food: Food get() = _food

    fun getMenuList(area: String) {
        viewModelScope.launch {
            val route = "getMenu.php/"
            val apiService = APIService.getInstance(route)
            isLoaded_menu = false
            try {
                _menu.clear()
                _menu.addAll(apiService.getMenu(area))
                isLoaded_menu = true
            } catch (e: Exception) {
                errorMessage_menu = e.message.toString()
            }
        }
    }

    fun getFoodItem(id: String) {
        viewModelScope.launch {
            val route = "getFood.php/"
            val apiService = APIService.getInstance(route)
            isLoaded_food = false
            try {
                _food = apiService.getFood(id)
                isLoaded_food = true
            } catch (e: Exception) {
                errorMessage_food = e.message.toString()
            }
        }
    }
}