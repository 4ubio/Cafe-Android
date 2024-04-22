package com.example.cafe.views

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import coil.compose.AsyncImage
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.viewmodels.FoodViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun menu_screen(navController: NavHostController, viewModel: FoodViewModel, area: String) {

    //Load Menu
    LaunchedEffect(viewModel.menu, block = {
        viewModel.getMenuList(area)
    })

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
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
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = "Back",
                        tint = Color(0xFF471608),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Text(
                    text = area,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            //Display Menu
            if (viewModel.isLoaded_menu) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(15.dp)
                        .weight(30f)
                ) {
                    items(viewModel.menu) { food ->
                        Row(
                            modifier = Modifier
                                .background(
                                    Color(0xFFD2CECE),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .padding(horizontal = 10.dp, vertical = 20.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = "https://lacafe3.000webhostapp.com/food/${food.foto}",
                                placeholder = painterResource(id = R.drawable.food_icon),
                                error = painterResource(id = R.drawable.food_icon),
                                contentDescription = food.nombre,
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
                                    text = food.nombre,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                )

                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "$${food.precio} mxn",
                                    fontSize = 18.sp,
                                    fontStyle = FontStyle.Italic
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Button(
                                    onClick = {
                                        navController.navigate("ItemScreen/${food.id}")
                                    },
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

            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.padding(horizontal = 25.dp)) { Navbar(navController) }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun Preview_Menu() {
    //menu_screen(navController = rememberNavController(), area = "Café")
}
