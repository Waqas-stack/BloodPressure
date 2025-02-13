package com.o9tech.bloodpressure.DataModel.HypertensionModel

import androidx.compose.ui.graphics.Color
import com.o9tech.bloodpressure.R

object HypertensionSetData {
    fun setdataHypertension():List<HypertensionModel>{
        val hypertensionList = mutableListOf<HypertensionModel>()
        hypertensionList.add(
            HypertensionModel(
                1,
                R.drawable.love,
                "What causes Hypertension",
                Color(0xFF64B5F6)
            )
        )
        hypertensionList.add(
            HypertensionModel(
                2,
                R.drawable.love,
                "Hypertension Danger",
                Color(0xFFFF8A65)
            )
        )
        hypertensionList.add(
            HypertensionModel(
                3,
                R.drawable.love,
                "Hypertension types and symptoms",
                Color(0xFFFFD54F)
            )
        )
        hypertensionList.add(
            HypertensionModel(
                4,
                R.drawable.love,
                "Blood Pressure Number",
                Color(0xFFE57373)
            )
        )
        hypertensionList.add(
            HypertensionModel(
                5,
                R.drawable.love,
                "First medication for Hypertension",
                Color(0xFF81C784)
            )
        )
        hypertensionList.add(
            HypertensionModel(
                6,
                R.drawable.love,
                "Blood pressure Misbelief",
                Color(0xFF64B5F6)
            )
        )
        return hypertensionList
    }
}