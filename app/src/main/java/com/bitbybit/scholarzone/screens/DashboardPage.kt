package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.ui.theme.InterFontFamily

@Composable
fun DashboardPage(nav: NavController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column {
            Text(
                "Dashboard",
                fontSize = 20.sp,
                modifier = Modifier.offset(x = 18.dp, y = 24.dp)
                    .padding(bottom = 15.dp),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Scholarship Tracker",
                fontSize = 20.sp,
                modifier = Modifier.offset(x = 18.dp, y = 24.dp),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold
            )

            LazyRow(Modifier.offset(x = 18.dp, y = 50.dp)) {
                item {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(95.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Grants",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }

                item {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(152.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Undergraduate",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }

                item {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(112.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Graduate",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }
            }

            LazyRow(Modifier.offset(x = 18.dp, y = 75.dp)) {
                item {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(105.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Applied",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }

                item {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(120.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Approved",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }

                item {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(112.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Rejected",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }
            }

            Spacer(Modifier.height(15.dp))
            LazyColumn(Modifier.fillMaxHeight()) {
                item {
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp)
                            .offset(x = 18.dp, y = 95.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(20.dp))
                    ) {
                        Row {
                            Box(Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                                .width(125.dp).fillMaxHeight()) {
                                Image(painter = painterResource(R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)).fillMaxHeight()
                                )
                            }

                            Column(Modifier.offset(x = 15.dp, y = 10.dp)) {
                                Text(
                                    "Scholarship Name",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Company",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Category: Undergraduate",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Duration: 4 years",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Deadline: 4 days",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Spacer(Modifier.height(25.dp))
                                Button(
                                    onClick = { },
                                    shape = RoundedCornerShape(15.dp),
                                    modifier = Modifier.height(35.dp).width(110.dp)
                                        .offset(x = 80.dp)
                                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                    )
                                ) {
                                    Text("Applied",
                                        fontSize = 12.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.scholar_blue)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                }

                item {
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp)
                            .offset(x = 18.dp, y = 95.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(20.dp))
                    ) {
                        Row {
                            Box(Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                                .width(125.dp).fillMaxHeight()) {
                                Image(painter = painterResource(R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)).fillMaxHeight()
                                )
                            }

                            Column(Modifier.offset(x = 15.dp, y = 10.dp)) {
                                Text(
                                    "Scholarship Name",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Company",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Category: Undergraduate",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Duration: 4 years",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Deadline: 4 days",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Spacer(Modifier.height(25.dp))
                                Button(
                                    onClick = { },
                                    shape = RoundedCornerShape(15.dp),
                                    modifier = Modifier.height(35.dp).width(110.dp)
                                        .offset(x = 80.dp)
                                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                    )
                                ) {
                                    Text("Approved",
                                        fontSize = 12.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.scholar_blue)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                }

                item {
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp)
                            .offset(x = 18.dp, y = 95.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(20.dp))
                    ) {
                        Row {
                            Box(Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                                .width(125.dp).fillMaxHeight()) {
                                Image(painter = painterResource(R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)).fillMaxHeight()
                                )
                            }

                            Column(Modifier.offset(x = 15.dp, y = 10.dp)) {
                                Text(
                                    "Scholarship Name",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Company",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Category: Undergraduate",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Duration: 4 years",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Deadline: 4 days",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Spacer(Modifier.height(25.dp))
                                Button(
                                    onClick = { },
                                    shape = RoundedCornerShape(15.dp),
                                    modifier = Modifier.height(35.dp).width(110.dp)
                                        .offset(x = 80.dp)
                                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                    )
                                ) {
                                    Text("Rejected",
                                        fontSize = 12.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.scholar_blue)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                }

                item {
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp)
                            .offset(x = 18.dp, y = 95.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(20.dp))
                    ) {
                        Row {
                            Box(Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                                .width(125.dp).fillMaxHeight()) {
                                Image(painter = painterResource(R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)).fillMaxHeight()
                                )
                            }

                            Column(Modifier.offset(x = 15.dp, y = 10.dp)) {
                                Text(
                                    "Scholarship Name",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Company",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Category: Undergraduate",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Duration: 4 years",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Text(
                                    "Deadline: 4 days",
                                    fontSize = 14.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )

                                Spacer(Modifier.height(25.dp))
                                Button(
                                    onClick = { },
                                    shape = RoundedCornerShape(15.dp),
                                    modifier = Modifier.height(35.dp).width(110.dp)
                                        .offset(x = 80.dp)
                                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                    )
                                ) {
                                    Text("Applied",
                                        fontSize = 12.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Normal,
                                        color = colorResource(R.color.scholar_blue)
                                    )
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
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
fun PreviewDashboard() {
    DashboardPage(rememberNavController())
}