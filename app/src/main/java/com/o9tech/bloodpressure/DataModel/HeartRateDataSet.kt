package com.o9tech.bloodpressure.DataModel

import com.o9tech.bloodpressure.R

object HeartRateDataSet {
    fun SetHeartRate() :List<HeartRateModel> {
        val heartRateList = mutableListOf<HeartRateModel>()
        heartRateList.add(
            HeartRateModel(
                1,
                R.drawable.love,
                "What is Heart Rate?"
            )
        )

        heartRateList.add(
            HeartRateModel(
                2,
                R.drawable.love,
                "Factors \nAffecting Heart Rate"
            )
        )
        heartRateList.add(
            HeartRateModel(
                3,
                R.drawable.love,
                "Resting Heart Rate"
            )
        )
        heartRateList.add(
            HeartRateModel(
                4,
                R.drawable.love,
                "Target Heart Rate"
            )
        )
        heartRateList.add(
            HeartRateModel(
                5,
                R.drawable.love,
                "High\n Heart Rate complications"
            )
        )
        heartRateList.add(
            HeartRateModel(
                6,
                R.drawable.love,
                "Heart Rate Zones of children"
            )
        )
        return heartRateList
    }
}