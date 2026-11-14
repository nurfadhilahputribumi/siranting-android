package com.siranting.siranting.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RadioGroupDouble(
    selected: Double?,
    options: List<Pair<String, Double>>,
    onSelect: (Double) -> Unit
) {
    Column {
        options.forEach { (label, value) ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelect(value) }
                    .padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = selected == value,
                    onClick = { onSelect(value) }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(text = label)
            }
        }
    }
}