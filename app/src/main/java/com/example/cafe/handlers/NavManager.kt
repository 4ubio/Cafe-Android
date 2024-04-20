package com.example.cafe.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cafe.viewmodels.FoodViewModel
import com.example.cafe.viewmodels.OrderViewModel
import com.example.cafe.viewmodels.UserViewModel
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
    var foodViewModel = FoodViewModel()
    var orderViewModel = OrderViewModel()
    var userViewModel = UserViewModel()

    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable(route = "SplashScreen") {
            splash_screen(navController)
        }

        composable(route = "LoginScreen") {
            login_screen(navController, userViewModel)
        }

        composable(route = "RegisterScreen") {
            register_screen(navController)
        }

        composable(route = "HomeScreen") {
            home_screen(navController)
        }

        composable(route = "MenuScreen/{area}", arguments =
            listOf(
                navArgument("area") {type = NavType.StringType}
            )) {
            parameters ->
                val area = parameters.arguments?.getString("area") ?: ""
            menu_screen(navController, foodViewModel, area)
        }

        composable(route = "ItemScreen/{id}", arguments =
            listOf(
                navArgument("id") {type = NavType.StringType}
        )) {
                parameters ->
                    val id = parameters.arguments?.getString("id") ?: ""

            item_screen(navController, foodViewModel, id)
        }

        composable(route = "ConfScreen") {
            conf_screen(navController)
        }

        composable(route = "OrdersScreen") {
            orders_screen(navController, orderViewModel)
        }

        composable(route = "OrderScreen/{id}", arguments =
            listOf(
                navArgument("id") {type = NavType.StringType}
        )) {
                parameters ->
                    val id = parameters.arguments?.getString("id") ?: ""

            order_screen(navController, orderViewModel, id)
        }

        composable(route = "CartScreen/" +
                        "{id}/" +
                        "{nombre}/" +
                        "{foto}/" +
                        "{precio}/" +
                        "{cantidad}/", arguments =
            listOf(
                navArgument("id") {type = NavType.StringType},
                navArgument("nombre") {type = NavType.StringType},
                navArgument("foto") {type = NavType.StringType},
                navArgument("precio") {type = NavType.StringType},
                navArgument("cantidad") {type = NavType.StringType}
        )) {
                parameters ->
                    val id = parameters.arguments?.getString("id") ?: ""
                    val nombre = parameters.arguments?.getString("nombre") ?: ""
                    val foto = parameters.arguments?.getString("foto") ?: ""
                    val precio = parameters.arguments?.getString("precio") ?: ""
                    val cantidad = parameters.arguments?.getString("cantidad") ?: ""

            cart_screen(navController, id, nombre, foto, precio, cantidad)
        }

        composable(route = "ProfileScreen") {
            profile_screen(navController)
        }
    }
}