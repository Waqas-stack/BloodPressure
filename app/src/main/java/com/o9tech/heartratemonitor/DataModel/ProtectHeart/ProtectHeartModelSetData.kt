package com.o9tech.heartratemonitor.DataModel.ProtectHeart

import androidx.compose.ui.graphics.Color
import com.o9tech.heartratemonitor.R

object ProtectHeartModelSetData {
    fun setProtectdata():List<ProtectHeartModel>{
        val protectheartmodellist=ArrayList<ProtectHeartModel>()

        protectheartmodellist.add(
            ProtectHeartModel(
                1,
                R.drawable.protectheart,
                "Methods to improve Heart rate",
                Color(0xFFBA68C8)

            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                2,
                R.drawable.protectheart1,
                "Exercises to Lower Blood Pressure",
                Color(0xFFFFD54F)
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                3,
                R.drawable.protectheart2,
                "Methods to prevent Diabetes",
                Color(0xFF64B5F6)
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                4,
                R.drawable.protectheart3,
                "How to improve hypertension?",
                        Color(0xFF81C784)
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                5,
                R.drawable.protectheart4,
                "What causes Tiredness?",
                Color(0xFFBA68C8)
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                6,
                R.drawable.protectheart5,
                "How to improve hypertension??",
                Color(0xFF64B5F6)
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                7,
                R.drawable.protectheart6,
                "What causes Tiredness?",
                Color(0xFFBA68C8)
            )
        )
        protectheartmodellist.add(
            ProtectHeartModel(
                8,
                R.drawable.protectheart7,
                "What causes Tiredness?",
                Color(0xFFFFD54F)
            )
        )

        return protectheartmodellist
    }
}