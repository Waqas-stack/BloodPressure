package com.o9tech.heartratemonitor.ui.theme.Screens.CameraUp

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheet(
    bitmap: List<Bitmap>,
    modifier: Modifier = Modifier,
) {
    if (bitmap.isEmpty()) {
        Box(
            modifier = modifier.padding(14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No images found")
        }
    } else {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier,
        ) {
            items(bitmap.size) {
                Image(bitmap = bitmap[it].asImageBitmap(), contentDescription = "imaeges")
            }
        }
    }
}