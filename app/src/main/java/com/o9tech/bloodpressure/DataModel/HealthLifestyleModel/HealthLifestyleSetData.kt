package com.o9tech.bloodpressure.DataModel.HealthLifestyleModel

import androidx.compose.ui.graphics.Color
import com.o9tech.bloodpressure.R

object HealthLifestyleSetData {
    fun setHealthLifestyleData():List<HealthLifestyleModel> {
        val healthLifestyleList = mutableListOf<HealthLifestyleModel>()
        healthLifestyleList.add(
            HealthLifestyleModel(
                1,
                R.drawable.healthlife,
                "Exercises to Lower Blood pressure",
                Color(0xFFE57373)
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                2,
                R.drawable.healthlife1,
                "how to improve hypertension",
                Color(0xFFFF8A65)
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                3,
                R.drawable.healthlife2,
                "nurturing 101",
                Color(0xFFBA68C8)
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                4,
                R.drawable.healthlife3,
                "How to relieve stress",
                Color(0xFF64B5F6)
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                5,
                R.drawable.healthlife4,
                "Way to boost you Energy",
                Color(0xFFFFD54F)
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                6,
                R.drawable.healthlife5,
                "How to stay Calm under pressure",
                Color(0xFFE57373)
            )
        )
        healthLifestyleList.add(
            HealthLifestyleModel(
                7,
                R.drawable.healthlife6,
                "Tips to tame anxiety",
                Color(0xFF81C784)
            )
        )
        return healthLifestyleList
    }
}