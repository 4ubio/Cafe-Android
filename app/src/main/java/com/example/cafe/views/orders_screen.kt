package com.example.cafe.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.viewmodels.OrderViewModel
import com.example.cafe.viewmodels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun orders_screen(navController: NavHostController, orderViewModel: OrderViewModel, userViewModel: UserViewModel) {

    //Load Orders
    val id_iest = userViewModel.id_iest.collectAsState(initial = "")
    LaunchedEffect(orderViewModel.orders, block = {
        orderViewModel.getOrdersList(id_iest.value)
    })

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

            //Display Orders
            if (!orderViewModel.isLoading_orders) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(15.dp)
                        .weight(30f)
                ) {
                    items(orderViewModel.orders) { order ->

                        Row (
                            modifier = Modifier
                                .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                                .padding(10.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.food_icon),
                                contentDescription = "Food",
                                modifier = Modifier
                                    .weight(0.8f)
                                    .size(120.dp)
                                    .clip(shape = RoundedCornerShape(20.dp))
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            Column (
                                modifier = Modifier
                                    .weight(1f)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text (
                                    text = "No. ${order.id}",
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = order.nombre_platillo,
                                    fontSize = 18.sp,
                                    fontStyle = FontStyle.Italic
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "${order.total} mxn",
                                    fontSize = 18.sp,
                                    fontStyle = FontStyle.Italic
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "Cantidad: ${order.cantidad}",
                                    fontSize = 18.sp,
                                    fontStyle = FontStyle.Italic
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Button(
                                    onClick = {navController.navigate("OrderScreen/${order.id}")},
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
                    }
                }
            } else {
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(30f).fillMaxWidth()
                ) {
                    CircularProgressIndicator(
                        color = Color(0xFFB63B14),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(100.dp)
                    )
                }
            }

            //Navbar
            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.padding(horizontal = 25.dp)) {Navbar(navController)}
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Preview_Orders() {
    //orders_screen(navController = rememberNavController())
}