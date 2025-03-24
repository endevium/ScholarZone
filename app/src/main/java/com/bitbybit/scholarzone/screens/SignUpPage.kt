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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.objects.SignUpViewModel
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily

@Composable
fun SignupPage(nav: NavController, viewModel: SignUpViewModel) {
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }
    val focusRequester3 = remember { FocusRequester() }
    val focusRequester4 = remember { FocusRequester() }

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column (modifier = Modifier
            .padding(start = 15.dp)
            .padding(top = 15.dp)) {
            Box {
                IconButton(onClick = { nav.navigate(Routes.LandingPage) }) {
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
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(color = colorResource(R.color.scholar_darker_blue))
                    .height(15.dp)
                    .width(100.dp))

                Spacer(Modifier.width(8.dp))

                Box(modifier = Modifier
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(color = colorResource(R.color.scholar_light_gray))
                    .height(15.dp)
                    .width(100.dp))

                Spacer(Modifier.width(8.dp))

                Box(modifier = Modifier
                    .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                    .background(color = colorResource(R.color.scholar_light_gray))
                    .height(15.dp)
                    .width(100.dp))
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

            Spacer(Modifier.height(5.dp))

            Text(
                text = "Start your journey with ScholarZone!",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_black),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(25.dp))

            LazyColumn {
                item {
                    Text(
                        text = "Account Details",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily,
                        color = colorResource(id = R.color.scholar_black),
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(bottom = 5.dp)
                    )

                    Text(
                        text = "Username",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = viewModel.username,
                        onValueChange = { newValue ->
                            if (newValue.all { it.isLetterOrDigit() }) {
                                viewModel.username = newValue
                            }
                        },
                        placeholder = { Text("johndoe69")},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = ""
                            )
                        },
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp)
                            .focusRequester(focusRequester1),
                        shape = RoundedCornerShape(15.dp),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester2.requestFocus() }
                        ),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
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
                            .padding(start = 10.dp)
                            .focusRequester(focusRequester2),
                        shape = RoundedCornerShape(15.dp),
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester3.requestFocus() }
                        ),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
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
                        value = viewModel.password,
                        onValueChange = { viewModel.password = it },
                        placeholder = { Text("********") },
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
                        keyboardActions = KeyboardActions(
                            onNext = { focusRequester4.requestFocus() }
                        ),
                        maxLines = 1,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
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
                        placeholder = { Text("********") },
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
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done)
                    )

                    Spacer(Modifier.height(25.dp))
                }
            }

            NextBar(nav, viewModel.username, viewModel.email, viewModel.password, confirmPassword)
        }
    }
}

@Composable
fun NextBar(nav: NavController, username: String, email: String, password: String, confirmPassword: String) {
    val context = LocalContext.current

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
                    username.isEmpty() -> {
                        Toast.makeText(context, "Username is required", Toast.LENGTH_SHORT).show()
                    }
                    email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                        Toast.makeText(context, "Enter a valid email address", Toast.LENGTH_SHORT).show()
                    }
                    password.length < 8 -> {
                        Toast.makeText(context, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show()
                    }
                    confirmPassword != password -> {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        nav.navigate(Routes.SignupPageTwo)
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
fun PreviewSignup() {
    SignupPage(rememberNavController(), SignUpViewModel())
}