package com.bitbybit.scholarzone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.objects.ForgotPasswordViewModel
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.objects.SignUpViewModel
import com.bitbybit.scholarzone.screens.DashboardPage
import com.bitbybit.scholarzone.screens.ForgotPassword
import com.bitbybit.scholarzone.screens.ForgotPasswordTwo
import com.bitbybit.scholarzone.screens.HomePage
import com.bitbybit.scholarzone.screens.LandingPage
import com.bitbybit.scholarzone.screens.LoginPage
import com.bitbybit.scholarzone.screens.MainPage
import com.bitbybit.scholarzone.screens.NotificationPage
import com.bitbybit.scholarzone.screens.ProfilePage
import com.bitbybit.scholarzone.screens.SignUpPageThree
import com.bitbybit.scholarzone.screens.SignUpPageTwo
import com.bitbybit.scholarzone.screens.SignupPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nc = rememberNavController()
            val signUpViewModel: SignUpViewModel = viewModel()
            val forgotViewModel: ForgotPasswordViewModel = viewModel()
            val sharedPref: SharedPreferences = applicationContext.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
            val token: String? = sharedPref.getString("token", null)
            val startDestination = if (token.isNullOrEmpty()) Routes.LandingPage else Routes.MainPage

            NavHost(navController = nc, startDestination = startDestination, builder = {
                composable(Routes.LandingPage) {
                    LandingPage(nc)
                }
                composable(Routes.LoginPage) {
                    LoginPage(nc)
                }
                composable(Routes.SignupPage) {
                    SignupPage(nc, signUpViewModel)
                }
                composable(Routes.SignupPageTwo) {
                    SignUpPageTwo(nc, signUpViewModel)
                }
                composable(Routes.SignupPageThree) {
                    SignUpPageThree(nc, signUpViewModel)
                }
                composable(Routes.MainPage) {
                    val nestedNavController = rememberNavController()
                    MainPage(nestedNavController, nc)
                }
                composable(Routes.ForgotPassword) {
                    ForgotPassword(nc, forgotViewModel)
                }
                composable(Routes.ForgotPasswordTwo) {
                    ForgotPasswordTwo(nc, forgotViewModel)
                }
            })
        }
    }
}