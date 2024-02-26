package com.example.cafe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun menu_screen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            
        ) {
            Box (
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {navController.popBackStack()},
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .padding(15.dp)
                        .width(70.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back",
                        tint = Color(0xFF471608),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(
                    text = "La Cafe",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Rápida",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 20.dp)
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
                        text = "Hamburguesa",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$70 mxn",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {navController.navigate("ItemScreen")},
                        colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Seleccionar",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                            fontSize = 15.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Méxicana",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 20.dp)
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
                        text = "Chilaquiles de Pollo",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = "$75 mxn",
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Seleccionar",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                            fontSize = 15.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row (
                modifier = Modifier
                    .background(Color(0xFF471608), shape = RoundedCornerShape(20.dp))
                    .width(340.dp)
                    .padding(15.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Home",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier.size(40.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_view_list_24),
                    contentDescription = "Orders",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier.size(40.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
                    contentDescription = "Cart",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier.size(40.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = "User",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Menu() {
    menu_screen(navController = rememberNavController())
}
