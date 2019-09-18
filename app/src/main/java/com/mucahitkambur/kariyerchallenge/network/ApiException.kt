package com.mucahitkambur.kariyerchallenge.network

import com.mucahitkambur.kariyerchallenge.util.ERROR_MESSAGE
import com.mucahitkambur.kariyerchallenge.util.NO_CONNECTION
import com.mucahitkambur.kariyerchallenge.model.Result
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ApiException {

    companion object {
        fun create(error: Exception): Result = when(error) {
            is UnknownHostException -> Result(NO_CONNECTION)
            is SocketTimeoutException -> Result(NO_CONNECTION)
            is SocketException -> Result(NO_CONNECTION)
            else -> Result(ERROR_MESSAGE)
        }
    }
}