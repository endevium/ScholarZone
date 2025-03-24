package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
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
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily

@Composable
fun LandingPage(nav: NavController) {
    Box {
        Image(
            painter = painterResource(R.drawable.landing_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(modifier = Modifier.padding(top = 180.dp)) {
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
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsFontFamily
                )

                Text(
                    text = "Apply for scholarships easier",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = PoppinsFontFamily,
                    color = colorResource(id = R.color.scholar_blue)
                )
            }
        }

        Box(modifier = Modifier.padding(top = 550.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(20.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { nav.navigate(Routes.LoginPage) },
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

                Button(onClick = { nav.navigate(Routes.SignupPage) },
                    modifier = Modifier.height(60.dp).width(315.dp),
                    shape = RoundedCornerShape(15.dp),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                    )
                ) {
                    Text(text = "Sign Up",
                        fontSize = 18.sp,
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.scholar_black)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLanding() {
    LandingPage(rememberNavController())
}