package com.o9tech.heartratemonitor.ui.theme.Screens.DetailScreenInformation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.o9tech.heartratemonitor.DataModel.HeartRateModel


@Composable
fun DetailsInformationSceen(heartRateModel: HeartRateModel){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Details Information ${heartRateModel.title}")
    }
}