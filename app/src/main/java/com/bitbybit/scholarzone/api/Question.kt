package com.bitbybit.scholarzone.api

data class Question(
    val id: Int,
    val question: String,
    val type: String,
    val answer: String?
)
