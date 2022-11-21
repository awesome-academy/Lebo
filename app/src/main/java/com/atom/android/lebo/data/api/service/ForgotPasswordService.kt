package com.atom.android.lebo.data.api.service

import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.utils.constants.ApiConstant
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ForgotPasswordService {

    @FormUrlEncoded
    @POST(ApiConstant.ENDPOINT.FORGOT_PASSWORD)
    fun requestForgotPassword(@Field(ApiConstant.FILED.EMAIL) email: String): Single<BaseResponse<String?>>
}
