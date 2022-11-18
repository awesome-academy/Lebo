package com.atom.android.lebo.data.di

import com.atom.android.lebo.data.api.service.ForgotPasswordService
import com.atom.android.lebo.data.api.service.LoginService
import com.atom.android.lebo.data.api.service.UserService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(LoginService::class.java) }
    single { get<Retrofit>().create(ForgotPasswordService::class.java) }
    single { get<Retrofit>().create(UserService::class.java) }
}
