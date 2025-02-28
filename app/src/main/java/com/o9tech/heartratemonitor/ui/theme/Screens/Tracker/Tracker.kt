package com.o9tech.heartratemonitor.ui.theme.Screens.Tracker

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.appwhit
import com.o9tech.heartratemonitor.ui.theme.btnbg
import com.o9tech.heartratemonitor.ui.theme.lightgray
import com.o9tech.heartratemonitor.ui.theme.tabbg
import kotlinx.coroutines.launch

import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.Screens.weight.LineChartComposable


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TrackerScreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()

    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Chart", "History")
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState {
        tabTitles.size
    }
    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }


    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.love),
                                contentDescription = "Tracker Icon",
                                tint = Color.Red,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Heart Rate",
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                            )
                        }
                    },
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
                        Surface(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(appwhit),
                            color = Color.Transparent
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 18.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.flash),
                                    contentDescription = "Custom Action",
                                    tint = Color.Black,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "All(12)",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (isInternetAvailable.value) {
                    BannersAds(Modifier.fillMaxWidth())
                }
                Spacer(modifier = Modifier.height(10.dp))
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
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,

                        ) {
                        Column(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
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
                                    modifier = Modifier.padding(bottom = 10.dp, start = 3.dp)
                                ) {
                                    Text(text = "BPM", fontSize = 6.sp)
                                }
                            }
                            Text(text = "Average", fontSize = 14.sp)
                        }
                        Column(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
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
                                    modifier = Modifier.padding(bottom = 10.dp, start = 3.dp)
                                ) {
                                    Text(text = "BPM", fontSize = 6.sp)
                                }
                            }
                            Text(text = "Max", fontSize = 14.sp)
                        }

                        Column(
                            modifier = Modifier.padding(start = 10.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
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
                                    modifier = Modifier.padding(bottom = 10.dp, start = 3.dp)
                                ) {
                                    Text(text = "BPM", fontSize = 6.sp)
                                }
                            }
                            Text(text = "Min", fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.width(30.dp))
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
                        if (!pagerState.isScrollInProgress) {
                            selectedTabIndex = pagerState.currentPage
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        TabRow(
                            selectedTabIndex = selectedTabIndex,
                            containerColor = tabbg,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            indicator = { tabPositions ->
                                Box(
                                    modifier = Modifier
                                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(16.dp))
                                        .then(Modifier.background(Color.White))
                                        .zIndex(-1f)
                                )
                            },
                            divider = {},
//
                        ) {

                            tabTitles.forEachIndexed { index, title ->
                                Tab(
                                    selected = selectedTabIndex == index,
//                                    onClick = { selectedTabIndex = index },
                                    onClick = {
                                        coroutineScope.launch {
                                            pagerState.animateScrollToPage(index)
                                        }
                                    },
                                    text = {
                                        Text(
                                            text = title,
                                            fontSize = 20.sp, fontWeight = FontWeight.ExtraBold,
                                            color = if (selectedTabIndex == index) Color.Black else Color.Gray // Selected text color
                                        )
                                    }

                                )
                            }
                        }
                    }

                    HorizontalPager(
                        state = pagerState, modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    ) {
                        when (it) {
                            0 -> Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState()),
                                horizontalAlignment = Alignment.Start
                            ) {

//                                BarChartWithoutVerticalLines()
                                LineChartComposable()

                                Text(text = "Chart",)
                                Card(
                                    elevation = CardDefaults.cardElevation(1.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(130.dp)
                                        .padding(10.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    Text(
                                        text = "Dec 11,10:37",
                                        fontSize = 9.sp,
                                        modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        horizontalArrangement = Arrangement.Start,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column {
                                            Row (
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Text(
                                                    text = "120",
                                                    fontSize = 36.sp,
                                                    fontWeight = FontWeight.ExtraBold
                                                )
                                                Spacer(modifier = Modifier.width(10.dp))
                                                Column (
                                                    horizontalAlignment = Alignment.Start
                                                ){
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.love),
                                                        contentDescription = "icons",
                                                        tint = Color.Red,
                                                        modifier = Modifier.size(18.dp)
                                                    )
                                                    Text(
                                                        text = "bmp",
//                                                        text = "bmp",
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                            }
                                        }
                                        Spacer(modifier = Modifier.width(30.dp))
                                        Column (
                                            modifier = Modifier.padding(start = 10.dp),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.Start
                                        ){
                                            Row (
                                                verticalAlignment = Alignment.CenterVertically
                                            ){
                                                Box(
                                                    modifier = Modifier
                                                        .size(14.dp)
                                                        .background(
                                                            Color.Green,
                                                            shape = CircleShape
                                                        ) // Set the background color and shape
                                                )
                                                Text(
                                                    text = "Normal",
                                                    modifier = Modifier.padding(horizontal = 5.dp),
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Text(
                                                text = "Sitting | HRV:20ms",
                                                fontSize = 12.sp,
                                            )
                                            Text(
                                                text = "#Wake up",
                                                fontSize = 12.sp,
                                            )
                                        }
                                    }
                                }
                            }

                            1 -> LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.Start
                            ) {
                                items(10) {
                                    Card(
                                        elevation = CardDefaults.cardElevation(1.dp),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(130.dp)
                                            .padding(10.dp),
                                        shape = RoundedCornerShape(10.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color.White)
                                    ) {
                                        Text(
                                            text = "Dec 11,10:37",
                                            fontSize = 9.sp,
                                            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                                        )
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(10.dp),
                                            horizontalArrangement = Arrangement.Start,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column {
                                                Row (
                                                    verticalAlignment = Alignment.CenterVertically
                                                ){
                                                    Text(
                                                        text = "120",
                                                        fontSize = 36.sp,
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
                                                            modifier = Modifier.size(18.dp)
                                                        )
                                                        Text(
                                                            text = "bmp",
//
                                                            fontSize = 12.sp,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    }
                                                }
                                            }
                                            Spacer(modifier = Modifier.width(30.dp))
                                            Column (
                                                modifier = Modifier.padding(start = 10.dp),
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.Start
                                            ){
                                                Row (
                                                    verticalAlignment = Alignment.CenterVertically
                                                ){
                                                    Box(
                                                        modifier = Modifier
                                                            .size(14.dp)
                                                            .background(
                                                                Color.Green,
                                                                shape = CircleShape
                                                            ) // Set the background color and shape
                                                    )
                                                    Text(
                                                        text = "Normal",
                                                        modifier = Modifier.padding(horizontal = 5.dp),
                                                        fontSize = 14.sp,
                                                        fontWeight = FontWeight.Bold
                                                    )
                                                }
                                                Text(
                                                    text = "Sitting | HRV:20ms",
                                                    fontSize = 12.sp,
                                                )
                                                Text(
                                                    text = "#Wake up",
                                                    fontSize = 12.sp,
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = btnbg,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(6.dp),
                        onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Add", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
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
























