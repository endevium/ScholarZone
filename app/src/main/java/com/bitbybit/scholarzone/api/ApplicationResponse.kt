package com.bitbybit.scholarzone.api

data class ApplicationResponse(
    val status: Int,
    val message: String,
    val data: List<Application>
)
