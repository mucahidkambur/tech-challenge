package com.mucahitkambur.kariyerchallenge.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.mucahitkambur.kariyerchallenge.model.OrderResult
import com.mucahitkambur.kariyerchallenge.network.ApiException
import com.mucahitkambur.kariyerchallenge.network.ApiService
import com.mucahitkambur.kariyerchallenge.util.AppExecutors
import com.mucahitkambur.kariyerchallenge.util.Resource
import com.mucahitkambur.tdksozluk.network.api.ApiErrorResponse
import com.mucahitkambur.tdksozluk.network.api.ApiResponse
import com.mucahitkambur.tdksozluk.network.api.ApiSuccessResponse
import java.io.IOException
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val apiService: ApiService
){

    private val getOrderResult = MutableLiveData<Resource<List<OrderResult>>>()

    fun getOrders(): LiveData<Resource<List<OrderResult>>> {
        appExecutors.networkIO().execute {
            try {
                getOrderResult.postValue(
                    Resource.loading(
                        null
                    )
                )
                val response = apiService.getOrders().execute()
                when (val apiResponse = ApiResponse.create(response)) {
                    is ApiSuccessResponse -> {
                        getOrderResult.postValue(
                            Resource.success(
                                apiResponse.body
                            )
                        )
                    }
                    is ApiErrorResponse -> {
                        getOrderResult.postValue(
                            Resource.error(
                                apiResponse.errorMessage,
                                null
                            )
                        )
                    }
                }
            } catch (exception: IOException) {
                val apiException = ApiException.create(exception)
                getOrderResult.postValue(
                    Resource.error(
                        apiException,
                        null
                    )
                )
            }
        }
        return getOrderResult
    }

}