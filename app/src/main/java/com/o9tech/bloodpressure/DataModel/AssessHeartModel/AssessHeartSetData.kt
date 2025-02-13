package com.o9tech.bloodpressure.DataModel.AssessHeartModel

import androidx.compose.ui.graphics.Color
import com.o9tech.bloodpressure.R

object AssessHeartSetData {
    fun setAssessHeartSet():List<AssessHeartModel> {
        val assessHeartSet = ArrayList<AssessHeartModel>()
        assessHeartSet.add(
            AssessHeartModel(
                1,
                R.drawable.love,
                "Resting Heart rate",
                Color(0xFFBA68C8)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                2,
                R.drawable.love,
                "target Heart rate",
                Color(0xFF64B5F6)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                3,
                R.drawable.love,
                "Heart rate zones for children",
                Color(0xFFFFD54F)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                4,
                R.drawable.love,
                "waqas",
                Color(0xFF64B5F6)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                5,
                R.drawable.love,
                "Home Blood Pressure Measurement",
                Color(0xFFFF8A65)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood pressure Measurement Mistake  ",
                Color(0xFF81C784)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood pressure Number",
                Color(0xFF64B5F6)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood pressure Misbelief",
                Color(0xFFFFD54F)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood Sugar Normal ranges",
                Color(0xFFBA68C8)
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "What causes Tiredness",
                Color(0xFFFF8A65)
            )
        )
        return assessHeartSet
    }
}