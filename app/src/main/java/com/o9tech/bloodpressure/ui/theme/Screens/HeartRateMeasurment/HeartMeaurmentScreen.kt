package com.o9tech.bloodpressure.ui.theme.Screens.HeartRateMeasurment

import android.Manifest
import android.content.pm.PackageManager
import android.view.SurfaceView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.o9tech.bloodpressure.R
import com.o9tech.bloodpressure.ui.theme.appwhit
import com.o9tech.bloodpressure.ui.theme.circuler
import com.o9tech.bloodpressure.ui.theme.lightgray
import io.reactivex.disposables.Disposable
import net.kibotu.heartrateometer.HeartRateOmeter



@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeartRateMonitorScreen() {
    var bpm by remember { mutableStateOf("Waiting for BPM...") }
    var isFingerDetected by remember { mutableStateOf(false) }
    var disposable: Disposable? by remember { mutableStateOf(null) }
//    val context = navController.context
    val context = LocalContext.current
    val surfaceView = remember { SurfaceView(context) }

    CameraPermissionScreen {
        DisposableEffect(Unit) {
            val heartRateOmeter = HeartRateOmeter()
                .setFingerDetectionListener { detected -> isFingerDetected = detected }
                .withAverageAfterSeconds(10)

            disposable = heartRateOmeter.bpmUpdates(surfaceView).subscribe { data ->
                bpm = if (data.value > 0) "${data.value} BPM" else "Measuring..."
            }

            onDispose { disposable?.dispose() }
        }
    }

    Scaffold (
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
            Surface (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
//        AndroidView(factory = { surfaceView }, modifier = Modifier.size(300.dp))
                    HeartShapedCameraViewWithBorder(surfaceView)
//        HeartShapedCameraViewWithImage(surfaceView)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Finger Detected: ${if (isFingerDetected) "Yes" else "No"}", style = MaterialTheme.typography.bodyLarge, color = Color.Black)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = bpm, style = MaterialTheme.typography.headlineMedium, color = Color.Black)
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

@Composable
fun HeartShapedCameraViewWithBorder(surfaceView: SurfaceView) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(200.dp) // Outer border size
            .border(
                width = 16.dp,
                color = circuler,
                shape = CircleShape // Circular border around heart shape
            )
            .padding(10.dp) // Padding between the border and heart
            .clip(HeartIconShape()) // Clip the heart shape inside
            .background(Color.LightGray)
    ) {
        AndroidView(
            factory = { surfaceView },
            modifier = Modifier.fillMaxSize()
        )
    }
}



fun HeartIconShape() = GenericShape { size, _ ->
    val width = size.width
    val height = size.height

    moveTo(width / 2f, height * 0.25f)
    cubicTo(width * 0.1f, 0f, 0f, height * 0.4f, width / 2f, height)
    cubicTo(width, height * 0.4f, width * 0.9f, 0f, width / 2f, height * 0.25f)
}