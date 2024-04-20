package com.example.cafe.API

import com.example.cafe.models.Food
import com.example.cafe.models.Order
import com.example.cafe.models.OrderResponse
import com.example.cafe.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://lacafe3.000webhostapp.com/API/"

interface APIService {
    @GET("user")
    suspend fun authUser(
        @Query("email") email:String,
        @Query("password") password:String
    ): User

    @GET("menu")
    suspend fun getMenu(
        @Query("area") area:String,
    ): List<Food>

    @GET("food")
    suspend fun getFood(
        @Query("id") id:String,
    ): List<Food>

    @GET("orders")
    suspend fun getOrders(
        @Query("id_iest") id_iest:String,
    ): List<Order>

    @GET("order")
    suspend fun getOrder(
        @Query("id") id:String,
    ): List<Order>

    @GET("order_response")
    suspend fun setOrder(
        @Query("id_producto") id_producto:String,
        @Query("cantidad") cantidad:String,
        @Query("id_iest") id_iest:String,
        @Query("cliente") cliente:String,
    ): List<OrderResponse>

    companion object {
        var apiService: APIService? = null
        fun getInstance(route: String): APIService {
            apiService = Retrofit.Builder()
                .baseUrl(BASE_URL + route)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(APIService::class.java)
            return apiService!!
        }
    }
}