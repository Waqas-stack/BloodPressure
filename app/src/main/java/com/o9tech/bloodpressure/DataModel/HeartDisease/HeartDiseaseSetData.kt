package com.o9tech.bloodpressure.DataModel.HeartDisease

import com.o9tech.bloodpressure.R

object HeartDiseaseSetData {

    fun SetHeartDiseaseData():List<HeartDiseaseModel>{
        val heartDiseaseData = mutableListOf<HeartDiseaseModel>()

        heartDiseaseData.add(
            HeartDiseaseModel(
                1,
                R.drawable.love,
                "Common Heart Disease"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                2,
                R.drawable.love,
                "high Heart rate complications"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                3,
                R.drawable.love,
                "Know about Hypotension"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                4,
                R.drawable.love,
                "Know about Low Blood Sugar"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                5,
                R.drawable.love,
                "Diabetes Tests & Diagnostics"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                6,
                R.drawable.love,
                "Hypertension Types and Symptoms"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                7,
                R.drawable.love,
                "What Causes Tiredness?"
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                8,
                R.drawable.love,
                "How Negative Emotions hurt your Heart?"
            )
        )
        return heartDiseaseData
    }
}