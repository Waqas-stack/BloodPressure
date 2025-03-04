package com.o9tech.heartratemonitor.ui.theme.Screens.FeedBack

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.o9tech.heartratemonitor.ui.theme.lightgray

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FeedBackScreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()
    val context = LocalContext.current
    var feedbackText by remember { mutableStateOf("") }

    Scaffold (
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

                title = {
                    Text(
                        text = "Feedback",
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
//                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)
                    Spacer(modifier = Modifier.height(10.dp))
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        value = feedbackText,
                        onValueChange = {
                            feedbackText = it
                        },
                        label = { Text("Enter your feedback") },
                        placeholder = { Text("Type your feedback here...") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.LightGray
                        )
                    )
//                    TextField(value = fe, onValueChange = )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ),
                        onClick = {
                            Toast.makeText(context, "Feedback sent successfully", Toast.LENGTH_SHORT).show()
                        }) {
                        Text(text = "Send", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }
                }
            }
        }
    )

}