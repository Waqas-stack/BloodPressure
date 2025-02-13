package com.o9tech.bloodpressure.DataModel.BloodPressureModel

import androidx.compose.ui.graphics.Color
import com.o9tech.bloodpressure.R

object BloodPressureSetData {
    fun setDataBloodPressure():List<BloodPressureDataModel>{
        val bloodPressureList = ArrayList<BloodPressureDataModel>()
        bloodPressureList.add(
            BloodPressureDataModel(
                1,
                R.drawable.love,
                "Blood Pressure Measurement Mistakes",
                Color(0xFF64B5F6)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                2,
                R.drawable.love,
                "Blood Pressure Misbelief",
                Color(0xFFFFD54F)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                3,
                R.drawable.love,
                "Home Blood pressure measurement",
                Color(0xFFBA68C8)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                4,
                R.drawable.love,
                "hypotension Diagnosis & Treatment",
                Color(0xFFFF8A65)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                5,
                R.drawable.love,
                "know about hypotension",
                Color(0xFF64B5F6)
            )
        )
        return bloodPressureList
    }
}