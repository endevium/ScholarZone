package com.bitbybit.scholarzone.models

class AccountDetails {
    data class Username(
        val username: String
    )

    data class Email(
        val email: String
    )

    data class Password(
        val oldPassword: String,
        val newPassword: String,
    )
}