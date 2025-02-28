package com.o9tech.heartratemonitor.ui.theme.Screens.HealthArticles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.o9tech.heartratemonitor.ui.theme.lightgray
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.o9tech.heartratemonitor.R
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.DataModel.RecipesModel.RecipesDataModel
import com.o9tech.heartratemonitor.DataModel.RecipesModel.RecipesDataModelDataset
import com.o9tech.heartratemonitor.DataModel.healthArticles.HealthArticlesDataModel
import com.o9tech.heartratemonitor.DataModel.healthArticles.HealthArticlesDataSet
import com.o9tech.heartratemonitor.DataModel.sleepModel.SleepModelDataSet
import com.o9tech.heartratemonitor.DataModel.sleepModel.sleepDataModels
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HealthArticlesScreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()



    Scaffold (
//        topBar = {
//            Column {
//                TopAppBar(
//                    modifier = Modifier.padding(horizontal = 6.dp),
//
//                    title = {
//                        Text(
//                            text = "Info",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 22.sp,
//                            modifier = Modifier.padding(start = 5.dp),
//                        )
//                    },
//                    colors = TopAppBarDefaults.topAppBarColors(
//                        containerColor = lightgray
//                    ),
//                )
//                BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)
//                Spacer(modifier = Modifier.height(10.dp))
//            }
//        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp),
                ) {
                    
                   Row (
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically
                   ){
                       Text(text = "Health Articles", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                       TextButton(onClick = {
                           safeNavController.navigate("InformationScreen")
                       }) {
                           Text(text = "More", fontWeight = FontWeight.W400, fontSize = 12.sp)
                       }
                   }
                    LazyRow(
//                        modifier = Modifier.padding(top = 3.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {

                        val feature: List<HealthArticlesDataModel> = HealthArticlesDataSet.SetHeartRate()


                        items(feature) { fetal ->
//                            Column(
//                                modifier = Modifier
//                                    .width(150.dp)
//                                    .height(130.dp)
//                                    .clickable { }
//                                    .padding(horizontal = 10.dp, vertical = 10.dp)
//                            ) {
//                                // Background Image inside Box for layering
//                                Box(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .clip(RoundedCornerShape(10.dp))
//                                ) {
//                                    Image(
//                                        painter = painterResource(id = fetal.image),
//                                        contentDescription = "",
//                                        contentScale = ContentScale.Crop, // Makes image cover the entire box
//                                        modifier = Modifier.fillMaxSize()
//                                    )
//
//                                    // Foreground Content on Top of Image
//                                    Column(
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                            .padding(10.dp),
//                                        horizontalAlignment = Alignment.CenterHorizontally,
//                                        verticalArrangement = Arrangement.Center
//                                    ) {
//                                        Text(
//                                            text = fetal.title,
//                                            fontWeight = FontWeight.Bold,
//                                            color = Color.White // Make sure text is visible on the image
//                                        )
//                                        Text(
//                                            text = "6 Insights",
//                                            fontWeight = FontWeight.W400,
//                                            color = Color.White
//                                        )
//                                    }
//                                }
//                            }
//                            Column(
//                                modifier = Modifier
//                                    .width(150.dp)
//                                    .height(130.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                                    .background(Color.White)
//                                    .clickable {
//                                    }
//                                    .padding(horizontal = 10.dp, vertical = 10.dp),
////                                horizontalAlignment = Alignment.CenterHorizontally,
////                                verticalArrangement = Arrangement.SpaceBetween
//
//                            ) {
//
//                                Image(
//                                    painter = painterResource(id = fetal.image),
//                                    contentDescription = "",
//                                    modifier = Modifier.size(50.dp).align(Alignment.CenterHorizontally)
//                                )
//                                Text(text = fetal.title,fontWeight = FontWeight.Bold)
//                                Text(text ="6 Insights",fontWeight = FontWeight.W400)
////
//                            }

                            Box(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(130.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color.Black.copy(alpha = 0.7f))
                                    .clickable {
                                        safeNavController.navigate("InformationScreen")
//                                        navController.navigate("camerapermission")
//                                        navController.navigate("HeartRateMonitorScreen")
//                                        navController.navigate("FingerScanScreen")
//                                        navController.navigate("BloodPressureScreen")
                                    }
                            ) {
                                // Background Image
                                Image(
                                    painter = painterResource(id = fetal.image),
                                    contentDescription = "Background Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )

                                // Foreground Content (Text)
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 10.dp, vertical = 10.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Bottom
                                ) {
                                    Text(
                                        text = fetal.title,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White, // Ensure text is visible over the image
                                        fontSize = 16.sp
                                    )
                                    Text(
                                        text = "6 Insights",
//                                        fontWeight = FontWeight.W400,
                                        fontSize = 12.sp,
                                        color = Color.White // Make this text visible too
                                    )
                                }
                            }
                        }
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Better Sleep", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        TextButton(onClick = {
                            safeNavController.navigate("BetterSleepScreen")
                        }) {
                            Text(text = "More", fontWeight = FontWeight.W400, fontSize = 12.sp)
                        }
                    }

                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp,bottom = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {

                        val feature: List<sleepDataModels> = SleepModelDataSet.SetHeartRate()


                        items(feature) { fetal ->
                            CDView(fetal)
                        }
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Recipes", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        TextButton(onClick = {
                            safeNavController.navigate("RecipeCategory")
                        }) {
                            Text(text = "More", fontWeight = FontWeight.W400, fontSize = 12.sp)
                        }
                    }

                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {

                        val featurere: List<RecipesDataModel> = RecipesDataModelDataset.SetHeartRate()


                        items(featurere.size) { fetal ->
                            Box(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color.Black.copy(alpha = 0.3f))
                                    .clickable {
                                        safeNavController.navigate("details/${featurere[fetal].id}")
                                    }
                            ) {
                                // Background Image
                                Image(
                                    painter = painterResource(id = featurere[fetal].image),
                                    contentDescription = "Background Image",
                                    contentScale = ContentScale.Crop, // Ensures image covers the entire box
                                    modifier = Modifier.fillMaxSize()
                                )

                                // Foreground Content (Text)
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 10.dp, vertical = 10.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Spacer(modifier = Modifier.height(10.dp)) // Optional spacing

                                    Text(
                                        text = featurere[fetal].title,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White, // Ensures the text is visible on the background
                                        fontSize = 18.sp
                                    )
                                }
                            }
//                            Column(
//                                modifier = Modifier
//                                    .width(150.dp)
//                                    .height(200.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                                    .background(Color.White)
//                                    .clickable {
////                                        navController.currentBackStackEntry?.savedStateHandle?.set("fetal", fetal)
////                                        Log.d("NavDebug", "Saving fetal data: $fetal")
////                                        navController.navigate(Routesa.DetailsInformationSceen)
////                                        navController.navigate(
////                                            Routesa.DetailsInformationSceen + "/${fetal.id}/${fetal.image}/${fetal.title}"
////                                        )
////                                        navController.navigate(Routesa.DetailsInformationSceen+"/${fetal}")
//                                    }
//                                    .padding(horizontal = 10.dp, vertical = 10.dp),
//                                horizontalAlignment = Alignment.CenterHorizontally,
//                                verticalArrangement = Arrangement.SpaceBetween
//
//                            ) {
//
//                                Image(
//                                    painter = painterResource(id = fetal.image),
//                                    contentDescription = "",
//                                    modifier = Modifier.size(50.dp)
//                                )
//                                Text(text = fetal.title,fontWeight = FontWeight.Bold)
////
//                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    )
}







@Composable
fun CdDisk(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(100.dp) // CD Size
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2

            // Outer CD Circle
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.LightGray, Color.White, Color.Gray),
                    center = center,
                    radius = radius
                ),
                radius = radius,
                center = center
            )

            // Inner Ring (Reflective like a CD)
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Transparent, Color(0xFFB0BEC5)),
                    center = center,
                    radius = radius * 0.7f
                ),
                radius = radius * 0.7f,
                center = center,
                style = Stroke(width = 15f) // Thickness of the inner ring
            )

            // CD Hole (Center Circle)
            drawCircle(
                color = Color.White,
                radius = radius * 0.15f,
                center = center
            )
        }
    }
}

@Composable
fun CDLikeDisk() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.love ), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop
        )

        // Outer Black Circle
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            // Inner White Circle
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            )
        }
    }
}



@Composable
fun CDView(fetal: sleepDataModels) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        // CD Design (Circles with Background Image)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Black)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = fetal.image),
                contentDescription = "CD Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Outer Inner Circle (Black)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(30.dp) // Outer inner circle size
                    .clip(CircleShape)
                    .background(Color.Black)
            ) {
                // Center Circle (White)
                Box(
                    modifier = Modifier
                        .size(15.dp) // Center circle size
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp)) // Add spacing between the CD and the title

        // Title Text at the Bottom
        Text(
            text = fetal.title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}


//@Composable
//fun CDView(fetal: sleepDataModels) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Transparent)
//    ) {
//        // Outer Circle with Background Image
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(CircleShape)
//                .background(Color.Black)
//        ) {
//            Image(
//                painter = painterResource(id = fetal.image), // Add your image here
//                contentDescription = "CD Background",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//
//        // Outer Inner Circle (Black)
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(30.dp) // Outer inner circle size
//                .clip(CircleShape)
//                .background(Color.Black)
//        ) {
//            // Center Circle (White)
//            Box(
//                modifier = Modifier
//                    .size(15.dp) // Center circle size
//                    .clip(CircleShape)
//                    .background(Color.White)
//            )
//        }
//    }
//}



//@Composable
//fun CDView() {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Transparent)
//    ) {
//        // Outer Circle with Background Image
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(CircleShape)
//                .background(Color.Black)
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_background), // Add your image here
//                contentDescription = "CD Background",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//
//        // Inner White Circle
//        Box(
//            modifier = Modifier
//                .size(20.dp)
//                .clip(CircleShape)
//                .background(Color.White)
//        )
//    }
//}



//
//@Preview(showBackground = true)
//@Composable
//fun CdDiskPreview() {
//    CdDisk()
//}
