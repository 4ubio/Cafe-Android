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
fun conf_screen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.align(Alignment.Center)
        ) {
            Row (
                modifier = Modifier
                    .background(Color(0xFFB63B14), shape = RoundedCornerShape(100.dp))
                    .padding(10.dp)
                    .width(150.dp)
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_celebration_24),
                    contentDescription = "Celeb",
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Orden recibida",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Tu orden #12345 ha sido recibida correctamente  y pronto podrás pasar por tu pedido.",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {navController.navigate("OrdersScreen")},
                colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
            ) {
                Text(
                    text = "Ir a pedidos",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFFFF),
                    fontSize = 20.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Conf() {
    conf_screen(navController = rememberNavController())
}
