package com.siranting.siranting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siranting.siranting.R
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts

private val MedicalPrimary = Color(0xFF00695C)
private val MedicalBackground = Color(0xFFF8FAFC)

@Composable
fun OnboardingScreen(
    onContinue: () -> Unit,
    onBack: () -> Unit
) {

    // 🔥 ambil bahasa dari StateFlow
    val lang by AppLanguage.current.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MedicalBackground)
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(R.drawable.onboarding),
            contentDescription = "Onboarding",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            TextButton(
                onClick = onBack
            ) {
                Text(
                    text = Texts.back(lang)   // ✅ FIX
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "SIRANTING",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = MedicalPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = Texts.appDescription(lang),    // ✅ FIX
                fontSize = 20.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            ElevatedCard(
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = Texts.applicationBenefits(lang),   // ✅ FIX
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(Texts.benefit1(lang))   // ✅ FIX
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(Texts.benefit2(lang))   // ✅ FIX
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(Texts.benefit3(lang))   // ✅ FIX
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            ElevatedCard(
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = Texts.howToUse(lang),   // ✅ FIX
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(Texts.step1(lang))   // ✅ FIX
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(Texts.step2(lang))   // ✅ FIX
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(Texts.step3(lang))   // ✅ FIX
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(Texts.step4(lang))   // ✅ FIX
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp)
            ) {

                Text(
                    text = Texts.startNow(lang),   // ✅ FIX
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}