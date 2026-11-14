package com.siranting.siranting.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.platform.LocalContext
import com.siranting.siranting.R
import com.siranting.siranting.utils.AppLanguage

private val MedicalPrimary = Color(0xFF00695C)
private val MedicalBackground = Color(0xFFF8FAFC)

@Composable
fun LanguageScreen(
    onIndonesia: () -> Unit,
    onEnglish: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MedicalBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "🌐",
                fontSize = 72.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.select_language),
                fontSize = 36.sp,
                color = MedicalPrimary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.choose_language),
                color = Color.Gray,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            ElevatedButton(
                onClick = {
                    AppLanguage.setLanguage("id")   // ✅ FIX DI SINI
                    onIndonesia()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    text = stringResource(R.string.indonesian),
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = {
                    AppLanguage.setLanguage("en")   // ✅ FIX DI SINI
                    onEnglish()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    text = stringResource(R.string.english),
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "SIRANTING",
                color = MedicalPrimary,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.medical_system),
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}