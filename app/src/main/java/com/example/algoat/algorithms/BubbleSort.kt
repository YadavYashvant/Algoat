package com.example.algoat.algorithms
import kotlin.system.measureNanoTime

fun bubbleSort(arr: IntArray): Pair<IntArray, Long> {
    val n = arr.size
    val sortedArray = arr.copyOf()
    val timeTaken = measureNanoTime {
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    val temp = sortedArray[j]
                    sortedArray[j] = sortedArray[j + 1]
                    sortedArray[j + 1] = temp
                }
            }
        }
    }
    return Pair(sortedArray, timeTaken)
}