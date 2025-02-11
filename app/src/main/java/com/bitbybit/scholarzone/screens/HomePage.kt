package com.bitbybit.scholarzone.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(nav: NavController) {

}

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    HomePage(rememberNavController())
}