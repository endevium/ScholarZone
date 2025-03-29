package com.bitbybit.scholarzone.objects

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.models.ScholarshipApplication
import com.bitbybit.scholarzone.models.ScholarshipResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScholarshipApplicationViewModel: ViewModel() {
    var scholarships = mutableStateListOf<com.bitbybit.scholarzone.models.ScholarshipApplication>()
        private set

    private var allScholarships = listOf<com.bitbybit.scholarzone.models.ScholarshipApplication>()

    init {
        fetchScholarships()
    }

    private fun fetchScholarships() {
        val apiService = RetrofitClient.create(APIService::class.java)
        apiService.getScholarships().enqueue(object : Callback<com.bitbybit.scholarzone.models.ScholarshipResponse> {
            override fun onResponse(
                call: Call<com.bitbybit.scholarzone.models.ScholarshipResponse>,
                response: Response<com.bitbybit.scholarzone.models.ScholarshipResponse>
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

            override fun onFailure(call: Call<com.bitbybit.scholarzone.models.ScholarshipResponse>, t: Throwable) {
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