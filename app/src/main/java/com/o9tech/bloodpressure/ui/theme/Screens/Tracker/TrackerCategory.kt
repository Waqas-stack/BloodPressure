package com.o9tech.bloodpressure.ui.theme.Screens.Tracker

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.o9tech.bloodpressure.ui.theme.Screens.weight.LineChartComposable
import com.o9tech.bloodpressure.ui.theme.btnbg
import com.o9tech.bloodpressure.ui.theme.lightgray



@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackerCategoryScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),

                title = {
                    Text(
                        text = "Tracker",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(start = 5.dp),
                    )
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .size(40.dp) // Circle size
                            .background(
                                color = Color.LightGray,
                                shape = CircleShape
                            ), // Light gray background with circle shape
                        contentAlignment = Alignment.Center // Center the icon inside the circle
                    ) {
                        IconButton(onClick = {
//                            navController.navigate("ReminderScreen")
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications, // Notification icon
                                contentDescription = "Notification",
                                tint = Color.Black, // Icon color
                                modifier = Modifier.size(24.dp) // Icon size
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lightgray
                ),
            )
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ){
                    Card (
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ){
                        Column (
                            modifier = Modifier.padding(10.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Heart Health",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Button(
                                    modifier = Modifier
                                        .height(35.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = btnbg,
                                        contentColor = Color.White
                                    ),
                                    onClick = { /*TODO*/ }) {
                                    Text(
                                        text = "Measure",
                                        fontSize = 12.sp,
                                    )
                                }
                            }
                            LineChartComposable()
                            TextButton(onClick = {
                                navController.navigate("TrackerScreen")
                            },modifier = Modifier
                                .align(Alignment.End)) {
                                Text(text = "View More",
                                    style = TextStyle(
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    fontSize = 10.sp,
                                )
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card (
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ){
                        Column (
                            modifier = Modifier.padding(10.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Blood Pressure",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Button(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(30.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = btnbg,
                                        contentColor = Color.White
                                    ),
                                    onClick = { navController.navigate("NewRecordScreen") }) {
                                    Text(
                                        text = "Add",
                                        fontSize = 12.sp,
                                    )
                                }
                            }
                            LineChartComposable()
                            TextButton(onClick = {
                                navController.navigate("TrackerScreen")
                            },
                                modifier = Modifier
                                    .align(Alignment.End)) {
                                Text(text = "View More",  style = TextStyle(
                                    textDecoration = TextDecoration.Underline
                                ),
                                    fontSize = 10.sp, )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card (
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ){
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Blood Sugar",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Button(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(30.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = btnbg,
                                        contentColor = Color.White
                                    ),
                                    onClick = {
                                        navController.navigate("NewRecordScreen")
                                    }) {
                                    Text(
                                        text = "Add",
                                        fontSize = 12.sp,
                                    )
                                }
                            }
                            LineChartComposable()
                            TextButton(onClick = {
                                navController.navigate("TrackerScreen")
                            }, modifier = Modifier
                                .align(Alignment.End)) {
                                Text(text = "View More",
                                    style = TextStyle(
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    fontSize = 10.sp,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card (
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 3.dp
                        )
                    ){
                        Column (
                            modifier = Modifier.padding(10.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Weight",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Button(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(30.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = btnbg,
                                        contentColor = Color.White
                                    ),
                                    onClick = {
                                        navController.navigate("NewRecordScreen")
                                    }) {
//                                Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Add",
                                        fontSize = 12.sp,
//                                    fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            LineChartComposable()
                            TextButton(onClick = {
                                navController.navigate("TrackerScreen")
                            }, modifier = Modifier
                                .align(Alignment.End)) {
                                Text(text = "View More",
                                    style = TextStyle(
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    fontSize = 10.sp,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
    )
}