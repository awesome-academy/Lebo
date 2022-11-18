package com.atom.android.lebo.data.datasource.forgotpassword

import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.data.api.service.ForgotPasswordService
import io.reactivex.rxjava3.core.Single

class ForgotPasswordRemoteDataSource(private val forgotPasswordService: ForgotPasswordService) :
    IForgotPasswordDataSource.Remote {

    override fun requestForgotPassword(email: String): Single<BaseResponse<String?>> {
        return forgotPasswordService.requestForgotPassword(email)
    }
}
