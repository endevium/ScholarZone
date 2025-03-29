package com.bitbybit.scholarzone.models

data class ScholarshipApplication(
    val id: Int,
    val reviewer_id: Int,
    val application_name: String,
    val company: String,
    val application_description: String,
    val duration: String,
    val application_image: String?,
    val category: String,
    val slots: Int,
    val deadline: String
)
