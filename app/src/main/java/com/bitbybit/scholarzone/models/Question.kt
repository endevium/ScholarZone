package com.bitbybit.scholarzone.models

data class Question(
    val id: Int,
    val question: String,
    val type: String,
    val answer: String?
)
