package com.bitbybit.scholarzone.objects

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.models.AccountResponse
import com.bitbybit.scholarzone.models.Applicant
import com.bitbybit.scholarzone.models.ApplicantProfilePicture
import com.bitbybit.scholarzone.models.ApplicantResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.getId
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel(context: Context): ViewModel() {
    var applicant = mutableStateOf<com.bitbybit.scholarzone.models.ApplicantProfilePicture?>(null)
        private set

    private val id: Int = getId(context)

    init {
        fetchApplicant()
    }

    private fun fetchApplicant() {

        val apiService = RetrofitClient.create(APIService::class.java)

        apiService.getApplicant(id).enqueue(object : Callback<com.bitbybit.scholarzone.models.AccountResponse> {
            override fun onResponse(call: Call<com.bitbybit.scholarzone.models.AccountResponse>, response: Response<com.bitbybit.scholarzone.models.AccountResponse>) {
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

            override fun onFailure(call: Call<com.bitbybit.scholarzone.models.AccountResponse>, t: Throwable) {
                Log.d("Failure", "Error fetching user profile: ${t.message}")
            }
        })
    }

    fun uploadProfilePicture(uri: Uri, context: Context) {
        val contentResolver = context.contentResolver
        val inputStream = contentResolver.openInputStream(uri)
        val requestBody = inputStream?.readBytes()?.toRequestBody("image/*".toMediaTypeOrNull())
        val part = requestBody?.let {
            MultipartBody.Part.createFormData("profile_picture", "profile.jpg", it)
        }

        if (part != null) {
            val apiService = RetrofitClient.create(APIService::class.java)
            apiService.changeProfile(part).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(context, "Profile picture updated successfully!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Failed to update profile picture.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(context, "Failed to create request body.", Toast.LENGTH_SHORT).show()
        }
    }
}