package com.bitbybit.scholarzone.models

data class Application(
    val application_id: Int,
    val status: String,
    val submitted_at: String,
    val application_name: String,
    val company: String,
    val application_description: String,
    val category: String,
    val duration: String,
    val application_image: String,
    val slots: Int,
    val deadline: String,
    val applicant: com.bitbybit.scholarzone.models.Applicant,
    val questions: List<com.bitbybit.scholarzone.models.Question>
)
