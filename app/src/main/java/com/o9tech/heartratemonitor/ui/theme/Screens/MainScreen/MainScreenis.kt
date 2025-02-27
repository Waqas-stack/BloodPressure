package com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.BottomMenu.BottomMenuItems
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.Daily.DailyScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.HealthArticles.HealthArticlesScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Measure.MeasureScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Profile.ProfileScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Tracker.TrackerCategoryScreen
import com.o9tech.heartratemonitor.ui.theme.appbg
import com.o9tech.heartratemonitor.ui.theme.appwhit
import com.o9tech.heartratemonitor.ui.theme.lightgray
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val bottomMenuItems = prepareItem()
    var selectedItem by remember { mutableStateOf(0) }
    val context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }

    LaunchedEffect(Unit) {
        isInternetAvailable.value = checkInternet(context)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DynamicTopAppBar(navController, selectedItem)
        },
        bottomBar = {
            Column(
                modifier = Modifier.background(Color.White),
            ) {

                BottomAppBar(
                    containerColor = lightgray,
                    tonalElevation = 4.dp,


                    ) {
                    bottomMenuItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Red,
                                unselectedIconColor = Color.Gray,
                                selectedTextColor = Color.Red,
                                unselectedTextColor = Color.Gray,
                                indicatorColor = lightgray
                            ),
                            alwaysShowLabel = true,
                            enabled = true,
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
//                    navController.navigate(item.title)
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    color = if (selectedItem == index) Color.Red else Color.Gray
                                )
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.title,
                                    tint = if (selectedItem == index) Color.Red else Color.Gray,
                                    modifier = Modifier.size(24.dp)
                                )
                            })


                    }
                }
//                if (isInternetAvailable.value) {
//                    BannersAds(Modifier.fillMaxWidth())
//                }
            }
        }

    ) { innerpadding ->

        Column(modifier = Modifier.padding(innerpadding)) {
//            BannersAds(Modifier.fillMaxWidth())
            if (isInternetAvailable.value) {
                BannersAds(
                    modifier = Modifier
                        .fillMaxWidth().background(lightgray)
                        .padding(vertical = 10.dp),
                    adSize = AdSize.BANNER
                )
            }

            ContentScree(selectedItem, navController)
        }

    }
}


fun checkInternet(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}


@Composable
fun ContentScree(
    selectedindex: Int,
    navController: NavHostController,
) {
    when (selectedindex) {
        0 -> DailyScreen(navController)
        1 -> MeasureScreen(navController)
//        2 -> TrackerScreen()
        2 -> TrackerCategoryScreen(navController)
//        3 -> InformationScreen(navController)
        3 -> HealthArticlesScreen(navController)
        4 -> ProfileScreen(navController)
    }

}


fun prepareItem(): List<BottomMenuItems> {
    val bottomMenuItems = arrayListOf<BottomMenuItems>()
    bottomMenuItems.add(
        BottomMenuItems(
            "DAILY",
            icon = R.drawable.home,
        )
    )
    bottomMenuItems.add(
        BottomMenuItems(
            "MEASURE",
            icon = R.drawable.search,
        )
    )
    bottomMenuItems.add(
        BottomMenuItems(
            "TRACKER",
            icon = R.drawable.shopping,
        )
    )
    bottomMenuItems.add(
        BottomMenuItems(
            "INFO",
            icon = R.drawable.info,
        )
    )
    bottomMenuItems.add(
        BottomMenuItems(
            "ME",
            icon = R.drawable.person,
        )
    )

    return bottomMenuItems
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(navController: NavHostController, selectedIndex: Int) {
    val titles = listOf("Daily", "Measure", "Tracker", "Info", "Profile")
    TopAppBar(
        modifier = Modifier.padding(horizontal = 6.dp),
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = titles[selectedIndex],
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        actions = {
            if (selectedIndex != 4) { // Hide notification for Profile screen
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color = Color.LightGray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { navController.navigate("ReminderScreen") }) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notification",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = lightgray)
    )
}


@Composable
fun DynamicTopAppBar(navController: NavHostController, selectedItem: Int) {

    Column {
        when (selectedItem) {
            0 -> DailyTopAppBar(navController)
            1 -> MeasureTopAppBar(navController)
            2 -> TrackerTopAppBar(navController)
            3 -> InfoTopAppBar()
            4 -> ProfileTopAppBar()
            else -> {} // Profile (index 4) has no TopAppBar
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyTopAppBar(navController: NavHostController) {
    val (currentDate, currentDay) = remember { com.o9tech.heartratemonitor.ui.theme.Screens.Daily.getCurrentDateAndDay() }
    TopAppBar(

        modifier = Modifier.padding(horizontal = 6.dp),
        actions = {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { navController.navigate("ReminderScreen") }) {
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notification",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "$currentDate ,", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = currentDay, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = lightgray),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeasureTopAppBar(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = {
            Text(
                text = "Measure",
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                fontSize = 22.sp,
                color = appwhit
            )
        },
        actions = {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.volume),
                    contentDescription = "volume",
                    tint = appwhit,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(18.dp))
                Icon(
                    painter = painterResource(id = R.drawable.flash),
                    contentDescription = "flash",
                    tint = appwhit,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = appbg)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackerTopAppBar(navController: NavHostController) {
    Column {
        TopAppBar(
            modifier = Modifier.padding(horizontal = 6.dp),
            title = {
                Text(
                    text = "Tracker",
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            },
            actions = {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.LightGray, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        navController.navigate("ReminderScreen")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notification",
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = lightgray)
        )
        Spacer(modifier = Modifier.height(10.dp))
//        BannersAds(modifier = Modifier.fillMaxWidth(), adSize = AdSize.BANNER)
//        Spacer(modifier = Modifier.height(10.dp))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoTopAppBar() {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 6.dp),
        title = {
            Text(
                text = "Information",
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = lightgray)
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar() {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 6.dp),
        title = {
            Text(
                text = "Profile",
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = lightgray)
    )
}


fun getCurrentDateAndDay(): Pair<String, String> {
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("MMM dd")
    val date = today.format(formatter)
    val day = today.dayOfWeek.getDisplayName(
        java.time.format.TextStyle.FULL,
        Locale.getDefault()
    ) // Full day name
    return Pair(date, day)
}


/*
@Composable
fun BottomBar() {
//    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp.dp
//    val bottomBarHeight = screenHeight * 0.1f
    val bottomMenuItems = prepareItem()
    var selectedItem by remember { mutableStateOf(0) }
    BottomAppBar (
        containerColor = appwhit,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ){

        bottomMenuItems.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                enabled = true,
                selected =selectedItem == index,
                onClick = {
                    selectedItem = index
//                    navController.navigate(item.title)
                },
                label = {
                    Text(text = item.title, modifier = Modifier.padding(4.dp))
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                })
        }
    }

}*/
