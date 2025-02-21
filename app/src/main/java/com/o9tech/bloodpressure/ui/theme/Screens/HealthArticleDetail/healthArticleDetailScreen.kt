package com.o9tech.bloodpressure.ui.theme.Screens.HealthArticleDetail

import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.provider.MediaStore
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import android.util.Log

import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine





import android.graphics.ImageFormat
import android.graphics.YuvImage

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy



import java.io.ByteArrayOutputStream

//@Composable
//fun BloodPressureApp() {
//    val context = LocalContext.current
//    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
//    var pulseRate by remember { mutableStateOf(0) }
//
//    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
//        Text(text = "Blood Pressure Monitoring", style = MaterialTheme.typography.headlineMedium)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        AndroidView(factory = { ctx ->
//            SurfaceView(ctx).apply {
//                holder.addCallback(object : SurfaceHolder.Callback {
//                    override fun surfaceCreated(holder: SurfaceHolder) {
//                        val cameraProvider = cameraProviderFuture.get()
//                        val preview = Preview.Builder().build().also {
////                            it.setSurfaceProvider(holder.surface)
//                        }
//
//                        val analyzer = ImageAnalysis.Builder()
//                            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                            .build()
//                            .also { analysis ->
//                                analysis.setAnalyzer(ContextCompat.getMainExecutor(ctx), LuminosityAnalyzer { bpm ->
//                                    pulseRate = bpm
//                                })
//                            }
//
//                        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//                        try {
//                            cameraProvider.unbindAll()
//                            cameraProvider.bindToLifecycle(context as LifecycleOwner, cameraSelector, preview, analyzer)
//                        } catch (e: Exception) {
//                            Log.e("Camera", "Binding failed", e)
//                        }
//                    }
//
//                    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}
//                    override fun surfaceDestroyed(holder: SurfaceHolder) {}
//                })
//            }
//        }, modifier = Modifier.fillMaxWidth().height(300.dp))
//
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = "Pulse Rate: $pulseRate BPM", style = MaterialTheme.typography.headlineMedium)
//    }
//}
//
//private class LuminosityAnalyzer(private val listener: (Int) -> Unit) : ImageAnalysis.Analyzer {
//    override fun analyze(image: ImageProxy) {
//        val buffer = image.planes[0].buffer
//        val data = ByteArray(buffer.remaining())
//        buffer.get(data)
//        val averageLuma = data.average()
//
//        val bpm = calculateBPM(averageLuma)
//        listener(bpm)
//
//        image.close()
//    }
//
//    private fun calculateBPM(averageLuma: Double): Int {
//        // Simulated logic - real logic would use multiple frames over time
//        return (averageLuma / 2).toInt()
//    }
//}


@Composable
fun camerapermission() {
    val permission= listOf(
        android.Manifest.permission.CAMERA,
    )
    val isGranted = remember {
        mutableStateOf(false)
    }

    val context= LocalContext.current


    val launcher =rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = { permissions->
            isGranted.value = permissions.all { it.value }
        }

//                onResult = { permissions->
//            isGranted.value = permissions[android.Manifest.permission.CAMERA] == true
//        }

    )

//    LaunchedEffect(Unit){
//        isGranted.value = ContextCompat.checkSelfPermission(
//            context,
//            android.Manifest.permission.CAMERA
//
//        ) == PackageManager.PERMISSION_GRANTED
//    }


    if (isGranted.value){
        cameraApp()
//        BloodPressuareApp()
//        BloodPressureApp()
    }else{
        SideEffect {
            launcher.launch(permission.toTypedArray())
        }

//        Column (
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ){
//            Button(onClick = {
//                launcher.launch(permission.toTypedArray())
//
//            }) {
//                Text(text = "request permission")
//            }
//
//        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun cameraApp() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewview: PreviewView = remember {
        PreviewView(context)
    }

    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
    val preview = Preview.Builder().build()

    val imageCapture = remember {
        ImageCapture.Builder().build()
    }

    LaunchedEffect (Unit){
        val cameraProvider =context.getCameraprovider()
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(
            lifecycleOwner=lifecycleOwner,
            cameraSelector = cameraSelector,
            preview,
            imageCapture
        )
        preview.setSurfaceProvider(previewview.surfaceProvider)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        AndroidView(
            factory = { previewview },
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black.copy(alpha = 0.7f))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = {
                    capturephoto(imageCapture, context)
                }, modifier = Modifier
                    .size(50.dp)
                    .background(
                        Color.White,
                        CircleShape
                    )
                    .padding(8.dp)
                    .background(color = Color.Red, CircleShape)
            ) {

            }
        }
    }

}


private suspend fun Context.getCameraprovider(): ProcessCameraProvider =
    suspendCoroutine { continu ->
        val processCameraProvider = ProcessCameraProvider.getInstance(this)

        processCameraProvider.addListener(
            {
                continu.resume(processCameraProvider.get())
            },
            ContextCompat.getMainExecutor(this)
        )

    }


private fun capturephoto(imageCapture: ImageCapture, context: Context){
    val name = "Mycamera_${System.currentTimeMillis()}.jpg"

    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME,name)
        put(MediaStore.MediaColumns.MIME_TYPE,"image/jpeg")
        put(MediaStore.MediaColumns.RELATIVE_PATH,"Pictures")
    }
    val outputOptions = ImageCapture.OutputFileOptions.Builder(
        context.contentResolver,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        contentValues
    ).build()

    imageCapture.takePicture(
        outputOptions,ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback{
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                Toast.makeText(context,"photo saved",Toast.LENGTH_SHORT).show()

            }

            override fun onError(exception: ImageCaptureException) {
                Toast.makeText(context,"photo not saved",Toast.LENGTH_SHORT).show()
                TODO("Not yet implemented")
            }

        }
    )
}
















//@Composable
//fun BloodPressuareApp() {
//    val context = LocalContext.current
//    val lifecycleOwnaer = LocalLifecycleOwner.current
//
//    var redIntensity by remember { mutableStateOf(0) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Place your finger over the camera", color = Color.White, style = MaterialTheme.typography.headlineMedium)
//        Spacer(modifier = Modifier.height(20.dp))
//        Text(text = "Red Intensity: $redIntensity", color = Color.Red, style = MaterialTheme.typography.headlineMedium)
//    }
//
//    LaunchedEffect(Unit) {
//        startCamera(context, lifecycleOwnaer) { intensity ->
//            redIntensity = intensity
//        }
//    }
//}
//
//private fun startCamera(context: Context, lifecycleOwner: androidx.lifecycle.LifecycleOwner, onRedIntensityMeasured: (Int) -> Unit) {
//    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
//    cameraProviderFuture.addListener({
//        val cameraProvider = cameraProviderFuture.get()
//        val imageAnalyzer = ImageAnalysis.Builder().build().also {
//            it.setAnalyzer(ContextCompat.getMainExecutor(context)) { image ->
//                val intensity = analyzeImage(image)
//                onRedIntensityMeasured(intensity)
//                image.close()
//            }
//        }
//
//        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
//        try {
//            cameraProvider.unbindAll()
//            cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, imageAnalyzer)
//        } catch (exc: Exception) {
//            Log.e("Camera", "Use case binding failed", exc)
//        }
//    }, ContextCompat.getMainExecutor(context))
//}
//
//private fun analyzeImage(image: ImageProxy): Int {
//    val buffer = image.planes[0].buffer
//    val bytes = ByteArray(buffer.remaining())
//    buffer.get(bytes)
//
//    val yuvImage = YuvImage(bytes, ImageFormat.NV21, image.width, image.height, null)
//    val outputStream = ByteArrayOutputStream()
//    yuvImage.compressToJpeg(android.graphics.Rect(0, 0, image.width, image.height), 100, outputStream)
//
//    val argb = outputStream.toByteArray()
//
//    var redSum = 0
//    var pixelCount = argb.size / 4
//
//    for (i in argb.indices step 4) {
//        val r = argb[i].toInt() and 0xFF
//        redSum += r
//    }
//
//    return redSum / pixelCount
//}







@Composable
fun BloodPressureApp() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var redIntensity by remember { mutableStateOf(0) }

    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }

    LaunchedEffect(Unit) {
        val cameraProvider = cameraProviderFuture.get()
        val preview = Preview.Builder().build().also {
            it.setSurfaceProvider(null)
        }
        val imageAnalyzer = ImageAnalysis.Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
            .also {
                it.setAnalyzer(ContextCompat.getMainExecutor(context)) { image ->
                    val intensity = calculateRedIntensity(image)
                    redIntensity = intensity
                    image.close()
                }
            }

        val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, preview, imageAnalyzer)
        } catch (e: Exception) {
            Log.e("Camera", "Use case binding failed", e)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Red Intensity: $redIntensity", color = Color.White)
    }
}

private fun calculateRedIntensity(image: ImageProxy): Int {
    val planes = image.planes
    val yBuffer = planes[0].buffer
    val uBuffer = planes[1].buffer
    val vBuffer = planes[2].buffer

    val data = ByteArray(yBuffer.remaining())
    yBuffer.get(data)

    val yuvImage = YuvImage(data, ImageFormat.NV21, image.width, image.height, null)
    val out = ByteArrayOutputStream()
    yuvImage.compressToJpeg(android.graphics.Rect(0, 0, image.width, image.height), 100, out)

    val bytes = out.toByteArray()

    // Process the bytes to calculate red intensity
    // This is a placeholder; actual calculation logic needs to be implemented
    return bytes.count { it.toInt() and 0xFF > 200 } // Simple check for intensity
}
