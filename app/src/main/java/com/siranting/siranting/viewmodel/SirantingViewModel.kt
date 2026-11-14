package com.siranting.siranting.viewmodel

import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.ui.graphics.Color
import com.siranting.siranting.utils.Texts
import com.siranting.siranting.models.PregnancyRecord
import com.siranting.siranting.models.BalitaRecord
import com.google.firebase.firestore.FirebaseFirestore

// =========================
// MODE
// =========================
enum class ModeType {
    PREGNANCY,

    LACTATION
}

// =========================
// RESULT MODEL
// =========================
data class RiskResult(
    val score: Double,
    val category: String,
    val explanation: String
)

// =========================
// INPUT MODELS
// =========================
data class PregnancyInput(
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
    val jumlahAnak: String = "",
    val bbSebelumHamil: String = "",
    val bbSaatHamil: String = "",
    val tinggiBadan: String = ""
)

data class BalitaInput(

    // =====================
    // IDENTITAS
    // =====================
    val namaIbu: String = "",
    val usiaMenikah: String = "",
    val jumlahAnak: String = "",

    val namaAnak: String = "",
    val anakKe: String = "",

    // =====================
    // RISIKO IBU
    // =====================
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

)

data class HeightAgeReference(
    val minus3: Double,
    val minus2: Double,
    val plus3: Double
)

data class TbuReference(
    val minus3: Double,
    val minus2: Double,
    val plus3: Double
)

val malePbuTable = mapOf(
    0 to HeightAgeReference(44.2, 46.1, 55.6),
    1 to HeightAgeReference(48.9, 50.8, 60.6),
    2 to HeightAgeReference(52.4, 54.4, 64.4),
    3 to HeightAgeReference(55.3, 57.3, 67.6),
    4 to HeightAgeReference(57.6, 59.7, 70.1),
    5 to HeightAgeReference(59.6, 61.7, 72.2),
    6 to HeightAgeReference(61.2, 63.3, 74.0),
    7 to HeightAgeReference(62.7, 64.8, 75.7),
    8 to HeightAgeReference(64.0, 66.2, 77.2),
    9 to HeightAgeReference(65.2, 67.5, 78.7),
    10 to HeightAgeReference(66.4, 68.7, 80.1),
    11 to HeightAgeReference(67.6, 69.9, 81.5),
    12 to HeightAgeReference(68.6, 71.0, 82.9),
    13 to HeightAgeReference(69.6, 72.1, 84.2),
    14 to HeightAgeReference(70.6, 73.1, 85.5),
    15 to HeightAgeReference(71.6, 74.1, 86.7),
    16 to HeightAgeReference(72.5, 75.0, 88.0),
    17 to HeightAgeReference(73.3, 76.0, 89.2),
    18 to HeightAgeReference(74.2, 76.9, 90.4),
    19 to HeightAgeReference(75.0, 77.7, 91.5),
    20 to HeightAgeReference(75.8, 78.6, 92.6),
    21 to HeightAgeReference(76.5, 79.4, 93.8),
    22 to HeightAgeReference(77.2, 80.2, 94.9),
    23 to HeightAgeReference(78.0, 81.0, 95.9),
    24 to HeightAgeReference(78.7, 81.7, 97.0)
)

val maleTbuTable = mapOf(
    24 to TbuReference(78.0, 81.0, 96.3),
    25 to TbuReference(78.6, 81.7, 97.3),
    26 to TbuReference(79.3, 82.5, 98.3),
    27 to TbuReference(79.9, 83.1, 99.3),
    28 to TbuReference(80.5, 83.8, 100.3),
    29 to TbuReference(81.1, 84.5, 101.2),
    30 to TbuReference(81.7, 85.1, 102.1),
    31 to TbuReference(82.3, 85.7, 103.0),
    32 to TbuReference(82.8, 86.4, 103.9),
    33 to TbuReference(83.4, 86.9, 104.8),
    34 to TbuReference(83.9, 87.5, 105.6),
    35 to TbuReference(84.4, 88.1, 106.4),
    36 to TbuReference(85.0, 88.7, 107.2),
    37 to TbuReference(85.5, 89.2, 108.0),
    38 to TbuReference(86.0, 89.8, 108.8),
    39 to TbuReference(86.5, 90.3, 109.5),
    40 to TbuReference(87.0, 90.9, 110.3),
    41 to TbuReference(87.5, 91.4, 111.0),
    42 to TbuReference(88.0, 91.9, 111.7),
    43 to TbuReference(88.4, 92.4, 112.5),
    44 to TbuReference(88.9, 93.0, 113.2),
    45 to TbuReference(89.4, 93.5, 113.9),
    46 to TbuReference(89.8, 94.0, 114.6),
    47 to TbuReference(90.3, 94.4, 115.2),
    48 to TbuReference(90.7, 94.9, 115.9),
    49 to TbuReference(91.2, 95.4, 116.6),
    50 to TbuReference(91.6, 95.9, 117.3),
    51 to TbuReference(92.1, 96.4, 117.9),
    52 to TbuReference(92.5, 96.9, 118.6),
    53 to TbuReference(93.0, 97.4, 119.2),
    54 to TbuReference(93.4, 97.8, 119.9),
    55 to TbuReference(93.9, 98.3, 120.6),
    56 to TbuReference(94.3, 98.8, 121.2),
    57 to TbuReference(94.7, 99.3, 121.9),
    58 to TbuReference(95.2, 99.7, 122.6),
    59 to TbuReference(95.6, 100.2, 123.2),
    60 to TbuReference(96.1, 100.7, 123.9)

)

val femalePbuTable = mapOf(
    0 to HeightAgeReference(43.6, 45.4, 54.7),
    1 to HeightAgeReference(47.8, 49.8, 59.5),
    2 to HeightAgeReference(51.0, 53.0, 63.2),
    3 to HeightAgeReference(53.5, 55.6, 66.1),
    4 to HeightAgeReference(55.6, 57.8, 68.6),
    5 to HeightAgeReference(57.4, 59.6, 70.7),
    6 to HeightAgeReference(58.9, 61.2, 72.5),
    7 to HeightAgeReference(60.3, 62.7, 74.2),
    8 to HeightAgeReference(61.7, 64.0, 75.8),
    9 to HeightAgeReference(62.9, 65.3, 77.4),
    10 to HeightAgeReference(64.1, 66.5, 78.9),
    11 to HeightAgeReference(65.2, 67.7, 80.3),
    12 to HeightAgeReference(66.3, 68.9, 81.7),
    13 to HeightAgeReference(67.3, 70.0, 83.1),
    14 to HeightAgeReference(68.3, 71.0, 84.4),
    15 to HeightAgeReference(69.3, 72.0, 85.7),
    16 to HeightAgeReference(70.2, 73.0, 87.0),
    17 to HeightAgeReference(71.1, 74.0, 88.2),
    18 to HeightAgeReference(72.0, 74.9, 89.4),
    19 to HeightAgeReference(72.8, 75.8, 90.6),
    20 to HeightAgeReference(73.7, 76.7, 91.7),
    21 to HeightAgeReference(74.5, 77.5, 92.9),
    22 to HeightAgeReference(75.2, 78.4, 94.0),
    23 to HeightAgeReference(76.0, 79.2, 95.0),
    24 to HeightAgeReference(76.7, 80.0, 96.1)
)

val femaleTbuTable = mapOf(
    24 to TbuReference(76.0, 79.3, 95.4),
    25 to TbuReference(76.8, 80.0, 96.4),
    26 to TbuReference(77.5, 80.8, 97.4),
    27 to TbuReference(78.1, 81.5, 98.4),
    28 to TbuReference(78.8, 82.2, 99.4),
    29 to TbuReference(79.5, 82.9, 100.3),
    30 to TbuReference(80.1, 83.6, 101.3),
    31 to TbuReference(80.7, 84.3, 102.2),
    32 to TbuReference(81.3, 84.9, 103.1),
    33 to TbuReference(81.9, 85.6, 103.9),
    34 to TbuReference(82.5, 86.2, 104.8),
    35 to TbuReference(83.1, 86.8, 105.6),
    36 to TbuReference(83.6, 87.4, 106.5),
    37 to TbuReference(84.2, 88.0, 107.3),
    38 to TbuReference(84.7, 88.6, 108.1),
    39 to TbuReference(85.3, 89.2, 108.9),
    40 to TbuReference(85.8, 89.8, 109.7),
    41 to TbuReference(86.3, 90.4, 110.5),
    42 to TbuReference(86.8, 90.9, 111.2),
    43 to TbuReference(87.4, 91.5, 112.0),
    44 to TbuReference(87.9, 92.0, 112.7),
    45 to TbuReference(88.4, 92.5, 113.5),
    46 to TbuReference(88.9, 93.1, 114.2),
    47 to TbuReference(89.3, 93.6, 114.9),
    48 to TbuReference(89.8, 94.1, 115.7),
    49 to TbuReference(90.3, 94.6, 116.4),
    50 to TbuReference(90.7, 95.1, 117.1),
    51 to TbuReference(91.2, 95.6, 117.7),
    52 to TbuReference(91.7, 96.1, 118.4),
    53 to TbuReference(92.1, 96.6, 119.1),
    54 to TbuReference(92.6, 97.1, 119.8),
    55 to TbuReference(93.0, 97.6, 120.4),
    56 to TbuReference(93.4, 98.1, 121.1),
    57 to TbuReference(93.9, 98.5, 121.8),
    58 to TbuReference(94.3, 99.0, 122.4),
    59 to TbuReference(94.7, 99.5, 123.1),
    60 to TbuReference(95.2, 99.9, 123.7)
)

fun getPbuReference(
    ageMonth: Int,
    gender: String
): HeightAgeReference? {

    return when (gender) {
        "Laki-laki" -> malePbuTable[ageMonth]
        "Perempuan" -> femalePbuTable[ageMonth]
        else -> null
    }
}

fun getTbuReference(
    ageMonth: Int,
    gender: String
): TbuReference? {

    return when (gender) {
        "Laki-laki" -> maleTbuTable[ageMonth]
        "Perempuan" -> femaleTbuTable[ageMonth]
        else -> null
    }
}

fun getGrowthStatus(
    ageMonth: Int,
    gender: String,
    height: Double
): String {

    if (ageMonth < 24) {

        val ref = getPbuReference(ageMonth, gender)
            ?: return "Data tidak tersedia"

        return when {
            height < ref.minus3 -> "Sangat Pendek (Severely Stunted)"
            height < ref.minus2 -> "Pendek (Stunted)"
            height <= ref.plus3 -> "Normal"
            else -> "Tinggi"
        }

    } else {

        val ref = getTbuReference(ageMonth, gender)
            ?: return "Data tidak tersedia"

        return when {
            height < ref.minus3 -> "Sangat Pendek (Severely Stunted)"
            height < ref.minus2 -> "Pendek (Stunted)"
            height <= ref.plus3 -> "Normal"
            else -> "Tinggi"
        }
    }
}

data class WeightAgeReference(
    val minus3: Double,
    val minus2: Double,
    val plus1: Double
)

// Format: Usia (Bulan) to WeightAgeReference(-3 SD, -2 SD, +2 SD)
val maleBbuTable = mapOf(
    0 to WeightAgeReference(2.1, 2.5, 3.9),
    1 to WeightAgeReference(2.9, 3.4, 5.1),
    2 to WeightAgeReference(3.8, 4.3, 6.3),
    3 to WeightAgeReference(4.4, 5.0, 7.2),
    4 to WeightAgeReference(4.9, 5.6, 7.8),
    5 to WeightAgeReference(5.3, 6.0, 8.4),
    6 to WeightAgeReference(5.7, 6.4, 8.8),
    7 to WeightAgeReference(5.9, 6.7, 9.2),
    8 to WeightAgeReference(6.2, 6.9, 9.6),
    9 to WeightAgeReference(6.4, 7.1, 9.9),
    10 to WeightAgeReference(6.6, 7.3, 10.2),
    11 to WeightAgeReference(6.8, 7.6, 10.5),
    12 to WeightAgeReference(6.9, 7.7, 10.8),
    13 to WeightAgeReference(7.1, 7.9, 11.0),
    14 to WeightAgeReference(7.2, 8.1, 11.3),
    15 to WeightAgeReference(7.4, 8.3, 11.5),
    16 to WeightAgeReference(7.5, 8.4, 11.7),
    17 to WeightAgeReference(7.7, 8.6, 12.0),
    18 to WeightAgeReference(7.8, 8.8, 12.2),
    19 to WeightAgeReference(8.0, 8.9, 12.5),
    20 to WeightAgeReference(8.1, 9.1, 12.7),
    21 to WeightAgeReference(8.2, 9.2, 12.9),
    22 to WeightAgeReference(8.4, 9.4, 13.2),
    23 to WeightAgeReference(8.5, 9.5, 13.4),
    24 to WeightAgeReference(8.6, 9.7, 13.6),
    25 to WeightAgeReference(8.8, 9.8, 13.9),
    26 to WeightAgeReference(8.9, 10.0, 14.1),
    27 to WeightAgeReference(9.0, 10.1, 14.3),
    28 to WeightAgeReference(9.1, 10.2, 14.6),
    29 to WeightAgeReference(9.2, 10.4, 14.8),
    30 to WeightAgeReference(9.4, 10.5, 15.1),
    31 to WeightAgeReference(9.5, 10.7, 15.3),
    32 to WeightAgeReference(9.6, 10.8, 15.6),
    33 to WeightAgeReference(9.7, 10.9, 15.8),
    34 to WeightAgeReference(9.8, 11.0, 16.0),
    35 to WeightAgeReference(9.9, 11.2, 16.3),
    36 to WeightAgeReference(10.0, 11.3, 16.5),
    37 to WeightAgeReference(10.1, 11.4, 16.8),
    38 to WeightAgeReference(10.2, 11.5, 17.0),
    39 to WeightAgeReference(10.3, 11.6, 17.2),
    40 to WeightAgeReference(10.4, 11.8, 17.5),
    41 to WeightAgeReference(10.5, 11.9, 17.7),
    42 to WeightAgeReference(10.6, 12.0, 17.9),
    43 to WeightAgeReference(10.7, 12.1, 18.2),
    44 to WeightAgeReference(10.8, 12.2, 18.4),
    45 to WeightAgeReference(10.9, 12.4, 18.7),
    46 to WeightAgeReference(11.0, 12.5, 18.9),
    47 to WeightAgeReference(11.1, 12.6, 19.1),
    48 to WeightAgeReference(11.2, 12.7, 19.4),
    49 to WeightAgeReference(11.3, 12.8, 19.6),
    50 to WeightAgeReference(11.4, 12.9, 19.8),
    51 to WeightAgeReference(11.5, 13.1, 20.1),
    52 to WeightAgeReference(11.6, 13.2, 20.3),
    53 to WeightAgeReference(11.7, 13.3, 20.5),
    54 to WeightAgeReference(11.8, 13.4, 20.8),
    55 to WeightAgeReference(11.9, 13.5, 21.0),
    56 to WeightAgeReference(12.0, 13.6, 21.2),
    57 to WeightAgeReference(12.1, 13.7, 21.5),
    58 to WeightAgeReference(12.2, 13.8, 21.7),
    59 to WeightAgeReference(12.3, 14.0, 21.9),
    60 to WeightAgeReference(12.4, 14.1, 22.2)
)

// Format: Usia (Bulan) to WeightAgeReference(-3 SD, -2 SD, +1 SD)
val femaleBbuTable = mapOf(
    0 to WeightAgeReference(2.0, 2.4, 3.7),
    1 to WeightAgeReference(2.7, 3.2, 4.8),
    2 to WeightAgeReference(3.4, 3.9, 5.8),
    3 to WeightAgeReference(4.0, 4.5, 6.6),
    4 to WeightAgeReference(4.4, 5.0, 7.3),
    5 to WeightAgeReference(4.8, 5.4, 7.8),
    6 to WeightAgeReference(5.1, 5.7, 8.2),
    7 to WeightAgeReference(5.3, 6.0, 8.6),
    8 to WeightAgeReference(5.6, 6.3, 9.0),
    9 to WeightAgeReference(5.8, 6.5, 9.3),
    10 to WeightAgeReference(5.9, 6.7, 9.6),
    11 to WeightAgeReference(6.1, 6.9, 9.9),
    12 to WeightAgeReference(6.3, 7.0, 10.1),
    13 to WeightAgeReference(6.4, 7.2, 10.4),
    14 to WeightAgeReference(6.6, 7.4, 10.6),
    15 to WeightAgeReference(6.7, 7.6, 10.9),
    16 to WeightAgeReference(6.9, 7.7, 11.1),
    17 to WeightAgeReference(7.0, 7.9, 11.4),
    18 to WeightAgeReference(7.2, 8.1, 11.6),
    19 to WeightAgeReference(7.3, 8.2, 11.8),
    20 to WeightAgeReference(7.5, 8.4, 12.1),
    21 to WeightAgeReference(7.6, 8.6, 12.3),
    22 to WeightAgeReference(7.8, 8.7, 12.5),
    23 to WeightAgeReference(7.9, 8.9, 12.8),
    24 to WeightAgeReference(8.1, 9.0, 13.0),
    25 to WeightAgeReference(8.2, 9.2, 13.3),
    26 to WeightAgeReference(8.4, 9.4, 13.5),
    27 to WeightAgeReference(8.5, 9.5, 13.7),
    28 to WeightAgeReference(8.6, 9.7, 14.0),
    29 to WeightAgeReference(8.8, 9.8, 14.2),
    30 to WeightAgeReference(8.9, 10.0, 14.4),
    31 to WeightAgeReference(9.0, 10.1, 14.7),
    32 to WeightAgeReference(9.1, 10.3, 14.9),
    33 to WeightAgeReference(9.3, 10.4, 15.1),
    34 to WeightAgeReference(9.4, 10.5, 15.4),
    35 to WeightAgeReference(9.5, 10.7, 15.6),
    36 to WeightAgeReference(9.6, 10.8, 15.8),
    37 to WeightAgeReference(9.7, 10.9, 16.0),
    38 to WeightAgeReference(9.8, 11.1, 16.3),
    39 to WeightAgeReference(9.9, 11.2, 16.5),
    40 to WeightAgeReference(10.1, 11.3, 16.7),
    41 to WeightAgeReference(10.2, 11.5, 16.9),
    42 to WeightAgeReference(10.3, 11.6, 17.2),
    43 to WeightAgeReference(10.4, 11.7, 17.4),
    44 to WeightAgeReference(10.5, 11.8, 17.6),
    45 to WeightAgeReference(10.6, 12.0, 17.8),
    46 to WeightAgeReference(10.7, 12.1, 18.1),
    47 to WeightAgeReference(10.8, 12.2, 18.3),
    48 to WeightAgeReference(10.9, 12.3, 18.5),
    49 to WeightAgeReference(11.0, 12.4, 18.8),
    50 to WeightAgeReference(11.1, 12.6, 19.0),
    51 to WeightAgeReference(11.2, 12.7, 19.2),
    52 to WeightAgeReference(11.3, 12.8, 19.4),
    53 to WeightAgeReference(11.4, 12.9, 19.7),
    54 to WeightAgeReference(11.5, 13.0, 19.9),
    55 to WeightAgeReference(11.6, 13.2, 20.1),
    56 to WeightAgeReference(11.7, 13.3, 20.3),
    57 to WeightAgeReference(11.8, 13.4, 20.6),
    58 to WeightAgeReference(11.9, 13.5, 20.8),
    59 to WeightAgeReference(12.0, 13.6, 21.0),
    60 to WeightAgeReference(12.1, 13.7, 21.2)
)

fun getBbuReference(
    ageMonth: Int,
    gender: String
): WeightAgeReference? {
    return when (gender) {
        "Laki-laki" -> maleBbuTable[ageMonth]
        "Perempuan" -> femaleBbuTable[ageMonth]
        else -> null
    }
}

fun getWeightStatus(
    ageMonth: Int,
    gender: String,
    weight: Double
): String {
    val ref = getBbuReference(ageMonth, gender)
        ?: return "Data tidak tersedia"

    return when {
        weight < ref.minus3 -> "Berat badan sangat kurang (Severely Underweight)"
        weight < ref.minus2 -> "Berat badan kurang (Underweight)"
        weight <= ref.plus1 -> "Berat badan normal"
        else -> "Risiko berat badan lebih"
    }
}

// =========================
// VIEWMODEL
// =========================
class SirantingViewModel : ViewModel() {

    var lang by mutableStateOf("id")
        private set

    fun setLanguage(newLang: String) {
        lang = newLang
    }

    // =========================
    // MODE
    // =========================
    var mode by mutableStateOf(ModeType.PREGNANCY)
        private set

    fun updateMode(newMode: ModeType) {
        pregnancyInput = PregnancyInput()
        balitaInput = BalitaInput()
        riskResult = RiskResult(0.0, "", "")
        formStep = 1

        mode = newMode
    }

    // =========================
    // STEP CONTROL
    // =========================
    var formStep by mutableStateOf(1)
        private set

    fun nextStep() {
        if (formStep < 2) formStep++
    }

    fun backToStep1() {
        formStep = 1
    }

    // =========================
    // INPUT STATE
    // =========================
    var pregnancyInput by mutableStateOf(PregnancyInput())
        private set

    var balitaInput by mutableStateOf(BalitaInput())
        private set

    // =========================
    // RESULT STATE
    // =========================
    var riskResult by mutableStateOf(
        RiskResult(0.0, "", "")
    )
        private set

    // =========================
    // UPDATE FUNCTIONS
    // =========================
    fun updatePregnancy(update: (PregnancyInput) -> PregnancyInput) {
        pregnancyInput = update(pregnancyInput)
    }

    fun updateBalita(update: (BalitaInput) -> BalitaInput) {
        balitaInput = update(balitaInput)
    }

    // =========================
    // RESULT ENGINE
    // =========================
    fun calculateResult() {

        val totalScore: Double =
            if (mode == ModeType.PREGNANCY) {
                calculatePregnancyScore().toDouble()
            } else {
                calculateLactationScore()
            }

        val category = when (mode) {

            ModeType.PREGNANCY -> when {
                totalScore <= 6.0 -> Texts.risikoRendah(lang)
                totalScore <= 12.0 -> Texts.risikoSedang(lang)
                else -> Texts.riskHigh(lang)
            }

            ModeType.LACTATION -> when {
                totalScore <= 11.0 -> Texts.risikoRendah(lang)
                totalScore <= 23.0 -> Texts.risikoSedang(lang)
                else -> Texts.riskHigh(lang)

            }
        }

        val explanation = when (category) {
            Texts.risikoRendah(lang) -> Texts.explanationLow(lang)
            Texts.risikoSedang(lang) -> Texts.explanationMedium(lang)
            else -> Texts.explanationHigh(lang)
        }

        riskResult = RiskResult(
            score = totalScore,
            category = category,
            explanation = explanation
        )
    }

    // =========================
    // PREGNANCY SCORE
    // =========================
    private fun calculatePregnancyScore(): Int {
        return with(pregnancyInput) {
            listOfNotNull(
                ageRisk,
                education,
                income,
                kiaBook,
                jkn,
                birthRisk,
                infection,
                nonCommunicable,
                kek,
                anc,
                feTablet,
                lila,
                weightGain,
                sanitation
            ).sum()
        }
    }

    // =========================
    // LACTATION SCORE
    // =========================
    private fun calculateLactationScore(): Double {
        return with(balitaInput) {

            val sanitationScore =
                (toilet ?: 0.0) +
                        (cleanWater ?: 0.0) +
                        (homeEnvironment ?: 0.0) +
                        (drinkingWater ?: 0.0)

            listOf(
                (ageRisk ?: 0).toDouble(),
                (education ?: 0).toDouble(),
                (income ?: 0).toDouble(),

                (childGender ?: 0).toDouble(),

                (kiaBook ?: 0).toDouble(),
                (jkn ?: 0).toDouble(),

                (birthHistory ?: 0).toDouble(),

                (kek ?: 0).toDouble(),
                (anc ?: 0).toDouble(),
                (feTablet ?: 0).toDouble(),
                (smokingExposure ?: 0).toDouble(),

                sanitationScore,

                (tbu ?: 0).toDouble(),
                (bbu ?: 0).toDouble(),

                (birthWeightRisk ?: 0).toDouble(),

                (exclusiveBreastfeeding ?: 0).toDouble(),
                (shortBirthLength ?: 0).toDouble(),

                (kenaikanberat ?: 0).toDouble(),
                (timbangbalita ?: 0).toDouble(),
                (ukurpanjang ?: 0).toDouble(),

                (immunization ?: 0).toDouble(),
                (vitaminA ?: 0).toDouble(),
                (ispa ?: 0).toDouble(),
                (pneumonia ?: 0).toDouble(),
                (diarrhea ?: 0).toDouble(),

                (rawatinap ?: 0).toDouble(),

                (sleepHabit ?: 0).toDouble(),
                (diet ?: 0).toDouble(),
//                (usiabayi?: 0).toDouble()

            ).sum()
        }
    }

    // =========================
    // RESET
    // =========================
    fun reset() {
        pregnancyInput = PregnancyInput()
        balitaInput = BalitaInput()
        riskResult = RiskResult(0.0, "", "")
        formStep = 1
    }

    // =========================
    // RISK COLOR
    // =========================
    fun getRiskColor(category: String): Color {
        return when (category) {
            Texts.risikoRendah(lang) -> Color(0xFF4CAF50)
            Texts.risikoSedang(lang) -> Color(0xFFFFC107)
            Texts.riskHigh(lang) -> Color(0xFFF44336)
            else -> Color.Gray
        }
    }

    // =========================
    // FIRESTORE SAVE DATA
    // =========================

    fun savePregnancyData() {

        val db = FirebaseFirestore.getInstance()

        val record = PregnancyRecord(
            nama = pregnancyInput.nama,
            usiaMenikah = pregnancyInput.usiaMenikah,
            usiaKehamilan = pregnancyInput.usiaKehamilan,

            ageRisk = pregnancyInput.ageRisk,
            education = pregnancyInput.education,
            income = pregnancyInput.income,
            kiaBook = pregnancyInput.kiaBook,
            jkn = pregnancyInput.jkn,
            birthRisk = pregnancyInput.birthRisk,

            infection = pregnancyInput.infection,
            nonCommunicable = pregnancyInput.nonCommunicable,
            kek = pregnancyInput.kek,
            anc = pregnancyInput.anc,
            feTablet = pregnancyInput.feTablet,
            lila = pregnancyInput.lila,
            weightGain = pregnancyInput.weightGain,
            sanitation = pregnancyInput.sanitation,

            jumlahAnak = pregnancyInput.jumlahAnak, // Pastikan ini sudah ada di state
            bbSebelumHamil = pregnancyInput.bbSebelumHamil,
            bbSaatHamil = pregnancyInput.bbSaatHamil,
            tinggiBadan = pregnancyInput.tinggiBadan,

            score = riskResult.score,
            category = riskResult.category
        )

        db.collection("ibu_hamil")
            .add(record)
    }



    fun saveBalitaData() {
        val db = com.google.firebase.firestore.FirebaseFirestore.getInstance()

        val record = BalitaRecord(
            namaIbu = balitaInput.namaIbu,
            usiaMenikah = balitaInput.usiaMenikah,
            jumlahAnak = balitaInput.jumlahAnak,
            namaAnak = balitaInput.namaAnak,
            anakKe = balitaInput.anakKe,
            ageRisk = balitaInput.ageRisk,
            education = balitaInput.education,
            income = balitaInput.income,
            childGender = balitaInput.childGender,
            kiaBook = balitaInput.kiaBook,
            jkn = balitaInput.jkn,
            birthHistory = balitaInput.birthHistory,
            kek = balitaInput.kek,
            anc = balitaInput.anc,
            feTablet = balitaInput.feTablet,
            smokingExposure = balitaInput.smokingExposure,
            toilet = balitaInput.toilet,
            cleanWater = balitaInput.cleanWater,
            homeEnvironment = balitaInput.homeEnvironment,
            drinkingWater = balitaInput.drinkingWater,
            tinggiBadan = balitaInput.tinggiBadan,
            tbu = balitaInput.tbu,
            bbu = balitaInput.bbu,
            birthWeightRisk = balitaInput.birthWeightRisk,
            exclusiveBreastfeeding = balitaInput.exclusiveBreastfeeding,
            shortBirthLength = balitaInput.shortBirthLength,
            kenaikanberat = balitaInput.kenaikanberat,
            timbangbalita = balitaInput.timbangbalita,
            ukurpanjang = balitaInput.ukurpanjang,
            immunization = balitaInput.immunization,
            vitaminA = balitaInput.vitaminA,
            ispa = balitaInput.ispa,
            pneumonia = balitaInput.pneumonia,
            diarrhea = balitaInput.diarrhea,
            rawatinap = balitaInput.rawatinap,
            sleepHabit = balitaInput.sleepHabit,
            diet = balitaInput.diet,
            usiabayi = balitaInput.usiabayi,

            score = riskResult.score,
            category = riskResult.category
        )

        db.collection("balita")
            .add(record)
            .addOnSuccessListener {
                // Berhasil
            }
            .addOnFailureListener {
                // Error
            }
    }
}