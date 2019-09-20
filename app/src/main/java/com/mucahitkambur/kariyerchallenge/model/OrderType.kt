package com.mucahitkambur.kariyerchallenge.model

import com.mucahitkambur.kariyerchallenge.R

enum class OrderType (val state: String, val colorId: Int){
    ROAD("Yolda", R.color.green),
    PREPARING("Hazırlanıyor", R.color.orange),
    CONFIRMATION("Onay Bekliyor", R.color.red)
}