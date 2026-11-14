package com.siranting.siranting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.elevatedCardElevation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.siranting.siranting.R
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts
import com.siranting.siranting.viewmodel.AuthViewModel

private val MedicalPrimary = Color(0xFF00695C)
private val MedicalBackground = Color(0xFFF8FAFC)
private val MedicalText = Color(0xFF1F2937)

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onRegister: () -> Unit,
    onForgotPassword: () -> Unit,
    authViewModel: AuthViewModel = viewModel()
) {

    val lang by AppLanguage.current.collectAsState()
    val success by authViewModel.success.collectAsState()
    val error by authViewModel.error.collectAsState()

    LaunchedEffect(success) {
        if (success) {
            onLogin()
            authViewModel.resetState()
        }
    }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // ================= SCREEN SIZE DETECTION =================
    val configuration = LocalConfiguration.current
    val isSmallScreen = configuration.screenHeightDp < 700

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MedicalBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MedicalBackground)
                .padding(horizontal = 24.dp)
                .padding(WindowInsets.systemBars.asPaddingValues())
                .then(
                    if (isSmallScreen)
                        Modifier.verticalScroll(scrollState)
                    else Modifier
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = if (isSmallScreen)
                Arrangement.Top
            else
                Arrangement.SpaceBetween
        ) {

            // ================= TOP =================
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(if (isSmallScreen) 24.dp else 32.dp))

                Image(
                    painter = painterResource(R.drawable.siranting_login),
                    contentDescription = "SIRANTING",
                    modifier = Modifier.size(if (isSmallScreen) 160.dp else 220.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = "SIRANTING",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = MedicalPrimary
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = Texts.appDescription(lang),
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ================= CARD =================
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = elevatedCardElevation(defaultElevation = 6.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
                )
            ) {

                Column(modifier = Modifier.padding(24.dp)) {

                    Text(
                        text = Texts.loginTitle(lang),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MedicalText
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(Texts.password(lang)) },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = Texts.forgotPassword(lang),
                        color = MedicalPrimary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable { onForgotPassword() }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    error?.let {
                        Text(text = it, color = Color.Red)
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Button(
                            onClick = {
                                if (email.isBlank() || password.isBlank()) return@Button
                                authViewModel.login(email, password)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MedicalPrimary
                            )
                        ) {
                            Text(
                                text = Texts.login(lang),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        OutlinedButton(
                            onClick = onRegister,
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = Texts.register(lang),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ================= FOOTER =================
            Text(
                text = "SIRANTING v1.0",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}