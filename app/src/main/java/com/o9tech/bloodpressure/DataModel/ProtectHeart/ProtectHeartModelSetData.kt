package com.o9tech.bloodpressure.DataModel.ProtectHeart

import com.o9tech.bloodpressure.R

object ProtectHeartModelSetData {
    fun setProtectdata():List<ProtectHeartModel>{
        val protectheartmodellist=ArrayList<ProtectHeartModel>()

        protectheartmodellist.add(
            ProtectHeartModel(
                1,
                R.drawable.love,
                "Methods to improve Heart rate"
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                2,
                R.drawable.love,
                "Exercises to Lower Blood Pressure"
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                3,
                R.drawable.love,
                "Methods to prevent Diabetes"
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                4,
                R.drawable.love,
                "How to improve hypertension?"
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                5,
                R.drawable.love,
                "What causes Tiredness?"
            )
        )

        return protectheartmodellist
    }
}