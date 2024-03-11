package com.example.cafe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R

@Composable
fun Navbar(navController: NavHostController) {
    Row (
        modifier = Modifier
            .background(Color(0xFF471608), shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            painter = painterResource(id = R.drawable.home),
            contentDescription = "Home",
            tint = Color(0xFFFFFFFF),
            modifier = Modifier
                .size(40.dp)
                .clickable {navController.navigate("HomeScreen")}
        )

        Icon(
            painter = painterResource(id = R.drawable.list),
            contentDescription = "Orders",
            tint = Color(0xFFFFFFFF),
            modifier = Modifier
                .size(40.dp)
                .clickable {navController.navigate("OrdersScreen")}
        )

        Icon(
            painter = painterResource(id = R.drawable.cart),
            contentDescription = "Cart",
            tint = Color(0xFFFFFFFF),
            modifier = Modifier
                .size(40.dp)
                .clickable {navController.navigate("CartScreen")}
        )

        Icon(
            painter = painterResource(id = R.drawable.person),
            contentDescription = "User",
            tint = Color(0xFFFFFFFF),
            modifier = Modifier
                .size(40.dp)
                .clickable {navController.navigate("ProfileScreen")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Nav() {
    Navbar(navController = rememberNavController())
}