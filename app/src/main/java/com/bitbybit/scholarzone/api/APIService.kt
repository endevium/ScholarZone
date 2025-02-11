package com.bitbybit.scholarzone.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    // Applicants Login
    @Headers("Content-type: application/json")
    @POST("index.php")
    fun login(
        @Query("route") route: String = "applicant-login",
        @Body login: Login
    ): Call<ApplicantResponse>

    // Applicants Signup
    @Headers("Content-type: application/json")
    @POST("index.php")
    fun register(
        @Query("route") route: String = "applicants",
        @Body applicant: Applicant
    ): Call<ApplicantResponse>
}