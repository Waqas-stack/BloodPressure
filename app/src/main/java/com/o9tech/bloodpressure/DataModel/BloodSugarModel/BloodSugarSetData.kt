package com.o9tech.bloodpressure.DataModel.BloodSugarModel

import com.o9tech.bloodpressure.R

object BloodSugarSetData {
    fun setBloodSugar(): List<BloodSugarDataModel> {
        val bloodSugarList = mutableListOf<BloodSugarDataModel>()
        bloodSugarList.add(
            BloodSugarDataModel(
                1,
                R.drawable.love,
                "Know about Lower Blood sugar"
            )
        )
        bloodSugarList.add(
            BloodSugarDataModel(
                2,
                R.drawable.love,
                "Blood Sugar Normal Ranges"
            )
        )
        bloodSugarList.add(
            BloodSugarDataModel(
                3,
                R.drawable.love,
                "What is diabetes"
            )
        )
        bloodSugarList.add(
            BloodSugarDataModel(
                4,
                R.drawable.love,
                "Diabetes Tests & Diagnosis"
            )
        )
        return bloodSugarList

    }
}