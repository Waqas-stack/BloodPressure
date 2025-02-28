package com.o9tech.heartratemonitor.ui.theme.Screens.Language

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.o9tech.heartratemonitor.ui.theme.circuler
import com.o9tech.heartratemonitor.ui.theme.lightgray


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguagesScreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()
    var selectedIndex by remember { mutableStateOf(-1) }

    val languages = listOf(
        "English", "Spanish", "French", "German", "Italian",
        "Portuguese", "Russian", "Chinese", "Japanese", "Korean",
        "Arabic", "Hindi", "Turkish", "Dutch"
    )


    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 6.dp),
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
                    Box(modifier = Modifier.size(120.dp)) {
                    }
                },

                title = {
                    Text(
                        text = "language",
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
                    .padding(paddingValues)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(18.dp)
                ) {
                    items(languages.size) { index ->
                        val language = languages[index]

                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedIndex = index
                                    }
                                    .padding(vertical = 14.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(text = language, fontSize = 18.sp)
                                if (selectedIndex == index) {
                                    IconButton(onClick = {

                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Check,
                                            tint = Color.Red,
                                            contentDescription = "Check",
                                            modifier = Modifier.size(20.dp)

                                        )
                                    }

                                } else {
                                    Spacer(modifier = Modifier.size(46.dp))
                                }
                            }
                            Divider(color = circuler, thickness = 1.dp)
                        }
                    }
                }
            }
        }
    )
}




