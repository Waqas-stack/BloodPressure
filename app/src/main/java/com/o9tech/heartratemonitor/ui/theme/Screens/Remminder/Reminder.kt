package com.o9tech.heartratemonitor.ui.theme.Screens.Remminder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ReminderScreen(navController: NavHostController) {
    val isChecked = remember { mutableStateOf(false) }
    val isCheckedtwo = remember { mutableStateOf(false) }
    val isCheckedthree = remember { mutableStateOf(false) }
    val isCheckedfour = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),
                navigationIcon = {
                                 IconButton(onClick = {
                                     navController.popBackStack()
                                 }) {
                                     Icon(
                                         imageVector = Icons.Default.ArrowBack,
                                         contentDescription = "ArrowBack",
                                         modifier = Modifier.padding(start = 10.dp),
                                     )
                                 }


                },

                title = {
                    Text(
                        text = "Reminder",
//                        text = "reminder",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 5.dp),
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lightgray
                ),
            )
        },
        content = { paddingValues ->
            Surface(
                color = lightgray,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Blue)
                            .padding(14.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "cllock",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Text(
                            text = "set a reminder to log health data.",
                            fontSize = 14.sp,
                            color = Color.White,
//                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Heart rate", fontSize = 14.sp, fontWeight = FontWeight.W600)
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "add",
                            tint = Color.Red
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column {
                            Text(
                                text = "20:00",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(text = "Everyday", fontSize = 12.sp)
                        }
                        Switch(
                            modifier = Modifier,
                            checked = isChecked.value,
                            onCheckedChange = { isChecked.value = it }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Blood pressure", fontSize = 14.sp, fontWeight = FontWeight.W600)
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "add",
                            tint = Color.Red
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column {
                            Text(
                                text = "20:00",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(text = "Everyday", fontSize = 12.sp)
                        }
                        Switch(
                            modifier = Modifier,
                            checked = isCheckedtwo.value,
                            onCheckedChange = { isCheckedtwo.value = it }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Blood Sugar",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W600)
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "add",
                            tint = Color.Red
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column {
                            Text(
                                text = "20:00",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(text = "Everyday", fontSize = 12.sp)
                        }
                        Switch(
                            modifier = Modifier,
                            checked = isCheckedthree.value,
                            onCheckedChange = { isCheckedthree.value = it }
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Weight & BMI", fontSize = 14.sp, fontWeight = FontWeight.W600)
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "add",
                            tint = Color.Red
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column {
                            Text(
                                text = "20:00",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(text = "Everyday", fontSize = 12.sp)
                        }
                        Switch(
                            modifier = Modifier,
                            checked = isCheckedfour.value,
                            onCheckedChange = { isCheckedfour.value = it }
                        )
                    }


                }
            }
        }
    )
}