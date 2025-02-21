package com.o9tech.heartratemonitor.ui.theme.Screens.Detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DetailsScreen() {
    var showDialog by remember { mutableStateOf(false) } // State to control dialog visibility

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 0.dp),
//                navigationIcon = {
//
//                    IconButton(onClick = { }) {
//                        Icon(
//                            imageVector = Icons.Filled.ArrowBack,
//                            contentDescription = "Back"
//                        )
//                    }
//
//                },
                title = {
//
                    Column(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
//                            modifier = Modifier.fillMaxWidth()
                        ) {
//                            IconButton(
//                                onClick = {  },
//                                modifier = Modifier.padding(end = 8.dp) // Adds spacing between arrow and text
//                            ) {
//
//                            }
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Heart Rate",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(start = 0.dp),
                            )

                        }
                        Text(
                            text = "Subtitle",
                            modifier = Modifier.padding(start = 28.dp),
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                },
                actions = {
                    TextButton(onClick = {showDialog = true}) {
                        Text(
                            text = "Delete",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(end = 10.dp),
                        )
                    }
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
                    .padding(paddingValues),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Heart rate")
                        Text(text = "HRV")
                        Icon(imageVector = Icons.Default.Check, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
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
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Column(
                                    verticalArrangement = Arrangement.Bottom,
                                    modifier = Modifier.padding(bottom = 0.dp, start = 3.dp)
                                ) {
                                    Text(
                                        text = "bpm",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
//                            Text(text = "Average", fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.width(26.dp))
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
                                    text = "24",
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                Column(
                                    verticalArrangement = Arrangement.Bottom,
                                    modifier = Modifier.padding(bottom = 0.dp, start = 3.dp)
                                ) {
                                    Text(
                                        text = "ms",
                                        fontSize = 22.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = MaterialTheme.shapes.small,
                            modifier = Modifier.weight(1f),
                            onClick = { /*TODO*/ }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 8.dp), // Add padding at the start
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start // Align content to start
                            ) {
                                Text("Female")
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = MaterialTheme.shapes.small,
                            modifier = Modifier.weight(1f),
                            onClick = { /*TODO*/ }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 8.dp), // Add padding at the start
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start // Align content to start
                            ) {
                                Text("Age 35")
                            }
                        }

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {

                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = MaterialTheme.shapes.small,
                            modifier = Modifier.weight(1f),
                            onClick = { /*TODO*/ }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text("Sitting")
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = MaterialTheme.shapes.small,
                            modifier = Modifier.weight(2f),
                            onClick = { /*TODO*/ }) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text("Note", color = Color.LightGray)
                                Icon(imageVector = Icons.Default.Edit,
                                    contentDescription = "Edit",
                                    tint = Color.LightGray,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                    }
                }
            }
        }
    )
//    if (showDialog) {
//        AlertDialog(
//            containerColor = Color.White,
//            tonalElevation = 4.dp,
//            shape = MaterialTheme.shapes.medium,
//            onDismissRequest = { showDialog = false },
////            title = { Text(text = "sure you want to delete?",) },
//            text = { Text("Are you sure you want to logout?") },
//            confirmButton = {
//                TextButton(onClick = {
//                    showDialog = false
//
//                }) {
//                    Text("Delete")
//                }
//            },
//            dismissButton = {
//                TextButton(onClick = {
//                    showDialog = false // Dismiss the dialog
//                }) {
//                    Text("Cancel")
//                }
//            }
//        )
//    }


    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            containerColor = Color.White,
            tonalElevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            title = {
                Text(
                    text = "Are you sure you want to logout?",
//                    modifier = Modifier.align(Alignment.Start) // Align the text to the top-left
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    // Handle the logout action
                    showDialog = false
                    // Add your logout logic here
                }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false // Dismiss the dialog
                }) {
                    Text("Cancel")
                }
            }
        )
    }
}



@Composable
fun YourScreen() {
    var showDialog by remember { mutableStateOf(false) }

    // Trigger dialog visibility
    Button(onClick = { showDialog = true }) {
        Text("Show Logout Dialog")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            containerColor = Color.White,
            tonalElevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            title = {
                Text(
                    text = "Are you sure you want to logout?",
                    fontSize = 1.sp
//                    modifier = Modifier.align(Alignment.Start) // Align the text to the top-left
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    // Handle the logout action
                    showDialog = false
                    // Add your logout logic here
                }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false // Dismiss the dialog
                }) {
                    Text("Cancel")
                }
            }
        )
    }
}



