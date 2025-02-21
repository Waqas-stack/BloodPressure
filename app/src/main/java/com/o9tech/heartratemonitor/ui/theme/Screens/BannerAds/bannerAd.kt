package com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


@Composable
fun BannersAds(modifier: Modifier, adSize: AdSize = AdSize.FULL_BANNER){
    AndroidView(modifier = modifier, factory = {
        AdView(it).apply {
//            setAdSize(AdSize.FULL_BANNER)
            setAdSize(adSize)
//            adUnitId = "ca-app-pub-3940256099942544/6300978111"
            adUnitId = "ca-app-pub-3940256099942544/9214589741"
            loadAd(AdRequest.Builder().build())
        }
    })
}