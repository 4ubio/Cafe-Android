package com.example.cafe.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Divider
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
fun profile_screen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            //Content
            Spacer(modifier = Modifier.height(15.dp))

            Icon(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "User",
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Sebastián Rubio Quiroz",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(20.dp))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable { navController.navigate("OrdersScreen") }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.list),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Ver tu historial de pedidos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Configuración",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.width(350.dp).align(Alignment.CenterHorizontally))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.gift),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Novedades",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.width(350.dp).align(Alignment.CenterHorizontally))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Notificaciones",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.width(350.dp).align(Alignment.CenterHorizontally))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Comentarios",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.width(350.dp).align(Alignment.CenterHorizontally))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.people),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Creadores",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.width(350.dp).align(Alignment.CenterHorizontally))

            Row (
                modifier = Modifier
                    .background(Color(0xFFD2CECE), shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                    .padding(15.dp)
                    .width(320.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    text = "Cerrar Sesión",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
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
fun Preview_Profile() {
    profile_screen(navController = rememberNavController())
}