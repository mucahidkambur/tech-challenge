package com.mucahitkambur.kariyerchallenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mucahitkambur.kariyerchallenge.model.OrderResult
import com.mucahitkambur.kariyerchallenge.repositories.MainRepository
import com.mucahitkambur.kariyerchallenge.util.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {
    val orderResult: LiveData<Resource<List<OrderResult>>> = repository.getOrders()
}