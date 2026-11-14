package com.siranting.siranting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siranting.siranting.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinish: () -> Unit
) {

    LaunchedEffect(Unit) {
        delay(2500)
        onFinish()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFC))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.splashscreen
                ),
                contentDescription = "SIRANTING Logo",
                modifier = Modifier.size(260.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "SIRANTING",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00695C)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Sistem Skrining Risiko Stunting",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray
            )

            Text(
                text = "Ibu Hamil dan Balita",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            CircularProgressIndicator(
                color = Color(0xFF00695C)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "SIRANTING v1.0",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}