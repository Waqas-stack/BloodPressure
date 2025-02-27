package com.o9tech.heartratemonitor.ui.theme.Screens.DailySettings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
fun DailySettingsSceen(navController: NavHostController) {
    val isChecked = remember { mutableStateOf(false) }
    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }

    Scaffold(
        topBar = {
            Column {
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
                            text = "Daily Health Tracker",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 5.dp),
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                if (isInternetAvailable.value) {
                    BannersAds(modifier = Modifier
                        .fillMaxWidth()
                        .background(lightgray), adSize = AdSize.BANNER)
                }
            }
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
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                navController.navigate("UnintSettingsScreen")
                            }
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Unit Settings",
                            fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "KeyboardArrowRight",
                            tint = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Blood Sugar", fontSize = 16.sp)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                navController.navigate("TargetRangeScreen")
                            }
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Edit Target Range",
                            fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "KeyboardArrowRight",
                            tint = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Blood pressure", fontSize = 16.sp)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 14.dp, vertical = 10.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(text = "Sync the pulse reading to Heart rate every time you add a new BP record", fontSize = 14.sp)
                        Row(
                            modifier = Modifier
                                .padding(vertical = 0.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Off",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Switch(
                                modifier = Modifier,
                                checked = isChecked.value,
                                onCheckedChange = { isChecked.value = it }
                            )
                        }


                    }
                    Text(text = "BP records usually display both BP and heart rate results", fontSize = 11.sp)

                }
            }
        }
    )
}