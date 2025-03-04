package com.o9tech.heartratemonitor.ui.theme.Screens.Profile


import android.content.Context
import android.content.Intent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.appbg
import com.o9tech.heartratemonitor.ui.theme.btnbg
import com.o9tech.heartratemonitor.ui.theme.circuler
import com.o9tech.heartratemonitor.ui.theme.circulerprofile
import com.o9tech.heartratemonitor.ui.theme.lightgray


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ProfileScreen(navController: NavHostController?) {
    val safeNavController = navController ?: rememberNavController()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var isSheetOpen by remember { mutableStateOf(false) }

    val isChecked = remember { mutableStateOf(false) }
    val context = LocalContext.current


    Scaffold (
        content = {paddingValues->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                color = lightgray
            ) {
                Box (
                    modifier = Modifier.fillMaxSize()
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        //                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize =  AdSize.BANNER)
                        //                    Spacer(modifier = Modifier.height(10.dp))
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 10.dp, start = 20.dp)
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(circulerprofile)
                                .wrapContentSize(Alignment.Center)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = "Profile Image",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                        Text(
                            text = "Sync & Restore",
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "sign in and back up your data",
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 20.dp),
                            fontSize = 12.sp,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            modifier = Modifier
                                .padding(start = 20.dp, end = 20.dp)
                                .fillMaxWidth()
                                .height(40.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = btnbg,
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(6.dp),
                            onClick = { /*TODO*/ }) {
                            //                Icon(imageVector = Icons.Default.Add, contentDescription = "")
                            //                Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Sync", fontSize = 18.sp, fontWeight = FontWeight.W700)
                        }

                        Spacer(modifier = Modifier.height(20.dp))


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .padding(10.dp),
                        ) {
                            Text(text = "Settings", fontSize = 16.sp, color = Color.Gray)
                            //                        Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        safeNavController.navigate("GernalScreen")
                                    }
                                    .padding(vertical = 10.dp)

                            ) {
                                Icon(imageVector = Icons.Outlined.Settings, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "General settings",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,

                                    )
                            }
                            //                        Spacer(modifier = Modifier.height(14.dp))

                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            //                        Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        safeNavController.navigate("ReminderScreen")
                                    }
                                    .padding(vertical = 10.dp)

                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.CheckCircle,
                                    contentDescription = ""
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Reminders",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            //                        Spacer(modifier = Modifier.height(14.dp))
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            //                        Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        safeNavController.navigate("LanguagesScreen")
                                    }
                                    .padding(vertical = 10.dp)

                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.AccountCircle,
                                    contentDescription = ""
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Language",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            //                        Spacer(modifier = Modifier.height(14.dp))
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()

                            ) {
                                Icon(imageVector = Icons.Outlined.Delete, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Export a file",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically

                            ) {
                                Row(
                                    modifier = Modifier.padding(start = 10.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.ThumbUp,
                                        contentDescription = ""
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = "Contact with Google Fit",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Switch(
                                    //                        colors = SwitchDefaults.colors(
                                    //                            checkedThumbColor = Color.White,
                                    //                            checkedTrackColor = btnbg,
                                    //                            uncheckedThumbColor = Color.White,
                                    //                            uncheckedTrackColor = Color.LightGray
                                    //                        ),
                                    modifier = Modifier,
                                    checked = isChecked.value,
                                    onCheckedChange = { isChecked.value = it }
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))


                        }

                        Spacer(modifier = Modifier.height(20.dp))


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.White)
                                .padding(10.dp),
                        ) {
                            Text(text = "More", fontSize = 16.sp, color = Color.Gray)
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        isSheetOpen = true
                                    }
                                    .padding(vertical = 10.dp)

                            ) {
                                Icon(imageVector = Icons.Outlined.Star, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Rate us",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))

                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth().clickable {
                                        shareText(context,"Hey! Check out this amazing app: https://play.google.com/store/apps/details?id=com.yourap")
                                    } .padding(vertical = 10.dp)

                            ) {
                                Icon(imageVector = Icons.Outlined.Share, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Share with friends",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth().clickable {
                                        safeNavController.navigate("FeedBackScreen")
                                    }.padding(vertical = 10.dp)

                            ) {
                                Icon(imageVector = Icons.Outlined.Edit, contentDescription = "")
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Feedback",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(14.dp))
                            Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 40.dp)
                                    .height(1.dp)
                                    .background(circuler)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()

                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.AccountBox,
                                    contentDescription = ""
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Privacy policy",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }


                            Spacer(modifier = Modifier.height(10.dp))


                        }
                        Spacer(modifier = Modifier.height(34.dp))

                    }
                    if (isSheetOpen) {
//                        OverlappingOnBorder()
                        RateUsBottomSheeta(
                            sheetState = sheetState,
                            onDismiss = { isSheetOpen = false }
                        )
                    }
                }
            }
        }
    )



   
}






//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RateUsBottomSheet(
//    sheetState: SheetState,
//    onDismiss: () -> Unit
//) {
//    var rating by remember { mutableStateOf(0) } // Stores selected rating
//
//    ModalBottomSheet(
//        onDismissRequest = onDismiss,
//        sheetState = sheetState,
//        containerColor = Color.White
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "Rate Our App",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black
//            )
//
//            Spacer(modifier = Modifier.height(10.dp))
//
//            // Star Rating Row
//            Row(
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                for (i in 1..5) {
//                    Icon(
//                        imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
//                        contentDescription = "Star",
//                        tint = Color.Red,
//                        modifier = Modifier
//                            .size(40.dp)
//                            .clickable { rating = i }
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Button(
//                onClick = {
//                    // Handle Rating Submission Here (Navigate to Play Store, etc.)
//                    onDismiss()
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Submit")
//            }
//
//            Spacer(modifier = Modifier.height(10.dp))
//        }
//    }
//}


//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RateUsBottomSheet(
//    sheetState: SheetState,
//    onDismiss: () -> Unit
//) {
//    var rating by remember { mutableStateOf(0) } // Stores user-selected rating
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        // 🏆 Emoji on Top-Left Corner
//        Text(
//            text = "🏆", // Change Emoji if needed (e.g., 😊, ⭐)
//            fontSize = 30.sp,
//            color = Color.Yellow,
//            modifier = Modifier
//                .offset(x = (-20).dp, y = (-20).dp) // Moves emoji outside top-left border
//                .zIndex(2f) // Ensures it's above the sheet
//        )
//
//        ModalBottomSheet(
//            onDismissRequest = onDismiss,
//            sheetState = sheetState,
//            containerColor = Color.White
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "Rate Our App",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//
//                Spacer(modifier = Modifier.height(10.dp))
//
//                // Star Rating Row
//                Row(
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    for (i in 1..5) {
//                        Icon(
//                            imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
//                            contentDescription = "Star",
//                            tint = Color.Red,
//                            modifier = Modifier
//                                .size(40.dp)
//                                .clickable { rating = i }
//                        )
//                    }
//                }
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Button(
//                    onClick = {
//                        // TODO: Handle Rating Submission (e.g., Navigate to Play Store)
//                        onDismiss()
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Text("Submit")
//                }
//
//                Spacer(modifier = Modifier.height(10.dp))
//            }
//        }
//    }
//}





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RateUsBottomSheet(
    sheetState: SheetState,
    onDismiss: () -> Unit
) {
    var rating by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp)
        ) {
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = sheetState,
                containerColor = Color.White
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "🏆",
                        fontSize = 40.sp,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(x = (-1).dp, y = (-60).dp)
                            .zIndex(2f)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Thank you for your \nsupport!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "we would be very grateful if you can rate us ",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (i in 1..5) {
                            Icon(
                                imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                                contentDescription = "Star",
                                tint = Color.Red,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clickable { rating = i }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            // TODO: Handle Rating Submission (e.g., Navigate to Play Store)
                            onDismiss()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Submit")
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}






@Composable
fun OverlappingOnBorder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 140.dp), // To keep it centered on the screen
        contentAlignment = Alignment.Center
    ) {
        // 🔵 Blue Box (Main Background)
        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp)
                .background(Color.Blue)
        )

        // 🔴 Red Box (Overlapping on Border)
        Box(
            modifier = Modifier
                .size(80.dp).padding(horizontal = 10.dp)
                .background(Color.Red)
                .align(Alignment.TopStart) // Moves it to top-left of Blue Box
        )
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RateUsBottomSheeta(
    sheetState: SheetState,
    onDismiss: () -> Unit
) {
    var rating by remember { mutableStateOf(0) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Rate Our App",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            // ⭐ Star Rating Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (i in 1..5) {
                    Icon(
                        imageVector = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star,
                        contentDescription = "Star",
                        tint = Color.Yellow,
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { rating = i }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    // TODO: Handle Rating Submission (e.g., Navigate to Play Store)
                    onDismiss()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}



fun shareText(context: Context, text: String) {
    val sendIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, "Share via")
    context.startActivity(shareIntent)
}
