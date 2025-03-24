package com.bitbybit.scholarzone.api

data class ApplicantResponse(
    val status: Int,
    val message: String,
    val id: Int,
    val token: String
)
