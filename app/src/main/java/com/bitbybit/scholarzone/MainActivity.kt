package com.bitbybit.scholarzone

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
import com.bitbybit.scholarzone.screens.ForgotPassword
import com.bitbybit.scholarzone.screens.ForgotPasswordTwo
import com.bitbybit.scholarzone.screens.HomePage
import com.bitbybit.scholarzone.screens.LandingPage
import com.bitbybit.scholarzone.screens.LoginPage
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

            NavHost(navController = nc, startDestination = Routes.LandingPage, builder = {
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
                composable(Routes.HomePage) {
                    HomePage(nc)
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