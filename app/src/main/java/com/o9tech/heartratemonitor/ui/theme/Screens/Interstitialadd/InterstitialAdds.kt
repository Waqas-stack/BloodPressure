package com.o9tech.heartratemonitor.ui.theme.Screens.Interstitialadd

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


fun InterstitialAddssc(activity: Activity) {

            InterstitialAd.load(
                activity,
                "ca-app-pub-3940256099942544/1033173712",
                AdRequest.Builder().build(),
                object :  InterstitialAdLoadCallback(){
                    override fun onAdFailedToLoad(p0: LoadAdError) {
                        super.onAdFailedToLoad(p0)
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        super.onAdLoaded(interstitialAd)
                        interstitialAd.show(activity)
                    }
                }
                )

        }
