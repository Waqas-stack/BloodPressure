package com.o9tech.heartratemonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.android.gms.ads.MobileAds
import com.o9tech.heartratemonitor.ui.theme.BloodPressureTheme
import com.o9tech.heartratemonitor.ui.theme.Screens.DailySettings.DailySettingsSceen
import com.o9tech.heartratemonitor.ui.theme.Screens.FAQ.FaqScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.FeedBack.FeedBackScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.GernalSettings.GernalScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.HeartRateMeasurment.HeartRateMonitorScreen
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
import com.o9tech.heartratemonitor.ui.theme.Screens.healthArticlsdetail.RecipeCategory
import com.o9tech.heartratemonitor.ui.theme.Screens.newRecord.NewRecordScreen
import com.o9tech.heartratemonitor.ui.theme.Screens.weight.weightScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        installSplashScreen()
        MobileAds.initialize(this)

        setContent {
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

                }

            }
        }

    }
}


