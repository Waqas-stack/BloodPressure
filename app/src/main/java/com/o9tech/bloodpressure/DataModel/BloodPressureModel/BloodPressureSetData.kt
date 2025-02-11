package com.o9tech.bloodpressure.DataModel.BloodPressureModel

import com.o9tech.bloodpressure.R

object BloodPressureSetData {
    fun setDataBloodPressure():List<BloodPressureDataModel>{
        val bloodPressureList = ArrayList<BloodPressureDataModel>()
        bloodPressureList.add(
            BloodPressureDataModel(
                1,
                R.drawable.love,
                "Blood Pressure Measurement Mistakes"
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                2,
                R.drawable.love,
                "Blood Pressure Misbelief"
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                3,
                R.drawable.love,
                "Home Blood pressure measurement"
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                4,
                R.drawable.love,
                "hypotension Diagnosis & Treatment"
            )
        )
        bloodPressureList.add(
            BloodPressureDataModel(
                5,
                R.drawable.love,
                "know about hypotension"
            )
        )
        return bloodPressureList
    }
}