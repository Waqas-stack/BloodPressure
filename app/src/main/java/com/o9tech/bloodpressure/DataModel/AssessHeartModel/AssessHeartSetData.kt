package com.o9tech.bloodpressure.DataModel.AssessHeartModel

import com.o9tech.bloodpressure.R

object AssessHeartSetData {
    fun setAssessHeartSet():List<AssessHeartModel> {
        val assessHeartSet = ArrayList<AssessHeartModel>()
        assessHeartSet.add(
            AssessHeartModel(
                1,
                R.drawable.love,
                "Resting Heart rate"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                2,
                R.drawable.love,
                "target Heart rate"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                3,
                R.drawable.love,
                "Heart rate zones for children"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                4,
                R.drawable.love,
                "waqas"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                5,
                R.drawable.love,
                "Home Blood Pressure Measurement"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood pressure Measurement Mistake  "
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood pressure Number"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood pressure Misbelief"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "Blood Sugar Normal ranges"
            )
        )
        assessHeartSet.add(
            AssessHeartModel(
                6,
                R.drawable.love,
                "What causes Tiredness"
            )
        )
        return assessHeartSet
    }
}