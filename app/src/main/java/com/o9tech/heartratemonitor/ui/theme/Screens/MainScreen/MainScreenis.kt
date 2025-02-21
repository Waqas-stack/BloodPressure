package com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.o9tech.heartratemonitor.BottomMenu.BottomMenuItems
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.Daily.DailyScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.HealthArticles.HealthArticlesScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Measure.MeasureScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Profile.ProfileScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Tracker.TrackerCategoryScreen
import com.o9tech.heartratemonitor.ui.theme.appwhit


@Composable
fun MainScreen(navController: NavHostController) {
    val bottomMenuItems = prepareItem()
    var selectedItem by remember { mutableStateOf(0) }
    val context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }

    LaunchedEffect(Unit) {
        isInternetAvailable.value = checkInternet(context)
    }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Column {
                BottomAppBar (
                    containerColor = appwhit,
                    modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    tonalElevation = 4.dp,

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
                                Text(text = item.title, )
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.title,
                                    modifier = Modifier.size(20.dp)
                                )
                            })

                    }
                }
                if (isInternetAvailable.value) {
                    BannersAds(Modifier.fillMaxWidth())
                }
            }
        }

    ){innerpadding->

        ContentScree(modifier = Modifier.padding(innerpadding), selectedItem,navController)

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
    modifier: Modifier = Modifier,
    selectedindex: Int,
    navController: NavHostController
){
    when(selectedindex){
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

}