package com.mucahitkambur.kariyerchallenge.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET
    fun getContent(): Call<String>
}