package com.bitbybit.scholarzone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bitbybit.scholarzone.objects.Routes
import com.bitbybit.scholarzone.screens.LandingPage
import com.bitbybit.scholarzone.screens.LoginPage
import com.bitbybit.scholarzone.screens.SignupPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val nc = rememberNavController()

            NavHost(navController = nc, startDestination = Routes.LandingPage, builder = {
                composable(Routes.LandingPage) {
                    LandingPage(nc)
                }
                composable(Routes.LoginPage) {
                    LoginPage(nc)
                }
                composable(Routes.SignupPage) {
                    SignupPage(nc)
                }
            })
        }
    }
}