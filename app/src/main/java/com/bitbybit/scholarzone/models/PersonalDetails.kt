package com.bitbybit.scholarzone.models

class PersonalDetails {
    data class FirstName(
        val firstName: String
    )

    data class LastName(
        val lastName: String
    )

    data class Gender(
        val gender: String
    )

    data class Birthdate(
        val birthdate: String
    )

    data class PhoneNumber(
        val phone_number: Int
    )

    data class School(
        val school: String
    )

    data class Program(
        val program: String
    )

    data class RPC(
        val rpc: String
    )

    data class BSB(
        val bsb: String
    )
}