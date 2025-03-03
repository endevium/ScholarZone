package com.bitbybit.scholarzone.objects

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.ScholarshipApplication
import com.bitbybit.scholarzone.api.ScholarshipResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScholarshipApplicationViewModel: ViewModel() {
    var scholarships = mutableStateListOf<ScholarshipApplication>()
        private set

    private var allScholarships = listOf<ScholarshipApplication>()

    init {
        fetchScholarships()
    }

    private fun fetchScholarships() {
        val apiService = RetrofitClient.create(APIService::class.java)
        apiService.getScholarships().enqueue(object : Callback<ScholarshipResponse> {
            override fun onResponse(
                call: Call<ScholarshipResponse>,
                response: Response<ScholarshipResponse>
            ) {
                if (response.isSuccessful) {
                    scholarships.clear()
                    response.body()?.data?.let {
                        allScholarships = it
                        scholarships.addAll(it)
                    }
                    Log.d("Success", "Successfully fetched scholarships")
                } else {
                    Log.d("Failure", "Failed to fetch scholarships")
                }
            }

            override fun onFailure(call: Call<ScholarshipResponse>, t: Throwable) {
                println("Error fetching scholarships: ${t.message}")
                Log.d("Failure", "${t.message}")
            }
        })
    }

    fun filterScholarshipsByCategory(category: String) {
        scholarships.clear()
        scholarships.addAll(allScholarships.filter { it.category == category })
    }

    fun loadAllScholarships() {
        scholarships.clear()
        scholarships.addAll(allScholarships)
    }
}