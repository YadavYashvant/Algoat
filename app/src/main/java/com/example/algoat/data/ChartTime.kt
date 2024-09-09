package com.example.algoat.data

import com.himanshoe.charty.common.ChartData

data class ChartTime(
    override val xValue: Any,
    override val yValue: Float,
    override val chartString: String
): ChartData
