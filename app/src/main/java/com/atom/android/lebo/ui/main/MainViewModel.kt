package com.atom.android.lebo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.base.BaseViewModel
import com.atom.android.lebo.data.repository.user.UserRepository
import com.atom.android.lebo.model.User

class MainViewModel(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _user = MutableLiveData<BaseResponse<User?>>()
    val user: LiveData<BaseResponse<User?>>
        get() = _user

    init {
        getUser()
    }
    fun getUser() {
        registerDisposable(
            executeTask(
                task = { userRepository.getUsers() },
                onSuccess = {
                    _user.value = it
                },
                onError = { error.value = it.message },
                loadingInvisible = false
            )
        )
    }
}
