package com.atom.android.lebo.utils.extensions

import com.atom.android.lebo.utils.constants.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun <T> Single<T>.withIOToMainThread(): Single<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.withIOToMainThread(): Observable<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.ignoreFastAction() =
    debounce(Constant.DELAY.INPUT_TEXT, TimeUnit.MILLISECONDS).withIOToMainThread()

fun <T> Single<T>.handleLoading(show: () -> Unit, hide: () -> Unit) =
    doOnSubscribe { show() }.doOnSuccess { hide() }.doOnError { hide() }
