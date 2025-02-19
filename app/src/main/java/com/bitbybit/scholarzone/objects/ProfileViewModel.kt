package com.bitbybit.scholarzone.objects

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.AccountResponse
import com.bitbybit.scholarzone.api.Applicant
import com.bitbybit.scholarzone.api.ApplicantResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.getId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel(context: Context): ViewModel() {
    var applicant = mutableStateOf<Applicant?>(null)
        private set

    private val id: Int = getId(context)

    init {
        fetchApplicant()
    }

    private fun fetchApplicant() {

        val apiService = RetrofitClient.create(APIService::class.java)

        apiService.getApplicant(id).enqueue(object : Callback<AccountResponse> {
            override fun onResponse(call: Call<AccountResponse>, response: Response<AccountResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody?.status == 200 && responseBody.data != null) {
                        applicant.value = responseBody.data
                        Log.d("Success", "User profile loaded: ${responseBody.data.username}")
                    } else {
                        Log.d("Failure", "Invalid response format or status: ${responseBody?.status}")
                    }
                } else {
                    Log.d("Failure", "Failed to fetch user profile, HTTP code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<AccountResponse>, t: Throwable) {
                Log.d("Failure", "Error fetching user profile: ${t.message}")
            }
        })
    }
}