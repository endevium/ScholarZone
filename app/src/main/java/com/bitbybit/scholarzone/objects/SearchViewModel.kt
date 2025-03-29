package com.bitbybit.scholarzone.objects

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.models.Question
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.models.ScholarshipApplication
import com.bitbybit.scholarzone.models.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    var searchResults = mutableStateListOf<com.bitbybit.scholarzone.models.ScholarshipApplication>()
        private set

    fun searchScholarships(keyword: String) {
        val apiService = RetrofitClient.create(APIService::class.java)

        apiService.searchScholarship(keyword).enqueue(object : Callback<com.bitbybit.scholarzone.models.SearchResponse> {
            override fun onResponse(call: Call<com.bitbybit.scholarzone.models.SearchResponse>, response: Response<com.bitbybit.scholarzone.models.SearchResponse>) {
                if (response.isSuccessful) {
                    searchResults.clear()
                    searchResults.addAll(response.body()?.data ?: emptyList())
                }
            }

            override fun onFailure(call: Call<com.bitbybit.scholarzone.models.SearchResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}
