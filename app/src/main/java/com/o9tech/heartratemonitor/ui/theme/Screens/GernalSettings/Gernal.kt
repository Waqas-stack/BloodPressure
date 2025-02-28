package com.o9tech.heartratemonitor.ui.theme.Screens.GernalSettings

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GernalScreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()

    val isChecked = remember { mutableStateOf(false) }
    val isCheckedtwo = remember { mutableStateOf(false) }
    val isCheckedthree = remember { mutableStateOf(false) }

    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }


    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),
                navigationIcon = {
                    IconButton(onClick = {
                        safeNavController.popBackStack()
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
                        text = "General Settings",
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
                        .padding(horizontal = 16.dp, vertical = 16.dp)

                ) {
                    if (isInternetAvailable.value) {
                        BannersAds(modifier = Modifier.fillMaxWidth(), adSize = AdSize.BANNER)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Heart Rate")
                    Spacer(modifier = Modifier.size(10.dp))
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
                                text = "Ask my condition",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(text = "After every measurement", fontSize = 12.sp)
                        }
                        Switch(
                            modifier = Modifier,
                            checked = isChecked.value,
                            onCheckedChange = { isChecked.value = it }
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = "Daily Health Tracker", fontSize = 14.sp)
                    Spacer(modifier = Modifier.size(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 14.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Row(
                            modifier = Modifier
                                .padding(vertical = 14.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Show Daily page",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Switch(
                                modifier = Modifier,
                                colors = SwitchDefaults.colors(

                                ),
                                checked = isCheckedtwo.value,
                                onCheckedChange = { isCheckedtwo.value = it }
                            )
                        }
                        Divider(

                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    safeNavController.navigate("DailySettingsSceen")
                                }
                                .padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Daily settings",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "icon",
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(2.dp))
                    Text(
                        text = "Help you track all-around health data (blood pressure, blood sugar,and weight) as you need",
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    Text(text = "First Day of week", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable { }
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Monday", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.size(24.dp))
                    Text(text = "First Day of week", fontSize = 16.sp)
                    Spacer(modifier = Modifier.size(4.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Dark Mood", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Switch(
                            modifier = Modifier,
                            checked = isCheckedthree.value,
                            colors = SwitchDefaults.colors(

                            ),
                            onCheckedChange = { isCheckedthree.value = it }
                        )
                    }
                }
            }
        }
    )


}