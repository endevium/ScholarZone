package com.bitbybit.scholarzone.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import com.bitbybit.scholarzone.objects.ApplicationFormViewModel
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.ui.theme.InterFontFamily
import com.bitbybit.scholarzone.ui.theme.PoppinsFontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Answer
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.SubmitApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ApplicationFormPage(nav: NavController, viewModel: ApplicationFormViewModel = viewModel()) {
    val context = LocalContext.current
    val backStackEntry = nav.currentBackStackEntry
    val id = backStackEntry?.arguments?.getString("scholarship_application_id")?.toInt() ?: 0
    val application_name = backStackEntry?.arguments?.getString("application_name") ?: ""
    val company = backStackEntry?.arguments?.getString("company") ?: ""
    val application_description = backStackEntry?.arguments?.getString("application_description") ?: ""
    val duration = backStackEntry?.arguments?.getString("duration") ?: ""
    val category = backStackEntry?.arguments?.getString("category") ?: ""
    val slots = backStackEntry?.arguments?.getString("slots")?.toInt() ?: 0
    val deadline = backStackEntry?.arguments?.getString("deadline") ?: ""

    LaunchedEffect(id) {
        viewModel.fetchQuestions(id)
    }

    val answers = viewModel.answers.value

    Box(modifier = Modifier
        .background(color = Color.White)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .offset(x = 15.dp, y = 15.dp)
        ) {
            Box {
                IconButton(onClick = { nav.navigate("scholarshipApplicationPage/$id/$application_name/$company/$application_description/$duration/$category/$slots/$deadline") }) {
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
                application_name,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_blue),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(5.dp))

            Text(
                text = "Answer the following questions to apply for a slot!",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = InterFontFamily,
                color = colorResource(id = R.color.scholar_black),
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(Modifier.height(25.dp))

            if (viewModel.questions.isEmpty()) {
                Text(
                    text = "No questions available for this scholarship.",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.scholar_black),
                    fontWeight = FontWeight.Medium,
                    fontFamily = InterFontFamily,
                    modifier = Modifier.padding(start = 10.dp)
                )
            } else {
                LazyColumn(Modifier.height(500.dp)) {
                    items(viewModel.questions) { question ->
                        Text(
                            text = question.question,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.scholar_black),
                            fontWeight = FontWeight.Medium,
                            fontFamily = InterFontFamily,
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .padding(start = 10.dp)
                        )

                        val answer = answers[question.id] ?: ""
                        OutlinedTextField(
                            value = answer,
                            onValueChange = { newAnswer ->
                                viewModel.updateAnswer(
                                    question.id,
                                    newAnswer
                                )
                            },
                            placeholder = { Text("Enter your answer here") },
                            modifier = Modifier
                                .width(330.dp)
                                .height(55.dp)
                                .padding(start = 10.dp),
                            shape = RoundedCornerShape(15.dp),
                            maxLines = 1,
                            textStyle = TextStyle(
                                color = colorResource(id = R.color.scholar_black),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Light,
                                fontFamily = InterFontFamily
                            )
                        )

                        Spacer(Modifier.height(5.dp))
                    }
                }
            }
        }

        Button(
            onClick = {
                val apiService = RetrofitClient.create(APIService::class.java)
                val submitApplication = SubmitApplication(
                    scholarship_application_id = id
                )

                val submitAllAnswers = {
                    answers.forEach { (questionId, answer) ->
                        val answer = Answer(
                            question_id = questionId,
                            answer = answer
                        )

                        apiService.submitAnswer(answer).enqueue(object: Callback<Void> {
                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                if (response.isSuccessful) {
                                    Log.d("Success", "Answer submitted successfully")
                                } else {
                                    Toast.makeText(context, "Failed to submit answer for question $questionId.", Toast.LENGTH_SHORT).show()
                                }
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                                Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                }

                submitAllAnswers()

                apiService.submitApplication(submitApplication).enqueue(object: Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, "Application successfully submitted!", Toast.LENGTH_SHORT).show()
                            nav.navigate("scholarshipApplicationPage/$id/$application_name/$company/$application_description/$duration/$category/$slots/$deadline")
                        } else {
                            Toast.makeText(context, "Failed to submit application.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }

                })

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
            Text(text = "Submit",
                fontSize = 18.sp,
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewApplicationForm() {
    ApplicationFormPage(rememberNavController())
}