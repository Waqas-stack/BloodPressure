package com.o9tech.heartratemonitor.DataModel

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object HeartRateDataSet {
    fun SetHeartRate() :List<HeartRateModel> {
        val heartRateList = mutableListOf<HeartRateModel>()
        heartRateList.add(
            HeartRateModel(
                1,
                R.drawable.hearrate,
                "What is Heart Rate?",
                Color(0xFFE57373)
            )
        )



        heartRateList.add(
            HeartRateModel(
                2,
                R.drawable.hearrate1,
                "Factors \nAffecting Heart Rate",
                Color(0xFF81C784)
            )
        )
        heartRateList.add(
            HeartRateModel(
                3,
                R.drawable.hearrate2,
                "Resting Heart Rate",
                Color(0xFF64B5F6)
            )
        )
        heartRateList.add(
            HeartRateModel(
                4,
                R.drawable.hearrate3,
                "Target Heart Rate",
                Color(0xFFFFD54F)
            )
        )
        heartRateList.add(
            HeartRateModel(
                5,
                R.drawable.hearrate4,
                "High\n Heart Rate complications",
                Color(0xFFBA68C8)
            )
        )
        heartRateList.add(
            HeartRateModel(
                6,
                R.drawable.hearrate5,
                "Heart Rate Zones of children",
                Color(0xFFFF8A65)
            )
        )
        return heartRateList
    }
}