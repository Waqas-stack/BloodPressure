package com.o9tech.bloodpressure.ui.theme.Screens.Daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.o9tech.bloodpressure.R
import com.o9tech.bloodpressure.ui.theme.btnbg
import com.o9tech.bloodpressure.ui.theme.lightgray


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DailyScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),
                actions = {
                    Box(
                        modifier = Modifier
                            .size(40.dp) // Circle size
                            .background(
                                color = Color.LightGray,
                                shape = CircleShape
                            ), // Light gray background with circle shape
                        contentAlignment = Alignment.Center // Center the icon inside the circle
                    ) {
                        IconButton(onClick = {
                            navController.navigate("ReminderScreen")
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications, // Notification icon
                                contentDescription = "Notification",
                                tint = Color.Black, // Icon color
                                modifier = Modifier.size(24.dp) // Icon size
                            )
                        }
                    }
                },

                title = {
                    Text(
                        text = "",
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
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Text(text = "Dec 12", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                    Text(text = "Thursday", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 14.dp, vertical = 14.dp),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Column {
                                Text(
                                    text = "Heart Health",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Spacer(modifier = Modifier.size(2.dp))
                                Text(text = "last record:Yesterday", fontSize = 12.sp)
                            }
                            Image(
                                painter = painterResource(id = R.drawable.love),
                                contentDescription = "love",
                                modifier = Modifier.size(40.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,

                            ) {
                            Column(
//                                modifier = Modifier.padding(start = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
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
                                        verticalArrangement = Arrangement.Bottom,
                                        modifier = Modifier.padding(bottom = 4.dp, start = 3.dp)
                                    ) {
                                        Text(text = "ms", fontSize = 16.sp)
                                    }
                                }
                                Text(text = "HRV", fontSize = 14.sp)
                            }
                            Divider(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(50.dp),
                                color = Color.Gray
                            )
                            Column(
//                                modifier = Modifier.padding(start = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.Bottom
                                ) {
                                    Text(
                                        text = "180",
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        modifier = Modifier.padding(bottom = 4.dp, start = 3.dp)
                                    ) {
                                        Text(
                                            text = "bpm",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.W600
                                        )
                                    }
                                }
                                Text(text = "pluse", fontSize = 14.sp)
                            }
                            Divider(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(50.dp),
                                color = Color.Gray
                            )
                            Column(
//                                modifier = Modifier.padding(start = 10.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier,
                                    verticalAlignment = Alignment.Bottom
                                ) {
                                    Text(
                                        text = "50",
                                        fontSize = 30.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        modifier = Modifier.padding(bottom = 0.dp, start = 3.dp)
                                    ) {
                                        Text(text = "%", fontSize = 16.sp)
                                    }
                                }
                                Text(text = "Stress level", fontSize = 14.sp)
                            }
                            Spacer(modifier = Modifier.width(30.dp))
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btnbg,
                                contentColor = Color.White
                            ),
//                            shape = RoundedCornerShape(6.dp),
                            onClick = { /*TODO*/ }) {
//                            Icon(imageVector = Icons.Default.Add, contentDescription = "")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Measure Now",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(22.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(204.dp),
                    ) {

                        Column(
                            modifier = Modifier
                                .width(160.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .padding(horizontal = 14.dp, vertical = 14.dp),
                            verticalArrangement = Arrangement.SpaceBetween,

                            ) {
                            Text(
                                text = "Blood\nPressure",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Image(
                                painter = painterResource(id = R.drawable.love),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(66.dp)
                                    .align(Alignment.End)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            verticalArrangement = Arrangement.SpaceBetween,

                            ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color.White)
                                    .padding(horizontal = 14.dp, vertical = 14.dp),
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Row(
//                                        modifier = Modifier.background(color = Color.Red)
                                    ) {
                                        Text(
                                            text = "Blood Sugar",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.W600
                                        )
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.love),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(66.dp)
                                            .align(Alignment.End)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(color = Color.White)
                                    .padding(horizontal = 14.dp, vertical = 14.dp),
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    Row(
//                                        modifier = Modifier.background(color = Color.Red)
                                    ) {
                                        Text(
                                            text = "Weight & BMI",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.W600
                                        )
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.love),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(66.dp)
                                            .align(Alignment.End)
                                    )
                                }
                            }
                        }

                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.LightGray)
                            .padding(horizontal = 14.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Feel free to ask me",fontWeight = FontWeight.Bold,fontSize = 14.sp)
                            Text(text = "anything about health",fontWeight = FontWeight.Bold,fontSize = 14.sp)
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = btnbg,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier.width(180.dp),
                                onClick = { /*TODO*/ }) {
                                Text(text = "Consult")
                            }
                        }
                        Image(
                            painter = painterResource(id = R.drawable.love),
                            contentDescription = "consultent"
                        )
                    }
                    Spacer(modifier = Modifier.height(28.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "My Weekly stats",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(text = "Dec-8-Dec 14")
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .padding(horizontal = 14.dp, vertical = 14.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Resting Heart Rate",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = ""
                            )
                        }
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
                                        text = "bpm",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W600
                                    )

                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = Color.Green,
                                                shape = RoundedCornerShape(12.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 2.dp)
                                    ) {
                                        Text(text = "Normal", fontSize = 14.sp, color = Color.Black)
                                    }

//                                    Text(text = "ms", fontSize = 16.sp)
                                }

                            }

                        }

                        LineChartComposable()
//                        BarChartWithoutVerticalLines()

                        Text(text = "Sorry we dont have data to check your blood pressure " +
                                "please add reordds at leats todays to genrate your weekly health",
                            modifier = Modifier.padding(horizontal = 14.dp,),
                        )
//
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .padding(horizontal = 14.dp, vertical = 14.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Stress Level",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = ""
                            )
                        }
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Text(
                                text = "54",
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
                                                color = Color.Green,
                                                shape = RoundedCornerShape(12.dp)
                                            )
                                            .padding(horizontal = 8.dp, vertical = 2.dp)
                                    ) {
                                        Text(text = "Moderate", fontSize = 14.sp, color = Color.Black)
                                    }

//                                    Text(text = "ms", fontSize = 16.sp)
                                }

                            }

                        }
                        LineChartComposable()

//                        BarChartWithoutVerticalLines()

                        Text(text = "Sorry we dont have data to check your blood pressure " +
                                "please add reordds at leats todays to genrate your weekly health",
                            modifier = Modifier.padding(horizontal = 14.dp,),
                        )
//
                    }
                    Spacer(modifier = Modifier.height(60.dp))
//                    TabRowWithHorizontalPager()
//                    Spacer(modifier = Modifier.height(1200.dp))
                }
            }
        }
    )
}

















@Composable
fun BarChartWithoutVerticalLines() {
    val entries = listOf(
        BarEntry(0f, 5f),
        BarEntry(1f, 10f),
        BarEntry(2f, 15f),
        BarEntry(3f, 20f)
    )

    val dataSet = BarDataSet(entries, "").apply {


//        color = Color.CYAN
//        valueTextColor = Color.BLACK
        valueTextSize = 12f
    }

    val barData = BarData(dataSet)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp) // Adjust height as per your requirement
    ) {
        AndroidView(factory = { context ->
            BarChart(context).apply {
                data = barData
//                description.text = "Bar Chart Example"
//                description.textColor = Color.BLACK
                description.textSize = 12f
                setFitBars(true) // Make bars fit nicely within the chart
                animateY(1500)

                // Remove vertical grid lines
                xAxis.apply {
                    setDrawGridLines(false)
                    position = XAxis.XAxisPosition.BOTTOM // Set labels to bottom
                }

                // Remove right axis
                axisRight.isEnabled = false

                // Optionally customize left axis
                axisLeft.apply {
                    setDrawGridLines(true) // Keep horizontal grid lines
                }
            }
        }, modifier = Modifier.fillMaxSize())
    }
}











@Composable
fun LineChartComposable() {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        factory = { context ->
            LineChart(context).apply {
                // Configure chart appearance
                setDrawGridBackground(false)
                description.isEnabled = false
                legend.isEnabled = true
                setTouchEnabled(false)
                isDragEnabled = false
                setScaleEnabled(false)
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.setDrawGridLines(false)
                axisRight.isEnabled = false
                axisLeft.setDrawGridLines(true)

//                axisLeft.apply {
//                    setDrawAxisLine(false) // Disable Y-axis line (Left)
//                    setDrawGridLines(false) // Disable horizontal grid lines
//                }

                // Configure Y-axis (Right)
                axisRight.apply {
                    setDrawAxisLine(false) // Disable Y-axis line (Right)
                    isEnabled = false // Disable the entire right Y-axis if needed
                }

                // Configure X-axis
                xAxis.apply {
                    setDrawAxisLine(false) // Disable X-axis line
                    setDrawGridLines(false) // Disable vertical grid lines
                }

            }
        },
        update = { chart ->
            // Set data for the chart
            val entries = listOf(
                Entry(0f, 1f),
                Entry(1f, 2f),
                Entry(2f, 3f),
                Entry(3f, 2f),
                Entry(4f, 5f)
            )
            val dataSet = LineDataSet(entries, "Normal").apply {
                color = android.graphics.Color.RED
                valueTextColor = android.graphics.Color.BLACK
                lineWidth = 2f
                circleRadius = 4f
                setCircleColor(android.graphics.Color.RED)
                mode = LineDataSet.Mode.CUBIC_BEZIER
            }
            chart.data = LineData(dataSet)
            chart.invalidate() // Refresh the chart
        }
    )
}
