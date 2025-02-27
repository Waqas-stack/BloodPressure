package com.o9tech.heartratemonitor.ui.theme.Screens.bettersleep

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.o9tech.heartratemonitor.ui.theme.lightgray



//@Preview(showBackground = true)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BetterSleepScreen(){
//    Scaffold (
//        topBar = {
//            TopAppBar(
//                modifier = Modifier.padding(horizontal = 6.dp),
//
//                title = {
//                    Text(
//                        text = "Better Sleep",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp,
//                        modifier = Modifier.padding(start = 5.dp),
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
////                        navController.popBackStack()
//                    }) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowBack,
//                            contentDescription = "ArrowBack",
//                            modifier = Modifier.padding(start = 10.dp),
//                        )
//                    }
//
//
//
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = lightgray
//                ),
//            )
//        },
//        content = {
//            Surface(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(it),
//
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(10.dp)
//                ) {
//                    Text(text = "Meditation")
//
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .padding(8.dp),
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(4) { index ->
//                            CDCard(title = "CD Title $index", imageRes = R.drawable.ic_launcher_background)
//                        }
//                    }
//                    Text(text = "Nature")
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .padding(8.dp),
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(4) { index ->
//                            CDCard(title = "CD Title $index", imageRes = R.drawable.ic_launcher_background)
//                        }
//                    }
//                }
//
//
//
//            }
//        }
//    )
//}
//
//
//
//@Composable
//fun CDCard(title: String, imageRes: Int) {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 4.dp
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(200.dp)
//            .padding(8.dp),
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // CD Disk
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(CircleShape)
//                    .background(Color.Black)
//            ) {
//                Image(
//                    painter = painterResource(id = imageRes),
//                    contentDescription = "CD Disk",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                Box(
//                    modifier = Modifier
//                        .size(30.dp)
//                        .clip(CircleShape)
//                        .background(Color.Black),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(15.dp)
//                            .clip(CircleShape)
//                            .background(Color.White)
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Title
//            Text(
//                text = title,
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.Black
//            )
//        }
//    }
//}





import androidx.compose.foundation.rememberScrollState

import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.DataModel.healthArticles.HealthArticlesDataModel
import com.o9tech.heartratemonitor.DataModel.healthArticles.HealthArticlesDataSet
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet


//@Preview(showBackground = true)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BetterSleepScreen() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                modifier = Modifier.padding(horizontal = 6.dp),
//                title = {
//                    Text(
//                        text = "Better Sleep",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp,
//                        modifier = Modifier.padding(start = 5.dp),
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        // Handle back navigation
//                    }) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowBack,
//                            contentDescription = "ArrowBack",
//                            modifier = Modifier.padding(start = 10.dp),
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Transparent
//                ),
//            )
//        },
//        content = {
//            Surface(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(it)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(10.dp)
//                        .verticalScroll(rememberScrollState())  // Enable scrolling for the entire content
//                ) {
//                    Text(
//                        text = "Meditation",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(horizontal = 8.dp)
//                    )
//
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(320.dp), // Limit height to allow outer scroll
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(4) { index ->
//                            CDCard(title = "CD Title $index", imageRes = R.drawable.ic_launcher_background)
//                        }
//                    }
//
//                    Text(
//                        text = "Nature",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(horizontal = 8.dp)
//                    )
//
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(320.dp), // Limit height to allow outer scroll
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(4) { index ->
//                            CDCard(title = "CD Title $index", imageRes = R.drawable.ic_launcher_background)
//                        }
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun CDCard(title: String, imageRes: Int) {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(150.dp)
//            .padding(8.dp),
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // CD Disk
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(80.dp)
//                    .clip(CircleShape)
//                    .background(Color.Black)
//            ) {
//                Image(
//                    painter = painterResource(id = imageRes),
//                    contentDescription = "CD Disk",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                Box(
//                    modifier = Modifier
//                        .size(30.dp)
//                        .clip(CircleShape)
//                        .background(Color.Black),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(15.dp)
//                            .clip(CircleShape)
//                            .background(Color.White)
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Title
//            Text(
//                text = title,
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.Black
//            )
//        }
//    }
//}

//
//@Preview(showBackground = true)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BetterSleepScreen() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                modifier = Modifier.padding(horizontal = 6.dp),
//                title = {
//                    Text(
//                        text = "Better Sleep",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp,
//                        modifier = Modifier.padding(start = 5.dp),
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        // Handle back navigation
//                    }) {
//                        Icon(
//                            imageVector = Icons.Default.ArrowBack,
//                            contentDescription = "ArrowBack",
//                            modifier = Modifier.padding(start = 10.dp),
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.LightGray
//                ),
//            )
//        },
//        content = { paddingValues ->
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(paddingValues),
//                contentPadding = PaddingValues(10.dp),
//                verticalArrangement = Arrangement.spacedBy(10.dp)
//            ) {
//                item {
//                    Text(
//                        text = "Meditation",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(8.dp)
//                    )
//                }
//
//                item {
//                    // Non-scrollable Grid for Meditation
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(352.dp), // Fixed height
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(4) { index ->
//                            CDCard(title = "Meditation $index", imageRes = R.drawable.ic_launcher_background)
//                        }
//                    }
//                }
//
//                item {
//                    Text(
//                        text = "Nature",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        modifier = Modifier.padding(8.dp)
//                    )
//                }
//
//                item {
//                    // Non-scrollable Grid for Nature
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(300.dp), // Fixed height
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(4) { index ->
//                            CDCard(title = "Nature $index", imageRes = R.drawable.ic_launcher_background)
//                        }
//                    }
//                }
//            }
//        }
//    )
//}
//
//@Composable
//fun CDCard(title: String, imageRes: Int) {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(180.dp)
//            .padding(8.dp),
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // CD Disk
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(80.dp)
//                    .clip(CircleShape)
//                    .background(Color.Black)
//            ) {
//                Image(
//                    painter = painterResource(id = imageRes),
//                    contentDescription = "CD Disk",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                Box(
//                    modifier = Modifier
//                        .size(30.dp)
//                        .clip(CircleShape)
//                        .background(Color.Black),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(15.dp)
//                            .clip(CircleShape)
//                            .background(Color.White)
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Title
//            Text(
//                text = title,
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.Black
//            )
//        }
//    }
//}


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BetterSleepScreen(navController: NavHostController) {
    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }
    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    title = {
                        Text(
                            text = "Better Sleep",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 5.dp),
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
                            // Handle back navigation
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.padding(start = 10.dp),
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                if (isInternetAvailable.value) {
                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)}
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState()),  // Make the entire screen scrollable
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

//                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Meditation",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
                val feature: List<HealthArticlesDataModel> = HealthArticlesDataSet.SetHeartRate()

                // Grid for Meditation Section
//                GridSection(items = List(feature.size) { "Meditation $it" })
                GridSection(items = feature)

                Text(
                    text = "Nature",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )

                GridSection(items = feature)

                // Grid for Nature Section
//                GridSection(items = List(8) { "Nature $it" })
            }
        }
    )
}

@Composable
fun GridSection(items: List<HealthArticlesDataModel>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (i in items.indices step 2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                CDCard(item = items[i], modifier = Modifier.weight(1f))
                if (i + 1 < items.size) {
                    CDCard(item = items[i + 1], modifier = Modifier.weight(1f))
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


//@Composable
//fun GridSection(items: List<String>) {
//    Column(
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        // Creating rows for grid-like layout (2 items per row)
//        for (i in items.indices step 2) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                CDCard(title = items[i], imageRes = R.drawable.ic_launcher_background, modifier = Modifier.weight(1f))
//                if (i + 1 < items.size) {
//                    CDCard(title = items[i + 1], imageRes = R.drawable.ic_launcher_background, modifier = Modifier.weight(1f))
//                } else {
//                    Spacer(modifier = Modifier.weight(1f))  // Placeholder if odd number of items
//                }
//            }
//        }
//    }
//}

//@Composable
//fun CDCard(title: String, imageRes: Int, modifier: Modifier = Modifier) {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = modifier
//            .height(200.dp)
//            .padding(8.dp),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // CD Disk
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(CircleShape)
//                    .background(Color.Black)
//            ) {
//                Image(
//                    painter = painterResource(id = imageRes),
//                    contentDescription = "CD Disk",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                Box(
//                    modifier = Modifier
//                        .size(30.dp)
//                        .clip(CircleShape)
//                        .background(Color.Black),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(15.dp)
//                            .clip(CircleShape)
//                            .background(Color.White)
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Title
//            Text(
//                text = title,
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.Black
//            )
//        }
//    }
//}

@Composable
fun CDCard(item: HealthArticlesDataModel, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .height(200.dp)
            .padding(horizontal = 18.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // CD Disk
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            ) {
                Image(
                    painter = painterResource(id = item.image),  // Use image from the data model
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(15.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Title from Data Model
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black
            )
        }
    }
}
