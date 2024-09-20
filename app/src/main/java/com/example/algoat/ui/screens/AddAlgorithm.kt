package com.example.algoat.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.algoat.utils.getTextFromClipboard

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAlgorithm() {
    var input by remember { mutableStateOf("  ") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
    ) {
        Button(onClick = {
            input = getTextFromClipboard(context)
        },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Paste from Clipboard \uD83D\uDCCB")
        }

        TextField(
            minLines = 30,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = { Text("Please paste your algorithm here \uD83D\uDC49") },
            value = input,
            onValueChange = { input = it },
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
        )

        Button(onClick = {
            // Add the algorithm to the database
        },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Add Algorithm")
        }
    }
}