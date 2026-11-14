package com.siranting.siranting.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DropdownField(
    label: String,
    value: Int?,
    options: List<Pair<String, Int>>,
    onValueChange: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val selectedText = options.find { it.second == value }?.first ?: "Pilih $label"

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(text = label)

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        ) {
            Box(modifier = Modifier.padding(12.dp)) {
                Text(selectedText)
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { (text, optionValue) ->
                DropdownMenuItem(
                    text = { Text(text) },
                    onClick = {
                        onValueChange(optionValue)
                        expanded = false
                    }
                )
            }
        }
    }
}