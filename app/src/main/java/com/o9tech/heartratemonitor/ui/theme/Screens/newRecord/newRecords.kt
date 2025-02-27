package com.o9tech.heartratemonitor.ui.theme.Screens.newRecord

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NewRecordScreen(navController: NavHostController) {

    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 0.dp),
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
                actions = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .height(30.dp)
                            .padding(end = 10.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Save", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                },

                title = {
                    Text(
//                        text = "These are category of blood pressure and when user tap on it then go to the details screen",
                        text = "New Record",
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
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                ) {
                    if (isInternetAvailable.value) {
                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)}
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Weight(lbs)=")
                            Spacer(modifier = Modifier.height(5.dp))
                            Card(
                                modifier = Modifier,
                                elevation = CardDefaults.cardElevation(5.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                )
                            ) {
//                              Text(text = "120",fontSize = 20.sp,fontWeight = FontWeight.Bold,)
                                TextField(
                                    modifier = Modifier.width(160.dp),
                                    value = "120.57", onValueChange = {},
                                    minLines = 1,
                                    singleLine = true,
                                    textStyle = androidx.compose.ui.text.TextStyle(
                                        fontSize = 30.sp, // 🔥 Increase the font size here
                                        fontWeight = FontWeight.Bold, // Optional: Make the text bold
                                        color = Color.Black,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                    ),
                                    colors = TextFieldDefaults.colors(
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                        disabledTextColor = Color.Black,
                                        disabledPlaceholderColor = Color.Black
                                    ),
                                )
                            }
                        }
                        Column(
                            modifier = Modifier,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Height(cm)")
                            Spacer(modifier = Modifier.height(5.dp))
                            Card(
                                modifier = Modifier,
                                elevation = CardDefaults.cardElevation(5.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                )
                            ) {
//                              Text(text = "120",fontSize = 20.sp,fontWeight = FontWeight.Bold,)
                                TextField(
                                    modifier = Modifier.width(160.dp),
                                    value = "120.57", onValueChange = {},
                                    minLines = 1,
                                    singleLine = true,
                                    textStyle = androidx.compose.ui.text.TextStyle(
                                        fontSize = 30.sp, // 🔥 Increase the font size here
                                        fontWeight = FontWeight.Bold, // Optional: Make the text bold
                                        color = Color.Black,
                                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                    ),
                                    colors = TextFieldDefaults.colors(
                                        unfocusedContainerColor = Color.Transparent,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        focusedContainerColor = Color.Transparent,
                                        disabledContainerColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                        disabledTextColor = Color.Black,
                                        disabledPlaceholderColor = Color.Black
                                    ),
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        elevation = CardDefaults.cardElevation(5.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier,
//                             horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "dots",
                                    tint = Color.Red
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "OverWeight",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,

                                    )

                            }
                            Text(text = "25.0-29.9", fontSize = 14.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        elevation = CardDefaults.cardElevation(5.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Date & Time",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                TextButton(onClick = { /*TODO*/ }) {
                                    Text(text = "Note", fontSize = 18.sp)
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = "Edit",
                                        tint = Color.Red,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}