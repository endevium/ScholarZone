package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.BottomNavigationItem
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily


@Composable
fun HomePage(nav: NavController) {
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
                placeholder = { Text("Start typing...")},
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
                        nav.navigate(Routes.SearchPage)
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
                                    text = "Scholarship Name",
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
                                    text = "Scholarship Name",
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
                                    text = "Scholarship Name",
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
                }


                // SCHOLARSHIP CARD
                item {
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp)
                            .offset(x = 18.dp, y = 130.dp)
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
                                    onClick = { nav.navigate(Routes.ScholarshipApplicationPage) },
                                    shape = RoundedCornerShape(15.dp),
                                    modifier = Modifier.height(35.dp).width(90.dp)
                                        .offset(x = 105.dp)
                                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                    )
                                ) {
                                    Text("Apply",
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
                            .offset(x = 18.dp, y = 130.dp)
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
                                    onClick = { nav.navigate(Routes.ScholarshipApplicationPage) },
                                    shape = RoundedCornerShape(15.dp),
                                    modifier = Modifier.height(35.dp).width(90.dp)
                                        .offset(x = 105.dp)
                                        .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                    )
                                ) {
                                    Text("Apply",
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
                    Spacer(Modifier.height(140.dp))
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    HomePage(rememberNavController())
}


