package com.example.cafe.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.API.APIService
import com.example.cafe.models.Order
import com.example.cafe.models.OrderResponse
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val _orders = mutableStateListOf<Order>()
    var errorMessage_orders: String by mutableStateOf("")
    val orders: List<Order> get() = _orders

    private val _order = mutableStateListOf<Order>()
    var errorMessage_order: String by mutableStateOf("")
    val order: List<Order> get() = _order

    private val _orderResponse = mutableStateListOf<OrderResponse>()
    var errorMessage_order_response: String by mutableStateOf("")
    val orderResponse: List<OrderResponse> get() = _orderResponse

    fun getOrdersList(id_iest: String) {
        viewModelScope.launch {
            val route = "getOrders.php/"
            val apiService = APIService.getInstance(route)
            try {
                _orders.clear()
                _orders.addAll(apiService.getOrders(id_iest))
            } catch (e: Exception) {
                errorMessage_orders = e.message.toString()
            }
        }
    }

    fun getOrderItem(id: String) {
        viewModelScope.launch {
            val route = "getOrder.php/"
            val apiService = APIService.getInstance(route)
            try {
                _order.clear()
                _order.addAll(apiService.getOrder(id))
            } catch (e: Exception) {
                errorMessage_order = e.message.toString()
            }
        }
    }

    fun setUserOrder(id_producto: String, cantidad: String, id_iest: String, cliente: String) {
        viewModelScope.launch {
            val route = "createOrder.php/"
            val apiService = APIService.getInstance(route)
            try {
                _orderResponse.clear()
                _orderResponse.addAll(apiService.setOrder(id_producto, cantidad, id_iest, cliente))
            } catch (e: Exception) {
                errorMessage_order_response = e.message.toString()
            }
        }
    }
}