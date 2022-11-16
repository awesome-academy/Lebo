package com.atom.android.lebo.di

import com.atom.android.lebo.ui.authentication.login.LoginViewModel
import com.atom.android.lebo.ui.authentication.loginOTP.LoginOTPViewModel
import com.atom.android.lebo.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
    viewModel { LoginOTPViewModel(get(), get()) }
    viewModel { MainViewModel(get(), get()) }
}
