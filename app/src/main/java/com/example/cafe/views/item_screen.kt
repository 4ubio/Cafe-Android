package com.example.cafe.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.viewmodels.FoodViewModel
import com.example.cafe.viewmodels.UserViewModel
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun item_screen(navController: NavHostController, foodViewModel: FoodViewModel, userViewModel: UserViewModel, id: String) {

    //Variables
    var id_iest = userViewModel.id_iest.collectAsState(initial = "")
    val items = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    var selectedIndex by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }
    var cant = items[selectedIndex]

    //Current Hour
    val actualDate = LocalTime.now()
    val format = DateTimeFormatter.ofPattern("HH:mm:ss")
    val actualHourString = actualDate.format(format)
    val actualHour = LocalTime.parse(actualHourString, format)

    //Load Item
    LaunchedEffect(Unit, block = {
        foodViewModel.getFoodItem(id)
        userViewModel.getUserStatus(id_iest.value)
    })

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column () {

            //Display Food
            if (foodViewModel.isLoaded_food) {
                Box () {
                    AsyncImage(
                        model = "https://lacafe3.000webhostapp.com/food/${foodViewModel.food.foto}",
                        placeholder = painterResource(id = R.drawable.food_icon),
                        error = painterResource(id = R.drawable.food_icon),
                        contentDescription = foodViewModel.food.nombre,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f)
                    )

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
                }

                Spacer(modifier = Modifier.height(15.dp))

                Row (
                    modifier = Modifier.padding(horizontal = 25.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                            .padding(15.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = foodViewModel.food.nombre,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = foodViewModel.food.descripcion,
                            fontSize = 20.sp,
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Tiempo de preparación: ${foodViewModel.food.tiempo} minutos",  //PENDIENTE TRADUCCION
                            fontSize = 20.sp,
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Estado: ${foodViewModel.food.estado}",     //PENDIENTE TRADUCCION
                            fontSize = 20.sp,
                        )

                        Spacer(modifier = Modifier.height(15.dp))

                        if (userViewModel.userStatus != "Activo") {
                            Text(
                                (stringResource(id = R.string.blocked)),   //Texto en ambos idiomas
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        } else if (
                            actualHour.isBefore(LocalTime.parse(foodViewModel.food.hora_inicio, format)) ||
                            actualHour.isAfter(LocalTime.parse(foodViewModel.food.hora_fin, format))
                        ) {
                            Text(
                                (stringResource(id = R.string.no_available2)),   //Texto en ambos idiomas
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        } else if (foodViewModel.food.estado != (stringResource(id = R.string.available))) {  //Texto en ambos idiomas
                            Text(
                                (stringResource(id = R.string.no_available)),   //Texto en ambos idiomas
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        } else {

                            //Select cant button
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    (stringResource(id = R.string.amount)),   //Texto en ambos idiomas
                                    fontSize = 20.sp
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Button(
                                    onClick = { expanded = true },
                                    colors = ButtonDefaults.buttonColors(Color(0xFF6B869E)),
                                ) {
                                    Text(text = "$cant")
                                }

                                DropdownMenu(
                                    expanded = expanded,
                                    onDismissRequest = { expanded = false },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    items.forEachIndexed { index, cant ->
                                        DropdownMenuItem(
                                            text = {
                                                Text(text = cant)
                                            }, onClick = {
                                                selectedIndex = index
                                                expanded = false
                                            })
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Button(
                                onClick = {
                                    navController.navigate(
                                        "CartScreen/" +
                                                "${foodViewModel.food.id}/" +
                                                "${foodViewModel.food.nombre}/" +
                                                "${foodViewModel.food.foto}/" +
                                                "${foodViewModel.food.precio}/" +
                                                "${cant}/"
                                    )
                                },
                                colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                            ) {
                                Text(
                                    text = "Seleccionar   $${foodViewModel.food.precio} mxn",   //PENDIENTE TRADUCCION
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFFFFFF),
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            } else {
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(30f)
                        .fillMaxWidth()
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
fun Preview_Item() {
    //item_screen(navController = rememberNavController())
}