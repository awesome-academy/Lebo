package com.atom.android.lebo.data.repository.user

import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.data.datasource.user.IUserDataSource
import com.atom.android.lebo.model.User
import io.reactivex.rxjava3.core.Single

class UserRepository(private val remote: IUserDataSource.Remote) : IUserRepository {

    override fun getUsers(): Single<BaseResponse<User?>> {
        return remote.getUsers()
    }

    override fun changedPassword(
        oldPassword: String,
        newPassword: String
    ): Single<BaseResponse<String?>> {
        return remote.changedPassword(oldPassword, newPassword)
    }
}
