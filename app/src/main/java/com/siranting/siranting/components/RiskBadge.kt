package com.siranting.siranting.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RiskBadge(category: String) {

    val (bgColor, textColor) = when (category) {

        "Risiko Rendah" ->
            Color(0xFFE8F5E9) to Color(0xFF2E7D32)

        "Risiko Sedang" ->
            Color(0xFFFFF8E1) to Color(0xFFF9A825)

        else ->
            Color(0xFFFFEBEE) to Color(0xFFC62828)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(bgColor, shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category,
            color = textColor,
            style = MaterialTheme.typography.titleLarge
        )
    }
}