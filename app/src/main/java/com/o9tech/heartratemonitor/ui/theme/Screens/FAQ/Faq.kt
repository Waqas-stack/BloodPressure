package com.o9tech.heartratemonitor.ui.theme.Screens.FAQ

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FaqScreen(navController: NavHostController) {
    var isExpandedappwork by remember { mutableStateOf(false) }
    var isExpandedResult by remember { mutableStateOf(false) }
    var isExpandedHotflash by remember { mutableStateOf(false) }
    var isExpandedwitoutfinger by remember { mutableStateOf(false) }
    var isExpandedcannotmeasure by remember { mutableStateOf(false) }
    var isExpandedchangeagegender by remember { mutableStateOf(false) }
    var isExpandedbeepsound by remember { mutableStateOf(false) }
    var isExpandedcheckheart by remember { mutableStateOf(false) }
    var isExpandeddetecthal by remember { mutableStateOf(false) }
    var isExpandedscan by remember { mutableStateOf(false) }
    var isExpandedsuggestion by remember { mutableStateOf(false) }
    var isExpandednoticed by remember { mutableStateOf(false) }

    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }


    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    modifier = Modifier.padding(horizontal = 6.dp),
                    navigationIcon = {

                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.padding(start = 10.dp),
                            )
                        }

                    },

                    title = {
                        Text(
                            text = "FAQ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 5.dp),
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                if (isInternetAvailable.value) {
                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize = AdSize.BANNER)
                }
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
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {

                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedappwork = !isExpandedappwork
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "How dose the app Work?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedappwork) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedappwork) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedResult = !isExpandedResult
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "The result seems inaccurate.",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedResult) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedResult) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))

//                    Spacer(modifier = Modifier.height(9.dp))


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedHotflash = !isExpandedHotflash
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Can i turn off off the hot flashlight?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedHotflash) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedHotflash) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedwitoutfinger = !isExpandedwitoutfinger
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Why did it measure without \nmy finger on the  camera?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedwitoutfinger) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedwitoutfinger) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedcannotmeasure = !isExpandedcannotmeasure
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Why can't i measure my heart \nrate",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedcannotmeasure) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedcannotmeasure) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedchangeagegender = !isExpandedchangeagegender
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "How to change my age and \ngender?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedchangeagegender) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedchangeagegender) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedbeepsound = !isExpandedbeepsound
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "How to turn off the flashlight / \nbeep sound?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedbeepsound) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedbeepsound) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedcheckheart = !isExpandedcheckheart
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "When should i check my heart \nrate?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedcheckheart) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedcheckheart) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandeddetecthal = !isExpandeddetecthal
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Dose it detect arrhythmia o other \nheart problems?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandeddetecthal) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandeddetecthal) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedscan = !isExpandedscan
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Does the Camera scan my \nfingerprint?",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedscan) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedscan) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedsuggestion = !isExpandedsuggestion
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "I have a suggestion",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandedsuggestion) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedsuggestion) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandednoticed = !isExpandednoticed
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "I noticed a problem",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                imageVector = if (isExpandednoticed) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandednoticed) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Text("Here is some expanded content!")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("You can put more items here.")
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Add as much content as needed.")
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(9.dp))
                }
            }
        }
    )
}