package com.o9tech.heartratemonitor.DataModel.AssessHeartModel

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object AssessHeartSetData {
    fun setAssessHeartSet():List<AssessHeartModel> {
        val assessHeartSet = ArrayList<AssessHeartModel>()
        assessHeartSet.add(
            AssessHeartModel(
                1,
                R.drawable.bp1,
                "Resting Heart rate",
                Color(0xFFBA68C8)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                2,
                R.drawable.bp2,
                "target Heart rate",
                Color(0xFF64B5F6)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                3,
                R.drawable.protectheart,
                "Heart rate zones for children",
                Color(0xFFFFD54F)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                4,
                R.drawable.heartdiese,
                "waqas",
                Color(0xFF64B5F6)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                5,
                R.drawable.firstaid2,
                "Home Blood Pressure Measurement",
                Color(0xFFFF8A65)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.firstaid1,
                "Blood pressure Measurement Mistake  ",
                Color(0xFF81C784)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                7,
                R.drawable.protectheart5,
                "Blood pressure Number",
                Color(0xFF64B5F6)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                8,
                R.drawable.hearrate2,
                "Blood pressure Misbelief",
                Color(0xFFFFD54F)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                9,
                R.drawable.healthlife1,
                "Blood Sugar Normal ranges",
                Color(0xFFBA68C8)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                10,
                R.drawable.glucosemeter,
                "What causes Tiredness",
                Color(0xFFFF8A65)
            )
        )
        return assessHeartSet
    }
}