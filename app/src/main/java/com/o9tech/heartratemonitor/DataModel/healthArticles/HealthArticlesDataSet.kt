package com.o9tech.heartratemonitor.DataModel.healthArticles

import com.o9tech.heartratemonitor.R

object HealthArticlesDataSet {
    fun SetHeartRate() :List<HealthArticlesDataModel> {
        val heartRateList = mutableListOf<HealthArticlesDataModel>()
        heartRateList.add(
            HealthArticlesDataModel(
                1,
                R.drawable.imagesheart,
                "Heart Rate?",
                ""
            )
        )

        heartRateList.add(
            HealthArticlesDataModel(
                2,
                R.drawable.imagesattack,
                "Affecting Heart Rate",
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
                "Heart complications",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                6,
                R.drawable.imagesbeautiful,
                "Zones of children",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                7,
                R.drawable.notgood,
                "Zones ",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                8,
                R.drawable.theheart,
                "children",
                ""
            )
        )
        heartRateList.add(
            HealthArticlesDataModel(
                9,
                R.drawable.overweight,
                "Heart Rate",
                ""
            )
        )
        return heartRateList
    }

}