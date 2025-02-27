package com.o9tech.heartratemonitor.ui.theme.Screens.HeartRateMeasurment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.PointF
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.SurfaceView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
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
import androidx.compose.material3.Button
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.graphics.plus
import androidx.core.graphics.times
import androidx.navigation.NavHostController
import com.google.android.gms.ads.AdSize
import com.o9tech.heartratemonitor.R
import com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds.BannersAds
import com.o9tech.heartratemonitor.ui.theme.Screens.Interstitialadd.InterstitialAddssc
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.checkInternet
import com.o9tech.heartratemonitor.ui.theme.circuler
import com.o9tech.heartratemonitor.ui.theme.lightgray
import io.reactivex.disposables.Disposable
import net.kibotu.heartrateometer.HeartRateOmeter
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


import androidx.compose.animation.core.*
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeartRateMonitorScreen(navController: NavHostController) {
    var bpm by remember { mutableStateOf("Waiting for BPM...") }
    var isFingerDetected by remember { mutableStateOf(false) }
    var disposable: Disposable? by remember { mutableStateOf(null) }
    val context = LocalContext.current
    val activity = context as? Activity
    val surfaceView = remember { SurfaceView(context) }

    val isInternetAvailable = remember { mutableStateOf(checkInternett(context)) }
    var bpmValue by remember { mutableStateOf(0) }
    var oldvalue by remember { mutableStateOf(0) }
    var isMeasuring by remember { mutableStateOf(false) }
    var loadInterstitialAd by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isInternetAvailable.value = checkInternet(context)
    }

    var interstitialAd: InterstitialAd? by remember { mutableStateOf(null) }

    LaunchedEffect(loadInterstitialAd) {
        if(loadInterstitialAd){
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712",
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(error: LoadAdError) {
                    println("Ad failed to load: ${error.message}")

                }

                override fun onAdLoaded(loadedAd: InterstitialAd) {
                    println("Ad Loaded Successfully")
                    interstitialAd = loadedAd
                }
            }
        )
    }
    }




    LaunchedEffect(bpmValue) {
        if (bpmValue > 0) {
            loadInterstitialAd = false
            isInternetAvailable.value = checkInternet(context)
            if (isInternetAvailable.value && interstitialAd != null) {
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        println("Ad dismissed, resetting value...")
//                        bpmValue = 0 // Reset BPM after ad is dismissed
                        interstitialAd = null // Clear ad reference
                        oldvalue = bpmValue
                        loadInterstitialAd=true
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        println("Ad failed to show: ${adError.message}")
                        interstitialAd = null
                    }
                }

                // 🔥 Show the Ad
//                interstitialAd?.show(co)
                activity?.let {
                    interstitialAd?.show(it)
                }
            }
        }
    }



//    LaunchedEffect(bpmValue) {
//        if (bpmValue > 0) {
//            isInternetAvailable.value = checkInternett(context)
//            if (isInternetAvailable.value) {
//                activity?.let {
//                    InterstitialAddssc(it) {
//                        oldvalue = bpmValue
//                    }
//                }
//            }
//        }
//    }

    CameraPermissionScreen {
//            DisposableEffect(Unit) {
//                val heartRateOmeter = HeartRateOmeter()
//                    .setFingerDetectionListener { detected ->
//                        isFingerDetected = detected
//                        isMeasuring = detected
//                        println("--thevalue--   ${isMeasuring}")
//                        bpm = "Measuring..."
//                    }
//                    .withAverageAfterSeconds(10)
//                disposable = heartRateOmeter.bpmUpdates(surfaceView).subscribe { data ->
//                    bpmValue = data.value
//                    bpm = if (data.value > 0) "${data.value} BPM" else "Measuring..."
//                }
//                onDispose { disposable?.dispose() }
//            }
        DisposableEffect(Unit) {
            val heartRateOmeter = HeartRateOmeter()
                .setFingerDetectionListener { detected ->
                    isFingerDetected = detected
                    isMeasuring = detected
                    println("--thevalue--   ${isMeasuring}")
//                    bpm = "Measuring..."
                }
                .withAverageAfterSeconds(10)
            disposable = heartRateOmeter.bpmUpdates(surfaceView).subscribe { data ->
                val newValue = data.value
                if (newValue != oldvalue && newValue > 0) {
                    bpmValue = newValue
                    bpm = "$newValue BPM"
                } else {
                    bpm = "Measuring..."
                }
//                bpm = if (data.value > 0) "${data.value} BPM" else "Measuring..."
            }
            onDispose { disposable?.dispose() }
        }

    }
    Scaffold(
        topBar = {
            Column {
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
                            navController.popBackStack()
                        }) {
                            Text(text = "Cancel", fontWeight = FontWeight.Bold, color = Color.Black)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = lightgray
                    ),
                )
                if (isInternetAvailable.value) {
                    BannersAds(modifier = Modifier.fillMaxWidth(), adSize = AdSize.BANNER)
                }
            }
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Place your finger on the camera lens.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HeartShapedCameraViewWithAnimatedCircleBordaer(surfaceView, isMeasuring)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Finger Detected: ${if (isFingerDetected) "Detecting..." else "No"}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )


                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = bpm,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.Black
                    )

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
        onPermissionGranted()
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


fun checkInternett(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}


@Composable
fun HeartShapedCameraViewWithAnimatedCircleBordaer(
    surfaceView: SurfaceView,
    isMeasuring: Boolean,
) {

    val progresss = remember { mutableStateOf(0f) }

    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(isMeasuring) {
        var job: Job? = null
        if (isMeasuring) {
            job = coroutineScope.launch {
                for (i in 0..100) {
                    progresss.value = (i.toFloat() / 100)
                    delay(100L)
                }
            }
        }
        onDispose {
            job?.cancel()
            progresss.value = 0f
        }


    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(200.dp)
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .border(
                    width = 15.dp,
                    color = circuler,
                    shape = CircleShape
                )
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(140.dp)
        ) {
            CircularProgressIndicator(
                progress = progresss.value,
                strokeWidth = 15.dp,
                color = Color.Red,
                modifier = Modifier
                    .size(140.dp)
            )
        }
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(BulkyHeartShape2())
        ) {
            AndroidView(
                factory = { surfaceView },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


fun BulkyHeartShape2(): Shape = GenericShape { size, _ ->
    val width = size.width
    val height = size.height
    moveTo(width / 2f, height * 0.20f)

    cubicTo(
        width * 0.1f, height * 0f,
        width * -0.1f, height * 0.5f,
        width / 2f, height
    )
    cubicTo(
        width * 1.1f, height * 0.5f,
        width * 0.9f, height * 0f,
        width / 2f, height * 0.20f
    )
    close()
}


//
//@Composable
//fun HeartShapedCameraViewWithCircleBorders(surfaceView: SurfaceView) {
//    val infiniteTransition = rememberInfiniteTransition()
//    val angle by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 100500, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        )
//    )
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(200.dp)
//            .background(Color.Transparent)
//    ) {
//        // Border Layer
//        Box(
//            modifier = Modifier
//                .size(170.dp)
//                .border(
//                    width = 16.dp,
//                    color = circuler,
//                    shape = CircleShape
//                )
//        )
//
//        // Flowing Animation Layer Inside Border
//        Canvas(
//            modifier = Modifier.size(150.dp)
//        ) {
//            val stroke = 10.dp.toPx()
//            val diameter = size.minDimension
//            val arcRect = Rect(
//                left = stroke / 2,
//                top = stroke / 2,
//                right = diameter - stroke / 2,
//                bottom = diameter - stroke / 2
//            )
//
//            drawArc(
//                color = Color.Red,
//                startAngle = angle,
//                sweepAngle = 90f,
//                useCenter = false,
//                style = Stroke(width = stroke)
//            )
//        }
//
//        // Heart-shaped Camera Preview
//        Box(
//            modifier = Modifier
//                .size(120.dp)
//                .clip(BulkyHeartShape2())
//        ) {
//            AndroidView(
//                factory = { surfaceView },
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//    }
//}
//
//// Bulky Heart Shape
//
//
//@Composable
//fun HeartShapedCameraViewWithAnimatedCircleBorder(surfaceView: SurfaceView) {
//    val infiniteTransition = rememberInfiniteTransition(label = "borderAnimation")
//    var isround by remember { mutableStateOf(false) }
//    val borderraduis by animateIntAsState(
//        targetValue = if (isround) 100 else 0,
//        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
//    )
//    val animatedValue by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 1000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        ), label = "rotateAnimation"
//    )
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(200.dp)
//            .background(Color.Transparent)
//    ) {
//        // Animated Border
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(170.dp)
//                .graphicsLayer {
//                    rotationZ = animatedValue // Rotation animation
//                }
//                .border(
//                    width = 18.dp,
//                    brush = Brush.sweepGradient(
//                        colors = listOf(Color.LightGray, Color.Transparent, Color.LightGray)
//                    ),
//                    shape = CircleShape
//                )
//        ) {
//            // Static Border inside animated layer
//            Box(
//                modifier = Modifier
//                    .size(165.dp)
//                    .border(
//                        width = 10.dp,
//                        color = Color.Red,
//                        shape = CircleShape
//                    )
//            )
//        }
//
//        // Heart-shaped Camera Preview
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(BulkyHeartShape2())
//        ) {
//            AndroidView(
//                factory = { surfaceView },
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//    }
//}
//
//// Heart Shape Function (Bulky with proper dip)
//
//
//@Composable
//fun HeartRateMonitorWithRotatingBorder(surfaceView: SurfaceView, isMeasuring: Boolean) {
//    val infiniteTransition = rememberInfiniteTransition(label = "borderRotation")
//    val animatedRotation by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = if (isMeasuring) 360f else 0f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 2000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        ), label = "rotationAnimation"
//    )
//
////    val animatedRotation by animateIntAsState(targetValue = )
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(240.dp)
//            .background(Color.Transparent)
//    ) {
//        // Rotating Border Animation - Only active when measuring
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier
//                .size(180.dp)
//                .graphicsLayer {
//                    rotationZ = if (isMeasuring) animatedRotation else 0f
//                }
//                .border(
//                    width = 18.dp,
//                    brush = Brush.sweepGradient(
//                        colors = listOf(
//                            Color.Red,
//                            Color.Transparent,
//                            Color.Red
//                        )
//                    ),
//                    shape = CircleShape
//                )
//        ) {
//            // Static Red Inner Border
//            Box(
//                modifier = Modifier
//                    .size(160.dp)
//                    .border(
//                        width = 10.dp,
//                        color = Color.Red,
//                        shape = CircleShape
//                    )
//            )
//        }
//
//        // Heart-shaped Camera Preview
//        Box(
//            modifier = Modifier
//                .size(130.dp)
//                .clip(BulkyHeartShape2())
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
//
//@Composable
//fun HeartShapedCameraViewWithAnimatedCircleBorder(surfaceView: SurfaceView, isMeasuring: Boolean) {
//    val animatedRotation by animateIntAsState(
//        targetValue = if (isMeasuring) 360 else 0,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 2000, delayMillis = 1000),
////            repeatMode = RepeatMode.Restart
//        )
//    )
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(200.dp)
//            .background(Color.Transparent)
//    ) {
//        // 🔥 Animated Border
//        Box(
//            modifier = Modifier
//                .size(170.dp)
//                .graphicsLayer {
//                    rotationZ = animatedRotation.toFloat()
//                }
//                .border(
//                    width = 16.dp,
//                    brush = Brush.sweepGradient(
//                        colors = listOf(Color.Red, Color.Transparent, Color.Red)
//                    ),
//                    shape = CircleShape
//                )
//        )
//
//        // ❤️ Heart-shaped Camera Preview
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(BulkyHeartShape2())
//        ) {
//            AndroidView(
//                factory = { surfaceView },
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//    }
//}
//
//@Composable
//fun HeartShapedCameraViewWithFlowingBorder(surfaceView: SurfaceView) {
//    val infiniteTransition = rememberInfiniteTransition()
//    val angle by infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 3000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        )
//    )
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(220.dp)
//            .background(Color.Transparent)
//    ) {
//        // Circular border with flowing red animation
//        Canvas(
//            modifier = Modifier.size(200.dp)
//        ) {
//            drawArc(
//                color = Color.Red,
//                startAngle = angle,
//                sweepAngle = 120f,
//                useCenter = false,
//                style = Stroke(width = 12.dp.toPx())
//            )
//        }
//
//        // Heart shape with camera preview
//        Box(
//            modifier = Modifier
//                .size(160.dp)
//                .clip(BulkyHeartShape2())
//                .background(Color.Black)
//        ) {
//            AndroidView(
//                factory = { surfaceView },
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//    }
//}
//
//
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
//
//
//fun HeartShape(): Shape = GenericShape { size, _ ->
//    // Start near the top-center
//    moveTo(size.width / 2, size.height * 0.2f)
//    // Right half of the heart
//    cubicTo(
//        size.width * 0.9f, 0f,
//        size.width, size.height * 0.3f,
//        size.width / 2, size.height
//    )
//    // Left half of the heart
//    cubicTo(
//        0f, size.height * 0.3f,
//        size.width * 0.1f, 0f,
//        size.width / 2, size.height * 0.2f
//    )
//    close()
//}
//
//fun BulkyHeartShape(): Shape = GenericShape { size, _ ->
//    val width = size.width
//    val height = size.height
//
//    // Start at the top center of the heart
//    moveTo(width / 2f, height * 0.25f)
//
//    // Left half of the heart with more "bulk"
//    cubicTo(
//        width * -0.2f, height * 0.2f,   // Control point for top left (wider curve)
//        width * 0.1f, height * 0.8f,    // Bottom left curve
//        width / 2f, height              // Bottom center point
//    )
//
//    // Right half of the heart with more "bulk"
//    cubicTo(
//        width * 0.9f, height * 0.8f,    // Bottom right curve
//        width * 1.2f, height * 0.2f,    // Control point for top right (wider curve)
//        width / 2f, height * 0.25f      // Top center
//    )
//    close()
//}
//
//
//
//
//
//fun SharpBulkyHeartShape(): Shape = GenericShape { size, _ ->
//    val width = size.width
//    val height = size.height
//
//    // Start at the top center dip of the heart
//    moveTo(width / 2f, height * 0.18f)
//
//    // Left half of the heart with sharper top curve
//    cubicTo(
//        width * 0.05f, height * -0.15f,  // Control point for sharp top left curve
//        0f, height * 0.4f,               // Bottom left curve
//        width / 2f, height               // Bottom center point
//    )
//
//    // Right half of the heart with sharper top curve
//    cubicTo(
//        width, height * 0.4f,            // Bottom right curve
//        width * 0.95f, height * -0.15f,  // Control point for sharp top right curve
//        width / 2f, height * 0.18f       // Top center dip
//    )
//    close()
//}
//

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


//@SuppressLint("RestrictedApi")
//@Composable
//fun HeartShapedCameraViewWithCircleBorder(surfaceView: SurfaceView) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(200.dp)
//            .background(Color.Transparent)
//    ) {
//        Box(
//            modifier = Modifier
//                .size(170.dp)
//                .border(
//                    width = 16.dp,
//                    color = circuler,
//                    shape = CircleShape
//                )
//        )
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(BulkyHeartShape2())
//        ) {
//            AndroidView(
//                factory = { surfaceView },
//                modifier = Modifier.fillMaxSize()
//            )
//
//        }
//    }
//}

