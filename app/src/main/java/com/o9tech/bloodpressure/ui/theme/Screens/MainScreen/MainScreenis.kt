package com.o9tech.bloodpressure.ui.theme.Screens.MainScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.o9tech.bloodpressure.BottomMenu.BottomMenuItems
import com.o9tech.bloodpressure.R
import com.o9tech.bloodpressure.ui.theme.Screens.Daily.DailyScreen
import com.o9tech.bloodpressure.ui.theme.Screens.HealthArticles.HealthArticlesScreen
import com.o9tech.bloodpressure.ui.theme.Screens.Measure.MeasureScreen
import com.o9tech.bloodpressure.ui.theme.Screens.Profile.ProfileScreen
import com.o9tech.bloodpressure.ui.theme.Screens.Tracker.TrackerCategoryScreen
import com.o9tech.bloodpressure.ui.theme.appwhit


@Composable
fun MainScreen(navController: NavHostController) {
    val bottomMenuItems = prepareItem()
    var selectedItem by remember { mutableStateOf(0) }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
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

    ){innerpadding->

        ContentScree(modifier = Modifier.padding(innerpadding), selectedItem,navController)
    }
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