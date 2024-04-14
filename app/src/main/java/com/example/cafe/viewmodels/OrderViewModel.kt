package com.example.cafe.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.API.APIService
import com.example.cafe.models.Order
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val _orders = mutableStateListOf<Order>()
    var errorMessage: String by mutableStateOf("")

    val orders: List<Order> get() = _orders

    fun getOrdersList(id_iest: String) {
        viewModelScope.launch {
            val route = "getOrders.php/"
            val apiService = APIService.getInstance(route)
            try {
                _orders.clear()
                _orders.addAll(apiService.getOrders(id_iest))
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}