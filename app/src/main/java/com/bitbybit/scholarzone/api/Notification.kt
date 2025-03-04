package com.bitbybit.scholarzone.api

data class Notification(
    val id: Int,
    val applicant_id: Int,
    val title: String,
    val body: String
)
