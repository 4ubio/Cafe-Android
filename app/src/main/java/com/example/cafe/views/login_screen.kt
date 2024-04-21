package com.example.cafe.views

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cafe.R
import com.example.cafe.ui.theme.nexa
import com.example.cafe.viewmodels.UserViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login_screen(navController: NavHostController, viewModel: UserViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val corrutineScope = rememberCoroutineScope()

    //Listen for isAuthing changes
    LaunchedEffect(viewModel.isAuthing, block = {
        if (viewModel.isAuthed) {                           //If user is authed,
            corrutineScope.launch {        //Save their login data
                viewModel.setData(
                    true,
                    viewModel.user.id_iest,
                    viewModel.user.nombre,
                    viewModel.user.email,
                    viewModel.user.estado
                )
            }
            navController.navigate("HomeScreen")    //And change screen

        } else if (viewModel.isAuthFailed) {                //Else, show message
            Toast.makeText(context, "Correo o contraseña incorrectos.", Toast.LENGTH_LONG).show()
        }
    })

    Box(
        modifier = Modifier
            .background(Color(0xFFB63B14))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.delfin),
                contentDescription = "Logo del IEST",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "La Cafe",
                color = Color(0xFFFFFFFF),
                fontSize = 75.sp,
                fontFamily = nexa,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Column (
                modifier = Modifier
                    .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(20.dp))
                    .padding(10.dp)
                    .width(320.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Correo Institucional") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Mail",
                            tint = Color(0xFFB63B14),
                        )},
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFFB63B14), unfocusedBorderColor = Color(0xFFB63B14)),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp)
                )

                Spacer(modifier = Modifier.height(2.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = "Password",
                            tint = Color(0xFFB63B14),
                        )},
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color(0xFFB63B14), unfocusedBorderColor = Color(0xFFB63B14)),
                    shape = RoundedCornerShape(30.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 3.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                if (!viewModel.isAuthing) {
                    Button(
                        onClick = {
                            if (email != "" && password != "") {
                                viewModel.authCafeUser(email, password)
                            } else {
                                Toast.makeText(context, "Faltan campos por llenar.", Toast.LENGTH_LONG).show()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFFB63B14)),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(
                            text = "Iniciar Sesión",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                            fontSize = 20.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Button(
                        onClick = {
                            navController.navigate("RegisterScreen")
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                    ) {
                        Text(
                            text = "O registrate ya",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF000000),
                            fontSize = 20.sp
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.height(5.dp))
                    CircularProgressIndicator(
                        color = Color(0xFFB63B14),
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }

                Spacer(modifier = Modifier.height(5.dp))
            }

        }

    }
}

//@Preview(showBackground = true)
@Composable
fun Preview_Login() {
    //login_screen(navController = rememberNavController())
}