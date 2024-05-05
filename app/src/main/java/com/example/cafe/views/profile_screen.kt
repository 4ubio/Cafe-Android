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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cafe.R
import com.example.cafe.components.Navbar
import com.example.cafe.viewmodels.UserViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun profile_screen(navController: NavHostController, viewModel: UserViewModel) {
    val corrutineScope = rememberCoroutineScope()

    var savedIdIEST = viewModel.id_iest.collectAsState(initial = "")
    var savedName = viewModel.name.collectAsState(initial = "")
    var savedEmail = viewModel.email.collectAsState(initial = "")

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
                text = "${savedName.value}",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Email: ${savedEmail.value}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "ID IEST: ${savedIdIEST.value}",
                fontSize = 20.sp,
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
                    (stringResource(id=R.string.see_orders)),    //Texto en ambos idiomas
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
                    (stringResource(id=R.string.configuration)),    //Texto en ambos idiomas
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
                    (stringResource(id=R.string.news)),    //Texto en ambos idiomas
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
                    (stringResource(id=R.string.notifications)),    //Texto en ambos idiomas
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
                    (stringResource(id=R.string.comments)),    //Texto en ambos idiomas
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
                    (stringResource(id=R.string.creators)),    //Texto en ambos idiomas
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
                    .clickable {
                        corrutineScope.launch {
                            viewModel.setData(false, "", "", "", "")
                            viewModel.logoutCafeUser()
                            navController.navigate("LoginScreen")
                        }
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = "Icon",
                    tint = Color(0xFFB63B14),
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Text(
                    (stringResource(id=R.string.sign_out)),    //Texto en ambos idiomas
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

//@Preview(showBackground = true)
@Composable
fun Preview_Profile() {
    //profile_screen(navController = rememberNavController())
}