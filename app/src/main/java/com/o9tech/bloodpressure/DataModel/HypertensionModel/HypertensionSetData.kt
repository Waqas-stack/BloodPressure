package com.o9tech.bloodpressure.DataModel.HypertensionModel

import com.o9tech.bloodpressure.R

object HypertensionSetData {
    fun setdataHypertension():List<HypertensionModel>{
        val hypertensionList = mutableListOf<HypertensionModel>()
        hypertensionList.add(
            HypertensionModel(
                1,
                R.drawable.love,
                "What causes Hypertension"
            )
        )
        hypertensionList.add(
            HypertensionModel(
                2,
                R.drawable.love,
                "Hypertension Danger"
            )
        )
        hypertensionList.add(
            HypertensionModel(
                3,
                R.drawable.love,
                "Hypertension types and symptoms"
            )
        )
        hypertensionList.add(
            HypertensionModel(
                4,
                R.drawable.love,
                "Blood Pressure Number"
            )
        )
        hypertensionList.add(
            HypertensionModel(
                5,
                R.drawable.love,
                "First medication for Hypertension"
            )
        )
        hypertensionList.add(
            HypertensionModel(
                6,
                R.drawable.love,
                "Blood pressure Misbelief"
            )
        )
        return hypertensionList
    }
}