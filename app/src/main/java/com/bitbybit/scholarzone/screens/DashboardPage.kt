package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.DashboardViewModel
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun DashboardPage(nav: NavController) {
    val context = LocalContext.current
    val viewModel = remember { DashboardViewModel(context) }

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
                        onClick = { viewModel.loadAllApplications() },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(82.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("All",
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
                        onClick = { viewModel.filterApplicationsByCategory("Undergraduate") },
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
                        onClick = { viewModel.filterApplicationsByCategory("Graduate") },
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

                item {
                    Button(
                        onClick = { viewModel.filterApplicationsByCategory("STEM") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(92.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("STEM",
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
                        onClick = { viewModel.filterApplicationsByCategory("Arts") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(92.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Arts",
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
                        onClick = { viewModel.filterApplicationsByCategory("Business") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(112.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Business",
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
                        onClick = { viewModel.filterApplicationsByCategory("Education") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(122.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Education",
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
                        onClick = { viewModel.filterApplicationsByCategory("Medicine") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(112.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Medicine",
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
                        onClick = { viewModel.filterApplicationsByCategory("Law") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(92.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Law",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }

                    Spacer(Modifier.width(12.dp))
                }
            }

            LazyRow(Modifier.padding(start = 18.dp, top = 75.dp))
            {
                item {
                    Button(
                        onClick = { viewModel.filterApplicationsByStatus("Pending") },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(105.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Pending",
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
                        onClick = { viewModel.filterApplicationsByStatus("Approved") },
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
                        onClick = { viewModel.filterApplicationsByStatus("Rejected") },
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
            LazyColumn(Modifier.fillMaxSize()) {
                if (viewModel.applications.isEmpty()) {
                    item {
                        Spacer(Modifier.height(250.dp))
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "No applications found",
                                fontSize = 16.sp,
                                fontFamily = InterFontFamily,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray
                            )
                        }
                    }
                } else {
                    items(viewModel.applications) { application ->
                        Box(
                            modifier = Modifier
                                .width(350.dp)
                                .height(200.dp)
                                .offset(x = 18.dp, y = 10.dp)
                                .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(20.dp))
                        ) {
                            Row {
                                Box(
                                    Modifier
                                        .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                                        .width(125.dp)
                                        .fillMaxHeight()
                                ) {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(application.application_image?.takeIf { it.isNotBlank() } ?: "")
                                            .crossfade(true)
                                            .placeholder(R.drawable.scholarship)
                                            .error(R.drawable.scholarship)
                                            .build(),
                                        contentDescription = "Scholarship Image",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                Column(Modifier.offset(x = 15.dp, y = 10.dp)) {
                                    Text(
                                        application.application_name,
                                        fontSize = 14.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(bottom = 5.dp)
                                    )

                                    Text(
                                        application.company,
                                        fontSize = 14.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Light,
                                        modifier = Modifier.padding(bottom = 5.dp)
                                    )

                                    Text(
                                        "Category: ${application.category}",
                                        fontSize = 14.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Light,
                                        modifier = Modifier.padding(bottom = 5.dp)
                                    )

                                    Text(
                                        "Deadline: ${application.deadline}",
                                        fontSize = 14.sp,
                                        fontFamily = InterFontFamily,
                                        fontWeight = FontWeight.Light,
                                        modifier = Modifier.padding(bottom = 5.dp)
                                    )

                                    if (application.status == "Approved") {
                                        Text(
                                            "Status: ${application.status}",
                                            fontSize = 14.sp,
                                            fontFamily = InterFontFamily,
                                            color = Color.Green,
                                            fontWeight = FontWeight.Light,
                                            modifier = Modifier.padding(bottom = 5.dp)
                                        )
                                    } else if (application.status == "Pending") {
                                        Text(
                                            "Status: ${application.status}",
                                            fontSize = 14.sp,
                                            fontFamily = InterFontFamily,
                                            fontWeight = FontWeight.Light,
                                            modifier = Modifier.padding(bottom = 5.dp)
                                        )
                                    } else if (application.status == "Rejected") {
                                        Text(
                                            "Status: ${application.status}",
                                            fontSize = 14.sp,
                                            fontFamily = InterFontFamily,
                                            color = Color.Red,
                                            fontWeight = FontWeight.Light,
                                            modifier = Modifier.padding(bottom = 5.dp)
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(Modifier.height(12.dp))
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
fun PreviewDashboard() {
    DashboardPage(rememberNavController())
}