package com.bitbybit.scholarzone.models

data class QuestionResponse(
    val status: Int,
    val data: List<com.bitbybit.scholarzone.models.Question>
)
