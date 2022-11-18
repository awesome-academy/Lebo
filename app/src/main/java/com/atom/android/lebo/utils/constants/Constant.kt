package com.atom.android.lebo.utils.constants

object Constant {

    private const val PROJECT_NAME = "com.atom.android.lebo."

    object DIALOGCONFIG {
        const val MARGIN_Y = -170
    }

    object REGEX {
        const val NUMBER_PHONE = "([0-9]{9,10})\\b"
        const val EMAIL = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$"
        const val PASS = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
        const val PASS_WORD = "^.{6,}$"
    }

    object DELAY {
        const val SPLASH_SCREEN = 1500L
        const val INPUT_TEXT = 500L
    }

    object Type {
        const val NETWORK = "NETWORK"
        const val HTTP = "HTTP"
        const val SERVER = "SERVER"
        const val UNEXPECTED = "UNEXPECTED"
    }

    object BUNDLED {
        const val EMAIL = "BUNDLED_EMAIL"
    }

    object DEFAULT {
        const val POSITION = 0
        const val STRING = ""
        const val LENGTH_OTP = 6
    }

    const val SIZE_DEFAULT_IMAGE = 120

    const val SIZE_SPAN_OF_TEXT = 1.2f
    const val SIZE_SPAN_OF_NUMBER = 0.8f

    const val SECOND_TO_MILLI = 1000L

    const val SHARED_PREF_ROOT = PROJECT_NAME + "SHARED_PREF"
    const val SHARED_PREF_DEFAULT_STRING = ""
    const val SHARED_PREF_TOKEN_LOGIN = PROJECT_NAME + "TOKEN_LOGIN"
    const val SHARED_PREF_EMAIL = PROJECT_NAME + "EMAIL"
}
