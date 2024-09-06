package com.example.algoat.algorithms

import kotlin.system.measureNanoTime

fun selectionSort(arr: IntArray): Pair<IntArray, Long> {
    val sortedArray = arr.copyOf()
    val timeTaken = measureNanoTime {
        for (i in sortedArray.indices) {
            var minIdx = i
            for (j in i + 1 until sortedArray.size) {
                if (sortedArray[j] < sortedArray[minIdx]) {
                    minIdx = j
                }
            }
            val temp = sortedArray[minIdx]
            sortedArray[minIdx] = sortedArray[i]
            sortedArray[i] = temp
        }
    }
    return Pair(sortedArray, timeTaken)
}