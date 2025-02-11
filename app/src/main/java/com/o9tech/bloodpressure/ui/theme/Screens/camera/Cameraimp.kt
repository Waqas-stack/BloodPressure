package com.o9tech.bloodpressure.ui.theme.Screens.camera

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.o9tech.bloodpressure.ui.theme.appbg
import com.o9tech.bloodpressure.ui.theme.appwhit
import java.util.concurrent.Executors

@SuppressLint("RememberReturnType")
@Composable
fun FingerScanScreen(viewModel: BloodPressureViewModel) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    val previewView = remember { PreviewView(context) }

    AndroidView(
        factory = { previewView },
        modifier = Modifier.fillMaxSize()
    )

    LaunchedEffect(Unit) {
        val cameraProvider = cameraProviderFuture.get()
        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(previewView.surfaceProvider)
        }
        val analyzer = ImageAnalysis.Builder().build().also {
            it.setAnalyzer(Executors.newSingleThreadExecutor(), { image ->
                viewModel.processImage(image)
                image.close()
            })
        }

        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                lifecycleOwner,
                cameraSelector,
                preview,
                analyzer
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}



@Composable
fun DisplayHeartRate(viewModel: BloodPressureViewModel) {
    val heartRate by viewModel.heartRate.collectAsState()

    LaunchedEffect(heartRate) {
        Log.d("BloodPressureApp", "Current Heart Rate: $heartRate BPM")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Heart Rate: $heartRate BPM", fontSize = 24.sp)
    }
}




//@Composable
//fun BloodPressureScreen(viewModel: BloodPressureViewModel) {
//    val lifecycleOwner = LocalLifecycleOwner.current
//    val context = LocalContext.current
//    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        // Camera Preview
//        AndroidView(
//            factory = { previewView ->
//                val preview = Preview.Builder().build()
//                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//
//                val cameraProvider = cameraProviderFuture.get()
////                preview.setSurfaceProvider(previewView.surfaceProvider)
//
//                // Set up ImageAnalysis
//                val imageAnalysis = ImageAnalysis.Builder()
//                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                    .build()
//                    .also { analysis ->
//                        analysis.setAnalyzer(Executors.newSingleThreadExecutor()) { imageProxy ->
//                            viewModel.processImage(imageProxy)
//                        }
//                    }
//
//                // Bind to lifecycle
//                cameraProvider.unbindAll()
//                cameraProvider.bindToLifecycle(
//                    lifecycleOwner,
//                    cameraSelector,
//                    preview,
//                    imageAnalysis
//                )
//
//                previewView
//            },
//            modifier = Modifier.fillMaxSize()
//        )
//
//        // Overlay for Heart Rate Display
//        Box(
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .fillMaxWidth()
//                .background(Color.White.copy(alpha = 0.8f))
//                .padding(16.dp)
//        ) {
//            DisplayHeartRate(viewModel = viewModel)
//        }
//    }
//}




@Composable
fun BloodPressureScreen(viewModel: BloodPressureViewModel) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Camera Preview
        AndroidView(
            factory = { previewView ->
                PreviewView(context).apply {
                    scaleType = PreviewView.ScaleType.FILL_CENTER
                }
            },
            modifier = Modifier.fillMaxSize(),
            update = { previewView ->
                val cameraProvider = cameraProviderFuture.get()
                val preview = Preview.Builder().build().apply {
                    setSurfaceProvider(previewView.surfaceProvider)
                }

                val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                // Set up ImageAnalysis
                val imageAnalysis = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                    .also { analysis ->
                        analysis.setAnalyzer(Executors.newSingleThreadExecutor()) { imageProxy ->
                            viewModel.processImage(imageProxy)
                        }
                    }

                // Bind to lifecycle
                try {
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageAnalysis
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        )

        // Overlay for Heart Rate Display
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(color = appwhit)
                .padding(16.dp)
        ) {
            DisplayHeartRate(viewModel = viewModel)
        }
    }
}
