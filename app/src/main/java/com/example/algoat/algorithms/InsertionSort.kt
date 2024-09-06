package com.example.algoat.algorithms

import kotlin.system.measureNanoTime

fun insertionSort(arr: IntArray): Pair<IntArray, Long> {
    val sortedArray = arr.copyOf()
    val timeTaken = measureNanoTime {
        for (i in 1 until sortedArray.size) {
            val key = sortedArray[i]
            var j = i - 1
            while (j >= 0 && sortedArray[j] > key) {
                sortedArray[j + 1] = sortedArray[j]
                j -= 1
            }
            sortedArray[j + 1] = key
        }
    }
    return Pair(sortedArray, timeTaken)
}