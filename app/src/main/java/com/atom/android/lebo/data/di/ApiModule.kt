package com.atom.android.lebo.data.di

import com.atom.android.lebo.data.api.service.LoginService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(LoginService::class.java) }
}
