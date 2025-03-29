package com.bitbybit.scholarzone.screens

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.bitbybit.scholarzone.models.Answer
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.models.SubmitApplication
import com.bitbybit.scholarzone.models.SubmitApplicationResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ApplicationFormPage(nav: NavController, viewModel: ApplicationFormViewModel = viewModel()) {
    val context = LocalContext.current
    val backStackEntry = nav.currentBackStackEntry
    val id = backStackEntry?.arguments?.getString("scholarship_application_id")?.toInt() ?: 0
    val application_name = backStackEntry?.arguments?.getString("application_name") ?: ""
    val company = backStackEntry?.arguments?.getString("company") ?: ""
    val application_image = backStackEntry?.arguments?.getString("application_image")?.let {
        URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
    } ?: ""
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
                IconButton(
                    onClick = {
                        val encodedImageUrl = URLEncoder.encode(application_image, StandardCharsets.UTF_8.toString())
                        nav.navigate("scholarshipApplicationPage/$id/$application_name/$company/$application_description/$encodedImageUrl/$duration/$category/$slots/$deadline") }) {
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
                        Log.d("QuestionType", "Question ID: ${question.id}, Type: ${question.type}")
                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.GetContent()
                        ) { uri: Uri? ->
                            uri?.let {
                                val filePath = getFileFromUri(context, it)
                                if (filePath != null) {
                                    viewModel.updateAnswer(question.id, File(filePath))
                                } else {
                                    Log.e("Error", "Failed to get file path")
                                }
                            }
                        }

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

                        if (question.type == "upload") {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                val fileAnswer = answers[question.id] as? File

                                if (fileAnswer != null) {
                                    Text("Uploaded file: ${fileAnswer.name}", color = Color.Gray)
                                    Spacer(Modifier.height(5.dp))
                                    Button(
                                        onClick = { launcher.launch("image/*") },
                                        modifier = Modifier.width(330.dp).height(55.dp),
                                        shape = RoundedCornerShape(15.dp)
                                    ) {
                                        Text("Change File", fontSize = 16.sp)
                                    }
                                } else {
                                    Button(
                                        onClick = { launcher.launch("image/*") },
                                        modifier = Modifier.width(330.dp).height(55.dp),
                                        shape = RoundedCornerShape(15.dp)
                                    ) {
                                        Text("Upload File", fontSize = 16.sp)
                                    }
                                }
                            }
                        } else {
                            val answer = answers[question.id] as? String ?: ""
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
                        }

                        Spacer(Modifier.height(5.dp))
                    }
                }
            }
        }

        Button(
            onClick = {
                if (!viewModel.areAllQuestionsAnswered()) {
                    Toast.makeText(context, "Please answer all questions before submitting.", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                val apiService = RetrofitClient.create(APIService::class.java)
                val submitApplication = com.bitbybit.scholarzone.models.SubmitApplication(
                    scholarship_application_id = id
                )

                viewModel.submitAllAnswers()

                apiService.submitApplication(submitApplication).enqueue(object: Callback<com.bitbybit.scholarzone.models.SubmitApplicationResponse> {
                    override fun onResponse(call: Call<com.bitbybit.scholarzone.models.SubmitApplicationResponse>, response: Response<com.bitbybit.scholarzone.models.SubmitApplicationResponse>) {
                        if (response.isSuccessful && response.body() != null) {
                            val responseBody = response.body()!!
                            Toast.makeText(context, responseBody.message, Toast.LENGTH_SHORT).show()
                            val encodedImageUrl = URLEncoder.encode(application_image, StandardCharsets.UTF_8.toString())
                            nav.navigate("scholarshipApplicationPage/$id/$application_name/$company/$application_description/$encodedImageUrl/$duration/$category/$slots/$deadline")
                        } else {
                            try {
                                val errorBody = response.errorBody()?.string()
                                val errorResponse = Gson().fromJson(errorBody, com.bitbybit.scholarzone.models.SubmitApplicationResponse::class.java)
                                Toast.makeText(context, errorResponse.message, Toast.LENGTH_SHORT).show()
                            } catch (e: Exception) {
                                Toast.makeText(context, "Failed to submit application.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<com.bitbybit.scholarzone.models.SubmitApplicationResponse>, t: Throwable) {
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

fun getFileFromUri(context: Context, uri: Uri): String? {
    val contentResolver = context.contentResolver
    var fileName: String? = null

    contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        if (cursor.moveToFirst()) {
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex != -1) {
                fileName = cursor.getString(nameIndex)
            }
        }
    }

    if (fileName == null) {
        Log.e("File Error", "Could not retrieve file name")
        return null
    }

    val file = File(context.cacheDir, fileName)

    try {
        contentResolver.openInputStream(uri)?.use { inputStream ->
            file.outputStream().use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        }
        return file.absolutePath
    } catch (e: Exception) {
        Log.e("File Error", "Failed to copy file: ${e.message}")
    }
    return null
}



@Composable
@Preview(showBackground = true)
fun PreviewApplicationForm() {
    ApplicationFormPage(rememberNavController())
}