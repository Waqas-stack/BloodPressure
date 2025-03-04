package com.o9tech.heartratemonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.android.gms.ads.MobileAds
import com.o9tech.heartratemonitor.ui.theme.BloodPressureTheme
import com.o9tech.heartratemonitor.ui.theme.Screens.CameraUp.CameraViewModel
import com.o9tech.heartratemonitor.ui.theme.Screens.DailySettings.DailySettingsSceen
import com.o9tech.heartratemonitor.ui.theme.Screens.FAQ.FaqScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.FeedBack.FeedBackScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.GernalSettings.GernalScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.HeartRateMeasurment.HeartRateMonitorScreen
//import com.o9tech.bloodpressure.ui.theme.Screens.HealthArticleDetail.camerapermission
import com.o9tech.heartratemonitor.ui.theme.Screens.Information.InformationScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Language.LanguagesScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.MainScreen.MainScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.RecipesDetails.DetailsScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.RecipesDetails.DetailssScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.RecipesDetails.DetailssssScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Remminder.ReminderScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.StressLevel.StressLevelSreen
import com.o9tech.heartratemonitor.ui.theme.Screens.TargetRange.TargetRangeScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.Tracker.TrackerScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.UnitSettings.UnintSettingsScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.bettersleep.BetterSleepScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.camera.BloodPressureViewModel
import com.o9tech.heartratemonitor.ui.theme.Screens.healthArticlsdetail.RecipeCategory
import com.o9tech.heartratemonitor.ui.theme.Screens.newRecord.NewRecordScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.weight.weightScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        val controller = WindowInsetsControllerCompat(window, window.decorView)
        // Configure to hide only the navigation bar
//        controller.hide(WindowInsetsCompat.Type.navigationBars()) // Hide navigation bar
//        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

//        enableEdgeToEdge()
//        if (!hasrequiredpermission()) {
////            requestPermissions(CameraX_Permission, 0)
//            ActivityCompat.requestPermissions(this, CameraX_Permission, 0)
//        }
        MobileAds.initialize(this)
        setContent {
            val bloodPressureViewModel: BloodPressureViewModel = viewModel()
            val cameraViewModel: CameraViewModel = viewModel()
            val scope = rememberCoroutineScope()
            val navController = rememberNavController()
            BloodPressureTheme {


                NavHost(navController = navController, startDestination = "MainScreen") {
                    composable("MainScreen") {
                        MainScreen(navController)
                    }

                    composable("GernalScreen") {
                        GernalScreen(navController)
                    }
                    composable("DailySettingsSceen") {
                        DailySettingsSceen(navController)
                    }
                    composable("TargetRangeScreen") {
                        TargetRangeScreen(navController)
                    }
                    composable("ReminderScreen") {
                        ReminderScreen(navController)
                    }
                    composable("UnintSettingsScreen") {
                        UnintSettingsScreen(navController)
                    }
                    composable("FaqScreen") {
                        FaqScreen(navController)
                    }
                    composable("LanguagesScreen") {
                        LanguagesScreen(navController)
                    }
                    composable("InformationScreen") {
                        InformationScreen(navController)
                    }
                    composable("BetterSleepScreen") {
                        BetterSleepScreen(navController)
                    }
                    composable(
                        "details/{articleId}",
                        arguments = listOf(navArgument("articleId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val articleId = backStackEntry.arguments?.getInt("articleId") ?: 0
                        DetailsScreen(navController, articleId)
                    }
                    composable("RecipeCategory") {
                        RecipeCategory(navController)
                    }
                    composable(
                        route = "detailss/{itemId}",
                        arguments = listOf(navArgument("itemId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemId = backStackEntry.arguments?.getInt("itemId") ?: 0
                        DetailssScreen(itemId, navController)
                    }
                    composable("DetailssssScreen") {
                        DetailssssScreen(navController)
                    }
//                    composable("camerapermission") {
//                        camerapermission()
//                    }
                    composable("HeartRateMonitorScreen") {
                        HeartRateMonitorScreen(navController)
                    }
                    composable("weightScreen") {
                        weightScreen(navController)
                    }
                    composable("TrackerScreen") {
                        TrackerScreen(navController)
                    }
                    composable("NewRecordScreen") {
                        NewRecordScreen(navController)
                    }
                    composable("StressLevelSreen") {
                        StressLevelSreen(navController)
                    }
                    composable("FeedBackScreen") {
                        FeedBackScreen(navController)
                    }
//                    composable("TrackerCategoryScreen") {
//                        TrackerCategoryScreen()
//                    }

//                    composable("BloodPressureScreen") {
//                        BloodPressureScreen(bloodPressureViewModel)
//                    }
                }


//                val scaffoldState = rememberBottomSheetScaffoldState()
//                val controller = remember {
//                    LifecycleCameraController(applicationContext).apply {
//                        setEnabledUseCases(
//                            CameraController.IMAGE_CAPTURE or
//                                    CameraController.VIDEO_CAPTURE
//                        )
//                    }
//                }
//
//                val bitmap by cameraViewModel.bitmaps.collectAsState()
//                BottomSheetScaffold(
//                    scaffoldState = scaffoldState,
//                    sheetPeekHeight = 0.dp,
//                    sheetContent = {
//                        BottomSheet(
//                            bitmap = bitmap,
//                           modifier = Modifier.fillMaxWidth()
//                        )
//                    }) { paddingValues ->
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(paddingValues)
//                    ) {
//                        Camerappreview(
//                            controller = controller,
//                            modifier = Modifier.fillMaxSize()
//                        )
//                        IconButton(
//                            onClick = {
//                                controller.cameraSelector =
//                                    if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
//                                        CameraSelector.DEFAULT_FRONT_CAMERA
//                                    } else {
//                                        CameraSelector.DEFAULT_BACK_CAMERA
//                                    }
//                            },
//                            modifier = Modifier.offset(16.dp, 16.dp)
//                        ) {
//                            Icon(imageVector = Icons.Default.Call, contentDescription = "Camera")
//                        }
//
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .align(Alignment.BottomCenter)
//                                .padding(16.dp),
//                            horizontalArrangement = Arrangement.SpaceAround
//                        ) {
//                            IconButton(onClick = {
//                                scope.launch {
//                                    scaffoldState.bottomSheetState.expand()
//                                }
//                            }) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "photo"
//                                )
//                            }
//                            IconButton(onClick = { /*TODO*/ }) {
//                                Icon(
//                                    imageVector = Icons.Default.Settings,
//                                    contentDescription = "take photo"
//                                )
//                            }
//                            IconButton(onClick = {
//                                TakePhoto(
//                                    controller = controller,
//                                    onPhotoTaken = cameraViewModel::onTakePhoto
//                                )
//                            }) {
//                                Icon(
//                                    imageVector = Icons.Default.CheckCircle,
//                                    contentDescription = "take photo"
//                                )
//                            }
//                        }
//                    }

            }
//                NavHost(navController = navController, startDestination = "InformationScreen") {
//                    composable("ProfileScreen") {
//                        InformationScreen(navController)
//                    }
//                    composable("DetailsInformationSceen") {
//                        DetailsInformationSceen()
//                    }
//                }


//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//                BloodPressureScreen(homeViewModel)
//                MainScreen()
//                ProfileScreen()
//                MeasureScreen()
//                TrackerScreen()
//                GernalScreen()
//                ReminderScreen()
//                DailySettingsSceen()
//                InformationScreen()
//                DailyScreen()
//                HeartRateScreen()
//                DetailsScreen()
//                TargetRangeScreen()
//                FaqScreen()
        }

    }
}

//    private fun TakePhoto(
//        controller: LifecycleCameraController,
//        onPhotoTaken: (Bitmap) -> Unit
//    ) {
//        controller.takePicture(
//            ContextCompat.getMainExecutor(applicationContext),
//            object : ImageCapture.OnImageCapturedCallback(){
//                override fun onCaptureSuccess(image: ImageProxy) {
//                    super.onCaptureSuccess(image)
//                    val matrix = Matrix().apply {
//                        postRotate(image.imageInfo.rotationDegrees.toFloat())
////                        postScale(-1f, 1f)
//                    }
//                    val originalBitmap = image.toBitmap()
//
//                    if (originalBitmap != null) {
//                        // Ensure dimensions are within bounds
//                        val rotatedBitmap = Bitmap.createBitmap(
//                            originalBitmap,
//                            0,
//                            0,
//                            originalBitmap.width.coerceAtMost(image.width),
//                            originalBitmap.height.coerceAtMost(image.height),
//                            matrix,
//                            true
//                        )
//                        onPhotoTaken(rotatedBitmap)
//                    } else {
//                        Log.e("BitmapDebug", "Bitmap conversion failed.")
//                    }
//
////                    val rotatedBitmap = Bitmap.createBitmap(
////                        image.toBitmap(),
////                        0,
////                        0,
////                        image.width,
////                        image.height, matrix, true
////                    )
//
//
//
//                }
//                override fun onError(exception: ImageCaptureException) {
//                    super.onError(exception)
//                    Log.e("CameraX", "Error taking photo", exception)
//                }
//            }
//        )
//    }
//
//    private fun hasrequiredpermission(): Boolean {
////        return CameraX_Permission.all {
////            checkSelfPermission(android.Manifest.permission.CAMERA) == android.content.pm.PackageManager.PERMISSION_GRANTED
////        }
//        return CameraX_Permission.all {
//            ContextCompat.checkSelfPermission(
//                applicationContext, it
//            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
//        }
//    }
//
//    companion object {
//        private val CameraX_Permission = arrayOf(
//            android.Manifest.permission.CAMERA,
//            android.Manifest.permission.RECORD_AUDIO
//        )
//    }
//}

