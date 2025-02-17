package com.bitbybit.scholarzone.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Applicant
import com.bitbybit.scholarzone.api.ApplicantResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.saveToken
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.objects.SignUpViewModel
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun SignUpPageThree(nav: NavController, viewModel: SignUpViewModel) {

    var school by remember { mutableStateOf("") }
    var program by remember { mutableStateOf("") }
    var fullAddress by remember { mutableStateOf("") }
    var rpc by remember { mutableStateOf("") }
    var bsb by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
                .padding(top = 15.dp)
        ) {
            Box {
                IconButton(onClick = { nav.navigate(Routes.SignupPageTwo) }) {
                    Image(
                        painter = painterResource(R.drawable.back_button_one),
                        contentDescription = "",
                        modifier = Modifier
                            .width(75.dp)
                            .height(75.dp)
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            Row(Modifier.padding(start = 10.dp)) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                        .background(color = colorResource(R.color.scholar_light_gray))
                        .height(15.dp)
                        .width(100.dp)
                )

                Spacer(Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                        .background(color = colorResource(R.color.scholar_light_gray))
                        .height(15.dp)
                        .width(100.dp)
                )

                Spacer(Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                        .background(color = colorResource(R.color.scholar_darker_blue))
                        .height(15.dp)
                        .width(100.dp)
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Sign Up",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_blue),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(13.dp))

            LazyColumn {
                item {
                    Text(
                        text = "School",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = school,
                        onValueChange = { school = it },
                        placeholder = { Text("ex: PHINMA - University of Pangasinan")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Program",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = program,
                        onValueChange = { program = it },
                        placeholder = { Text("ex: Information Technology")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Full Address",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = fullAddress,
                        onValueChange = { fullAddress = it },
                        placeholder = { Text("Enter full address")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Region, Province, City",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = rpc,
                        onValueChange = { rpc = it },
                        placeholder = { Text("Enter your region, province, city")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Barangay, Street, Building",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = bsb,
                        onValueChange = { bsb = it },
                        placeholder = { Text("Enter barangay, street, building")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(40.dp))
                }
            }

            SubmitBar(nav, school, program, fullAddress, rpc, bsb, viewModel)
        }
    }
}

@Composable
fun SubmitBar(nav: NavController, school: String, program: String, fullAddress: String, rpc: String, bsb: String, viewModel: SignUpViewModel) {
    val context = LocalContext.current
    val apiService = RetrofitClient.create(APIService::class.java)

    Box(
        Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(Color.White)) {
        Column {
            TextButton(onClick = { nav.navigate(Routes.LoginPage) }) {
                Text(text = "Already have an account? Log in instead",
                    fontWeight = FontWeight.Light,
                    fontFamily = InterFontFamily,
                    fontSize = 14.sp,
                    modifier = Modifier.width(299.dp),
                    color = colorResource(id = R.color.scholar_blue)
                )
            }

            Button(onClick = {
                when {
                    school.isEmpty() -> {
                        Toast.makeText(context, "School is required", Toast.LENGTH_SHORT).show()
                    }
                    program.isEmpty() -> {
                        Toast.makeText(context, "Program is required", Toast.LENGTH_SHORT).show()
                    }
                    fullAddress.isEmpty() -> {
                        Toast.makeText(context, "Full address is required", Toast.LENGTH_SHORT).show()
                    }
                    rpc.isEmpty() -> {
                        Toast.makeText(context, "Region, province, city are required", Toast.LENGTH_SHORT).show()
                    }
                    bsb.isEmpty() -> {
                        Toast.makeText(context, "Barangay, street, building are required", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        val applicant = Applicant(
                            username = viewModel.username,
                            email = viewModel.email,
                            password = viewModel.password,
                            firstname = viewModel.firstName,
                            lastname = viewModel.lastName,
                            gender = viewModel.gender,
                            birthdate = viewModel.birthdate,
                            phone_number = viewModel.phoneNumber,
                            school = school,
                            program = program,
                            full_address = fullAddress,
                            rpc = rpc,
                            bsb = bsb
                        )

                        val gson = Gson()
                        Log.d("REQUEST_BODY", gson.toJson(applicant))

                        apiService.register("applicants", applicant).enqueue(object: Callback<ApplicantResponse> {
                                override fun onResponse(
                                    call: Call<ApplicantResponse>,
                                    response: Response<ApplicantResponse>
                                ) {
                                    if (response.isSuccessful) {
                                        val signUpResponse = response.body()
                                        val token = signUpResponse?.token

                                        Log.d("SignUpDebug", "Response: ${response.body()}")
                                        if (token != null) {
                                            RetrofitClient.setToken(token)
                                            saveToken(context, token)
                                        }

                                        Toast.makeText(context, "Account created successfully", Toast.LENGTH_SHORT).show()
                                        nav.navigate(Routes.MainPage)
                                    } else {
                                        val errorBody = response.errorBody()?.string()
                                        Toast.makeText(context, "Error: $errorBody", Toast.LENGTH_LONG).show()
                                    }
                                }

                                override fun onFailure(
                                    call: Call<ApplicantResponse>,
                                    t: Throwable
                                ) {
                                    Toast.makeText(context, "An unknown error occured", Toast.LENGTH_SHORT).show()
                                }

                            })

                    }
                }
            },
                modifier = Modifier
                    .height(60.dp)
                    .width(330.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = ButtonDefaults.buttonElevation(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.scholar_darker_blue),
                )
            ) {
                Text(text = "Sign Up",
                    fontSize = 18.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpThree() {
    SignUpPageThree(rememberNavController(), SignUpViewModel())
}