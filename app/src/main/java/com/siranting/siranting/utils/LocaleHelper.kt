package com.siranting.siranting.utils

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

fun setLanguage(language: String) {
    AppCompatDelegate.setApplicationLocales(
        LocaleListCompat.forLanguageTags(language)
    )
}