package com.bitbybit.scholarzone.objects

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bitbybit.scholarzone.api.APIService
import com.bitbybit.scholarzone.api.Application
import com.bitbybit.scholarzone.api.Notification
import com.bitbybit.scholarzone.api.NotificationResponse
import com.bitbybit.scholarzone.api.RetrofitClient
import com.bitbybit.scholarzone.api.getId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationViewModel(context: Context): ViewModel() {
    var notifications by mutableStateOf(listOf<Notification>())
        private set

    private val id: Int = getId(context)

    private var allNotifications = listOf<Notification>()

    init {
        fetchNotifications()
    }

    private fun fetchNotifications() {
        val apiService = RetrofitClient.create(APIService::class.java)

        apiService.getNotifications(id).enqueue(object : Callback<NotificationResponse> {
            override fun onResponse(
                call: Call<NotificationResponse>,
                response: Response<NotificationResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val fetchedData = responseBody?.data ?: emptyList()

                    if (fetchedData.isNotEmpty()) {
                        notifications = fetchedData
                        allNotifications = fetchedData
                    } else {
                        notifications = emptyList()
                    }
                } else {
                    Log.e("API", "Failed to fetch applications - Response Code: ${response.code()} - ${response.errorBody()?.string()}")
                    notifications = emptyList()
                }
            }

            override fun onFailure(call: Call<NotificationResponse>, t: Throwable) {
                Log.e("Failure", "Error fetching notifications: ${t.message}")
            }

        })
    }
}