package com.bitbybit.scholarzone.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.models.ForgotPassword
import com.bitbybit.scholarzone.models.ForgotPasswordResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.models.SubmitApplicationResponse
import com.bitbybit.scholarzone.objects.ForgotPasswordViewModel
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ForgotPasswordTwo(nav: NavController, viewModel: ForgotPasswordViewModel) {
    var otp by remember { mutableIntStateOf(0) }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPassword by remember { mutableStateOf("") }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
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
                IconButton(onClick = { nav.navigate(Routes.ForgotPassword) }) {
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
                        .background(color = colorResource(R.color.scholar_darker_blue))
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
                text = "One-Time PIN",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            OutlinedTextField(
                value = if (otp == 0) "" else otp.toString(), // Convert Int to String for display
                onValueChange = { newValue ->
                    val intValue = newValue.toIntOrNull() // Convert String to Int safely
                    if (intValue != null && newValue.length <= 6) {
                        otp = intValue
                    }
                },
                placeholder = { Text("123456") },
                modifier = Modifier
                    .width(330.dp)
                    .height(55.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(15.dp),
                textStyle = TextStyle(
                    color = colorResource(id = R.color.scholar_black),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = InterFontFamily
                ),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = "Password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Create a password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val visibilityIcon = if (passwordVisible) {
                        painterResource(id = R.drawable.eye_visibility_off)
                    } else {
                        painterResource(id = R.drawable.eye_visibility)
                    }
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Image(painter = visibilityIcon, contentDescription = "Toggle password visibility")
                    }
                },
                modifier = Modifier
                    .width(330.dp)
                    .height(55.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(15.dp),
                textStyle = TextStyle(
                    color = colorResource(id = R.color.scholar_black),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = InterFontFamily
                ),
                maxLines = 1,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(Modifier.height(10.dp))
            Text(
                text = "Confirm Password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = { Text("Re-enter your password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val visibilityIcon = if (confirmPasswordVisible) {
                        painterResource(id = R.drawable.eye_visibility_off)
                    } else {
                        painterResource(id = R.drawable.eye_visibility)
                    }
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Image(painter = visibilityIcon, contentDescription = "Toggle password visibility")
                    }
                },
                modifier = Modifier
                    .width(330.dp)
                    .height(55.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(15.dp),
                textStyle = TextStyle(
                    color = colorResource(id = R.color.scholar_black),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = InterFontFamily
                ),
                maxLines = 1,
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(Modifier.height(275.dp))

            Button(onClick = {
                if (password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                    if (confirmPassword == password) {
                        val apiService = RetrofitClient.create(APIService::class.java)
                        val forgotPassword = com.bitbybit.scholarzone.models.ForgotPassword(
                            email = viewModel.email,
                            new_password = password,
                            otp = otp
                        )

                        apiService.forgotPassword(forgotPassword).enqueue(object: Callback<com.bitbybit.scholarzone.models.ForgotPasswordResponse> {
                            override fun onResponse(
                                call: Call<com.bitbybit.scholarzone.models.ForgotPasswordResponse>,
                                response: Response<com.bitbybit.scholarzone.models.ForgotPasswordResponse>
                            ) {
                                if (response.isSuccessful && response.body() != null) {
                                    Toast.makeText(context, "Changed password successfully", Toast.LENGTH_SHORT).show()
                                    nav.navigate(Routes.LoginPage)
                                } else {
                                    try {
                                        val errorBody = response.errorBody()?.string()
                                        val errorResponse = Gson().fromJson(errorBody, com.bitbybit.scholarzone.models.ForgotPasswordResponse::class.java)
                                        Toast.makeText(context, errorResponse.message, Toast.LENGTH_SHORT).show()
                                    } catch (e: Exception) {
                                        Toast.makeText(context, "Failed to change password", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }

                            override fun onFailure(
                                call: Call<com.bitbybit.scholarzone.models.ForgotPasswordResponse>,
                                t: Throwable
                            ) {
                                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
                            }

                        })
                        Toast.makeText(context, "Placeholder Text for successful", Toast.LENGTH_SHORT).show()
                    }
                     else {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Password fields are required", Toast.LENGTH_SHORT).show()
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
fun PreviewFPT() {
    ForgotPasswordTwo(rememberNavController(), ForgotPasswordViewModel())
}