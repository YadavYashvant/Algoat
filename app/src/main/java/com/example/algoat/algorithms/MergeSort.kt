package com.example.algoat.algorithms

import kotlin.system.measureNanoTime

fun mergeSort(arr: IntArray): Pair<IntArray, Long> {
    val sortedArray = arr.copyOf()
    val timeTaken = measureNanoTime {
        mergeSortHelper(sortedArray, 0, sortedArray.size - 1)
    }
    return Pair(sortedArray, timeTaken)
}

private fun mergeSortHelper(arr: IntArray, left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSortHelper(arr, left, mid)
        mergeSortHelper(arr, mid + 1, right)
        merge(arr, left, mid, right)
    }
}

private fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val n1 = mid - left + 1
    val n2 = right - mid
    val leftArray = IntArray(n1)
    val rightArray = IntArray(n2)
    for (i in 0 until n1) leftArray[i] = arr[left + i]
    for (j in 0 until n2) rightArray[j] = arr[mid + 1 + j]
    var i = 0
    var j = 0
    var k = left
    while (i < n1 && j < n2) {
        if (leftArray[i] <= rightArray[j]) {
            arr[k] = leftArray[i]
            i++
        } else {
            arr[k] = rightArray[j]
            j++
        }
        k++
    }
    while (i < n1) {
        arr[k] = leftArray[i]
        i++
        k++
    }
    while (j < n2) {
        arr[k] = rightArray[j]
        j++
        k++
    }
}
