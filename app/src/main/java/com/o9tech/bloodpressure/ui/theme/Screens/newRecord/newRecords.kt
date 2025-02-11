package com.o9tech.bloodpressure.ui.theme.Screens.newRecord

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.o9tech.bloodpressure.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NewRecordScreen(){
    Scaffold (
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
                actions = {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Save")
                    }
                },

                title = {
                    Text(
                        text = "These are category of blood pressure and when user tap on it then go to the details screen",
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
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column (
                    modifier = Modifier.fillMaxSize()
                ){
                   Row (
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(10.dp),
                       horizontalArrangement = Arrangement.SpaceEvenly
                   ){
                      Column {
                          Text(text = "Systolic")
                          Card (

                              modifier = Modifier,
                              elevation = CardDefaults.cardElevation(5.dp),
                              shape = RoundedCornerShape(10.dp),
                              colors =CardDefaults.cardColors(
                                  containerColor = Color.White
                              )
                          ){
//                              Text(text = "120",fontSize = 20.sp,fontWeight = FontWeight.Bold,)
                              TextField(
                                  modifier = Modifier.width(200.dp),
                                  value = "120", onValueChange = {},
                                  colors = TextFieldDefaults.colors(
                                      unfocusedContainerColor = Color.Transparent,
                                      focusedIndicatorColor = Color.Transparent,
                                      unfocusedIndicatorColor = Color.Transparent,
                                      focusedContainerColor = Color.Transparent,
                                      disabledContainerColor = Color.Transparent,
                                      disabledIndicatorColor = Color.Transparent,
                                      disabledTextColor = Color.Black,
                                      disabledPlaceholderColor = Color.Black
                                  ),
                                  )
                          }
                      }
                      Column (
                          modifier = Modifier
                      ){
                          Text(text = "Diastolic")
                          Card (

                              modifier = Modifier,
                              elevation = CardDefaults.cardElevation(5.dp),
                              shape = RoundedCornerShape(10.dp),
                              colors =CardDefaults.cardColors(
                                  containerColor = Color.White
                              )
                          ){
//                              Text(text = "120",fontSize = 20.sp,fontWeight = FontWeight.Bold,)
                              TextField(
                                  modifier = Modifier.width(200.dp),
                                  value = "120", onValueChange = {},
                                  colors = TextFieldDefaults.colors(
                                      unfocusedContainerColor = Color.Transparent,
                                      focusedIndicatorColor = Color.Transparent,
                                      unfocusedIndicatorColor = Color.Transparent,
                                      focusedContainerColor = Color.Transparent,
                                      disabledContainerColor = Color.Transparent,
                                      disabledIndicatorColor = Color.Transparent,
                                      disabledTextColor = Color.Black,
                                      disabledPlaceholderColor = Color.Black
                                  ),
                              )
                          }
                      }
                   }
                }
            }
        }
    )
}