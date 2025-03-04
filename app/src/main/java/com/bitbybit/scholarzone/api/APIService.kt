package com.bitbybit.scholarzone.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    // Applicants Login
    @Headers("Content-type: application/json")
    @POST("api/applicant-login")
    fun login(
        @Body login: Login
    ): Call<ApplicantResponse>

    // Applicants Signup
    @Headers("Content-type: application/json")
    @POST("api/applicants")
    fun register(
        @Body applicant: Applicant
    ): Call<ApplicantResponse>

    // Applicant Info
    @GET("api/applicants")
    fun getApplicant(
        @Query("id") id: Int
    ): Call<AccountResponse>

    @GET("api/scholarships")
    fun getScholarships(): Call<ScholarshipResponse>

    @GET("api/search-scholarships")
    fun searchScholarship(
        @Query("search") search: String
    ): Call<SearchResponse>

    @GET("api/questions")
    fun getQuestions(
        @Query("scholarship_application_id") scholarship_application_id: Int
    ): Call<QuestionResponse>

    @Headers("Content-type: application/json")
    @POST("api/submit-answer")
    fun submitAnswer(
        @Body answer: Answer
    ): Call<Void>

    @Headers("Content-type: application/json")
    @POST("api/submit-application")
    fun submitApplication(
        @Body submitApplication: SubmitApplication
    ): Call<Void>

    @GET("api/applicant-applications")
    fun getApplications(
        @Query("applicant_id") id: Int
    ): Call<ApplicationResponse>

    @GET("api/notifications")
    fun getNotifications(
        @Query("applicant_id") id: Int
    ): Call<NotificationResponse>

}