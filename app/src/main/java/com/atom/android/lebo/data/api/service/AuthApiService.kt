package com.atom.android.lebo.data.api.service

import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.model.User
import com.atom.android.lebo.utils.constants.ApiConstant
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {

    interface UserService {

        @GET(ApiConstant.ENDPOINT.USER)
        fun getUser(): Single<BaseResponse<User?>>

        @FormUrlEncoded
        @POST(ApiConstant.ENDPOINT.CHANGE_PASSWORD)
        fun changePassword(
            @Field(ApiConstant.FILED.OLD_PASSWORD) oldPassword: String,
            @Field(ApiConstant.FILED.NEW_PASSWORD) newPassword: String
        ): Single<BaseResponse<String?>>
    }
}
