package com.bitbybit.scholarzone.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.R
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.objects.SignUpViewModel
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun SignUpPageTwo(nav: NavController, viewModel: SignUpViewModel) {

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(start = 15.dp)
                .padding(top = 15.dp)
        ) {
            Box {
                IconButton(onClick = { nav.navigate(Routes.SignupPage) }) {
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

            Row(Modifier.padding(start = 10.dp)) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                        .background(color = colorResource(R.color.scholar_light_gray))
                        .height(15.dp)
                        .width(100.dp)
                )

                Spacer(Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                        .background(color = colorResource(R.color.scholar_darker_blue))
                        .height(15.dp)
                        .width(100.dp)
                )

                Spacer(Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp, 5.dp, 5.dp, 5.dp))
                        .background(color = colorResource(R.color.scholar_light_gray))
                        .height(15.dp)
                        .width(100.dp)
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = "Sign Up",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_blue),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(13.dp))

            LazyColumn {
                item {
                    Text(
                        text = "Personal Details",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = InterFontFamily,
                        color = colorResource(id = R.color.scholar_black),
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(bottom = 5.dp)
                    )

                    Text(
                        text = "First Name",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = viewModel.firstName,
                        onValueChange = { viewModel.firstName = it },
                        placeholder = { Text("ex: John")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Last Name",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = viewModel.lastName,
                        onValueChange = { viewModel.lastName = it },
                        placeholder = { Text("ex: Doe")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        maxLines = 1,
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(10.dp))
                }

                item {
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

                    GenderDropdown(selectedGender = viewModel.gender, onGenderSelected = { viewModel.gender = it })

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Birthdate",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    BirthdatePicker(viewModel.birthdate) { viewModel.birthdate = it }

                    Spacer(Modifier.height(10.dp))
                }

                item {
                    Text(
                        text = "Phone Number",
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.scholar_black),
                        fontWeight = FontWeight.Medium,
                        fontFamily = InterFontFamily,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .padding(start = 10.dp)
                    )

                    OutlinedTextField(
                        value = viewModel.phoneNumber.toString(),
                        onValueChange = {
                            newValue -> viewModel.phoneNumber = newValue.toIntOrNull() ?: 0
                        },
                        placeholder = { Text("+63")},
                        modifier = Modifier
                            .width(330.dp)
                            .height(55.dp)
                            .padding(start = 10.dp),
                        shape = RoundedCornerShape(15.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done
                        ),
                        textStyle = TextStyle(color = colorResource(id = R.color.scholar_black), fontSize = 16.sp, fontWeight = FontWeight.Light, fontFamily = InterFontFamily)
                    )

                    Spacer(Modifier.height(15.dp))
                }
            }

            NextBarTwo(nav, viewModel.firstName, viewModel.lastName, viewModel.gender, viewModel.birthdate, viewModel.phoneNumber)
        }
    }
}

@Composable
fun NextBarTwo(nav: NavController, firstName: String, lastName: String, gender: String, birthdate: String, phoneNumber: Int) {
    val context = LocalContext.current

    Box(
        Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(Color.White)) {
        Column {
            TextButton(onClick = { nav.navigate(Routes.LoginPage) }) {
                Text(text = "Already have an account? Log in instead",
                    fontWeight = FontWeight.Light,
                    fontFamily = InterFontFamily,
                    fontSize = 14.sp,
                    modifier = Modifier.width(299.dp),
                    color = colorResource(id = R.color.scholar_blue)
                )
            }

            Button(onClick = {
                when {
                    firstName.isEmpty() -> {
                        Toast.makeText(context, "First name is required", Toast.LENGTH_SHORT).show()
                    }
                    lastName.isEmpty() -> {
                        Toast.makeText(context, "Last name is required", Toast.LENGTH_SHORT).show()
                    }
                    gender.isEmpty() -> {
                        Toast.makeText(context, "Please select your gender", Toast.LENGTH_SHORT).show()
                    }
                    birthdate.isEmpty() -> {
                        Toast.makeText(context, "Birthdate is required", Toast.LENGTH_SHORT).show()
                    }
                    phoneNumber == 0 -> {
                        Toast.makeText(context, "Phone number is required", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        nav.navigate(Routes.SignupPageThree)
                    }
                }
                             },
                modifier = Modifier
                    .height(60.dp)
                    .width(330.dp)
                    .padding(start = 10.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = ButtonDefaults.buttonElevation(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.scholar_darker_blue),
                )
            ) {
                Text(text = "Next",
                    fontSize = 18.sp,
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDropdown(selectedGender: String, onGenderSelected: (String) -> Unit) {
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
fun BirthdatePicker(birthdate: String, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    val context = LocalContext.current
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, dayOfMonth)
            onDateSelected(dateFormat.format(selectedDate.time))
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    OutlinedTextField(
        value = birthdate,
        onValueChange = {},
        placeholder = { Text("Select birthdate") },
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle(
            color = colorResource(id = R.color.scholar_black),
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            fontFamily = InterFontFamily
        ),
        trailingIcon = {
            IconButton(onClick = { datePickerDialog.show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = ""
                )
            }
        },
        modifier = Modifier
            .width(330.dp)
            .height(55.dp)
            .padding(start = 10.dp)
            .clickable { datePickerDialog.show() },
        readOnly = true
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpPageTwo() {
    SignUpPageTwo(rememberNavController(), SignUpViewModel())
}