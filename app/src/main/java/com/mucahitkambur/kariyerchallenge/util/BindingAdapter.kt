package com.mucahitkambur.kariyerchallenge.util

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.mucahitkambur.kariyerchallenge.R
import com.mucahitkambur.kariyerchallenge.model.OrderType

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("viewColor")
    fun View.viewColor(status: String) {
        when(status){
            OrderType.PREPARING.state -> setBackgroundColor(ContextCompat.getColor(this.context, R.color.orange))
            OrderType.CONFIRMATION.state -> setBackgroundColor(ContextCompat.getColor(this.context, R.color.red))
            OrderType.ROAD.state -> setBackgroundColor(ContextCompat.getColor(this.context, R.color.green))
        }
    }

    @JvmStatic
    @BindingAdapter("textColor")
    fun AppCompatTextView.textColor(status: String) {
        when(status){
            OrderType.PREPARING.state -> setTextColor(ContextCompat.getColor(this.context, R.color.orange))
            OrderType.CONFIRMATION.state -> setTextColor(ContextCompat.getColor(this.context, R.color.red))
            OrderType.ROAD.state -> setTextColor(ContextCompat.getColor(this.context, R.color.green))
        }
    }
}