package com.o9tech.heartratemonitor.DataModel.DiabetesModel

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object DiabetesSetData {
    fun setDiabetesData():List<DiabetesDataModel>{
        val diabetesData = mutableListOf<DiabetesDataModel>()
        diabetesData.add(
            DiabetesDataModel(
                1,
                R.drawable.love,
                "Diabetes Tests & Diagnosis",
                Color(0xFF64B5F6)
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                2,
                R.drawable.love,
                "What is Diabetes",
                        Color(0xFFFF8A65)
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                3,
                R.drawable.love,
                "Type I & Type II Diabetes",
                Color(0xFFBA68C8)
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                4,
                R.drawable.love,
                "Diabetes symptoms",
                Color(0xFFFFD54F)
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                5,
                R.drawable.love,
                "How to treat Diabetes",
                Color(0xFF81C784)
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                6,
                R.drawable.love,
                "Methods to prevent Diabetes",
                Color(0xFFE57373)
            )
        )
        return diabetesData
    }
}