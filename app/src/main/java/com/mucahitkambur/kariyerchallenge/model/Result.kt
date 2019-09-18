package com.mucahitkambur.kariyerchallenge.model

import com.google.gson.annotations.SerializedName

data class Result(
    @field:SerializedName("error")
    val message: String = String()
)