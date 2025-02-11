package com.bitbybit.scholarzone.api

data class Applicant(
    val username: String,
    val email: String,
    val password: String,
    val firstname: String,
    val lastname: String,
    val gender: String,
    val birthdate: String,
    val phone_number: Int,
    val school: String,
    val program: String,
    val full_address: String,
    val rpc: String,
    val bsb: String
)
