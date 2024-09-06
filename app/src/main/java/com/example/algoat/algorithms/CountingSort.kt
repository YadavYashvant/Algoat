package com.example.algoat.algorithms

import kotlin.system.measureNanoTime

fun countingSort(arr: IntArray): Pair<IntArray, Long> {
    val sortedArray = arr.copyOf()
    val timeTaken = measureNanoTime {
        val max = sortedArray.maxOrNull() ?: return@measureNanoTime
        val count = IntArray(max + 1)
        for (num in sortedArray) {
            count[num]++
        }
        var index = 0
        for (i in count.indices) {
            while (count[i] > 0) {
                sortedArray[index++] = i
                count[i]--
            }
        }
    }
    return Pair(sortedArray, timeTaken)
}