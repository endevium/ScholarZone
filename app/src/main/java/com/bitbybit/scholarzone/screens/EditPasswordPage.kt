package com.bitbybit.scholarzone.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
import com.bitbybit.scholarzone.models.AccountDetails
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily

@Composable
fun EditPasswordPage(nav: NavController) {
    val context = LocalContext.current
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var oldPasswordVisible by remember { mutableStateOf(false) }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .offset(x = 15.dp, y = 15.dp)
        ) {
            Box {
                IconButton(onClick = { nav.navigate(Routes.AccountDetailsPage) }) {
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

            Text(
                text = "Edit Password",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_blue),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Old Password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            OutlinedTextField(
                value = oldPassword,
                onValueChange = { oldPassword = it },
                placeholder = { Text("Enter old password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val visibilityIcon = if (oldPasswordVisible) {
                        painterResource(id = R.drawable.eye_visibility_off)
                    } else {
                        painterResource(id = R.drawable.eye_visibility)
                    }
                    IconButton(onClick = { oldPasswordVisible = !oldPasswordVisible }) {
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
                visualTransformation = if (oldPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = "New Password",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            OutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholder = { Text("Create a new password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                    val visibilityIcon = if (newPasswordVisible) {
                        painterResource(id = R.drawable.eye_visibility_off)
                    } else {
                        painterResource(id = R.drawable.eye_visibility)
                    }
                    IconButton(onClick = { newPasswordVisible = !newPasswordVisible }) {
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
                visualTransformation = if (newPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
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
                placeholder = { Text("Re-enter new password") },
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

            Spacer(Modifier.height(10.dp))
        }

        Button(
            onClick = {
                when {
                    oldPassword.isEmpty() -> {
                        Toast.makeText(context, "Old password is required", Toast.LENGTH_SHORT).show()
                    }
                    newPassword.length < 8 -> {
                        Toast.makeText(context, "Password must be at least 8 characters", Toast.LENGTH_SHORT).show()
                    }
                    confirmPassword != newPassword -> {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        val password = com.bitbybit.scholarzone.models.AccountDetails.Password(
                            oldPassword = oldPassword,
                            newPassword = newPassword,
                        )

                        val apiService = RetrofitClient.create(APIService::class.java)
                    }
                }
            },
            modifier = Modifier
                .height(90.dp)
                .width(330.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.scholar_darker_blue),
            )
        ) {
            Text(text = "Save Changes",
                fontSize = 18.sp,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewPassword() {
    EditPasswordPage(rememberNavController())
}