package com.siranting.siranting.models

import com.google.firebase.Timestamp

data class PregnancyRecord(
    val nama: String = "",
    val usiaMenikah: String = "",
    val usiaKehamilan: String = "",

    val ageRisk: Int? = null,
    val education: Int? = null,
    val income: Int? = null,
    val kiaBook: Int? = null,
    val jkn: Int? = null,
    val birthRisk: Int? = null,

    val infection: Int? = null,
    val nonCommunicable: Int? = null,
    val kek: Int? = null,
    val anc: Int? = null,
    val feTablet: Int? = null,
    val lila: Int? = null,
    val weightGain: Int? = null,
    val sanitation: Int? = null,

    // tambahan admin
    val score: Double = 0.0,
    val category: String = "",
    val createdAt: Timestamp = Timestamp.now(),

    val jumlahAnak: String = "",
    val bbSebelumHamil: String = "",
    val bbSaatHamil: String = "",
    val tinggiBadan: String = ""
)