package com.o9tech.heartratemonitor.ui.theme.Screens.BannerAds

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.o9tech.heartratemonitor.ui.theme.Screens.utils.AppConstants


@Composable
fun BannersAds(modifier: Modifier, adSize: AdSize = AdSize.BANNER){

    AndroidView(modifier = modifier.fillMaxWidth(), factory = {
        AdView(it).apply {
//            setAdSize(AdSize.FULL_BANNER)
            setAdSize(adSize)
            adUnitId = AppConstants.BANNER_AD_UNIT_ID
            loadAd(AdRequest.Builder().build())
        }
    })
}