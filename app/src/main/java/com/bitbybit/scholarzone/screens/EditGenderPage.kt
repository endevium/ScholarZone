package com.bitbybit.scholarzone.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.models.PersonalDetails
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily

@Composable
fun EditGenderPage(nav: NavController) {
    val context = LocalContext.current
    var inputField by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .offset(x = 15.dp, y = 15.dp)
        ) {
            Box {
                IconButton(onClick = { nav.navigate(Routes.PersonalDetailsPage) }) {
                    Image(
                        painter = painterResource(R.drawable.back_button_one),
                        contentDescription = "",
                        modifier = Modifier
                            .width(75.dp)
                            .height(75.dp)
                    )
                }
            }

            Spacer(Modifier.height(10.dp))

            Text(
                text = "Edit Gender",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_blue),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Gender",
                fontSize = 14.sp,
                color = colorResource(id = R.color.scholar_black),
                fontWeight = FontWeight.Medium,
                fontFamily = InterFontFamily,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .padding(start = 10.dp)
            )

            EditGenderDropdown(selectedGender = inputField, onGenderSelected = { inputField = it })

            Spacer(Modifier.height(10.dp))
        }

        Button(
            onClick = {
                if (inputField.isNotEmpty()) {
                    val gender = com.bitbybit.scholarzone.models.PersonalDetails.Gender(
                        gender = inputField
                    )

                    val apiService = RetrofitClient.create(APIService::class.java)
                } else {
                    Toast.makeText(context, "Gender is required", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .height(90.dp)
                .width(330.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.scholar_darker_blue),
            )
        ) {
            Text(text = "Save Changes",
                fontSize = 18.sp,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditGenderDropdown(selectedGender: String, onGenderSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val genders = listOf("Male", "Female")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = selectedGender,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text("Select Gender") },
            modifier = Modifier
                .width(330.dp)
                .height(55.dp)
                .padding(start = 10.dp)
                .menuAnchor(),
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(
                color = colorResource(id = R.color.scholar_black),
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = InterFontFamily
            ),
            trailingIcon = {
                Image(
                    painter = if (expanded) {
                        painterResource(R.drawable.keyboard_arrow_up)
                    } else {
                        painterResource(R.drawable.keyboard_arrow_down)
                    },
                    contentDescription = "Dropdown Icon",
                    modifier = Modifier.clickable { expanded = !expanded }
                )
            }
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            genders.forEach { gender ->
                DropdownMenuItem(
                    text = { Text(gender) },
                    onClick = {
                        onGenderSelected(gender)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewGender() {
    EditGenderPage(rememberNavController())
}