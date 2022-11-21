package com.atom.android.lebo.data.di

import com.atom.android.lebo.data.repository.forgotpassword.ForgotPasswordRepository
import com.atom.android.lebo.data.repository.login.LoginRepository
import com.atom.android.lebo.data.repository.user.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRepository(get()) }
    single { ForgotPasswordRepository(get()) }
    single { UserRepository(get()) }
}
