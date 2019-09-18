package com.mucahitkambur.kariyerchallenge.di

import com.mucahitkambur.kariyerchallenge.ui.login.LoginFragment
import com.mucahitkambur.kariyerchallenge.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}