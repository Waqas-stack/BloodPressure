package com.o9tech.heartratemonitor.ui.theme.Screens.Profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.appbg
import com.o9tech.heartratemonitor.ui.theme.btnbg
import com.o9tech.heartratemonitor.ui.theme.lightgray


@Preview(showBackground = true)
@Composable
fun ProfileScreen(navController: NavHostController) {
    val isChecked = remember { mutableStateOf(false) }

    Scaffold (
        content = {paddingValues->
            Surface(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                color = lightgray
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
//                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)
//                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp, start = 20.dp)
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(lightgray)
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    Text(
                        text = "Sync & Restore",
                        modifier = Modifier.padding(start = 20.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "sign in and back up your data",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 20.dp),
                        fontSize = 12.sp,
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp)
                            .fillMaxWidth()
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = btnbg,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(6.dp),
                        onClick = { /*TODO*/ }) {
//                Icon(imageVector = Icons.Default.Add, contentDescription = "")
//                Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Sync", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(10.dp),
                    ) {
                        Text(text = "Settings", fontSize = 16.sp,color = Color.Gray)
//                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().clickable {
                                    navController.navigate("GernalScreen")
                                }.padding(vertical = 10.dp)

                        ) {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "General settings",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,

                            )
                        }
//                        Spacer(modifier = Modifier.height(14.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
//                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().clickable {
                                    navController.navigate("ReminderScreen")
                                }.padding(vertical = 10.dp)

                        ) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Reminders", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
//                        Spacer(modifier = Modifier.height(14.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
//                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().clickable {
                                    navController.navigate("LanguagesScreen")
                                }.padding(vertical = 10.dp)

                        ) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Language", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
//                        Spacer(modifier = Modifier.height(14.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Export a file", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Row (
                                modifier = Modifier.padding(start = 10.dp)
                            ){
                                Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Contact with Google Fit", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            }

                            Switch(
//                        colors = SwitchDefaults.colors(
//                            checkedThumbColor = Color.White,
//                            checkedTrackColor = btnbg,
//                            uncheckedThumbColor = Color.White,
//                            uncheckedTrackColor = Color.LightGray
//                        ),
                                modifier = Modifier,
                                checked = isChecked.value,
                                onCheckedChange = { isChecked.value = it }
                            )
                        }
                        Spacer(modifier = Modifier.height(14.dp))




                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(10.dp),
                    ) {
                        Text(text = "More", fontSize = 16.sp,color = Color.Gray)
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "General settings", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(14.dp))

                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Reminders", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Language", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 40.dp)
                                .height(1.dp)
                                .background(Color.LightGray)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Export a file", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }


                        Spacer(modifier = Modifier.height(10.dp))



                    }
                    Spacer(modifier = Modifier.height(34.dp))
                }
            }
        }
    )



   
}




