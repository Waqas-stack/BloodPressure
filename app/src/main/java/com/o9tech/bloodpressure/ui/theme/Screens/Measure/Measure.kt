package com.o9tech.bloodpressure.ui.theme.Screens.Measure

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.o9tech.bloodpressure.BottomMenu.BottomMenuItems
import com.o9tech.bloodpressure.R
import com.o9tech.bloodpressure.ui.theme.appbg
import com.o9tech.bloodpressure.ui.theme.appwhit
import com.o9tech.bloodpressure.ui.theme.lightgray

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MeasureScreen() {
    val transition = rememberInfiniteTransition()

    // Vertical offset (up and down movement)
    val offsetY by transition.animateFloat(
        initialValue = 0f,
        targetValue = 2f, // Max displacement
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000, // Duration for up and down movement
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse // Reverse to make it oscillate
        )
    )

    // Scale animation for pumping effect
    val scale by transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f, // Heart grows larger
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200, // Duration for scaling (pumping)
//                easing = FastOutSlowInEasing
                easing = CubicBezierEasing(0.25f, 0.8f, 0.25f, 1f) // Smooth easing curve

            ),
            repeatMode = RepeatMode.Reverse // Reverse to make it shrink
        )
    )

    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),

                title = {
                    Text(
                        text = "Measure",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = appwhit,
                        modifier = Modifier.padding(start = 5.dp),
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
                            contentDescription = "volume",
                            modifier = Modifier.size(24.dp),
                    tint = appwhit
                        )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = appbg
                ),
            )
        },
//        bottomBar = {
//            BottomBar()
//        },

        content = {paddingValues ->
           Surface (
               color = appbg,
               modifier = Modifier
                   .fillMaxSize(),
           ){
               ConstraintLayout(
                   modifier = Modifier.fillMaxSize().padding(paddingValues),
               ) {
                   val (measure, heart, detail) = createRefs()

//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp)
//                            .constrainAs(measure) {
//                                top.linkTo(parent.top, margin = 60.dp)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            },
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            text = "Measure",
//                            color = Color.White,
//                            fontSize = 22.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                        Row {
//                            Icon(
//                                painter = painterResource(id = R.drawable.volume),
//                                contentDescription = "volume",
//                                tint = appwhit,
//                                modifier = Modifier.size(24.dp)
//                            )
//                            Spacer(modifier = Modifier.width(18.dp))
//                            Icon(
//                                painter = painterResource(id = R.drawable.flash),
//                                contentDescription = "volume",
//                                modifier = Modifier.size(24.dp),
//                                tint = appwhit
//                            )
//
//                        }
//                    }

                   Box(
                       modifier = Modifier
                           .constrainAs(heart) {

                               top.linkTo(parent.top, margin = 160.dp)
                               start.linkTo(parent.start)
                               end.linkTo(parent.end)
                           }
                           .wrapContentSize() // Size of the heart box (make it large enough for the text to fit)
                           .offset(y = offsetY.dp) // Apply vertical motion
                           .graphicsLayer(scaleX = scale, scaleY = scale) // Apply scaling
                       , // Make background transparent
                       contentAlignment = Alignment.Center // Center the text inside the heart
                   ) {
                       // Heart PNG icon (replace with your heart PNG resource)
                       Image(
                           painter = painterResource(id = R.drawable.love), // Your heart PNG resource
                           contentDescription = "Heart Icon",
                           modifier = Modifier.wrapContentSize()// Fill the box with the heart
                       )

                       // Column with two text elements in the center
                       Column(
                           modifier = Modifier
                               .height(100.dp)
                               .align(Alignment.Center)
                               // Center the text inside the heart
                               .padding(0.dp), // Optional padding for spacing
//                        horizontalAlignment = Alignment.CenterHorizontally // Center text horizontally
                       ) {
                           // First Text in the Column
                           Text(
                               text = "START",
                               color = Color.White,
                               fontSize = 30.sp,
                               fontWeight = FontWeight.ExtraBold,
                               modifier = Modifier.align(Alignment.CenterHorizontally) // Center the first text
                           )
//                        Spacer(modifier = Modifier.height(8.dp)) // Space between the two texts
                           // Second Text in the Column
                           Text(
                               text = "tap to measure",
                               color = Color.White,
                               fontSize = 14.sp,
                               fontWeight = FontWeight.Normal,
                               modifier = Modifier.align(Alignment.CenterHorizontally) // Center the second text
                           )
                       }
//                Text(text = "waqas",color = Color.Blue)
                   }

                   Column(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(20.dp)
                           .constrainAs(detail) {
                               top.linkTo(heart.bottom, margin = 120.dp)
                               start.linkTo(parent.start)
                               end.linkTo(parent.end)
                           }
                   ) {
                       Text(
                           text = "Last Measurement",
                           color = appwhit,
                           fontSize = 20.sp,
                           fontWeight = FontWeight.Bold
                       )
                       Spacer(modifier = Modifier.height(3.dp))
                       Row (
                           modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.SpaceBetween,
                           verticalAlignment = Alignment.CenterVertically
                       ){


                           Row (
//                        modifier = Modifier.background(color = Color.Green)
                               verticalAlignment = Alignment.CenterVertically
                           ){
                               Text(
                                   text = "120",
                                   color = appwhit,
                                   fontSize = 50.sp,
                                   fontWeight = FontWeight.ExtraBold
                               )
                               Spacer(modifier = Modifier.width(10.dp))
                               Column (
                                   horizontalAlignment = Alignment.Start
                               ){
                                   Icon(
                                       painter = painterResource(id = R.drawable.love),
                                       contentDescription = "",
                                       tint = Color.Red,
                                       modifier = Modifier.size(24.dp)
                                   )
                                   Text(
                                       text = "BMP",
                                       color = appwhit,
                                       fontSize = 20.sp,
                                       fontWeight = FontWeight.Bold
                                   )
                               }
                           }
                           Column (
//                        modifier = Modifier.background(color = Color.Green),
                               horizontalAlignment = Alignment.End
                           ){
                               Text(text = "2024,Dec 5",color = lightgray)
                               Text(text = "0:19",color = lightgray)
                           }
                       }
                   }
               }
           }
        }
    )


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



















































//
//@Composable
//fun HeartWithTextAndAnimation() {
//    // Infinite transition for continuous animation
//    val transition = rememberInfiniteTransition()
//
//    // Vertical offset (up and down movement)
//    val offsetY by transition.animateFloat(
//        initialValue = 0f,
//        targetValue = 20f, // Max displacement
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 500, // Duration for up and down movement
//                easing = FastOutSlowInEasing
//            ),
//            repeatMode = RepeatMode.Reverse // Reverse to make it oscillate
//        )
//    )
//
//    // Scale animation for pumping effect
//    val scale by transition.animateFloat(
//        initialValue = 1f,
//        targetValue = 1.5f, // Heart grows larger
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 500, // Duration for scaling (pumping)
//                easing = FastOutSlowInEasing
//            ),
//            repeatMode = RepeatMode.Reverse // Reverse to make it shrink
//        )
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .wrapContentSize(Alignment.Center)
//    ) {
//        // Heart Icon with Text
//        Box(
//            modifier = Modifier
//                .size(150.dp) // Size of the heart box
//                .offset(y = offsetY.dp) // Apply vertical motion
//                .graphicsLayer(scaleX = scale, scaleY = scale) // Apply scaling
//                .background(Color.Transparent, shape = CircleShape), // Make background transparent
//            contentAlignment = Alignment.Center // Text inside the heart
//        ) {
//            // Heart PNG icon (replace with your heart PNG resource)
//            Image(
//                painter = painterResource(id = R.drawable.love), // Your heart PNG resource
//                contentDescription = "Heart Icon",
//                modifier = Modifier.fillMaxSize() // Fill the box with the heart
//            )
//
//            // Text inside the heart
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "START",
//                    color = Color.White, // Text color
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
////                   modifier = Modifier.align(Alignment.Center) // Center the text
//                )
//                Text(
//                    text = "tap to measure",
//                    color = Color.White, // Text color
//                    fontSize = 14.sp,
//                    fontWeight = FontWeight.Bold,
////                   modifier = Modifier.align(Alignment.Center) // Center the text
//                )
//            }
//            Spacer(modifier = Modifier.height(26.dp))
//        }
//    }
//}

//
//@Composable
//fun PumpingHeartWithText() {
//    // Infinite transition for continuous animation
//    val transition = rememberInfiniteTransition()
//
//    // Vertical offset (up and down movement)
//    val offsetY by transition.animateFloat(
//        initialValue = 0f,
//        targetValue = 20f, // Max displacement
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 500, // Duration for up and down movement
//                easing = FastOutSlowInEasing
//            ),
//            repeatMode = RepeatMode.Reverse // Reverse to make it oscillate
//        )
//    )
//
//    // Scale animation for pumping effect
//    val scale by transition.animateFloat(
//        initialValue = 1f,
//        targetValue = 1.5f, // Heart grows larger
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 500, // Duration for scaling (pumping)
//                easing = FastOutSlowInEasing
//            ),
//            repeatMode = RepeatMode.Reverse // Reverse to make it shrink
//        )
//    )
//
//    Box(
//        modifier = Modifier
//            .wrapContentSize()
//            .wrapContentSize(Alignment.Center)
//    ) {
//        // Heart Icon with Text
//        Box(
//            modifier = Modifier
//                .size(200.dp) // Size of the heart box (make it large enough for the text to fit)
//                .offset(y = offsetY.dp) // Apply vertical motion
//                .graphicsLayer(scaleX = scale, scaleY = scale) // Apply scaling
//                .background(Color.Transparent, shape = CircleShape), // Make background transparent
//            contentAlignment = Alignment.Center // Center the text inside the heart
//        ) {
//            // Heart PNG icon (replace with your heart PNG resource)
//            Image(
//                painter = painterResource(id = R.drawable.love), // Your heart PNG resource
//                contentDescription = "Heart Icon",
//                modifier = Modifier.fillMaxSize() // Fill the box with the heart
//            )
//
//            // Column with two text elements in the center
//            Column(
//                modifier = Modifier
//                    .align(Alignment.Center) // Center the text inside the heart
//                    .padding(10.dp), // Optional padding for spacing
//                horizontalAlignment = Alignment.CenterHorizontally // Center text horizontally
//            ) {
//                // First Text in the Column
//                Text(
//                    text = "START",
//                    color = Color.White,
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center the first text
//                )
//                Spacer(modifier = Modifier.height(8.dp)) // Space between the two texts
//                // Second Text in the Column
//                Text(
//                    text = "tap to measure",
//                    color = Color.White,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Normal,
//                    modifier = Modifier.align(Alignment.CenterHorizontally) // Center the second text
//                )
//            }
//        }
//    }
//}
