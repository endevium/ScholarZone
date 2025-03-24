package com.bitbybit.scholarzone.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.api.clearToken
import com.bitbybit.scholarzone.objects.ProfileViewModel
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily

@Composable
fun ProfilePage(nav: NavController, rootNav: NavController) {
    val context = LocalContext.current
    val viewModel: ProfileViewModel = remember { ProfileViewModel(context) }
    val applicant = viewModel.applicant.value

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Profile",
                fontSize = 20.sp,
                modifier = Modifier.offset(y = 24.dp)
                    .padding(bottom = 35.dp)
                    .fillMaxWidth(),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(R.drawable.profile_circle),
                contentDescription = "",
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )

            Spacer(Modifier.height(5.dp))
            Button(
                onClick = { },
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier.height(35.dp).width(135.dp)
                    .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Text("Edit Picture",
                    fontSize = 15.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = colorResource(R.color.scholar_blue)
                )
            }

            Text(
                applicant?.username ?: "Loading...",
                fontSize = 18.sp,
                modifier = Modifier.offset(y = 24.dp)
                    .padding(bottom = 5.dp)
                    .fillMaxWidth(),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )

            Text(
                applicant?.email ?: "Loading...",
                fontSize = 18.sp,
                modifier = Modifier.offset(y = 24.dp)
                    .padding(bottom = 45.dp)
                    .fillMaxWidth(),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.ExtraLight,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    nav.navigate(Routes.PersonalDetailsPage)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp).width(105.dp)
                    .border(1.dp, colorResource(R.color.scholar_light_gray), RoundedCornerShape(0.dp)),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile Icon",
                        modifier = Modifier.size(30.dp),
                        tint = colorResource(R.color.scholar_black),
                    )

                    Text("Personal Details",
                        color = colorResource(R.color.scholar_black),
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 15.dp)
                    )
                }
            }

            Button(
                onClick = {
                    nav.navigate(Routes.AccountDetailsPage)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp).width(105.dp)
                    .border(1.dp, colorResource(R.color.scholar_light_gray), RoundedCornerShape(0.dp)),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Profile Icon",
                        modifier = Modifier.size(30.dp),
                        tint = colorResource(R.color.scholar_black),
                    )

                    Text("Account Details",
                        color = colorResource(R.color.scholar_black),
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 15.dp)
                    )
                }
            }

            Button(
                onClick = {
                    rootNav.navigate(Routes.LandingPage) {
                        popUpTo(Routes.LandingPage) { inclusive = true } // Clears back stack
                    }
                    clearToken(context)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp).width(105.dp)
                    .border(1.dp, colorResource(R.color.scholar_light_gray), RoundedCornerShape(0.dp)),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.logout),
                        contentDescription = "Profile Icon",
                        modifier = Modifier.size(30.dp),
                        tint = Color.Red,
                    )

                    Text("Log Out",
                        color = Color.Red,
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 15.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    ProfilePage(rememberNavController(), rememberNavController())
}