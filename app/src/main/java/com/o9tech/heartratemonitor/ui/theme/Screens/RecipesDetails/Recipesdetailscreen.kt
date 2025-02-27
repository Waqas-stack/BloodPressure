package com.o9tech.heartratemonitor.ui.theme.Screens.RecipesDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.o9tech.heartratemonitor.DataModel.RecipesModel.RecipesDataModelDataset
import com.o9tech.heartratemonitor.R
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailssScreen(itemId: Int, navController: NavHostController) {
    val selectedItem = RecipesDataModelDataset.SetHeartRate().find { it.id == itemId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Details") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.clickable {
                        navController.navigate("DetailssssScreen")
                    }
                ) {
                    selectedItem?.let {
                        Image(
                            painter = painterResource(id = it.image),
                            contentDescription = "Item Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = it.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    } ?: Text(text = "Item not found!", color = Color.Red)
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DetailssssScreen(navController: NavHostController) {

    val state = rememberCollapsingToolbarScaffoldState()


    CollapsingToolbarScaffold(
        modifier = Modifier,
        state = state,


        scrollStrategy = ScrollStrategy.EnterAlways,
        toolbar = {
            val textsize = (18 + (30 - 12) * state.toolbarState.progress).sp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .pin()
                    .background(color = MaterialTheme.colorScheme.primary)
            )
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.recipe8),
                contentDescription = "nul",
                contentScale = ContentScale.Crop,
                alpha = if (textsize.value == 18f) 0f else 1f,
            )
            Text(
                text = "Recipe Name",
                style = TextStyle(color = Color.White, fontSize = textsize),
                modifier = Modifier
                    .padding(10.dp)
                    .road(whenCollapsed = Alignment.TopStart, whenExpanded = Alignment.BottomStart)
            )

            IconButton(onClick = {
                                 navController.popBackStack()
            }, modifier = Modifier.padding(vertical = 20.dp)) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "arrowback",
                    tint = Color.White,
                    modifier = Modifier.size(50.dp)
                    )
            }
        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(8) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 3.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = "Item $it", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Text(text = "Item this is the card of the recipe details screen and workinf on this and reuild its project ")
                    }

                }

            }
        }
    }
}
