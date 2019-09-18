package com.mucahitkambur.kariyerchallenge.ui

import androidx.lifecycle.ViewModel
import com.mucahitkambur.kariyerchallenge.repositories.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel() {


}