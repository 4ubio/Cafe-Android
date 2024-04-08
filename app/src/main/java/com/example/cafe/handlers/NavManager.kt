package com.example.cafe.handlers

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

        composable(route = "MenuScreen/{area}", arguments =
            listOf(
                navArgument("area") {type = NavType.StringType},
            )) {
            parameters ->
                val area = parameters.arguments?.getString("area") ?: ""
            menu_screen(navController, area)
        }

        composable(route = "ItemScreen" +
                            "/{id}" +
                            "/{nombre}" +
                            "/{foto}" +
                            "/{precio}" +
                            "/{descripcion}" +
                            "/{estado}" +
                            "/{tiempo}" +
                            "/{categoria}" +
                            "/{area}" +
                            "/{hora_fin}" +
                            "/{hora_inicio}",
                    arguments = listOf(
                            navArgument("id") {type = NavType.StringType},
                            navArgument("nombre") {type = NavType.StringType},
                            navArgument("foto") {type = NavType.StringType},
                            navArgument("precio") {type = NavType.StringType},
                            navArgument("descripcion") {type = NavType.StringType},
                            navArgument("estado") {type = NavType.StringType},
                            navArgument("tiempo") {type = NavType.StringType},
                            navArgument("categoria") {type = NavType.StringType},
                            navArgument("area") {type = NavType.StringType},
                            navArgument("hora_fin") {type = NavType.StringType},
                            navArgument("hora_inicio") {type = NavType.StringType},
        )) {
                parameters ->
                    val id = parameters.arguments?.getString("id") ?: ""
                    val nombre = parameters.arguments?.getString("nombre") ?: ""
                    val foto = parameters.arguments?.getString("foto") ?: ""
                    val precio = parameters.arguments?.getString("precio") ?: ""
                    val descripcion = parameters.arguments?.getString("descripcion") ?: ""
                    val estado = parameters.arguments?.getString("estado") ?: ""
                    val tiempo = parameters.arguments?.getString("tiempo") ?: ""
                    val categoria = parameters.arguments?.getString("categoria") ?: ""
                    val area = parameters.arguments?.getString("area") ?: ""
                    val hora_fin = parameters.arguments?.getString("hora_fin") ?: ""
                    val hora_inicio = parameters.arguments?.getString("hora_inicio") ?: ""

            item_screen(
                navController,
                id,
                nombre,
                foto,
                precio,
                descripcion,
                estado,
                tiempo,
                categoria,
                area,
                hora_fin,
                hora_inicio
            )
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