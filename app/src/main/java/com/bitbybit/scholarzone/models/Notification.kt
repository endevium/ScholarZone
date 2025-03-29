package com.bitbybit.scholarzone.models

data class Notification(
    val id: Int,
    val applicant_id: Int,
    val title: String,
    val body: String,
    val date: String
)
