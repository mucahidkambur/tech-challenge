package com.mucahitkambur.kariyerchallenge.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.mucahitkambur.kariyerchallenge.network.ApiService
import com.mucahitkambur.kariyerchallenge.util.AppExecutors
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val apiService: ApiService
){

}