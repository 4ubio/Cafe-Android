package com.example.cafe.API

import com.example.cafe.models.Food
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://lacafe3.000webhostapp.com/API/getMenu.php/"

interface APIService {
    @GET("menu")
    suspend fun getMenu(
        @Query("area") area:String,
    ): List<Food>

    companion object {
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}