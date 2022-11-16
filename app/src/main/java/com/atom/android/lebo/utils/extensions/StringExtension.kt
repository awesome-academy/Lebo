package com.atom.android.lebo.utils.extensions

import android.content.Context
import com.atom.android.lebo.R
import com.atom.android.lebo.utils.constants.Constant
import java.util.regex.Pattern

fun String?.isValidEmail(context: Context?) = when {
    this.isNullOrEmpty() -> {
        Pair(false, context?.getString(R.string.mess_required_field_email))
    }
    !Pattern.matches(Constant.REGEX.EMAIL, this) -> {
        Pair(false, context?.getString(R.string.mess_validate_email_failed))
    }
    else -> {
        Pair(true, null)
    }
}

fun String?.isValidPassword(context: Context?) = when {
    this.isNullOrEmpty() -> {
        Pair(false, context?.getString(R.string.mess_required_field_password))
    }
    !this.matches(Constant.REGEX.PASS_WORD.toRegex()) -> {
        Pair(false, context?.getString(R.string.mess_validate_password_failed))
    }
    else -> {
        Pair(true, null)
    }
}

fun String?.isValidConfirmPassword(context: Context?, password: String) = when {
    this.isNullOrEmpty() -> {
        Pair(false, context?.getString(R.string.mess_required_field_confirm_password))
    }
    this != password -> {
        Pair(false, context?.getString(R.string.mess_validate_confirm_password_failed))
    }
    else -> {
        Pair(true, null)
    }
}

fun String?.isValidOTP(context: Context?) = when {
    this.isNullOrEmpty() -> {
        Pair(false, context?.getString(R.string.mess_required_field_otp))
    }
    this.length != Constant.DEFAULT.LENGTH_OTP -> {
        Pair(false, context?.getString(R.string.mess_validate_otp_failed))
    }
    else -> {
        Pair(true, null)
    }
}
