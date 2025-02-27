package com.o9tech.heartratemonitor.DataModel.BloodPressureModel

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object BloodPressureSetData {
    fun setDataBloodPressure():List<BloodPressureDataModel>{
        val bloodPressureList = ArrayList<BloodPressureDataModel>()
        bloodPressureList.add(
            BloodPressureDataModel(
                1,
                R.drawable.bp1,
                "Blood Pressure Measurement Mistakes",
                Color(0xFF64B5F6)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                2,
                R.drawable.bp2,
                "Blood Pressure Misbelief",
                Color(0xFFFFD54F)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                3,
                R.drawable.heartdiese1,
                "Home Blood pressure measurement",
                Color(0xFFBA68C8)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                4,
                R.drawable.heartdiese2,
                "hypotension Diagnosis & Treatment",
                Color(0xFFFF8A65)
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                5,
                R.drawable.heartdiese3,
                "know about hypotension",
                Color(0xFF64B5F6)
            )
        )
        return bloodPressureList
    }
}