package com.o9tech.heartratemonitor.ui.theme.Screens.StressLevel

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdSize
import com.mahmoud.composecharts.linechart.LineChartEntity
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.Screens.weight.LineChartComposable
import com.o9tech.heartratemonitor.ui.theme.btnbg
import com.o9tech.heartratemonitor.ui.theme.lightgray



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun StressLevelSreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()


//    val lineChartData = listOf(
//        LineChartEntity(0.0f, "Sun"),
//        LineChartEntity(50.0f, "Mon"),
//        LineChartEntity(60.0f, "Tue"),
//        LineChartEntity(70.0f, "wed"),
//        LineChartEntity(80.0f, "Thu"),
//        LineChartEntity(30.0f, "Fri"),
//        LineChartEntity(10.0f, "Sat"),
//    )
//    val verticalAxisValues = listOf(50.0f, 60.0f, 70.0f, 80.0f)
    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }
    Scaffold (
        topBar = {
            Column {
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
                    actions = {
                        TextButton(onClick = {

                        }) {
                            Text(
                                text = "View all",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(end = 10.dp),
                            )
                        }
                    },

                    title = {
                        Text(
                            text = "Stress Level",
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
                    BannersAds(modifier = Modifier.fillMaxWidth().background(lightgray), adSize =  AdSize.BANNER)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Box(modifier = Modifier.fillMaxSize()){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .background(color = lightgray)
                    ) {

                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            elevation = CardDefaults.cardElevation(5.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ){
                            Column (
                                modifier = Modifier.padding(10.dp)
                            ){
                                Text(text = "Stress",fontSize = 20.sp,fontWeight = FontWeight.Bold,color = Color.Gray)
//                          LineChart(
//                              lineChartData = lineChartData,
//                              verticalAxisValues = verticalAxisValues
//                          )
                                Spacer(modifier = Modifier.height(16.dp))

                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.Bottom
                                ) {
                                    Text(
                                        text = "80",
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        modifier = Modifier
                                            .width(120.dp)
                                            .padding(bottom = 0.dp, start = 3.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier,
                                            horizontalArrangement = Arrangement.spacedBy(12.dp),
//                                    verticalAlignment = Alignment.CenterVertically
                                        ) {

                                            Text(
                                                text = "%",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.W600
                                            )

                                            Box(
                                                modifier = Modifier
                                                    .background(
                                                        color = Color.Blue,
                                                        shape = RoundedCornerShape(4.dp)
                                                    )
                                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                                            ) {
                                                Text(text = "Moderate", fontSize = 14.sp, color = Color.White)
                                            }

//                                    Text(text = "ms", fontSize = 16.sp)
                                        }

                                    }

                                }
                                LineChartComposable()
                                Text(text = "Sorry we dont have data to check your blood pressure " +
                                        "please add reordds at leats todays to genrate your weekly health",
                                    modifier = Modifier.padding(horizontal = 14.dp,),
                                )

                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            elevation = CardDefaults.cardElevation(5.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)){
                            Column (
                                modifier = Modifier.padding(10.dp)
                            ){
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(text = "How to reduce Stress",fontSize = 22.sp,fontWeight = FontWeight.Bold,color = Color.Black)
                                    Image(painter = painterResource(id = R.drawable.love),
                                        contentDescription ="",
                                        modifier = Modifier.size(40.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "Sorry we dont have data to check your blood pressure " +
                                        "please add reordds at leats todays to genrate your weekly health",
                                    modifier = Modifier.padding(horizontal = 14.dp,),
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "Macronutrition",fontSize = 16.sp,fontWeight = FontWeight.Bold,color = Color.Black)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Sorry we dont have data to check your blood pressure " +
                                        "please add reordds at leats todays to genrate your weekly health",
                                    modifier = Modifier.padding(horizontal = 14.dp,),
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "1. Carbohydrates",fontSize = 16.sp,fontWeight = FontWeight.Bold,color = Color.Black)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Sorry we dont have data to check your blood pressure " + "please add reordds at leats todays to genrate your weekly health"  + " please add reordds at leats todays to genrate your weekly health",
                                    modifier = Modifier.padding(horizontal = 14.dp,),
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "2. Proteiens",fontSize = 16.sp,fontWeight = FontWeight.Bold,color = Color.Black)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Sorry we dont have data to check your blood pressure " + "please add reordds at leats todays to genrate your weekly health"  + " please add reordds at leats todays to genrate your weekly health",
                                    modifier = Modifier.padding(horizontal = 14.dp,),
                                )
                            }
                        }

                    }
                    Button(
                        modifier = Modifier
                            .width(300.dp)
                            .align(Alignment.BottomCenter)
                            .padding(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = btnbg,
                            contentColor = Color.White
                        ),
//                            shape = RoundedCornerShape(6.dp),
                        onClick = {
                            safeNavController.navigate("HeartRateMonitorScreen")
                        }) {
//                            Icon(imageVector = Icons.Default.Add, contentDescription = "")
                        Spacer(modifier = Modifier.width(8.dp))
//                        IconButton(onClick = { /*TODO*/ }) {
//                            Icon(imageVector = Icons.Default.Add, contentDescription = "add")
//                        }
                        Icon(painter = painterResource(id = R.drawable.fingerscanner),
                            contentDescription = "add",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "Measure Now",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
        }
    )
}