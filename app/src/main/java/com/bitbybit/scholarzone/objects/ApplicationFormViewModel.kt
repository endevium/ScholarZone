package com.bitbybit.scholarzone.objects

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Answer
import com.bitbybit.scholarzone.api.Question
import com.bitbybit.scholarzone.api.QuestionResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ApplicationFormViewModel : ViewModel() {
    var questions = mutableStateListOf<Question>()
        private set

    private val _answers = mutableStateOf<Map<Int, Any>>(emptyMap())
    val answers: State<Map<Int, Any>> = _answers

    fun fetchQuestions(id: Int) {
        val apiService = RetrofitClient.create(APIService::class.java)
        apiService.getQuestions(id).enqueue(object : Callback<QuestionResponse> {
            override fun onResponse(call: Call<QuestionResponse>, response: Response<QuestionResponse>) {
                if (response.isSuccessful) {
                    questions.clear()
                    questions.addAll(response.body()?.data ?: emptyList())
                }
            }

            override fun onFailure(call: Call<QuestionResponse>, t: Throwable) {
                println("Error fetching questions: ${t.message}")
            }
        })
    }
    fun updateAnswer(questionId: Int, answer: Any) {
        _answers.value += (questionId to answer)
    }

    fun submitAllAnswers() {
        val apiService = RetrofitClient.create(APIService::class.java)

        answers.value.forEach { (questionId, answer) ->
            if (answer is File) {
                val requestFile = answer.asRequestBody("multipart/form-data".toMediaTypeOrNull())
                val filePart = MultipartBody.Part.createFormData("answer", answer.name, requestFile)
                val questionIdPart =
                    questionId.toString().toRequestBody("text/plain".toMediaTypeOrNull())

                apiService.submitFile(questionIdPart, filePart).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Log.d("Success", "File answer submitted successfully for question $questionId")
                        } else {
                            Log.e("Error", "Failed to submit file for question $questionId. Response: ${response.errorBody()?.string()}")
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Log.e("Error", "File submission failed: ${t.message}")
                    }
                })
            } else if (answer is String) {
                val answerObj = Answer(question_id = questionId, answer = answer)
                apiService.submitAnswer(answerObj).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Log.d("Success", "Text answer submitted successfully for question $questionId")
                        } else {
                            Log.e("Error", "Failed to submit text for question $questionId. Response: ${response.errorBody()?.string()}")
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Log.e("Error", "Text submission failed for question $questionId: ${t.message}")
                    }
                })
            }
        }
    }

    fun areAllQuestionsAnswered(): Boolean {
        return questions.all { question ->
            answers.value.containsKey(question.id) && answers.value[question.id] != null
        }
    }
}
