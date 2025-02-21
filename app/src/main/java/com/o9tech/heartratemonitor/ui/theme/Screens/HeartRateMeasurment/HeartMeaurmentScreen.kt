package com.o9tech.heartratemonitor.ui.theme.Screens.HeartRateMeasurment

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.icu.text.CaseMap.Title
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.SurfaceView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.Interstitialadd.InterstitialAddssc
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.circuler
import com.o9tech.heartratemonitor.ui.theme.lightgray
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import net.kibotu.heartrateometer.HeartRateOmeter


data class Botomitem(
    val title: String,
    val selectedicon: ImageVector,
    val unselectedicon: ImageVector,

    )


@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeartRateMonitorScreen() {
    var bpm by remember { mutableStateOf("Waiting for BPM...") }
    var isFingerDetected by remember { mutableStateOf(false) }
    var disposable: Disposable? by remember { mutableStateOf(null) }
    val context = LocalContext.current
    val activity = context as? Activity
    val surfaceView = remember { SurfaceView(context) }

//    val items = listOf(
//        Botomitem(
//            title = "Home",
//            selectedicon = Icons.Default.Home,
//            unselectedicon = Icons.Outlined.Home
//
//        ),
//        Botomitem(
//            title = "Email",
//            selectedicon = Icons.Default.Email,
//            unselectedicon = Icons.Outlined.Email
//
//        ),
//        Botomitem(
//            title = "Me",
//            selectedicon = Icons.Default.Person,
//            unselectedicon = Icons.Outlined.Person
//
//        ),
//    )

    val isInternetAvailable = remember { mutableStateOf(checkInternett(context)) }
    var bpmValue by remember { mutableStateOf(0) } // NEW: Store BPM as Int
//    var selectedItem by rememberSaveable {
//        mutableStateOf(0)
//    }



    LaunchedEffect(Unit) {
        isInternetAvailable.value = checkInternet(context)
    }


    LaunchedEffect(bpmValue) {
        if (bpmValue > 0) {
//            delay(2000L) // Wait 5 seconds after each BPM scan
            isInternetAvailable.value = checkInternett(context) // ⚡ Recheck internet
            if (isInternetAvailable.value) {
                activity?.let { InterstitialAddssc(it) } // 🎯 Show Ad if internet is available
            }
        }
    }

    CameraPermissionScreen {
        DisposableEffect(Unit) {
            val heartRateOmeter = HeartRateOmeter()
                .setFingerDetectionListener { detected -> isFingerDetected = detected }
                .withAverageAfterSeconds(10)

            disposable = heartRateOmeter.bpmUpdates(surfaceView).subscribe { data ->
//                bpm = if (data.value > 0) "${data.value} BPM" else "Measuring..."
                bpmValue = data.value // 🔥 Trigger LaunchedEffect when value updates
                bpm = if (data.value > 0) "${data.value} BPM" else "Measuring..."

            }

            onDispose { disposable?.dispose() }
        }
    }


    Scaffold(
        bottomBar = {
            if (isInternetAvailable.value) {
                BannersAds(modifier = Modifier.fillMaxWidth())
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.fingerscanner),
                            contentDescription = "Tracker Icon",
                            tint = Color.Red,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "How to measure",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    }
                },
                actions = {
                    TextButton(onClick = {

                    }) {
                        Text(text = "Cancel", fontWeight = FontWeight.Bold, color = Color.Black)
                    }
//                    Surface(
//                        modifier = Modifier
//                            .padding(horizontal = 8.dp)
//                            .clip(RoundedCornerShape(12.dp))
//                            .background(appwhit),
//                        color = Color.Transparent
//                    ) {
//                        Row(
//                            modifier = Modifier
//                                .padding(horizontal = 18.dp, vertical = 8.dp),
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Icon(
//                                painter = painterResource(id = R.drawable.flash),
//                                contentDescription = "Custom Action",
//                                tint = Color.Black,
//                                modifier = Modifier.size(16.dp)
//                            )
//                            Spacer(modifier = Modifier.width(4.dp))
//                            Text(
//                                text = "All(12)",
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Bold,
//                                color = Color.Black
//                            )
//                        }
//                    }
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
                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
//        AndroidView(factory = { surfaceView }, modifier = Modifier.size(300.dp))
                    HeartShapedCameraViewWithCircleBorder(surfaceView)
//        HeartShapedCameraViewWithImage(surfaceView)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Finger Detected: ${if (isFingerDetected) "Yes" else "No"}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = bpm,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black
                    )

//                    Button(onClick = {
//                        activity?.let {
//                            InterstitialAddssc(it)
//                        }
////                        InterstitialAddssc(activity = this)
//                    }) {
//                        Text(text = "add")
//                    }

                }
            }
        }
    )


}


@Composable
fun CameraPermissionScreen(onPermissionGranted: @Composable () -> Unit) {
    val permission = listOf(android.Manifest.permission.CAMERA)
    val isGranted = remember { mutableStateOf(false) }
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        isGranted.value = permissions[Manifest.permission.CAMERA] == true
    }

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_GRANTED
        ) {
            isGranted.value = true
        } else {
            launcher.launch(permission.toTypedArray())
        }
    }

    if (isGranted.value) {
        onPermissionGranted()  // Call when permission is granted
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Camera permission is required to continue.")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { launcher.launch(permission.toTypedArray()) }) {
                Text(text = "Grant Permission")
            }
        }
    }
}

//@Composable
//fun HeartShapedCameraViewWithBorder(surfaceView: SurfaceView) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(200.dp) // Outer border size
//            .border(
//                width = 16.dp,
//                color = circuler,
//                shape = CircleShape // Circular border around heart shape
//            )
//            .padding(10.dp) // Padding between the border and heart
//            .clip(HeartIconShape()) // Clip the heart shape inside
//            .background(Color.LightGray)
//    ) {
//        AndroidView(
//            factory = { surfaceView },
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}


fun checkInternett(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}


//fun HeartIconShape() = GenericShape { size, _ ->
//    val width = size.width
//    val height = size.height
//
//    moveTo(width / 2f, height * 0.25f)
//    cubicTo(width * 0.1f, 0f, 0f, height * 0.4f, width / 2f, height)
//    cubicTo(width, height * 0.4f, width * 0.9f, 0f, width / 2f, height * 0.25f)
//}





//@Composable
//fun HeartShapedCameraView(surfaceView: SurfaceView) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(150.dp)
//            .clip(HeartIconShape()) // Apply heart shape clipping
//            .background(Color.Red.copy(alpha = 0.1f))
//    ) {
//        AndroidView(
//            factory = { surfaceView },
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}

//botom appbar
//bottomBar = {
//    NavigationBar (
//        modifier = Modifier.height(70.dp).padding(top = 16.dp)
//    ){
//        items.forEachIndexed { index, botomitem ->
//            NavigationBarItem(selected = selectedItem == index,
//                onClick = {
//                    selectedItem = index
//                },
//                label = {
//                    Text(text = botomitem.title)
//                },
//                icon = {
//                    Icon(
//                        imageVector = if (index == selectedItem) botomitem.selectedicon else botomitem.unselectedicon,
//                        contentDescription = botomitem.title,
//                        modifier = Modifier.size(24.dp)
//
//                    )
//
//                }
//            )
//
//        }
//    }
//},





//@Composable
//fun HeartShapedCameraViewWithBorder(surfaceView: SurfaceView) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(240.dp) // Outer size for border
//            .background(Color.Transparent)
//    ) {
//        // Border layer (Heart Shape)
//        Box(
//            modifier = Modifier
//                .size(240.dp)
//                .graphicsLayer {
//                    shadowElevation = 8.dp.toPx()
//                    shape = CircleShape
//                    clip = true
//                }
//                .background(circuler) // Border color
//        )
//
//        // Inner heart with camera preview
//        Box(
//            modifier = Modifier
//                .size(220.dp) // Slightly smaller to show the border
//                .clip(HeartIconShape())
//                .background(Color.LightGray)
//        ) {
//            AndroidView(
//                factory = { surfaceView },
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//    }
//}
//
//// 🎯 Improved and Symmetrical Heart Shape Function
//fun HeartIconShape() = GenericShape { size, _ ->
//    val width = size.width
//    val height = size.height
//
//    moveTo(width / 2f, height * 0.2f)
//
//    // Left curve of the heart
//    cubicTo(
//        width * 0.05f, height * 0.0f,    // Control point for top left
//        0f, height * 0.4f,               // Bottom left arc
//        width / 2f, height               // Bottom center point
//    )
//
//    // Right curve of the heart
//    cubicTo(
//        width, height * 0.4f,            // Bottom right arc
//        width * 0.95f, height * 0.0f,    // Control point for top right
//        width / 2f, height * 0.2f        // Top center
//    )
//}



@Composable
fun HeartShapedCameraViewWithCircleBorder(surfaceView: SurfaceView) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(300.dp) // Outer size for border
            .background(Color.Transparent)
    ) {
        // Circle Border Layer
        Box(
            modifier = Modifier
                .size(270.dp).border(
                width = 16.dp,
                color = circuler,
                shape = CircleShape // Circular border around heart shape
            )
//                .clip(CircleShape) // Circular border shape
//                .background(color = Color.LightGray) // Border color
        )

        // Inner heart with camera preview
        Box(
            modifier = Modifier
                .size(200.dp) // Slightly smaller to show the border
                .clip(HeartIconShape()) // Heart shape for the camera preview
//                .background(Color.LightGray)
        ) {
            AndroidView(
                factory = { surfaceView },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

// 🎯 Improved Heart Shape Function
fun HeartIconShape() = GenericShape { size, _ ->
    val width = size.width
    val height = size.height

    moveTo(width / 2f, height * 0.2f)

    // Left curve of the heart
    cubicTo(
        width * 0.05f, height * 0.0f,    // Control point for top left
        0f, height * 0.4f,               // Bottom left arc
        width / 2f, height               // Bottom center point
    )

    // Right curve of the heart
    cubicTo(
        width, height * 0.4f,            // Bottom right arc
        width * 0.95f, height * 0.0f,    // Control point for top right
        width / 2f, height * 0.2f        // Top center
    )
}
