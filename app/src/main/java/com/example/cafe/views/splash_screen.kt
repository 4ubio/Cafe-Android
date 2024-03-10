package com.example.cafe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R
import kotlinx.coroutines.delay

@Composable
fun splash_screen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack()
        navController.navigate("LoginScreen")
    }

    splash()
}

@Composable
fun splash() {
    Box(
        modifier = Modifier
            .background(Color(0xFFB63B14))
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.delfin),
            contentDescription = "Logo del IEST",
            modifier = Modifier
                .align(Alignment.Center)
                .size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Splash() {
    splash_screen(navController = rememberNavController())
}