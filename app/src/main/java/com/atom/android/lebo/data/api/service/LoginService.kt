package com.atom.android.lebo.data.api.service

import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.model.LoginEntity
import com.atom.android.lebo.utils.constants.ApiConstant
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST(ApiConstant.ENDPOINT.LOGIN)
    fun login(@Body loginEntity: LoginEntity): Single<BaseResponse<String?>>

    @GET(ApiConstant.ENDPOINT.CHECK_LOGIN)
    fun checkLogin(): Single<BaseResponse<String?>>

    @POST(ApiConstant.ENDPOINT.GENERATE_OTP)
    fun requestOTPLogin(@Query(ApiConstant.FILED.EMAIL) email: String?): Single<BaseResponse<String?>>
}
