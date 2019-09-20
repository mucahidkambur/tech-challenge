package com.mucahitkambur.kariyerchallenge.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.mucahitkambur.kariyerchallenge.BuildConfig
import com.mucahitkambur.kariyerchallenge.network.ApiService
import com.mucahitkambur.kariyerchallenge.util.API_URL
import com.mucahitkambur.kariyerchallenge.util.PREF_FILE_NAME
import com.mucahitkambur.tdksozluk.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun providesSharedPreference(context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideService(httpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(httpClient)
            .build()
            .create(ApiService::class.java)
    }
}