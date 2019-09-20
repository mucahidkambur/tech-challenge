package com.mucahitkambur.kariyerchallenge.network

import com.mucahitkambur.kariyerchallenge.model.OrderResult
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    fun getOrders(): Call<List<OrderResult>>
}