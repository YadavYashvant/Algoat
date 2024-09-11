package com.example.algoat.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.algoat.algorithms.bubbleSort
import com.example.algoat.algorithms.countingSort
import com.example.algoat.algorithms.insertionSort
import com.example.algoat.algorithms.mergeSort
import com.example.algoat.algorithms.selectionSort
import com.example.algoat.data.ChartTime
import com.example.algoat.data.SortingAlgorithm
import com.example.algoat.ui.components.BottomNavigation
import com.himanshoe.charty.common.ChartDataCollection

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val algorithms = listOf(
        SortingAlgorithm("Bubble Sort", "BubbleSort"),
        SortingAlgorithm("Insertion Sort", "InsertionSort"),
        SortingAlgorithm("Selection Sort", "SelectionSort"),
        SortingAlgorithm("Merge Sort", "MergeSort"),
        SortingAlgorithm("Counting Sort", "CountingSort")
    )

    val times = mutableMapOf(
        "Bubble Sort" to 2L,
        "Insertion Sort" to 1L,
        "Selection Sort" to 3L,
        "Merge Sort" to 4L,
        "Counting Sort" to 3L
    )

    val dataCollection = ChartDataCollection(
        listOf(
            ChartTime(xValue = 2, yValue = times["Bubble Sort"]?.toFloat() ?: 0f, chartString = "Bubble Sort"),
            ChartTime(xValue = 2, yValue = times["Insertion Sort"]?.toFloat() ?: 0f, chartString = "Insertion Sort"),
            ChartTime(xValue = 2, yValue = times["Selection Sort"]?.toFloat() ?: 0f, chartString = "Selection Sort"),
            ChartTime(xValue = 2, yValue = times["Merge Sort"]?.toFloat() ?: 0f, chartString = "Merge Sort"),
            ChartTime(xValue = 2, yValue = times["Counting Sort"]?.toFloat() ?: 0f, chartString = "Counting Sort"),
        )
    )

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomNavigation(navController) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate("AddAlgorithm") },
                content = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Algorithm")
                    Text("Add Algorithm")
                }
            )
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "Home") {
            composable("Home") {
                HomeScreen(innerPadding, navController, algorithms)
            }
            composable("Plot") {
                    PlotScreen(innerPadding, dataCollection)
            }
            composable("AddAlgorithm") {
                AddAlgorithm()
            }
            composable("Leaderboard") {
                LeaderboardScreen(innerPadding)
            }
            composable("BubbleSort") {
                AlgorithmScreen("Bubble Sort", ::bubbleSort)
            }
            composable("InsertionSort") {
                AlgorithmScreen("Insertion Sort", ::insertionSort)
            }
            composable("SelectionSort") {
                AlgorithmScreen("Selection Sort", ::selectionSort)
            }
            composable("MergeSort") {
                AlgorithmScreen("Merge Sort", ::mergeSort)
            }
            composable("CountingSort") {
                AlgorithmScreen("Counting Sort", ::countingSort)
            }
        }
    }
}