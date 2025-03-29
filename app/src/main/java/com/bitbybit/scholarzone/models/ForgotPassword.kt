package com.bitbybit.scholarzone.models

data class ForgotPassword(
    val email: String,
    val new_password: String,
    val otp: Int
)
