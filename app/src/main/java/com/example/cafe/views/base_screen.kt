package com.example.cafe.views

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun base_screen(navController: NavHostController) {

}

@Preview(showBackground = true)
@Composable
fun Preview_Base() {
    base_screen(navController = rememberNavController())
}
