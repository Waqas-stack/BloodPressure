package com.o9tech.heartratemonitor.DataModel.BloodSugarModel

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object BloodSugarSetData {
    fun setBloodSugar(): List<BloodSugarDataModel> {
        val bloodSugarList = mutableListOf<BloodSugarDataModel>()
        bloodSugarList.add(
            BloodSugarDataModel(
                1,
                R.drawable.love,
                "Know about Lower Blood sugar",
                Color(0xFF64B5F6)
            )
        )
        bloodSugarList.add(
            BloodSugarDataModel(
                2,
                R.drawable.love,
                "Blood Sugar Normal Ranges",
                Color(0xFFFFD54F)
            )
        )
        bloodSugarList.add(
            BloodSugarDataModel(
                3,
                R.drawable.love,
                "What is diabetes",
                Color(0xFFFF8A65)
            )
        )
        bloodSugarList.add(
            BloodSugarDataModel(
                4,
                R.drawable.love,
                "Diabetes Tests & Diagnosis",
                Color(0xFFBA68C8)
            )
        )
        return bloodSugarList

    }
}