package com.siranting.siranting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.siranting.siranting.navigation.AppNavigation
import com.siranting.siranting.ui.theme.SirantingTheme
import com.siranting.siranting.viewmodel.SirantingViewModel
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setApplicationLocales(
            AppCompatDelegate.getApplicationLocales()
        )

        super.onCreate(savedInstanceState)

        setContent {
            SirantingTheme {

                val viewModel: SirantingViewModel = viewModel()

                AppNavigation(
                    viewModel = viewModel
                )
            }
        }
    }
}