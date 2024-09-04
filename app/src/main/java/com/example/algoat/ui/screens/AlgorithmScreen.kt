package com.example.algoat.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlgorithmScreen(algorithmName: String, sortFunction: (IntArray) -> Pair<IntArray, Long>) {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var timeTaken by remember { mutableStateOf(0L) }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$algorithmName Screen")
        TextField(
            value = input,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { input = it },
            label = { Text("Input Array (comma separated)") }
        )
        Button(onClick = {
            val arr = input.split(",").map { it.trim().toInt() }.toIntArray()
            val (sortedArray, time) = sortFunction(arr)
            result = sortedArray.joinToString(", ")
            timeTaken = time
        }) {
            Text("Run")
        }
        Text("Sorted Array: $result")
        Text("Time Taken: ${timeTaken / 1_000} µs")
    }
}