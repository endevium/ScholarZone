package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily

@Composable
fun LoginPage(nav: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box {
        Image(
            painter = painterResource(R.drawable.landing_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column {
            Box(modifier = Modifier.padding(start = 10.dp).padding(top = 10.dp)) {
                IconButton(onClick = { nav.navigate(Routes.LandingPage) }) {
                    Image(
                        painter = painterResource(R.drawable.back_button_one),
                        contentDescription = "",
                        modifier = Modifier.width(75.dp).height(75.dp)
                    )
                }
            }

            Box(modifier = Modifier.padding(top = 15.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = colorResource(id = R.color.scholar_blue))) {
                                append("Scholar")
                            }
                            withStyle(style = SpanStyle(color = colorResource(id = R.color.scholar_black), fontWeight = FontWeight.Normal)) { // Zone in black
                                append("Zone")
                            }
                        },
                        textAlign = TextAlign.Center,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = PoppinsFontFamily
                    )

                    Text(
                        text = "Apply for scholarships easier",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = PoppinsFontFamily,
                        color = colorResource(id = R.color.scholar_blue)
                    )
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            Box(modifier = Modifier
                .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))
                .background(color = Color.White)
                .fillMaxWidth()
                .height(650.dp)
            ) {
                Column(modifier = Modifier.padding(start = 35.dp).padding(top = 40.dp)) {
                    Text(
                        text = "Log In",
                        fontSize = 26.sp,
                        color = colorResource(id = R.color.scholar_blue),
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    Text(
                        text = "Please log in to continue",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Normal,
                        fontFamily = InterFontFamily
                    )
                    Spacer(Modifier.height(25.dp))

                    Text(
                        text = "E-mail Address",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("ex: john.doe@example.com")},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = ""
                            )
                        },
                        modifier = Modifier.width(310.dp).height(55.dp),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(13.dp))

                    Text(
                        text = "Password",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("Enter your password")},
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = ""
                            )
                        },
                        modifier = Modifier.width(310.dp).height(55.dp),
                        shape = RoundedCornerShape(15.dp),
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    TextButton(onClick = {}) {
                        Text(text = "Forgot Password?",
                            fontWeight = FontWeight.Bold,
                            fontFamily = InterFontFamily,
                            fontSize = 16.sp,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(299.dp),
                            color = colorResource(id = R.color.scholar_black)
                       )
                    }

                    Spacer(Modifier.height(15.dp))

                    Button(onClick = { },
                        modifier = Modifier.height(60.dp).width(315.dp),
                        shape = RoundedCornerShape(15.dp),
                        elevation = ButtonDefaults.buttonElevation(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.scholar_darker_blue),
                        )
                    ) {
                        Text(text = "Log In",
                            fontSize = 18.sp,
                            fontFamily = PoppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    TextButton(onClick = { nav.navigate(Routes.SignupPage) }) {
                        Text(text = "Don't have an account? Sign up instead",
                            fontWeight = FontWeight.Light,
                            fontFamily = InterFontFamily,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(299.dp),
                            color = colorResource(id = R.color.scholar_blue)
                        )
                    }
                }
            }
        }





    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    LoginPage(rememberNavController())
}
