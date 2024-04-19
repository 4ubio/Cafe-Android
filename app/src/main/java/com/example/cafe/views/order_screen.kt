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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.viewmodels.OrderViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun order_screen(navController: NavHostController, viewModel: OrderViewModel, id: String) {

    //Refresh and variables
    var refreshing by remember { mutableStateOf(false) }
    var progress = 0.0f

    //Load Order
    LaunchedEffect(refreshing, block = {
        if (refreshing) {
            refreshing = false
        } else {
            viewModel.getOrderItem(id)
        }
    })

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing),
        onRefresh = {refreshing = true},
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column() {

                //Display Food
                if (!viewModel.order.isEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(30f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(viewModel.order) { order ->

                            Box(
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
                                    text = "Tu pedido",
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "No. ${order.id}",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 30.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            Row(
                                modifier = Modifier
                                    .background(
                                        Color(0xFFD2CECE),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .padding(horizontal = 10.dp, vertical = 20.dp)
                                    .widthIn(max = 400.dp, min = 350.dp)
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.food_icon),
                                    contentDescription = "Food",
                                    modifier = Modifier
                                        .weight(0.8f)
                                        .size(100.dp)
                                        .clip(shape = RoundedCornerShape(20.dp))
                                )

                                Spacer(modifier = Modifier.width(20.dp))

                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .align(Alignment.CenterVertically)
                                ) {
                                    Text(
                                        text = order.nombre_platillo,
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold,
                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "$${order.total} mxn",
                                        fontSize = 18.sp,
                                        fontStyle = FontStyle.Italic
                                    )

                                    Spacer(modifier = Modifier.height(5.dp))

                                    Text(
                                        text = "Cantidad: ${order.cantidad}",
                                        fontSize = 18.sp,
                                        fontStyle = FontStyle.Italic
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 30.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Recoger en:",
                                    fontSize = 20.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Light
                                )

                                Text(
                                    text = order.area,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 30.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Fecha de pedido:",
                                    fontSize = 20.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Light
                                )

                                Text(
                                    text = order.fecha,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 30.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Hora de pedido:",
                                    fontSize = 20.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Light
                                )

                                Text(
                                    text = order.hora,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Divider(
                                color = Color.Gray,
                                thickness = 1.dp,
                                modifier = Modifier.padding(horizontal = 30.dp)
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            Row(
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
                                    text = "$${order.total} mxn",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.height(30.dp))

                            Column(
                                modifier = Modifier.padding(horizontal = 30.dp)
                            ) {
                                Text(
                                    text = order.estado,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                //Set progress
                                if (order.estado == "En preparación") {
                                    progress = 0.33f
                                } else if (order.estado == "Listo para recoger") {
                                    progress = 0.66f
                                } else {
                                    progress = 1f
                                }

                                LinearProgressIndicator(
                                    progress = progress,
                                    color = Color(0xFFB63B14),
                                    modifier = Modifier
                                        .height(35.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(Color(0xFFC7D0D8))
                                        .fillMaxWidth()
                                )
                            }
                        }
                    }
                } else {
                    Column(
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

                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = Modifier.padding(horizontal = 25.dp)) { Navbar(navController) }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Preview_Order() {
    //order_screen(navController = rememberNavController(), id = "1")
}