package com.o9tech.heartratemonitor.ui.theme.Screens.weight

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.mahmoud.composecharts.linechart.LineChartEntity
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.btnbg
import com.o9tech.heartratemonitor.ui.theme.lightgray




@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun weightScreen(){

    val lineChartData = listOf(
        LineChartEntity(0.0f, "Sun"),
        LineChartEntity(50.0f, "Mon"),
        LineChartEntity(60.0f, "Tue"),
        LineChartEntity(70.0f, "wed"),
        LineChartEntity(80.0f, "Thu"),
        LineChartEntity(30.0f, "Fri"),
        LineChartEntity(10.0f, "Sat"),
    )
    val verticalAxisValues = listOf(50.0f, 60.0f, 70.0f, 80.0f)
    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),
                navigationIcon = {

                    IconButton(onClick = {
//                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "ArrowBack",
                            modifier = Modifier.padding(start = 10.dp),
                        )
                    }

                },
                actions = {
                    TextButton(onClick = { /*TODO*/ }) {
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
                        text = "weight",
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
                                Text(text = "weight",fontSize = 20.sp,fontWeight = FontWeight.Bold,color = Color.Gray)
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
                                                text = "kg",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.W600
                                            )

                                            Box(
                                                modifier = Modifier
                                                    .background(
                                                        color = Color.Green,
                                                        shape = RoundedCornerShape(4.dp)
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
                                    Text(text = "Nutrition 101",fontSize = 22.sp,fontWeight = FontWeight.Bold,color = Color.Black)
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
                        onClick = { /*TODO*/ }) {
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





@Composable
fun LineChartComposable() {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
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