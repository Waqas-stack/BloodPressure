package com.o9tech.heartratemonitor.ui.theme.Screens.camera

import android.util.Log
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class CameraViewmodel @Inject constructor():ViewModel() {
//
//    private val _lightData = MutableStateFlow<List<Float>>(emptyList())
//    val lightData: StateFlow<List<Float>> = _lightData
//
//    fun processFrame(frame: ImageProxy) {
//        val buffer = frame.planes[0].buffer
//        val data = ByteArray(buffer.remaining())
//        buffer.get(data)
//
//        // Simplistic light intensity processing
//        val avgLight = data.map { it.toInt() and 0xFF }.average().toFloat()
//
//        _lightData.update { it + avgLight }
//        frame.close()
//    }
//}
//@HiltViewModel
//class BloodPressureViewModel @Inject constructor() : ViewModel() {
//    private val _heartRate = MutableStateFlow(0)
//    val heartRate: StateFlow<Int> get() = _heartRate
//
//    fun processImage(image: ImageProxy) {
//        // Implement PPG processing here to calculate heart rate
//        // Example: Analyze red intensity changes over time.
//    }
//}

//@HiltViewModel
//class BloodPressureViewModel @Inject constructor() : ViewModel() {
//    private val _heartRate = MutableStateFlow(0)
//    val heartRate: StateFlow<Int> get() = _heartRate
//
//    private val intensityReadings = mutableListOf<Long>()
//    private val samplingRate = 30 // 30 frames per second
//
//    fun processImage(image: ImageProxy) {
//        val buffer = image.planes[0].buffer
//        val data = ByteArray(buffer.remaining())
//        buffer.get(data)
//
//        // Calculate average red intensity
//        val avgRedIntensity = calculateRedIntensity(data, image.width, image.height)
//
//        // Store the intensity timestamp
//        val currentTime = System.currentTimeMillis()
//        intensityReadings.add(currentTime)
//
//        // Analyze readings
//        if (intensityReadings.size >= samplingRate * 5) { // Analyze over a 5-second window
//            calculateHeartRate()
//            intensityReadings.clear()
//        }
//
//        image.close()
//    }
//
//    private fun calculateRedIntensity(data: ByteArray, width: Int, height: Int): Double {
//        var redSum = 0
//        var pixelCount = 0
//
//        // Iterate over pixels and sum red values
//        for (i in data.indices step 4) { // Assuming RGBA
//            redSum += data[i].toInt() and 0xFF // Extract red channel
//            pixelCount++
//        }
//
//        return redSum.toDouble() / pixelCount
//    }
//
//    private fun calculateHeartRate() {
//        val intervals = intensityReadings.zipWithNext { a, b -> b - a }
//        val avgInterval = intervals.average()
//        val bpm = if (avgInterval > 0) (60_000 / avgInterval).toInt() else 0
//        _heartRate.value = bpm
//    }
//}


//@HiltViewModel
//class BloodPressureViewModel @Inject constructor() : ViewModel() {
//    private val _heartRate = MutableStateFlow(0)
//    val heartRate: StateFlow<Int> get() = _heartRate
//
//    private val intensityReadings = mutableListOf<Long>()
//    private val samplingRate = 30 // 30 frames per second
//
//    // To process the image in a background thread
//    private val coroutineScope = CoroutineScope(Dispatchers.Default)
//
//    fun processImage(image: ImageProxy) {
//        // Run image processing in a background thread
//        coroutineScope.launch {
//            val buffer = image.planes[0].buffer
//            val data = ByteArray(buffer.remaining())
//            buffer.get(data)
//
//            // Calculate average red intensity
//            val avgRedIntensity = calculateRedIntensity(data, image.width, image.height)
//
//            // Store the intensity timestamp
//            val currentTime = System.currentTimeMillis()
//            intensityReadings.add(currentTime)
//
//            // Analyze readings after 5 seconds (samplingRate * 5)
//            if (intensityReadings.size >= samplingRate * 5) {
//                calculateHeartRate()
//                intensityReadings.clear()
//            }
//
//            image.close()
//        }
//    }
//
//    private fun calculateRedIntensity(data: ByteArray, width: Int, height: Int): Double {
//        var redSum = 0
//        var pixelCount = 0
//
//        // Iterate over pixels and sum red values
//        for (i in data.indices step 4) { // Assuming RGBA format (4 bytes per pixel)
//            val red = data[i].toInt() and 0xFF // Extract the red channel (first byte of RGBA)
//            redSum += red
//            pixelCount++
//        }
//
//        return redSum.toDouble() / pixelCount
//    }
//
//    private fun calculateHeartRate() {
//        // Calculate time intervals between successive intensity readings
//        val intervals = intensityReadings.zipWithNext { a, b -> b - a }
//
//        // Calculate average interval
//        val avgInterval = intervals.average()
//
//        // Calculate BPM if there's a valid interval
//        val bpm = if (avgInterval > 0) (60_000 / avgInterval).toInt() else 0
//
//        // Update the heart rate state
//        _heartRate.value = bpm
//    }
//}


@HiltViewModel
class BloodPressureViewModel @Inject constructor() : ViewModel() {
    private val _heartRate = MutableStateFlow(0)
    val heartRate: StateFlow<Int> get() = _heartRate

    private val intensityReadings = mutableListOf<Long>()
    private val samplingRate = 30 // 30 frames per second

    // To process the image in a background thread
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun processImage(image: ImageProxy) {
        coroutineScope.launch {
            val buffer = image.planes[0].buffer
            val data = ByteArray(buffer.remaining())
            buffer.get(data)

            Log.d("BloodPressureViewModel", "Processing image, data size: ${data.size}")

            val avgRedIntensity = calculateRedIntensity(data, image.width, image.height)

            val currentTime = System.currentTimeMillis()
            intensityReadings.add(currentTime)
            Log.d("BloodPressureViewModel", "Avg Red Intensity: $avgRedIntensity")
            if (intensityReadings.size >= samplingRate * 5) {
                calculateHeartRate()
                intensityReadings.clear()
            }
            image.close()




        }
    }

    private fun calculateRedIntensity(data: ByteArray, width: Int, height: Int): Double {
        var redSum = 0
        var pixelCount = 0

        for (i in data.indices step 4) {
            val red = data[i].toInt() and 0xFF
            redSum += red
            pixelCount++
        }

        return if (pixelCount > 0) redSum.toDouble() / pixelCount else 0.0
    }

    private fun calculateHeartRate() {
        val intervals = intensityReadings.zipWithNext { a, b -> b - a }

        Log.d("BloodPressureViewModel", "Intervals: $intervals")
        val avgInterval = intervals.average()
        Log.d("BloodPressureViewModel", "Avg Interval: $avgInterval")
        val bpm = if (avgInterval > 0) (60_000 / avgInterval).toInt() else 0
        Log.d("BloodPressureViewModel", "Calculated BPM: $bpm")
        _heartRate.value = bpm
    }
}
