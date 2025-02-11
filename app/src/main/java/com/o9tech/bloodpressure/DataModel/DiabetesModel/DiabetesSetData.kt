package com.o9tech.bloodpressure.DataModel.DiabetesModel

import com.o9tech.bloodpressure.R

object DiabetesSetData {
    fun setDiabetesData():List<DiabetesDataModel>{
        val diabetesData = mutableListOf<DiabetesDataModel>()
        diabetesData.add(
            DiabetesDataModel(
                1,
                R.drawable.love,
                "Diabetes Tests & Diagnosis"
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                2,
                R.drawable.love,
                "What is Diabetes"
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                3,
                R.drawable.love,
                "Type I & Type II Diabetes"
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                4,
                R.drawable.love,
                "Diabetes symptoms"
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                5,
                R.drawable.love,
                "How to treat Diabetes"
            )
        )
        diabetesData.add(
            DiabetesDataModel(
                6,
                R.drawable.love,
                "Methods to prevent Diabetes"
            )
        )
        return diabetesData
    }
}