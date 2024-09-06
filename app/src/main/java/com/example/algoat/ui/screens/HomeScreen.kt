package com.example.algoat.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.algoat.data.SortingAlgorithm
import com.example.algoat.algorithms.bubbleSort
import com.example.algoat.algorithms.countingSort
import com.example.algoat.algorithms.insertionSort
import com.example.algoat.algorithms.mergeSort
import com.example.algoat.algorithms.selectionSort
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController, algorithms: List<SortingAlgorithm>) {

    var input by remember { mutableStateOf("5,4,6,1,3,7,9,2,8")}
    var times by remember { mutableStateOf<Map<String, Long>>(emptyMap()) }

    LazyColumn(modifier = Modifier.padding(innerPadding).padding(horizontal = 8.dp)) {
        item {
            TextField(
                maxLines = 5,
                value = input,
                onValueChange = { input = it },
                label = { Text("Input Array (comma separated)") },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
            )
        }
        item {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = {
                    val arr = input.split(",").map { it.trim().toInt() }.toIntArray()

                    val newTimes = algorithms.associate { algorithm ->
                        val sortFunction = when (algorithm.name) {
                            "Bubble Sort" -> ::bubbleSort
                            "Insertion Sort" -> ::insertionSort
                            "Selection Sort" -> ::selectionSort
                            "Merge Sort" -> ::mergeSort
                            "Counting Sort" -> ::countingSort
                            else -> throw IllegalArgumentException("Unknown algorithm")
                        }
                        algorithm.name to sortFunction(arr).second
                    }

                    times = newTimes

                }, modifier = Modifier.padding(8.dp)) {
                    Text("Run", fontSize = 16.sp)
                }

                Button(onClick = {
                    val randomArray = List(1000) { Random.nextInt(0, 10000) }
                    input = randomArray.joinToString(",")

                }, modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                    Text("Generate large input", fontSize = 16.sp)
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            HorizontalDivider(modifier = Modifier.padding(horizontal = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.height(800.dp)
            ) {
                items(algorithms) { algorithm ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { navController.navigate(algorithm.route) }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = algorithm.name, fontSize = 32.sp, fontWeight = FontWeight.Bold, lineHeight = 50.sp)
                            times[algorithm.name]?.let { time ->
                                Text(text = "Time Taken: ${time / 1_000} µs", fontWeight = FontWeight.W300 )
                            }
                        }
                    }
                }
            }
        }
    }
}