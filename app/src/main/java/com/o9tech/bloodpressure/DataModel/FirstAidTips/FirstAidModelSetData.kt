package com.o9tech.bloodpressure.DataModel.FirstAidTips

import com.o9tech.bloodpressure.R

object FirstAidModelSetData {
    fun setDataFirstAidModel():List<FirstAidModel>{
        val firstAidModel = ArrayList<FirstAidModel>()
        firstAidModel.add(
            FirstAidModel(
                1,
                R.drawable.love,
                "hypotensive crisis Guidelines"
            )
        )
        firstAidModel.add(
            FirstAidModel(
                2,
                R.drawable.love,
                "hypotensive crisis Guidelines"
            )
        )
        firstAidModel.add(
            FirstAidModel(
                3,
                R.drawable.love,
                "First Aid Advice for Diabetes"
            )
        )
        firstAidModel.add(
            FirstAidModel(
                4,
                R.drawable.love,
                "Calm and racing Heart fast"
            )
        )
        return firstAidModel
    }
}