package com.example.cafe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R
import com.example.cafe.components.Navbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun item_screen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (

        ) {

            Box () {
                Image(
                    painter = painterResource(id = R.drawable.burger),
                    contentDescription = "Food"
                )

                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                    modifier = Modifier.padding(15.dp).width(70.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Back",
                        tint = Color(0xFF471608),
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Hamburguesa",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Deliciosa hamburguesa",
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Tiempo de preparación: 10 minutos",
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Estado: Disponible",
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Cantidad:",
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {navController.navigate("CartScreen")},
                    colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        text = "Seleccionar     $70 mxn",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF),
                        fontSize = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Column (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Instrucciones especiales:",
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Sin cebolla, Sin tomate...",
                    fontSize = 15.sp,
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.padding(horizontal = 25.dp)) { Navbar(navController) }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Item() {
    item_screen(navController = rememberNavController())
}