package com.bitbybit.scholarzone.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.models.ForgotPasswordResponse
import com.bitbybit.scholarzone.api.OTP
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.objects.ForgotPasswordViewModel
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ForgotPassword(nav: NavController, viewModel: ForgotPasswordViewModel) {
    val context = LocalContext.current

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
                .padding(top = 15.dp)
        ) {
            Box {
                IconButton(onClick = { nav.navigate(Routes.LoginPage) }) {
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
                        .background(color = colorResource(R.color.scholar_darker_blue))
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
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Forgot Password",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_blue),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(15.dp))

            Text(
                text = "Email Address",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            OutlinedTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                placeholder = { Text("john.doe@example.com")},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = ""
                    )
                },
                modifier = Modifier
                    .width(330.dp)
                    .height(55.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(15.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                maxLines = 1,
                textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
            )

            Spacer(Modifier.height(450.dp))

            Button(onClick = {
                if (viewModel.email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(viewModel.email).matches()) {
                    val apiService = RetrofitClient.create(APIService::class.java)
                    val otp = OTP(
                        email = viewModel.email,
                    )

                    apiService.generateOTP(otp).enqueue(object: Callback<com.bitbybit.scholarzone.models.ForgotPasswordResponse> {
                        override fun onResponse(
                            call: Call<com.bitbybit.scholarzone.models.ForgotPasswordResponse>,
                            response: Response<com.bitbybit.scholarzone.models.ForgotPasswordResponse>
                        ) {
                            if (response.isSuccessful && response.body() != null) {
                                Toast.makeText(context, "Your OTP has been sent. Please check your e-mail.", Toast.LENGTH_SHORT).show()
                                nav.navigate(Routes.ForgotPasswordTwo)
                            } else {
                                try {
                                    val errorBody = response.errorBody()?.string()
                                    val errorResponse = Gson().fromJson(
                                        errorBody,
                                        com.bitbybit.scholarzone.models.ForgotPasswordResponse::class.java
                                    )
                                    Toast.makeText(
                                        context,
                                        errorResponse.message,
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } catch (e: Exception) {
                                    Toast.makeText(
                                        context,
                                        "Failed to change password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<com.bitbybit.scholarzone.models.ForgotPasswordResponse>, t: Throwable) {
                            Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
                        }

                    })
                } else {
                    Toast.makeText(context, "Enter a valid email address", Toast.LENGTH_SHORT).show()
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
                Text(text = "Next",
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
fun PreviewForgotPassword() {
    ForgotPassword(rememberNavController(), ForgotPasswordViewModel())
}