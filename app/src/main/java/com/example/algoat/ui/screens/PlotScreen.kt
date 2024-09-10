package com.example.algoat.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.himanshoe.charty.bar.BarChart
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.common.config.ChartDefaults

@Composable
fun PlotScreen(innerPadding: PaddingValues, dataCollection: ChartDataCollection) {
    BarChart(
        dataCollection = dataCollection,
        barSpacing = 8.dp,
        modifier = Modifier.fillMaxWidth().padding(innerPadding).height(300.dp),
        padding = 16.dp,
        axisConfig = ChartDefaults.axisConfigDefaults(),
    )
}
