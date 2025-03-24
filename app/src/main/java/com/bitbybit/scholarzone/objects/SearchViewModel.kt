package com.bitbybit.scholarzone.objects

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Question
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.ScholarshipApplication
import com.bitbybit.scholarzone.api.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    var searchResults = mutableStateListOf<ScholarshipApplication>()
        private set

    fun searchScholarships(keyword: String) {
        val apiService = RetrofitClient.create(APIService::class.java)

        apiService.searchScholarship(keyword).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                if (response.isSuccessful) {
                    searchResults.clear()
                    searchResults.addAll(response.body()?.data ?: emptyList())
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                println("Error: ${t.message}")
            }
        })
    }
}
