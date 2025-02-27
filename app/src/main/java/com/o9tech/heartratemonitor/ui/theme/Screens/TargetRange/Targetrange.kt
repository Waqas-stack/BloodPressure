package com.o9tech.heartratemonitor.ui.theme.Screens.TargetRange

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
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
fun TargetRangeScreen(navController: NavHostController) {
    var isExpandedAfterExercize by remember { mutableStateOf(false) }
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
                            text = "Edit Target Range",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 5.dp),
                        )
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.padding(start = 0.dp),
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                if (isInternetAvailable.value) {
                    BannersAds(modifier = Modifier.fillMaxWidth().background(lightgray), adSize =  AdSize.BANNER)}
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
                            .height(200.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 16.dp, vertical = 8.dp)

                    ) {
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Default",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.padding(start = 0.dp),
                            )
                        }
                        Text(
                            text = "For all unspecified conditions",
                            fontSize = 12.sp,
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Blue)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Low",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "< 72",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Green)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Normal",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "72 ~ 99",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Yellow)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Pre-diabetes",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "99 ~ 126",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Diabetes",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = ">= 126",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(26.dp))
                    Text(text = "Specified")
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 16.dp, vertical = 8.dp)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row {
                                Text(
                                    text = "Fasting",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "ArrowBack",
                                    modifier = Modifier.padding(start = 0.dp),
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.padding(start = 0.dp),
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Blue)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Low",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "< 72",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Green)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Normal",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "72 ~ 99",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Yellow)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Pre-diabetes",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "99 ~ 126",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Diabetes",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = ">= 126",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 16.dp, vertical = 8.dp)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row {
                                Text(
                                    text = "Before meal",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "ArrowBack",
                                    modifier = Modifier
                                        .size(24.dp)
                                        .padding(start = 0.dp),
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "ArrowBack",
                                modifier = Modifier.padding(start = 0.dp),
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Blue)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Low",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "< 72",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Green)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Normal",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "72 ~ 99",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Yellow)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Pre-diabetes",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = "99 ~ 126",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Diabetes",
                                    fontSize = 10.sp,
                                )
                            }
                            Text(
                                text = ">= 126",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(9.dp))
                    var isExpandedBeforeMeal by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedBeforeMeal = !isExpandedBeforeMeal
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Before Meal",
                                fontSize = 18.sp,
                            )
                            Icon(
                                imageVector = if (isExpandedBeforeMeal) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedBeforeMeal) {
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
                    var isExpandedAfterMeal1h by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedAfterMeal1h = !isExpandedAfterMeal1h
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "After Meal(1h)",
                                fontSize = 18.sp,
                            )
                            Icon(
                                imageVector = if (isExpandedAfterMeal1h) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedAfterMeal1h) {
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
                    var isExpandedAfterMeal2h by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedAfterMeal2h = !isExpandedAfterMeal2h
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "After Meal(2h)",
                                fontSize = 18.sp,
                            )
                            Icon(
                                imageVector = if (isExpandedAfterMeal2h) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedAfterMeal2h) {
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
                    var isExpandedAsleep by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedAsleep = !isExpandedAsleep
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Asleep",
                                fontSize = 18.sp,
                            )
                            Icon(
                                imageVector = if (isExpandedAsleep) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedAsleep) {
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
                    var isExpandedBeforeExcercise by remember { mutableStateOf(false) }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .clickable {
                                isExpandedBeforeExcercise = !isExpandedBeforeExcercise
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Before Exercise",
                                fontSize = 18.sp,
                            )
                            Icon(
                                imageVector = if (isExpandedBeforeExcercise) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }
                        AnimatedVisibility(visible = isExpandedBeforeExcercise) {
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
                                isExpandedAfterExercize = !isExpandedAfterExercize
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "After Exercise",
                                fontSize = 18.sp,
                            )
                            Icon(
                                imageVector = if (isExpandedAfterExercize) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                                contentDescription = "Expand/Collapse"
                            )
                        }

                        AnimatedVisibility(visible = isExpandedAfterExercize) {
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
                }
            }
        }
    )
}


@Composable
fun ExpandableColumn() {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable { isExpanded = !isExpanded }
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Before Meal",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowRight else Icons.Default.ArrowDropDown,
                contentDescription = "Expand/Collapse"
            )
        }
        AnimatedVisibility(visible = isExpanded) {
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
                Text(text = "Add as much content as need")
            }
        }
    }
}
