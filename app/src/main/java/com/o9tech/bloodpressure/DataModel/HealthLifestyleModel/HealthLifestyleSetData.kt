package com.o9tech.bloodpressure.DataModel.HealthLifestyleModel

import com.o9tech.bloodpressure.R

object HealthLifestyleSetData {
    fun setHealthLifestyleData():List<HealthLifestyleModel> {
        val healthLifestyleList = mutableListOf<HealthLifestyleModel>()
        healthLifestyleList.add(
            HealthLifestyleModel(
                1,
                R.drawable.love,
                "Exercises to Lower Blood pressure"
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                2,
                R.drawable.love,
                "how to improve hypertension"
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                3,
                R.drawable.love,
                "nurturing 101"
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                4,
                R.drawable.love,
                "How to relieve stress"
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                5,
                R.drawable.love,
                "Way to boost you Energy"
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                6,
                R.drawable.love,
                "How to stay Calm under pressure"
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                7,
                R.drawable.love,
                "Tips to tame anxiety"
            )
        )
        return healthLifestyleList
    }
}