package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.ProfileViewModel
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily

@Composable
fun AccountDetailsPage(nav: NavController) {
    val context = LocalContext.current
    val viewModel: ProfileViewModel = remember { ProfileViewModel(context) }
    val applicant = viewModel.applicant.value

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column {
            Row(
                Modifier.fillMaxWidth().height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { nav.navigate(Routes.ProfilePage) },
                    modifier = Modifier.offset(x = 15.dp, y = 15.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.back_button_one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                    )
                }

                Text(
                    "Account Details",
                    fontSize = 20.sp,
                    modifier = Modifier.offset(x = 20.dp, y = 15.dp)
                        .fillMaxWidth(),
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Bold,
                )
            }


            Spacer(Modifier.height(20.dp))
            LazyColumn {
                // FIRST NAME
                item {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(75.dp)
                            .border(
                                1.dp,
                                colorResource(R.color.scholar_light_gray),
                                RoundedCornerShape(0.dp)
                            )
                    ) {
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Username",
                            fontSize = 18.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 25.dp)
                                .weight(1f)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // NAME
                            Text(
                                applicant?.username ?: "Loading...",
                                fontSize = 18.sp,
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(start = 25.dp)
                                    .width(300.dp)
                            )

                            IconButton(onClick = { nav.navigate(Routes.EditUsernamePage)}) {
                                Image(
                                    painter = painterResource(R.drawable.edit_button),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }
                        }
                    }
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(75.dp)
                            .border(
                                1.dp,
                                colorResource(R.color.scholar_light_gray),
                                RoundedCornerShape(0.dp)
                            )
                    ) {
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Email Address",
                            fontSize = 18.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 25.dp)
                                .weight(1f)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // NAME
                            Text(
                                applicant?.email ?: "Loading...",
                                fontSize = 18.sp,
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(start = 25.dp)
                                    .width(300.dp)
                            )

                            IconButton(onClick = { nav.navigate(Routes.EditEmailPage) }) {
                                Image(
                                    painter = painterResource(R.drawable.edit_button),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }
                        }
                    }
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(75.dp)
                            .border(
                                1.dp,
                                colorResource(R.color.scholar_light_gray),
                                RoundedCornerShape(0.dp)
                            )
                    ) {
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Password",
                            fontSize = 18.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 25.dp)
                                .weight(1f)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // NAME
                            Text(
                                "********",
                                fontSize = 18.sp,
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(start = 25.dp)
                                    .width(300.dp)
                            )

                            IconButton(onClick = { nav.navigate(Routes.EditPasswordPage) }) {
                                Image(
                                    painter = painterResource(R.drawable.edit_button),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(30.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewAccountDetails() {
    AccountDetailsPage(rememberNavController())
}