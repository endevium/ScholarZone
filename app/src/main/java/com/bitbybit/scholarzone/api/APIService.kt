package com.bitbybit.scholarzone.api

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    // Applicants Login
    @Headers("Content-type: application/json")
    @POST("api/applicant-login")
    fun login(
        @Body login: Login
    ): Call<com.bitbybit.scholarzone.models.ApplicantResponse>

    // Applicants Signup
    @Headers("Content-type: application/json")
    @POST("api/applicants")
    fun register(
        @Body applicant: com.bitbybit.scholarzone.models.Applicant
    ): Call<com.bitbybit.scholarzone.models.ApplicantResponse>

    // Applicant Info
    @GET("api/applicants")
    fun getApplicant(
        @Query("id") id: Int
    ): Call<com.bitbybit.scholarzone.models.AccountResponse>

    @GET("api/scholarships")
    fun getScholarships(): Call<com.bitbybit.scholarzone.models.ScholarshipResponse>

    @GET("api/search-scholarships")
    fun searchScholarship(
        @Query("search") search: String
    ): Call<com.bitbybit.scholarzone.models.SearchResponse>

    @GET("api/questions")
    fun getQuestions(
        @Query("scholarship_application_id") scholarship_application_id: Int
    ): Call<com.bitbybit.scholarzone.models.QuestionResponse>

    @Headers("Content-type: application/json")
    @POST("api/submit-answer")
    fun submitAnswer(
        @Body answer: com.bitbybit.scholarzone.models.Answer
    ): Call<Void>

    @Multipart
    @POST("api/submit-answer")
    fun submitFile(
        @Part("question_id") questionId: RequestBody,
        @Part file: MultipartBody.Part
    ): Call<Void>

    @Headers("Content-type: application/json")
    @POST("api/submit-application")
    fun submitApplication(
        @Body submitApplication: com.bitbybit.scholarzone.models.SubmitApplication
    ): Call<com.bitbybit.scholarzone.models.SubmitApplicationResponse>

    @GET("api/applicant-applications")
    fun getApplications(
        @Query("applicant_id") id: Int
    ): Call<com.bitbybit.scholarzone.models.ApplicationResponse>

    @GET("api/notifications")
    fun getNotifications(
        @Query("applicant_id") id: Int
    ): Call<com.bitbybit.scholarzone.models.NotificationResponse>

    @POST("api/applicant-otp")
    fun generateOTP(
        @Body otp: OTP
    ): Call<com.bitbybit.scholarzone.models.ForgotPasswordResponse>

    @POST("api/applicant-forgot-password")
    fun forgotPassword(
        @Body forgotPassword: com.bitbybit.scholarzone.models.ForgotPassword
    ): Call<com.bitbybit.scholarzone.models.ForgotPasswordResponse>

    @Multipart
    @POST("api/applicant-profile-picture")
    fun changeProfile(
        @Part profile_picture: MultipartBody.Part
    ): Call<Void>
}