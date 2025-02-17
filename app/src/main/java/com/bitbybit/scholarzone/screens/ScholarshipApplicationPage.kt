package com.bitbybit.scholarzone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily

@Composable
fun ScholarshipApplicationPage(nav: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {

        Column(Modifier.fillMaxSize()) {
            Box(Modifier
                .fillMaxWidth()
                .height(350.dp)) {
                Image(
                    painter = painterResource(R.drawable.scholarship),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )

                IconButton(onClick = { nav.navigate(Routes.HomePage) {
                    popUpTo(Routes.HomePage) { inclusive = true }
                } },
                    Modifier.offset(x = 15.dp, y = 15.dp)) {
                    Image(
                        painter = painterResource(R.drawable.back_button_one),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .offset(y = (-30).dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
            ) {
                Text(
                    "Scholarship Name",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.offset(
                        x = 25.dp,
                        y = 25.dp
                    )
                        .padding(bottom = 5.dp)
                )

                Text(
                    "Company",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.offset(
                        x = 25.dp,
                        y = 25.dp
                    )
                        .padding(bottom = 5.dp)
                )

                Text(
                    "Category: Undergraduate",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.offset(
                        x = 25.dp,
                        y = 25.dp
                    )
                        .padding(bottom = 5.dp)
                )

                Text(
                    "Duration: 4 years",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.offset(
                        x = 25.dp,
                        y = 25.dp
                    )
                        .padding(bottom = 5.dp)
                )

                Text(
                    "Applicants: N/A",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.offset(
                        x = 25.dp,
                        y = 25.dp
                    )
                        .padding(bottom = 5.dp)
                )

                Text(
                    "Available Slots: 500",
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    modifier = Modifier.offset(
                        x = 25.dp,
                        y = 25.dp
                    )
                        .padding(bottom = 15.dp)
                )

                LazyColumn(Modifier
                    .width(350.dp)
                    .height(150.dp)
                    .offset(x = 25.dp, y = 25.dp)
                ) {
                    item {
                        Text(
                            "Eligible applicants can receive up to a 75% discount on tuition and miscellaneous fees. A significant feature of this scholarship is its accessibility, as there is no maintaining grade requirement, making it ideal for students committed to their education regardless of academic standing. The scholarship remains valid until the recipient completes their chosen program, provided they adhere to the guidelines set by their school.",
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                        )
                    }
                }

                Spacer(Modifier.height(55.dp))
                Row(
                    Modifier.offset(x = 25.dp, y = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Deadline: 4 days",
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Normal,
                        color = Color.Red
                    )

                    Button(
                        onClick = { nav.navigate(Routes.ApplicationFormPage) },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(35.dp).width(95.dp)
                            .offset(x = 125.dp)
                            .border(1.dp, colorResource(R.color.scholar_blue), RoundedCornerShape(15.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                        )
                    ) {
                        Text("Apply",
                            fontSize = 15.sp,
                            fontFamily = InterFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.scholar_blue)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewScholarship() {
    ScholarshipApplicationPage(rememberNavController())
}