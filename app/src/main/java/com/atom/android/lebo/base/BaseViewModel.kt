package com.atom.android.lebo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : ViewModel() {

    protected val loading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = loading

    protected val error = MutableLiveData<String>()
    val hasError: LiveData<String>
        get() = error

    private val compositeDisposable = CompositeDisposable()

    protected fun registerDisposable(disposable : Disposable){
        compositeDisposable.add(disposable)
    }

    protected fun showLoading() {
        loading.value = true
    }

    protected fun hideLoading() {
        loading.value = false
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
