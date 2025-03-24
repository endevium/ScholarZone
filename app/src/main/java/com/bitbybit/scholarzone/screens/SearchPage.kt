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
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bitbybit.scholarzone.objects.SearchViewModel
import kotlinx.coroutines.delay

@Composable
fun SearchPage(nav: NavController, viewModel: SearchViewModel = viewModel()) {
    var search by remember { mutableStateOf("") }
    val searchResults = viewModel.searchResults

    LaunchedEffect(search) {
        if (search.isNotBlank()) {
            delay(100L)
            viewModel.searchScholarships(search)
        }
    }

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
                        modifier = Modifier.size(50.dp)
                    )
                }

                Box {
                    OutlinedTextField(
                        value = search,
                        onValueChange = { search = it }, // Search triggers on typing
                        placeholder = {
                            Text("Start typing...", fontSize = 15.sp)
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = colorResource(id = R.color.scholar_black)
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

                TextButton(onClick = {
                    viewModel.searchScholarships(search) // Manual search when button is pressed
                }) {
                    Text(
                        "Search",
                        fontSize = 16.sp,
                        color = colorResource(R.color.scholar_blue),
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.offset(5.dp)
                    )
                }
            }

            Text(
                "Search Results",
                fontSize = 21.sp,
                modifier = Modifier.offset(x = 18.dp, y = 30.dp),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold
            )

            LazyColumn(
                modifier = Modifier.fillMaxHeight().offset(y = 20.dp)
            ) {
                items(searchResults) { scholarship ->
                    ScholarshipCard(nav, scholarship)
                    Spacer(Modifier.height(12.dp))
                }
            }

            Spacer(Modifier.height(150.dp))
        }
    }
}




@Composable
@Preview(showBackground = true)
fun PreviewSearch() {
    SearchPage(rememberNavController())
}