package com.mucahitkambur.kariyerchallenge.ui

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mucahitkambur.kariyerchallenge.model.LoginState
import com.mucahitkambur.kariyerchallenge.model.OrderResult
import com.mucahitkambur.kariyerchallenge.repositories.MainRepository
import com.mucahitkambur.kariyerchallenge.util.PREF_REMEMBER
import com.mucahitkambur.kariyerchallenge.util.Resource
import com.mucahitkambur.kariyerchallenge.util.USER_NAME
import com.mucahitkambur.kariyerchallenge.util.USER_PASSWORD
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val preferences: SharedPreferences
): ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val rememberState = MutableLiveData<Boolean>()
    val loginResult = MutableLiveData<LoginState>()

    val orderResult: LiveData<Resource<List<OrderResult>>> = repository.getOrders()

    fun login(){
        if (username.value.isNullOrEmpty() || password.value.isNullOrEmpty()){
            loginResult.postValue(LoginState.EMPTY_NULL)
        }else if (username.value == USER_NAME && password.value == USER_PASSWORD){
            rememberState.value?.let { state ->
                if (state)
                    preferences.edit().putBoolean(PREF_REMEMBER, true).apply()
            }
            loginResult.postValue(LoginState.SUCCESS)
        }
        else {
            loginResult.postValue(LoginState.ERROR)
        }
    }
}