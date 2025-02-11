package com.bitbybit.scholarzone.objects

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {
    var username by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var gender by mutableStateOf("")
    var birthdate by mutableStateOf("")
    var phoneNumber by mutableStateOf(0)
    var school by mutableStateOf("")
    var program by mutableStateOf("")
    var fullAddress by mutableStateOf("")
    var rpc by mutableStateOf("")
    var bsb by mutableStateOf("")
}


