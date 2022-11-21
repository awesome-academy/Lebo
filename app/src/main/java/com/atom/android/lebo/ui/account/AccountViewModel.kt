package com.atom.android.lebo.ui.account

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atom.android.lebo.base.BaseViewModel
import com.atom.android.lebo.utils.extensions.destroyTokenLogin

class AccountViewModel(private val sharedPreferences: SharedPreferences) : BaseViewModel() {

    private val _logoutState = MutableLiveData<Boolean>()
    val logoutState: LiveData<Boolean>
        get() = _logoutState

    fun logout() {
        _logoutState.value = sharedPreferences.destroyTokenLogin()
    }
}
