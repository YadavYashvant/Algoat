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