package com.bitbybit.scholarzone.objects

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Question
import com.bitbybit.scholarzone.api.QuestionResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplicationFormViewModel : ViewModel() {
    var questions = mutableStateListOf<Question>()
        private set

    private val _answers = mutableStateOf<Map<Int, String>>(emptyMap())
    val answers: State<Map<Int, String>> = _answers

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

    // Update the answer for a specific question
    fun updateAnswer(questionId: Int, answer: String) {
        _answers.value = _answers.value + (questionId to answer)
    }
}
