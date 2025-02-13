package com.o9tech.bloodpressure.DataModel.FirstAidTips

import androidx.compose.ui.graphics.Color
import com.o9tech.bloodpressure.R

object FirstAidModelSetData {
    fun setDataFirstAidModel():List<FirstAidModel>{
        val firstAidModel = ArrayList<FirstAidModel>()
        firstAidModel.add(
            FirstAidModel(
                1,
                R.drawable.firstaid,
                "hypotensive crisis Guidelines",
                Color(0xFF64B5F6)
            )
        )
        firstAidModel.add(
            FirstAidModel(
                2,
                R.drawable.firstaid1,
                "hypotensive crisis Guidelines",
                Color(0xFFFFD54F)
            )
        )
        firstAidModel.add(
            FirstAidModel(
                3,
                R.drawable.firstaid2,
                "First Aid Advice for Diabetes",
                Color(0xFFBA68C8)
            )
        )
        firstAidModel.add(
            FirstAidModel(
                4,
                R.drawable.firstaid3,
                "Calm and racing Heart fast",
                Color(0xFFFF8A65)
            )
        )
        firstAidModel.add(
            FirstAidModel(
                5,
                R.drawable.firstaid4,
                "Advice for Diabetes",
                Color(0xFFBA68C8)
            )
        )
        return firstAidModel
    }
}