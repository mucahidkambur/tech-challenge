package com.mucahitkambur.kariyerchallenge.model

import com.google.gson.annotations.SerializedName

data class ProductDetail(
    @SerializedName("orderDetail")
    val orderDetail: String,
    @SerializedName("summaryPrice")
    val summaryPrice: Double
)