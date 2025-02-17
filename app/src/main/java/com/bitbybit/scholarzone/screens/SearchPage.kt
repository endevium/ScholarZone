package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import kotlin.math.sin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPage(nav: NavController) {
    var search by remember { mutableStateOf("") }

    Box(Modifier.background(Color.White).fillMaxSize()) {
        Column {
            Row(
                Modifier.offset(x = 9.dp, y = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { nav.navigate(Routes.HomePage) }) {
                    Image(
                        painter = painterResource(R.drawable.back_button_one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                    )
                }

                Box {
                    OutlinedTextField(
                        value = search,
                        onValueChange = { search = it },
                        placeholder = {
                            Text(
                                "Start typing...",
                                fontSize = 15.sp
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = colorResource(id = R.color.scholar_black) // Ensure icon color is set
                            )
                        },
                        modifier = Modifier
                            .width(235.dp)
                            .height(55.dp)
                            .offset(x = 5.dp),
                        shape = RoundedCornerShape(20.dp),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done
                        ),
                        maxLines = 1,
                        singleLine = true,
                        textStyle = TextStyle(
                            color = colorResource(id = R.color.scholar_black),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Light,
                            fontFamily = InterFontFamily
                        )
                    )
                }

                TextButton(onClick = {}) {
                    Text("Search",
                        fontSize = 16.sp,
                        color = colorResource(R.color.scholar_blue),
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.offset(5.dp)
                    )
                }
            }

            Text("Search Results",
                fontSize = 21.sp,
                modifier = Modifier.offset(x = 18.dp, y = 30.dp),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold
            )

            LazyColumn(
                modifier = Modifier.fillMaxHeight()
                    .offset(x = 18.dp, y = 45.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp)
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
                                ) {                                    Text("Apply",
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
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewSearch() {
    SearchPage(rememberNavController())
}