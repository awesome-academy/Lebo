package com.atom.android.lebo.data.di

import com.atom.android.lebo.data.datasource.forgotpassword.ForgotPasswordRemoteDataSource
import com.atom.android.lebo.data.datasource.forgotpassword.IForgotPasswordDataSource
import com.atom.android.lebo.data.datasource.login.ILoginDataSource
import com.atom.android.lebo.data.datasource.login.LoginRemoteDataSource
import com.atom.android.lebo.data.datasource.user.IUserDataSource
import com.atom.android.lebo.data.datasource.user.UserRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<ILoginDataSource.Remote> { LoginRemoteDataSource(get()) }
    single<IForgotPasswordDataSource.Remote> { ForgotPasswordRemoteDataSource(get()) }
    single<IUserDataSource.Remote> { UserRemoteDataSource(get()) }
}
