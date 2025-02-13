package com.o9tech.bloodpressure.ui.theme.Screens.healthArticlsdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.navigation.NavHostController
import com.o9tech.bloodpressure.DataModel.RecipesModel.RecipesDataModel
import com.o9tech.bloodpressure.DataModel.RecipesModel.RecipesDataModelDataset
import com.o9tech.bloodpressure.ui.theme.lightgray


//@Preview(showBackground = true)
//@Composable
//fun RecipeCategory(){
//    Scaffold (
//
//        content = {
//            Surface(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(it)
//            ) {
//                Column (
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .verticalScroll(rememberScrollState())
//                ){
//                    val featurere: List<RecipesDataModel> = RecipesDataModelDataset.SetHeartRate()
//
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(2), // 2 columns
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        contentPadding = PaddingValues(8.dp),
//                        horizontalArrangement = Arrangement.spacedBy(8.dp),
//                        verticalArrangement = Arrangement.spacedBy(8.dp)
//                    ) {
//                        items(featurere.size) { index ->
//                            Box(
//                                modifier = Modifier
//                                    .width(150.dp)
//                                    .height(200.dp)
//                                    .clip(RoundedCornerShape(10.dp))
//                                    .background(Color.Black.copy(alpha = 0.3f))
//                                    .clickable {
////                                        navController.navigate("details/${featurere[index].id}")
//                                    }
//                            ) {
//                                // Background Image
//                                Image(
//                                    painter = painterResource(id = featurere[index].image),
//                                    contentDescription = "Background Image",
//                                    contentScale = ContentScale.Crop,
//                                    modifier = Modifier.fillMaxSize()
//                                )
//
//                                // Foreground Content (Text)
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .padding(horizontal = 10.dp, vertical = 10.dp),
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Spacer(modifier = Modifier.height(10.dp))
//                                    Text(
//                                        text = featurere[index].title,
//                                        fontWeight = FontWeight.Bold,
//                                        color = Color.White,
//                                        fontSize = 18.sp
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    )
//}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RecipeCategory(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),

                title = {
                    Text(
                        text = "Recipes",
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
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                val featurere: List<RecipesDataModel> = RecipesDataModelDataset.SetHeartRate()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                        .padding(8.dp),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    items(featurere.size) { index ->
                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.Black.copy(alpha = 0.3f))
                                .clickable {
                                    navController.navigate("detailss/${featurere[index].id}")
                                }
                        ) {
                            Image(
                                painter = painterResource(id =  featurere[index].image),
                                contentDescription = "Background Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 10.dp, vertical = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = featurere[index].title,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}


//
//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun FeatureGrid(navController: NavController, featurere: List<HealthArticlesDataModel>) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2), // 2 columns
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp),
//        contentPadding = PaddingValues(8.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(featurere.size) { index ->
//            Box(
//                modifier = Modifier
//                    .width(150.dp)
//                    .height(200.dp)
//                    .clip(RoundedCornerShape(10.dp))
//                    .background(Color.Black.copy(alpha = 0.3f))
//                    .clickable {
//                        navController.navigate("details/${featurere[index].id}")
//                    }
//            ) {
//                // Background Image
//                Image(
//                    painter = painterResource(id = featurere[index].image),
//                    contentDescription = "Background Image",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//
//                // Foreground Content (Text)
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 10.dp, vertical = 10.dp),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Text(
//                        text = featurere[index].title,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White,
//                        fontSize = 18.sp
//                    )
//                }
//            }
//        }
//    }
//}
