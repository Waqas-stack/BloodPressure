package com.o9tech.bloodpressure.DataModel.RecipesModel

import com.o9tech.bloodpressure.DataModel.HeartRateModel
import com.o9tech.bloodpressure.R

object RecipesDataModelDataset {
    fun SetHeartRate() :List<RecipesDataModel> {
        val heartRateList = mutableListOf<RecipesDataModel>()
        heartRateList.add(
            RecipesDataModel(
                1,
                R.drawable.recipe,
                "What is Heart Rate?"
            )
        )

        heartRateList.add(
            RecipesDataModel(
                2,
                R.drawable.recipe3,
                "Factors \nAffecting Heart Rate"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                3,
                R.drawable.recipe4,
                "Resting Heart Rate"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                4,
                R.drawable.recipe5,
                "Target Heart Rate"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                5,
                R.drawable.recipe6,
                "High\n Heart Rate complications"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                6,
                R.drawable.recipe7,
                "Heart Rate Zones of children"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                7,
                R.drawable.recipe8,
                "Heart Rate Zones of children"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                8,
                R.drawable.recipe9,
                "Heart Rate Zones of children"
            )
        )
        heartRateList.add(
            RecipesDataModel(
                9,
                R.drawable.recpi2png,
                "Heart Rate Zones of children"
            )
        )
        return heartRateList
    }
}