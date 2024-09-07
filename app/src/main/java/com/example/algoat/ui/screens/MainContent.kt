package com.example.algoat.ui.screens

import androidx.compose.material3.Scaffold
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
import com.example.algoat.data.SortingAlgorithm
import com.example.algoat.ui.components.BottomNavigation

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

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomNavigation(navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = "Home") {
            composable("Home") {
                HomeScreen(innerPadding, navController, algorithms)
            }
            composable("Plot") {
                PlotScreen(innerPadding)
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