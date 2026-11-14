package com.siranting.siranting.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.siranting.siranting.screens.*
import com.siranting.siranting.viewmodel.SirantingViewModel
import com.siranting.siranting.viewmodel.ModeType

import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(
    viewModel: SirantingViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LANGUAGE
    ) {

        composable(Routes.SPLASH) {
            SplashScreen(
                onFinish = {
                    navController.navigate(Routes.ONBOARDING) {
                        popUpTo(Routes.SPLASH) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.LANGUAGE) {
            LanguageScreen(
                onIndonesia = {
                    viewModel.setLanguage("id")

                    navController.navigate(Routes.ONBOARDING) {
                        popUpTo(Routes.LANGUAGE) {
                            inclusive = true
                        }
                    }
                },

                onEnglish = {
                    viewModel.setLanguage("en")

                    navController.navigate(Routes.ONBOARDING) {
                        popUpTo(Routes.LANGUAGE) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Routes.ONBOARDING) {
            OnboardingScreen(
                onContinue = {
                    navController.navigate(Routes.LOGIN)
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLogin = {

                    val email = FirebaseAuth.getInstance().currentUser?.email

                    if (email.equals("admin@siranting.com", ignoreCase = true)) {
                        navController.navigate(Routes.ADMIN) {
                            popUpTo(Routes.LOGIN) { inclusive = true }
                        }
                    } else {
                        navController.navigate(Routes.DASHBOARD) {
                            popUpTo(Routes.LOGIN) { inclusive = true }
                        }
                    }
                },

                onRegister = {
                    navController.navigate(Routes.REGISTER)
                },

                onForgotPassword = {
                    navController.navigate(Routes.FORGOT_PASSWORD)
                }
            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.FORGOT_PASSWORD) {
            ForgotPasswordScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.DASHBOARD) {
            DashboardScreen(
                viewModel = viewModel,

                onPregnancy = {
                    viewModel.updateMode(ModeType.PREGNANCY)
                    navController.navigate(Routes.PREGNANCY_FORM)
                },

                onLactation = {
                    viewModel.updateMode(ModeType.LACTATION)
                    navController.navigate(Routes.LACTATION_FORM)
                },

                onEducation = {
                    navController.navigate(Routes.EDUCATION)
                }
            )
        }

        composable(Routes.ADMIN) {
            AdminDashboardScreen()
        }

        composable(Routes.EDUCATION) {
            EducationScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(Routes.PREGNANCY_FORM) {
            PregnancyFormScreen(
                viewModel = viewModel,
                onSubmit = {
                    viewModel.calculateResult()
                    navController.navigate(Routes.RESULT)
                }
            )
        }

        composable(Routes.LACTATION_FORM) {
            LactationFormScreen(
                viewModel = viewModel,
                onSubmit = {
                    viewModel.calculateResult()
                    navController.navigate(Routes.RESULT)
                }
            )
        }

        composable(Routes.RESULT) {
            ResultScreen(
                viewModel = viewModel,
                onFinish = {
                    navController.popBackStack(
                        Routes.DASHBOARD,
                        inclusive = false
                    )
                }
            )
        }
    }
}