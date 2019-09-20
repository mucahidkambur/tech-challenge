package com.mucahitkambur.kariyerchallenge.util

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mucahitkambur.kariyerchallenge.R

inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
    provider: ViewModelProvider.Factory
) = ViewModelProviders.of(this, provider).get(VM::class.java)

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(
    provider: ViewModelProvider.Factory
) = ViewModelProviders.of(this, provider).get(VM::class.java)

fun Fragment.hideActionBar() {
    (requireActivity() as AppCompatActivity).supportActionBar?.hide()
}

fun Fragment.showActionBar() {
    (requireActivity() as AppCompatActivity).supportActionBar?.show()
}

fun Fragment.statusBarColor(colorId: Int) {
    val color = ContextCompat.getColor(requireContext(), colorId)
    requireActivity().window.statusBarColor = color
}

fun Fragment.commonTitle(strId: Int) {
    val act = (requireActivity() as AppCompatActivity)
    val textTitle = act.findViewById<AppCompatTextView>(R.id.text_title)
    textTitle.setText(strId)
}