package com.siranting.siranting.models

import com.google.firebase.Timestamp

data class BalitaRecord(
    // Identitas
    val namaIbu: String = "",
    val usiaMenikah: String = "",
    val jumlahAnak: String = "",
    val namaAnak: String = "",
    val anakKe: String = "",

    // Data Kesehatan & Risiko
    val ageRisk: Int? = null,
    val education: Int? = null,
    val income: Int? = null,
    val childGender: Int? = null,
    val kiaBook: Int? = null,
    val jkn: Int? = null,
    val birthHistory: Int? = null,
    val kek: Int? = null,
    val anc: Int? = null,
    val feTablet: Int? = null,
    val smokingExposure: Int? = null,
    val toilet: Double? = null,
    val cleanWater: Double? = null,
    val homeEnvironment: Double? = null,
    val drinkingWater: Double? = null,
    val tinggiBadan: Double? = null,
    val tbu: Int? = null,
    val bbu: Int? = null,
    val birthWeightRisk: Int? = null,
    val exclusiveBreastfeeding: Int? = null,
    val shortBirthLength: Int? = null,
    val kenaikanberat: Int? = null,
    val timbangbalita: Int? = null,
    val ukurpanjang: Int? = null,
    val immunization: Int? = null,
    val vitaminA: Int? = null,
    val ispa: Int? = null,
    val pneumonia: Int? = null,
    val diarrhea: Int? = null,
    val rawatinap: Int? = null,
    val sleepHabit: Int? = null,
    val diet: Int? = null,
    val usiabayi: Int? = null,

    // Hasil Analisis
    val score: Double = 0.0,
    val category: String = "",
    val createdAt: Timestamp = Timestamp.now()
)