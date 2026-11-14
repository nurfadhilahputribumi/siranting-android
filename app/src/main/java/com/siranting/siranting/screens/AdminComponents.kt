package com.siranting.siranting.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DataRow(label: String, value: String, isHighlight: Boolean = false) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        // Label pertanyaan: Hitam (onSurface), Bold
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )
        // Jawaban user: Normal, warna menyesuaikan highlight
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = if (isHighlight) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
    }
}