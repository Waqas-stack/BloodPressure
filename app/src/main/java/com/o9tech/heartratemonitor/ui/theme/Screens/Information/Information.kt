package com.o9tech.heartratemonitor.ui.theme.Screens.Information

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.DataModel.AssessHeartModel.AssessHeartModel
import com.o9tech.heartratemonitor.DataModel.AssessHeartModel.AssessHeartSetData
import com.o9tech.heartratemonitor.DataModel.BloodPressureModel.BloodPressureDataModel
import com.o9tech.heartratemonitor.DataModel.BloodPressureModel.BloodPressureSetData
import com.o9tech.heartratemonitor.DataModel.BloodSugarModel.BloodSugarDataModel
import com.o9tech.heartratemonitor.DataModel.BloodSugarModel.BloodSugarSetData
import com.o9tech.heartratemonitor.DataModel.DiabetesModel.DiabetesDataModel
import com.o9tech.heartratemonitor.DataModel.DiabetesModel.DiabetesSetData
import com.o9tech.heartratemonitor.DataModel.FirstAidTips.FirstAidModel
import com.o9tech.heartratemonitor.DataModel.FirstAidTips.FirstAidModelSetData
import com.o9tech.heartratemonitor.DataModel.HealthLifestyleModel.HealthLifestyleModel
import com.o9tech.heartratemonitor.DataModel.HealthLifestyleModel.HealthLifestyleSetData
import com.o9tech.heartratemonitor.DataModel.HeartDisease.HeartDiseaseModel
import com.o9tech.heartratemonitor.DataModel.HeartDisease.HeartDiseaseSetData
import com.o9tech.heartratemonitor.DataModel.HeartRateDataSet
import com.o9tech.heartratemonitor.DataModel.HeartRateModel
import com.o9tech.heartratemonitor.DataModel.HypertensionModel.HypertensionModel
import com.o9tech.heartratemonitor.DataModel.HypertensionModel.HypertensionSetData
import com.o9tech.heartratemonitor.DataModel.ProtectHeart.ProtectHeartModel
import com.o9tech.heartratemonitor.DataModel.ProtectHeart.ProtectHeartModelSetData
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun InformationScreen(navController: NavHostController) {
    var context = LocalContext.current
    val isInternetAvailable = remember { mutableStateOf(checkInternet(context)) }
    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    modifier = Modifier.padding(horizontal = 6.dp),

                    title = {
                        Text(
                            text = "Health Articles",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 5.dp),
                        )
                    },
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
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                if (isInternetAvailable.value) {
                BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)}
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
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp)
                ) {
//                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)
//                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Heart rate", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {

                        val feature: List<HeartRateModel> = HeartRateDataSet.SetHeartRate()


                        items(feature) { fetal ->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(fetal.backgroundColor)
                                    .clickable {
//                                        navController.currentBackStackEntry?.savedStateHandle?.set("fetal", fetal)
//                                        Log.d("NavDebug", "Saving fetal data: $fetal")
//                                        navController.navigate(Routesa.DetailsInformationSceen)
//                                        navController.navigate(
//                                            Routesa.DetailsInformationSceen + "/${fetal.id}/${fetal.image}/${fetal.title}"
//                                        )
//                                        navController.navigate(Routesa.DetailsInformationSceen+"/${fetal}")
                                    }
                                    .padding(horizontal = 10.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {

                                Image(
                                    painter = painterResource(id = fetal.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = fetal.title,fontWeight = FontWeight.Bold)
//
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                navController.navigate("FaqScreen")
                            }
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.love), // Notification icon
                                contentDescription = "KeyboardArrowlovet",
                                tint = Color.Black, // Icon color
                                modifier = Modifier.size(24.dp) // Icon size
                            )
                            Column {
                                Text(
                                    text = "Have a question?",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Spacer(modifier = Modifier.size(2.dp))
                                Text(text = "find the answers here", fontSize = 12.sp)
                            }
                        }


                        Box(
                            modifier = Modifier
                                .size(20.dp) // Circle size
                                .background(
                                    color = Color.LightGray,
                                    shape = CircleShape
                                ), // Light gray background with circle shape
                            contentAlignment = Alignment.Center // Center the icon inside the circle
                        ) {
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowRight, // Notification icon
                                contentDescription = "KeyboardArrowRight",
                                tint = Color.Black, // Icon color
                                modifier = Modifier.size(24.dp) // Icon size
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Heart Disease Triggers",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val heartdiseases: List<HeartDiseaseModel> = HeartDiseaseSetData.SetHeartDiseaseData()

                        items(heartdiseases) {heart->

                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(heart.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = heart.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = heart.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Health LifeStyle", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val healthLifestyle: List<HealthLifestyleModel> = HealthLifestyleSetData.setHealthLifestyleData()

                        items(healthLifestyle) {health->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(health.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = health.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = health.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Protect Heart", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val protectHeart: List<ProtectHeartModel> = ProtectHeartModelSetData.setProtectdata()

                        items(protectHeart) {protect->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(protect.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = protect.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = protect.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "First Aid Tips", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val firstAidTips: List<FirstAidModel> = FirstAidModelSetData.setDataFirstAidModel()

                        items(firstAidTips) {first->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(first.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = first.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = first.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Blood Pressure", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val bloodPressure: List<BloodPressureDataModel> = BloodPressureSetData.setDataBloodPressure()

                        items(bloodPressure) {blood->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(blood.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = blood.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = blood.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Hypertension", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val hypertension: List<HypertensionModel> = HypertensionSetData.setdataHypertension()

                        items(hypertension) {hyper->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(hyper.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = hyper.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = hyper.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Assess Heart Health",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val assessHeart: List<AssessHeartModel> = AssessHeartSetData.setAssessHeartSet()

                        items(assessHeart) {assess->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(assess.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = assess.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = assess.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Blood Sugar", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val bloodSugar: List<BloodSugarDataModel> = BloodSugarSetData.setBloodSugar()

                        items(bloodSugar) {bloodsugar->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(bloodsugar.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = bloodsugar.image),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = bloodsugar.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Diabetes", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    LazyRow(
                        modifier = Modifier.padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        val diabetes: List<DiabetesDataModel> = DiabetesSetData.setDiabetesData()

                        items(diabetes) {diabet->
                            Column(
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(diabet.backgroundColor)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween

                            ) {
                                Image(
                                    painter = painterResource(id = diabet.imge),
                                    contentDescription = "",
                                    modifier = Modifier.size(150.dp)
                                )
                                Text(text = diabet.title,fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        }
    )
}