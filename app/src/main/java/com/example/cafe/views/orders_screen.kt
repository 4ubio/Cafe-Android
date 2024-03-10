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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
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
fun orders_screen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            //Content
            Text(
                text = "Historial de pedidos",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(15.dp)
            )

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.burger),
                    contentDescription = "Food",
                    modifier = Modifier
                        .weight(0.8f)
                        .clip(shape = RoundedCornerShape(20.dp))
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column (
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text (
                        text = "No. 12345",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Hamburguesa",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$70 mxn",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Cantidad: 1",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                        onClick = {navController.navigate("OrderScreen")},
                        colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Ver",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                            fontSize = 15.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chilaquiles),
                    contentDescription = "Food",
                    modifier = Modifier
                        .weight(0.8f)
                        .clip(shape = RoundedCornerShape(20.dp))
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column (
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text (
                        text = "No. 12344",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Chilaquiles de Pollo",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$75 mxn",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "Cantidad: 1",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Ver",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                            fontSize = 15.sp
                        )
                    }
                }
            }

            //Navbar
            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.padding(horizontal = 25.dp)) {Navbar(navController)}
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Orders() {
    orders_screen(navController = rememberNavController())
}