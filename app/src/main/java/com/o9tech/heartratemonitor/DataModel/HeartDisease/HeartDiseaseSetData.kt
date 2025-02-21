package com.o9tech.heartratemonitor.DataModel.HeartDisease

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object HeartDiseaseSetData {

    fun SetHeartDiseaseData():List<HeartDiseaseModel>{
        val heartDiseaseData = mutableListOf<HeartDiseaseModel>()

        heartDiseaseData.add(
            HeartDiseaseModel(
                1,
                R.drawable.heartdiese,
                "Common Heart Disease",
                Color(0xFFFFD54F)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                2,
                R.drawable.heartdiese1,
                "high Heart rate complications",
                Color(0xFFBA68C8)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                3,
                R.drawable.heartdiese2,
                "Know about Hypotension",
                        Color(0xFFFF8A65)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                4,
                R.drawable.heartdiese3,
                "Know about Low Blood Sugar",
                Color(0xFF81C784)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                5,
                R.drawable.heartdiese4,
                "Diabetes Tests & Diagnostics",
                Color(0xFF64B5F6)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                6,
                R.drawable.heartdiese5,
                "Hypertension Types and Symptoms",
                Color(0xFFFFD54F)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                7,
                R.drawable.heartdiese6,
                "What Causes Tiredness?",
                Color(0xFFBA68C8)
            )
        )
        heartDiseaseData.add(
            HeartDiseaseModel(
                8,
                R.drawable.heartdiese7,
                "How Negative Emotions hurt your Heart?",
                Color(0xFFFF8A65)
            )
        )
        return heartDiseaseData
    }
}