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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siranting.siranting.R
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts


private val MedicalPrimary = Color(0xFF00695C)
private val MedicalBackground = Color(0xFFF8FAFC)

@Composable
fun ForgotPasswordScreen(
    onBack: () -> Unit
) {

    val lang by AppLanguage.current.collectAsState()
    val auth = FirebaseAuth.getInstance()

    var message by remember {
        mutableStateOf("")
    }

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MedicalBackground)
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(R.drawable.forgot),
            contentDescription = "Forgot Password",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = Modifier.padding(24.dp)
        ) {

            Text(
                text = Texts.forgotTitle(lang),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = MedicalPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                Texts.forgotDescription(lang),
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
                        text = Texts.resetPassword(lang),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        label = {
                            Text(Texts.email(lang))
                        },
                        placeholder = {
                            Text(Texts.emailPlaceholder(lang))
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {

                            if (email.isBlank()) {
                                message = Texts.emptyEmail(lang)
                            } else {

                                auth.sendPasswordResetEmail(email.trim())
                                    .addOnSuccessListener {
                                        message = Texts.resetSuccess(lang)
                                    }
                                    .addOnFailureListener {
                                        message = it.localizedMessage
                                            ?: Texts.resetFailed(lang)
                                    }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {

                        Text(
                            text = Texts.send(lang),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    if (message.isNotEmpty()) {

                        Spacer(modifier = Modifier.height(12.dp))

                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFE8F5E9)
                            )
                        ) {
                            Text(
                                text = message,
                                modifier = Modifier.padding(12.dp),
                                color = MedicalPrimary
                            )
                        }
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
                text = Texts.medicalSystem(lang),
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}