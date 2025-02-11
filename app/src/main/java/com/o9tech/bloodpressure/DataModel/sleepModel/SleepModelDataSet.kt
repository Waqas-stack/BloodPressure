package com.o9tech.bloodpressure.DataModel.sleepModel

import com.o9tech.bloodpressure.DataModel.HeartRateModel
import com.o9tech.bloodpressure.R

object SleepModelDataSet {
    fun SetHeartRate() :List<sleepDataModels> {
        val heartRateList = mutableListOf<sleepDataModels>()
        heartRateList.add(
            sleepDataModels(
                1,
                R.drawable.sleep,
                "Rate"
            )
        )

        heartRateList.add(
            sleepDataModels(
                2,
                R.drawable.dadsleep,
                "Factors "
            )
        )
        heartRateList.add(
            sleepDataModels(
                3,
                R.drawable.bettersleep,
                "Resting"
            )
        )
        heartRateList.add(
            sleepDataModels(
                4,
                R.drawable.imagesbetter,
                "Target"
            )
        )
        heartRateList.add(
            sleepDataModels(
                5,
                R.drawable.imageshealth,
                "complications"
            )
        )
        heartRateList.add(
            sleepDataModels(
                6,
                R.drawable.imagessleep,
                "children"
            )
        )
        return heartRateList
    }
}