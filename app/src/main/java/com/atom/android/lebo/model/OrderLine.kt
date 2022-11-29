package com.atom.android.lebo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderLine(
    val amount: Int,
    val book: Book,
    val price: Double
) : Parcelable
