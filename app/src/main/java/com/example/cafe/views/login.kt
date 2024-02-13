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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafe.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun login_screen() {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(Color(0xFFB63B14))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.delfin),
                contentDescription = "Logo del IEST",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "La Cafe",
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = "icono",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp).align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(15.dp))

                TextField(
                    value = user,
                    onValueChange = { user = it },
                    label = { Text("Correo Institucional") },
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 0.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = "icono",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp).align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(15.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    shape = RoundedCornerShape(20.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
            ) {
                    Text(
                        text = "Iniciar Sesión",
                        color = Color(0xFFB63B14),
                        fontSize = 20.sp
                    )
                }
        }

    }
}