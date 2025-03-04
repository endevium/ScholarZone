package com.bitbybit.scholarzone.objects

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Application
import com.bitbybit.scholarzone.api.ApplicationResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.getId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel(context: Context): ViewModel() {
    var applications by mutableStateOf(listOf<Application>())
        private set

    private val id: Int = getId(context)

    private var allApplications = listOf<Application>()

    init {
        fetchApplications()
    }

    private fun fetchApplications() {
        val apiService = RetrofitClient.create(APIService::class.java)

        apiService.getApplications(id).enqueue(object : Callback<ApplicationResponse> {
            override fun onResponse(call: Call<ApplicationResponse>, response: Response<ApplicationResponse>) {
                Log.d("API", "Response received: ${response.code()} - Body: ${response.body()}")

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val fetchedData = responseBody?.data ?: emptyList() // Prevent null crash

                    if (fetchedData.isNotEmpty()) {
                        applications = fetchedData
                        allApplications = fetchedData
                        Log.d("API", "Applications fetched: ${applications.size}")
                    } else {
                        Log.e("API", "Response is successful but data is empty!")
                        applications = emptyList()
                    }
                } else {
                    Log.e("API", "Failed to fetch applications - Response Code: ${response.code()} - ${response.errorBody()?.string()}")
                    applications = emptyList()
                }
            }

            override fun onFailure(call: Call<ApplicationResponse>, t: Throwable) {
                Log.e("Failure", "Error fetching applications: ${t.message}") // Prevent UI from breaking due to previous data
            }
        })
    }


    fun filterApplicationsByStatus(status: String) {
        applications = allApplications.filter { it.status == status }
    }

    fun filterApplicationsByCategory(category: String) {
        applications = allApplications.filter { it.category == category }
    }

    fun loadAllApplications() {
        applications = allApplications
    }

}