package com.mucahitkambur.kariyerchallenge.util

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.mucahitkambur.kariyerchallenge.R
import com.mucahitkambur.kariyerchallenge.model.OrderType
import java.text.SimpleDateFormat
import java.util.*

object BindingAdapter {

    // Sipariş durumu view'ının renginin ayarlanması
    @JvmStatic
    @BindingAdapter("viewColor")
    fun View.viewColor(status: String) {
        when(status){
            OrderType.PREPARING.state -> setBackgroundColor(ContextCompat.getColor(this.context, R.color.orange))
            OrderType.CONFIRMATION.state -> setBackgroundColor(ContextCompat.getColor(this.context, R.color.red))
            OrderType.ROAD.state -> setBackgroundColor(ContextCompat.getColor(this.context, R.color.green))
        }
    }

    // Sipariş durumu text'inin renginin ayarlanması
    @JvmStatic
    @BindingAdapter("textColor")
    fun AppCompatTextView.textColor(status: String) {
        when(status){
            OrderType.PREPARING.state -> setTextColor(ContextCompat.getColor(this.context, R.color.orange))
            OrderType.CONFIRMATION.state -> setTextColor(ContextCompat.getColor(this.context, R.color.red))
            OrderType.ROAD.state -> setTextColor(ContextCompat.getColor(this.context, R.color.green))
        }
    }

    // Int gelen Ay'ı String'e çevirme
    @JvmStatic
    @BindingAdapter("textMonth")
    fun AppCompatTextView.dateToString(month: String) {
        val calender = Calendar.getInstance()
        val monthDate = SimpleDateFormat("MMMM", Locale("tr"))
        calender.set(Calendar.MONTH, month.toInt() - 1)

        setText(monthDate.format(calender.time))
    }
}