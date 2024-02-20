package com.example.cafe.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cafe.views.login_screen
import com.example.cafe.views.register_screen

@Composable
fun NavManager() {
    var navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "LoginScreen") {
        composable(route = "LoginScreen") {
            login_screen(navController)
        }

        composable(route = "RegisterScreen") {
            register_screen(navController)
        }
    }
}