package com.siranting.siranting.models

data class User(
    val uid: String = "",
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val role: String = "patient"
)