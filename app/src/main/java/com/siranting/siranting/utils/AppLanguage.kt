package com.siranting.siranting.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppLanguage {

    private val _current = MutableStateFlow("id") // default Indonesia
    val current = _current.asStateFlow()

    fun setLanguage(lang: String) {
        _current.value = lang
    }
}