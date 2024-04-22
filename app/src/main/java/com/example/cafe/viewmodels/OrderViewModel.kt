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
    var isLoaded_orders: Boolean by mutableStateOf(false)
    val orders: List<Order> get() = _orders

    private var _order = Order("", "", "", "", "", "", "", "", "", "", "")
    var errorMessage_order: String by mutableStateOf("")
    var isLoaded_order: Boolean by mutableStateOf(false)
    val order: Order get() = _order

    private var _orderResponse = OrderResponse("")
    var errorMessage_order_response: String by mutableStateOf("")
    var isSetting_order: Boolean by mutableStateOf(false)
    var isCreated_order: Boolean by mutableStateOf(false)
    val orderResponse: OrderResponse get() = _orderResponse

    fun getOrdersList(id_iest: String) {
        viewModelScope.launch {
            val route = "getOrders.php/"
            val apiService = APIService.getInstance(route)
            isLoaded_orders = false
            try {
                _orders.clear()
                _orders.addAll(apiService.getOrders(id_iest))
                isLoaded_orders = true
            } catch (e: Exception) {
                errorMessage_orders = e.message.toString()
            }
        }
    }

    fun getOrderItem(id: String) {
        viewModelScope.launch {
            val route = "getOrder.php/"
            val apiService = APIService.getInstance(route)
            isLoaded_order = false
            try {
                _order = apiService.getOrder(id)
                isLoaded_order = true
            } catch (e: Exception) {
                errorMessage_order = e.message.toString()
            }
        }
    }

    fun setUserOrder(id_producto: String, cantidad: String, id_iest: String, cliente: String) {
        viewModelScope.launch {
            val route = "createOrder.php/"
            val apiService = APIService.getInstance(route)
            isSetting_order = true
            isCreated_order = false
            try {
                _orderResponse = apiService.setOrder(id_producto, cantidad, id_iest, cliente)
                isSetting_order = false
                isCreated_order = true
            } catch (e: Exception) {
                errorMessage_order_response = e.message.toString()
                isSetting_order = false
            }
        }
    }
}