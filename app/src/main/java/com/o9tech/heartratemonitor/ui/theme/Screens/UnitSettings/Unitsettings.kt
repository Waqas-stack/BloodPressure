package com.o9tech.heartratemonitor.ui.theme.Screens.UnitSettings

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun UnintSettingsScreen(navController: NavHostController) {

    var selectedRowweight by remember { mutableStateOf("lbs") }
    var selectedRowheight by remember { mutableStateOf("ft . in") }
    var selectedRowsugar by remember { mutableStateOf("mmol/l") }

    Scaffold (
        topBar = {
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
                        text = "Unit Settings",
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
            Surface (
                color = lightgray,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ){
                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "weight",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 14.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().clickable {
                                    selectedRowweight = "lbs"
                                }.padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "lbs",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (selectedRowweight == "lbs") {
                            Icon(imageVector = Icons.Default.Check,
                                contentDescription ="check",
                                tint = Color.Red
                                )
                            }
                        }
                        Divider()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedRowweight = "kg"
//
                                }
                                .padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "kg",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (selectedRowweight == "kg") {
                            Icon(imageVector = Icons.Default.Check,
                                contentDescription ="check",
                                tint = Color.Red
                            )}
                        }
                    }
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = "Height",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 14.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().clickable {
                                    selectedRowheight="ft . in"
                                }.padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "ft . in",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (selectedRowheight=="ft . in") {
                            Icon(imageVector = Icons.Default.Check,
                                contentDescription ="check",
                                tint = Color.Red
                            )
                            }
                        }
                        Divider()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
//                                    navController.navigate("DailySettingsSceen")
                                    selectedRowheight="cm"
                                }
                                .padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "cm",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (selectedRowheight=="cm"){
                            Icon(imageVector = Icons.Default.Check,
                                contentDescription ="check",
                                tint = Color.Red
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = "Blood sugar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 14.dp),
                    ) {
                        Row(
                            modifier = Modifier

                                .fillMaxWidth().clickable {
                                    selectedRowsugar="mmol/l"
                                }.padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "mmol/l",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (selectedRowsugar=="mmol/l") {
                            Icon(imageVector = Icons.Default.Check, contentDescription ="check",
                                tint = Color.Red
                            )
                            }
                        }
                        Divider()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
//                                    navController.navigate("DailySettingsSceen")
                                    selectedRowsugar="mg/dl"
                                }
                                .padding(vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "mg/dl",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (selectedRowsugar=="mg/dl"){
                            Icon(imageVector = Icons.Default.Check, contentDescription ="check",
                                tint = Color.Red)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(12.dp))
                }
            }
        }
    )
}