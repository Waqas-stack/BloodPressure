package com.o9tech.heartratemonitor.ui.theme.Screens.Tension_Relief

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.o9tech.heartratemonitor.ui.theme.lightgray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TensionScreen() {
    Scaffold(
        containerColor = lightgray,
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

                title = {
                    Text(
                        text = "Tension Relief",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 5.dp),
                    )
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

//                        Text(
//                            text = "View all",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 14.sp,
//                            color = Color.Gray,
//                            modifier = Modifier.padding(end = 10.dp),
//                        )
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = lightgray)
                ) {
                    Text(text = "Tension Relief")
                }
            }
        }
    )
}