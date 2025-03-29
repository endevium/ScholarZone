package com.bitbybit.scholarzone.models

data class ApplicationResponse(
    val status: Int,
    val message: String,
    val data: List<com.bitbybit.scholarzone.models.Application>
)
