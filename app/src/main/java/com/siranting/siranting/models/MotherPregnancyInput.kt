package com.siranting.siranting.models

data class MotherPregnancyInput(

    // =========================
    // IDENTITAS IBU
    // =========================
    val nama: String = "",
    val usiaMenikah: String = "",
    val usiaKehamilan: String = "",
    val jumlahAnak: String = "",

    // =========================
    // STEP 1 (RISIKO SOSIAL)
    // =========================
    val ageRisk: Int = 0,
    val education: Int = 0,
    val income: Int = 0,
    val kiaBook: Int = 0,
    val jkn: Int = 0,
    val birthRisk: Int = 0,

    // =========================
    // STEP 2 (KLINIS)
    // =========================
    val infection: Int = 0,
    val nonCommunicable: Int = 0,
    val kek: Int = 0,
    val anc: Int = 0,
    val feTablet: Int = 0,
    val lila: Int = 0,

    // =========================
    // STATUS GIZI / BB
    // =========================
    val bbSebelumHamil: Double = 0.0,
    val bbSaatHamil: Double = 0.0,
    val tinggiBadan: Double = 0.0,
    val weightGain: Int = 0,

    // =========================
    // SANITASI
    // =========================
    val sanitation: Int = 0
)