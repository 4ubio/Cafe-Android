package com.example.cafe.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cafe.views.cart_screen
import com.example.cafe.views.conf_screen
import com.example.cafe.views.home_screen
import com.example.cafe.views.item_screen
import com.example.cafe.views.login_screen
import com.example.cafe.views.menu_screen
import com.example.cafe.views.order_screen
import com.example.cafe.views.orders_screen
import com.example.cafe.views.profile_screen
import com.example.cafe.views.register_screen
import com.example.cafe.views.splash_screen

@Composable
fun NavManager() {
    var navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable(route = "SplashScreen") {
            splash_screen(navController)
        }

        composable(route = "LoginScreen") {
            login_screen(navController)
        }

        composable(route = "RegisterScreen") {
            register_screen(navController)
        }

        composable(route = "HomeScreen") {
            home_screen(navController)
        }

        composable(route = "MenuScreen") {
            menu_screen(navController)
        }

        composable(route = "ItemScreen") {
            item_screen(navController)
        }

        composable(route = "ConfScreen") {
            conf_screen(navController)
        }

        composable(route = "OrdersScreen") {
            orders_screen(navController)
        }

        composable(route = "OrderScreen") {
            order_screen(navController)
        }

        composable(route = "CartScreen") {
            cart_screen(navController)
        }

        composable(route = "ProfileScreen") {
            profile_screen(navController)
        }
    }
}