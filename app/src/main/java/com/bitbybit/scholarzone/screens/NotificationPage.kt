package com.bitbybit.scholarzone.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily

@Composable
fun NotificationPage(nav: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column {
            Row(Modifier
                .offset(x = 18.dp, y = 24.dp)
                .fillMaxWidth()
                .height(65.dp)) {
                Text(
                    "Notifications",
                    fontSize = 20.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }

            LazyColumn {
                // Notification Card
                item {
                    Column(
                        Modifier.fillMaxWidth()
                            .height(160.dp)
                            .border(1.dp, colorResource(R.color.scholar_light_gray),
                            )
                    ) {
                        // Notification Name
                        Text(
                            "Application Status",
                            fontSize = 16.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .offset(x = 18.dp, y = 10.dp)
                                .padding(bottom = 5.dp)
                        )

                        // Notification Description
                        Text(
                            "Your application for Hawak Kamay was approved.",
                            fontSize = 14.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .offset(x = 18.dp, y = 10.dp)
                                .padding(bottom = 10.dp)
                        )

                        Button(
                            onClick = {
                                nav.navigate(Routes.DashboardPage)
                            },
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier.height(35.dp).width(110.dp)
                                .offset(x = 265.dp, y = 55.dp)
                                .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                            )
                        ) {
                            Text("View",
                                fontSize = 13.sp,
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = colorResource(R.color.scholar_blue)
                            )
                        }
                    }
                }

                item {
                    Spacer(Modifier.height(100.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNotification() {
    NotificationPage(rememberNavController())
}