package com.o9tech.bloodpressure.DataModel.healthArticles

import com.o9tech.bloodpressure.DataModel.HeartRateModel
import com.o9tech.bloodpressure.R

object HealthArticlesDataSet {
    fun SetHeartRate() :List<HealthArticlesDataModel> {
        val heartRateList = mutableListOf<HealthArticlesDataModel>()
        heartRateList.add(
            HealthArticlesDataModel(
                1,
                R.drawable.imagesheart,
                "What is Heart Rate?",
                ""
            )
        )

        heartRateList.add(
            HealthArticlesDataModel(
                2,
                R.drawable.imagesattack,
                "Factors \nAffecting Heart Rate",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                3,
                R.drawable.pain,
                "Resting Heart Rate",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                4,
                R.drawable.imagesdoctor,
                "Target Heart Rate",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                5,
                R.drawable.healthheart,
                "High\n Heart Rate complications",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                6,
                R.drawable.imagesbeautiful,
                "Heart Rate Zones of children",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                7,
                R.drawable.notgood,
                "Heart Rate Zones of children",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                8,
                R.drawable.theheart,
                "Heart Rate Zones of children",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                9,
                R.drawable.overweight,
                "Heart Rate Zones of children",
                ""
            )
        )
        return heartRateList
    }

}