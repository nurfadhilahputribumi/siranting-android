package com.siranting.siranting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siranting.siranting.firebase.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun register(
        name: String,
        phone: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {

            _isLoading.value = true
            _error.value = null

            val result = repository.register(
                name = name,
                phone = phone,
                email = email,
                password = password
            )

            _isLoading.value = false

            result.onSuccess {
                _success.value = true
            }

            result.onFailure {
                _error.value = it.message
            }
        }
    }

    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {

            _isLoading.value = true
            _error.value = null

            val result = repository.login(
                email = email,
                password = password
            )

            _isLoading.value = false

            result.onSuccess {
                _success.value = true
            }

            result.onFailure {
                _error.value = it.message
            }
        }
    }

    fun resetState() {
        _success.value = false
        _error.value = null
    }

    fun setError(message: String) {
        _error.value = message
    }
}