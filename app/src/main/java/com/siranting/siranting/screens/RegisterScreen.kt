package com.siranting.siranting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siranting.siranting.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.siranting.siranting.viewmodel.AuthViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState

private val MedicalPrimary = Color(0xFF00695C)
private val MedicalBackground = Color(0xFFF8FAFC)

@Composable
fun RegisterScreen(
    onBack: () -> Unit,
    authViewModel: AuthViewModel = viewModel()
) {
    val lang by AppLanguage.current.collectAsState()

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val success by authViewModel.success.collectAsState()
    val error by authViewModel.error.collectAsState()

    LaunchedEffect(success) {
        if (success) {
            onBack()
            authViewModel.resetState()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MedicalBackground)
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(R.drawable.register),
            contentDescription = "Register",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Text(
                text = Texts.registerTitle(lang),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MedicalPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = Texts.registerDesc(lang),
                fontSize = 16.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = Texts.accountInfo(lang),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = {
                            Text(Texts.fullName(lang))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = {
                            Text(Texts.phoneNumber(lang))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = {
                            Text(Texts.email(lang))
                        },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = {
                            Text(Texts.password(lang))
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = {
                            Text(Texts.confirmPassword(lang))
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    error?.let {
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = it,
                            color = Color.Red
                        )
                    }

                    Button(
                        onClick = {

                            if (name.isBlank() ||
                                phone.isBlank() ||
                                email.isBlank() ||
                                password.isBlank()
                            ) {
                                authViewModel.setError(Texts.emptyFieldError(lang))
                                return@Button
                            }

                            if (password != confirmPassword) {
                                authViewModel.setError(Texts.passwordMismatch(lang))
                                return@Button
                            }

                            authViewModel.register(
                                name = name,
                                phone = phone,
                                email = email,
                                password = password
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {

                        Text(
                            text = Texts.registerButton(lang),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedButton(
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(14.dp)
            ) {

                Text(
                    text = Texts.backToLogin(lang),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = Texts.systemFooter(lang),
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}