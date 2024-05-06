package com.example.cafe.views

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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.viewmodels.OrderViewModel
import com.example.cafe.viewmodels.UserViewModel

@Composable
fun cart_screen(
    navController: NavHostController,
    orderViewModel: OrderViewModel,
    userViewModel: UserViewModel,
    id: String,
    nombre: String,
    foto: String,
    precio: String,
    cantidad: String
) {

    var name = userViewModel.name.collectAsState(initial = "")
    var id_iest = userViewModel.id_iest.collectAsState(initial = "")

    LaunchedEffect(orderViewModel.isCreated_order, block = {
        if (orderViewModel.isCreated_order) {
            navController.navigate("ConfScreen")
            orderViewModel.isCreated_order = false
        }
    })

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (

        ) {
            Box (
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .padding(15.dp)
                        .width(70.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Back",
                        tint = Color(0xFF471608),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(
                    (stringResource(id=R.string.cart)),    //Texto en ambos idiomas
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column (
                modifier = Modifier.padding(horizontal = 25.dp)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                        .padding(10.dp)
                        .widthIn(max = 400.dp, min = 350.dp)
                        .align(Alignment.CenterHorizontally)
                ) {

                    AsyncImage(
                        model = "https://lacafe3.000webhostapp.com/food/$foto",
                        placeholder = painterResource(id = R.drawable.food_icon),
                        error = painterResource(id = R.drawable.food_icon),
                        contentDescription = nombre,
                        modifier = Modifier
                            .weight(0.8f)
                            .clip(shape = RoundedCornerShape(20.dp))
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = nombre,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "$$precio mxn",
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Italic
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "${stringResource(id=R.string.amount)}: $cantidad",    //Texto en ambos idiomas
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Subtotal",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Light
                )

                Text(
                    text = "$${precio.toDouble() * cantidad.toInt()} mxn",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 30.dp))

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$${precio.toDouble() * cantidad.toInt()} mxn",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            if (!orderViewModel.isSetting_order) {
                Button(
                    onClick = {
                        orderViewModel.setUserOrder(id, cantidad, id_iest.value, name.value)
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp)
                ) {
                    Text(
                        (stringResource(id=R.string.pay)),       //Texto en ambos idiomas
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFFFFFF),
                        fontSize = 20.sp
                    )
                }
            } else {
                CircularProgressIndicator(
                    color = Color(0xFFB63B14),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.padding(horizontal = 25.dp)) { Navbar(navController) }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Preview_Cart() {
    //cart_screen(navController = rememberNavController())
}