package com.example.cafe.views

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.ui.theme.nexa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home_screen(navController: NavHostController) {

    var sizeImage by remember { mutableStateOf(IntSize.Zero) }

    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat()/5,
        endY = sizeImage.height.toFloat()
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "¡Bienvenido!",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(15.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Elige tu cafetería",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Column (
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(30f)
            ) {
                Box (
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .clickable { navController.navigate("MenuScreen/Café") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe_background),
                        contentDescription = "Loc",
                        modifier = Modifier.onGloballyPositioned {sizeImage = it.size}
                    )

                    Box(modifier = Modifier
                        .matchParentSize()
                        .background(gradient))

                    Text(
                        text = "La Café",
                        fontSize = 55.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nexa,
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Box (
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .clickable { navController.navigate("MenuScreen/Pérgola") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe_background),
                        contentDescription = "Loc",
                        modifier = Modifier.onGloballyPositioned {sizeImage = it.size}
                    )

                    Box(modifier = Modifier
                        .matchParentSize()
                        .background(gradient))

                    Text(
                        text = "Pérgola",
                        fontSize = 55.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nexa,
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Box (
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .clickable { navController.navigate("MenuScreen/Snacks") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe_background),
                        contentDescription = "Loc",
                        modifier = Modifier.onGloballyPositioned {sizeImage = it.size}
                    )

                    Box(modifier = Modifier
                        .matchParentSize()
                        .background(gradient))

                    Text(
                        text = "Snacks",
                        fontSize = 55.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nexa,
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Box (
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .clickable { navController.navigate("MenuScreen/Paninis") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe_background),
                        contentDescription = "Loc",
                        modifier = Modifier.onGloballyPositioned {sizeImage = it.size}
                    )

                    Box(modifier = Modifier
                        .matchParentSize()
                        .background(gradient))

                    Text(
                        text = "Paninis",
                        fontSize = 55.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nexa,
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(horizontal = 30.dp, vertical = 10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.padding(horizontal = 25.dp)) {Navbar(navController)}
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Home() {
    home_screen(navController = rememberNavController())
}