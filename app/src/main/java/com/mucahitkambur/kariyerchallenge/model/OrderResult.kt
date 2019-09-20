package com.mucahitkambur.kariyerchallenge.model

import com.google.gson.annotations.SerializedName

data class OrderResult(
    @SerializedName("date")
    val date: String,
    @SerializedName("month")
    val month: String,
    @SerializedName("marketName")
    val marketName: String,
    @SerializedName("orderName")
    val orderName: String,
    @SerializedName("productPrice")
    val productPrice: Double,
    @SerializedName("productState")
    val productState: String,
    @SerializedName("productDetail")
    val productDetail: ProductDetail
)