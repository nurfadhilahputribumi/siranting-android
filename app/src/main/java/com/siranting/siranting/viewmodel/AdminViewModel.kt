package com.siranting.siranting.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.siranting.siranting.models.PregnancyRecord
import com.siranting.siranting.models.BalitaRecord
import android.content.Context
import android.widget.Toast
import android.content.ContentValues
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.Locale


class AdminViewModel : ViewModel() {
    // Menyimpan daftar data ibu hamil yang diambil dari database
    var pregnancyDataList by mutableStateOf<List<PregnancyRecord>>(emptyList())
        private set

    // Menyimpan status loading (sedang mengambil data atau tidak)
    var isLoading by mutableStateOf(false)
        private set

    // Fungsi untuk menarik data dari Firestore
    fun fetchPregnancyData() {
        isLoading = true
        val db = FirebaseFirestore.getInstance()

        // Membaca dari koleksi "ibu_hamil"
        db.collection("ibu_hamil")
            .get()
            .addOnSuccessListener { documents ->
                val list = mutableListOf<PregnancyRecord>()
                for (document in documents) {
                    // Mengubah data dari database menjadi bentuk model PregnancyRecord
                    val record = document.toObject(PregnancyRecord::class.java)
                    list.add(record)
                }
                pregnancyDataList = list // Memasukkan data ke dalam state
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
                // Di sini Anda bisa menambahkan log error jika pengambilan data gagal
            }
    }

    // Di dalam AdminViewModel.kt
    var balitaDataList by mutableStateOf<List<BalitaRecord>>(emptyList())

    fun fetchBalitaData() {
        isLoading = true
        val db = FirebaseFirestore.getInstance()
        db.collection("balita")
            .get()
            .addOnSuccessListener { documents ->
                balitaDataList = documents.toObjects(BalitaRecord::class.java)
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
            }
    }

    private fun ageRiskText(value: Int?): String {
        return when (value) {
            0 -> "Usia 20–35 tahun"
            1 -> "Usia <20 atau >35 tahun"
            else -> "-"
        }
    }

    private fun educationText(value: Int?): String {
        return when (value) {
            0 -> "Pendidikan Tinggi"
            1 -> "SD-SMA"
            2 -> "Tidak Tamat SD"
            else -> "-"
        }
    }

    private fun incomeText(value: Int?): String {
        return when (value) {
            0 -> "Di atas UMK (> Rp.3.268.000)"
            1 -> "Di bawah UMK (< Rp. 3.268.000)"
            else -> "-"
        }
    }

    private fun kiaBookText(value: Int?): String {
        return when (value) {
            0 -> "Punya Buku KIA"
            1 -> "Tidak Punya Buku KIA"
            else -> "-"
        }
    }

    private fun jknText(value: Int?): String {
        return when (value) {
            0 -> "Punya"
            1 -> "Tidak Punya"
            else -> "-"
        }
    }

    private fun birthRiskText(value: Int?): String {
        return when (value) {
            0 -> "Bayi Cukup Umur (≥ 37 Minggu)"
            1 -> "Bayi Prematur (< 37 Minggu)"
            else -> "-"
        }
    }

    private fun infectionText(value: Int?): String {
        return when (value) {
            0 -> "0 Penyakit"
            1 -> "1 Penyakit"
            2 -> "2 Penyakit"
            3 -> "≥3 Penyakit"
            else -> "-"
        }
    }

    private fun kekText(value: Int?): String {
        return when (value) {
            0 -> "Tidak"
            2 -> "Ya"
            else -> "-"
        }
    }

    private fun ancText(value: Int?): String {
        return when (value) {
            1 -> "Ya"
            0 -> "Tidak"
            else -> "-"
        }
    }

    private fun feTabletText(value: Int?): String {
        return when (value) {
            2 -> "Ya"
            0 -> "Tidak"
            else -> "-"
        }
    }

    private fun lilaText(value: Int?): String {
        return when (value) {
            2 -> "< 23 cm>"
            0 -> "≥ 23 cm"
            else -> "-"
        }
    }

    private fun bmiCategory(record: PregnancyRecord): String {

        val bb = record.bbSaatHamil.toDoubleOrNull()
        val tb = record.tinggiBadan.toDoubleOrNull()

        if (bb == null || tb == null || tb <= 0)
            return "-"

        val bmi = bb / ((tb / 100.0) * (tb / 100.0))

        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25.0 -> "Normal"
            bmi < 30.0 -> "Overweight"
            else -> "Obese"
        }
    }

    private fun sanitationText(value: Int?): String {
        return when (value) {
            0 -> "Baik"
            2 -> "Cukup"
            3 -> "Buruk"
            else -> "-"
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun exportPregnancyData(context: Context) {

        try {

            val csv = StringBuilder()
            val dateFormat = SimpleDateFormat(
                "dd-MM-yyyy HH:mm",
                Locale.getDefault()
            )

            csv.append(
                "Nama," +
                        "Usia Menikah," +
                        "Usia Kehamilan," +
                        "Jumlah Anak," +
                        "BB Sebelum Hamil (kg)," +
                        "BB Saat Hamil (kg)," +
                        "Tinggi Badan (cm)," +
                        "Risiko Usia," +
                        "Pendidikan," +
                        "Pendapatan," +
                        "Buku KIA," +
                        "JKN," +
                        "Riwayat Kelahiran," +
                        "Penyakit Infeksi," +
                        "Penyakit Tidak Menular," +
                        "KEK," +
                        "ANC Rutin," +
                        "Tablet Tambah Darah," +
                        "LILA," +
                        "Status IMT," +
                        "Sanitasi," +
                        "Skor Risiko," +
                        "Kategori Risiko," +
                        "Tanggal Input\n"
            )


            pregnancyDataList.forEach { record ->
                csv.append(
                    "${record.nama}," +
                            "${record.usiaMenikah}," +
                            "${record.usiaKehamilan}," +
                            "${record.jumlahAnak}," +
                            "${record.bbSebelumHamil}," +
                            "${record.bbSaatHamil}," +
                            "${record.tinggiBadan}," +
                            "${ageRiskText(record.ageRisk)}," +
                            "${educationText(record.education)}," +
                            "${incomeText(record.income)}," +
                            "${kiaBookText(record.kiaBook)}," +
                            "${jknText(record.jkn)}," +
                            "${birthRiskText(record.birthRisk)}," +
                            "${infectionText(record.infection)}," +
                            "${infectionText(record.nonCommunicable)}," +
                            "${kekText(record.kek)}," +
                            "${ancText(record.anc)}," +
                            "${feTabletText(record.feTablet)}," +
                            "${lilaText(record.lila)}," +
                            "${bmiCategory(record)}," +
                            "${sanitationText(record.sanitation)}," +
                            "${record.score}," +
                            "${record.category}," +
                            "${dateFormat.format(record.createdAt.toDate())}\n"
                )
            }

            val resolver = context.contentResolver

            val contentValues = ContentValues().apply {
                put(
                    MediaStore.MediaColumns.DISPLAY_NAME,
                    "data_ibu_hamil.csv"
                )
                put(
                    MediaStore.MediaColumns.MIME_TYPE,
                    "text/csv"
                )
                put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    "Download"
                )
            }

            val uri = resolver.insert(
                MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                contentValues
            )

            if (uri != null) {

                resolver.openOutputStream(uri)?.use { output ->
                    output.write(csv.toString().toByteArray())
                }

                Toast.makeText(
                    context,
                    "File berhasil disimpan di Download",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                Toast.makeText(
                    context,
                    "Gagal membuat file",
                    Toast.LENGTH_LONG
                ).show()
            }

        } catch (e: Exception) {

            Toast.makeText(
                context,
                e.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun childGenderText(value: Int?): String {
        return when (value) {
            0 -> "Perempuan"
            1 -> "Laki-laki"
            else -> "-"
        }
    }

    private fun yesNoDoubleText(value: Double?): String {
        return when (value) {
            0.0 -> "Ya"
            0.5 -> "Tidak"
            else -> "-"
        }
    }

    private fun tbuText(value: Int?): String {
        return when (value) {
            0 -> "Normal"
            2 -> "Pendek (Stunting)"
            3 -> "Sangat Pendek"
            else -> "-"
        }
    }

    private fun growthMonitoringText(value: Int?): String {
        return when (value) {
            0 -> "Ya"
            1 -> "Tidak"
            else -> "-"
        }
    }

    private fun pneumoniaText(value: Int?): String {
        return when (value) {
            2 -> "Ya"
            0 -> "Tidak"
            else -> "-"
        }
    }

    private fun ispaText(value: Int?): String {
        return when (value) {
            3 -> "Ya"
            1 -> "Tidak"
            else -> "-"
        }
    }

    private fun bbuText(value: Int?): String {
        return when (value) {
            0 -> "Berat badan normal"
            2 -> "Berat badan kurang"
            3 -> "Berat badan sangat kurang"
            else -> "-"
        }
    }

    private fun exclusiveBreastfeedingText(value: Int?): String {
        return when (value) {
            0 -> "Ya"
            2 -> "Tidak"
            else -> "-"
        }
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    fun exportBalitaData(context: Context) {

        try {

            val csv = StringBuilder()
            val dateFormat = SimpleDateFormat(
                "dd-MM-yyyy HH:mm",
                Locale.getDefault()
            )

            csv.append(
                "Nama Ibu," +
                        "Usia Menikah," +
                        "Jumlah Anak," +
                        "Risiko Usia Ibu," +
                        "Pendidikan Ibu," +
                        "Pendapatan Keluarga," +

                        "Nama Anak," +
                        "Anak Ke," +
                        "Usia Bayi/Balita (bulan)," +
                        "Jenis Kelamin," +
                        "Buku KIA," +
                        "JKN," +
                        "Riwayat Kelahiran," +

                        "KEK Saat Hamil," +
                        "ANC Rutin," +
                        "Tablet Tambah Darah," +
                        "Paparan Asap Rokok," +

                        "Sanitasi Toilet," +
                        "Air Bersih," +
                        "Lingkungan Rumah," +
                        "Air Minum Aman," +

                        "Tinggi Badan (cm)," +
                        "Status TB/U," +
                        "Status BB/U," +

                        "ASI Eksklusif," +
                        "Riwayat BBLR," +
                        "Panjang Badan Lahir Pendek," +
                        "Kenaikan Berat Badan," +
                        "Penimbangan Rutin," +
                        "Pengukuran Tinggi Badan," +
                        "Imunisasi Lengkap," +
                        "Vitamin A," +

                        "ISPA," +
                        "Pneumonia," +
                        "Diare," +
                        "Rawat Inap," +
                        "Kebiasaan Tidur," +
                        "Menu Harian," +

                        "Skor Risiko," +
                        "Kategori Risiko," +
                        "Tanggal Input\n"
            )


            balitaDataList.forEach { record ->

                csv.append(
                    "${record.namaIbu}," +
                            "${record.usiaMenikah}," +
                            "${record.jumlahAnak}," +
                            "${ageRiskText(record.ageRisk)}," +
                            "${educationText(record.education)}," +
                            "${incomeText(record.income)}," +

                            "${record.namaAnak}," +
                            "${record.anakKe}," +
                            "${record.usiabayi}," +
                            "${childGenderText(record.childGender)}," +
                            "${kiaBookText(record.kiaBook)}," +
                            "${jknText(record.jkn)}," +
                            "${birthRiskText(record.birthHistory)}," +

                            "${kekText(record.kek)}," +
                            "${ancText(record.anc)}," +
                            "${feTabletText(record.feTablet)}," +
                            "${ancText(record.smokingExposure)}," +

                            "${yesNoDoubleText(record.toilet)}," +
                            "${yesNoDoubleText(record.cleanWater)}," +
                            "${yesNoDoubleText(record.homeEnvironment)}," +
                            "${yesNoDoubleText(record.drinkingWater)}," +

                            "${record.tinggiBadan}," +
                            "${tbuText(record.tbu)}," +
                            "${bbuText(record.bbu)}," +

                            "${exclusiveBreastfeedingText(record.exclusiveBreastfeeding)}," +
                            "${ancText(record.birthWeightRisk)}," +
                            "${ancText(record.shortBirthLength)}," +
                            "${growthMonitoringText(record.kenaikanberat)}," +
                            "${growthMonitoringText(record.timbangbalita)}," +
                            "${growthMonitoringText(record.ukurpanjang)}," +
                            "${exclusiveBreastfeedingText(record.immunization)}," +
                            "${growthMonitoringText(record.vitaminA)}," +

                            "${ispaText(record.ispa)}," +
                            "${pneumoniaText(record.pneumonia)}," +
                            "${pneumoniaText(record.diarrhea)}," +
                            "${ancText(record.rawatinap)}," +
                            "${ancText(record.sleepHabit)}," +
                            "${exclusiveBreastfeedingText(record.diet)}," +

                            "${record.score}," +
                            "${record.category}," +
                            "${dateFormat.format(record.createdAt.toDate())}\n"
                )
            }


            val resolver = context.contentResolver

            val contentValues = ContentValues().apply {
                put(
                    MediaStore.MediaColumns.DISPLAY_NAME,
                    "data_balita.csv"
                )
                put(
                    MediaStore.MediaColumns.MIME_TYPE,
                    "text/csv"
                )
                put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    "Download"
                )
            }

            val uri = resolver.insert(
                MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                contentValues
            )

            if (uri != null) {

                resolver.openOutputStream(uri)?.use { output ->
                    output.write(csv.toString().toByteArray())
                }

                Toast.makeText(
                    context,
                    "Data balita berhasil diekspor",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                Toast.makeText(
                    context,
                    "Gagal membuat file",
                    Toast.LENGTH_LONG
                ).show()
            }

        } catch (e: Exception) {

            Toast.makeText(
                context,
                e.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}