package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.api.ScholarshipApplication
import com.bitbybit.scholarzone.objects.ScholarshipApplicationViewModel
import com.bitbybit.scholarzone.ui.theme.InterFontFamily

@Composable
fun HomePage(
    nav: NavController,
    viewModel: ScholarshipApplicationViewModel = viewModel()
) {
    val scholarships = viewModel.scholarships
    var search by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column {
            Text("Home",
                fontSize = 20.sp,
                modifier = Modifier.offset(x = 18.dp, y = 24.dp),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = { Text("Start typing...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                },
                modifier = Modifier
                    .width(350.dp)
                    .height(60.dp)
                    .offset(x = 18.dp, y = 35.dp),
                shape = RoundedCornerShape(20.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        nav.navigate("searchPage")
                    }
                ),
                maxLines = 1,
                textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
            )

            LazyColumn(Modifier.fillMaxHeight()) {
                item {
                    Text("Featured Scholarships",
                        fontSize = 20.sp,
                        modifier = Modifier.offset(x = 18.dp, y = 50.dp),
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    LazyRow(Modifier.offset(y = 65.dp),
                        horizontalArrangement = Arrangement.Center,
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .width(350.dp)
                                    .height(200.dp)
                                    .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(20.dp))
                                )
                                Text(
                                    text = "Hawak Kamay Scholarship",
                                    fontSize = 18.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .offset(y = 50.dp),
                                    color = Color.White
                                )
                            }
                        }

                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .width(350.dp)
                                    .height(200.dp)
                                    .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                            ) {
                                val shape: Shape = RoundedCornerShape(20.dp)
                                Image(
                                    painter = painterResource(id = R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(shape)
                                )
                                Text(
                                    text = "Guanzon Grant",
                                    fontSize = 18.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .offset(y = 50.dp),
                                    color = Color.White
                                )
                            }
                        }

                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .width(350.dp)
                                    .height(200.dp)
                                    .border(1.dp, Color.Black, RoundedCornerShape(20.dp))
                            ) {
                                val shape: Shape = RoundedCornerShape(20.dp)
                                Image(
                                    painter = painterResource(id = R.drawable.scholarship),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(shape)
                                )
                                Text(
                                    text = "SM Scholarship",
                                    fontSize = 18.sp,
                                    fontFamily = InterFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .offset(y = 50.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

                item {
                    Text("Available Scholarships",
                        fontSize = 20.sp,
                        modifier = Modifier.offset(x = 18.dp, y = 80.dp),
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    LazyRow(Modifier.offset(x = 18.dp, y = 100.dp)) {
                        item {
                            Button(
                                onClick = { viewModel.filterScholarshipsByCategory("Undergraduate") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("Graduate") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("STEM") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("Arts") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("Business") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("Education") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("Medicine") },
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
                                onClick = { viewModel.filterScholarshipsByCategory("Graduate") },
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
                }

                items(scholarships) { scholarship ->
                    Box(Modifier.offset(y = 100.dp)) {
                        ScholarshipCard(nav, scholarship)
                    }
                    Spacer(Modifier.height(12.dp))
                }

                item {
                    Spacer(Modifier.height(140.dp))
                }
            }

        }
    }
}

@Composable
fun ScholarshipCard(nav: NavController, scholarship: ScholarshipApplication) {
    Box(
        modifier = Modifier
            .width(350.dp)
            .height(200.dp)
            .offset(x = 18.dp, y = 20.dp)
            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(20.dp))
    ) {
        Row {
            Box(
                Modifier
                    .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                    .width(125.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(R.drawable.scholarship),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(Modifier.padding(15.dp)) {
                Text(
                    scholarship.application_name,
                    fontSize = 14.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    scholarship.company,
                    fontSize = 14.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    "Category: ${scholarship.category}",
                    fontSize = 14.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    "Duration: ${scholarship.duration}",
                    fontSize = 14.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Text(
                    "Deadline: ${scholarship.deadline}",
                    fontSize = 14.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Spacer(Modifier.height(10.dp))
                Button(
                    onClick = { nav.navigate(
                        "scholarshipApplicationPage/${scholarship.id}/${scholarship.application_name}/${scholarship.company}/${scholarship.application_description}/${scholarship.duration}/${scholarship.category}/${scholarship.slots}/${scholarship.deadline}"
                    ) },
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .height(35.dp)
                        .width(90.dp)
                        .offset(x = 105.dp, y = 10.dp)
                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(
                        "Apply",
                        fontSize = 12.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(R.color.scholar_blue)
                    )
                }

                Spacer(Modifier.height(12.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    HomePage(rememberNavController(), ScholarshipApplicationViewModel())
}