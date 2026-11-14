package com.siranting.siranting.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siranting.siranting.viewmodel.SirantingViewModel
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.siranting.siranting.components.RadioGroup
import com.siranting.siranting.components.RadioGroupDouble
import com.siranting.siranting.components.SectionTitle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.graphics.Color
import com.siranting.siranting.viewmodel.getGrowthStatus
import com.siranting.siranting.viewmodel.getWeightStatus
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts

@Composable
fun LactationFormScreen(
    viewModel: SirantingViewModel,
    onSubmit: () -> Unit
) {
    val lang by AppLanguage.current.collectAsState()

    val state = viewModel.balitaInput

    var namaIbu by remember { mutableStateOf("") }
    var usiaMenikah by remember { mutableStateOf("") }
    var jumlahAnak by remember { mutableStateOf("") }

    var namaAnak by remember { mutableStateOf("") }
    var anakKe by remember { mutableStateOf("") }

    var usiabayi by remember { mutableStateOf("") }

// --- STATE UNTUK TINGGI BADAN (Sudah Anda miliki) ---
    var tinggiBadanInput by remember { mutableStateOf("") }
    var statusTbu by remember { mutableStateOf("") }

// --- TAMBAHKAN STATE UNTUK BERAT BADAN DI SINI ---
    var beratBadanInput by remember { mutableStateOf("") }
    var statusBbu by remember { mutableStateOf("") }

// --- STATE SKOR RISIKO (Sudah Anda miliki) ---
    var tbu by remember { mutableStateOf<Int?>(null) }
    var bbu by remember { mutableStateOf<Int?>(null) }
    var bblr by remember { mutableStateOf<Int?>(null) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        // ================= HEADER =================

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    "🧒 SIRANTING",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(Texts.instrumenSkriningStuntingBalita(lang))
            }
        }

        // ================= PROGRESS =================

        Card {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {

                Text("Step ${viewModel.formStep} / 2")

                LinearProgressIndicator(
                    progress = { viewModel.formStep / 2f },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }


        // ================= FORM =================

        if (viewModel.formStep == 1) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    Texts.dataIbu(lang),
                    style = MaterialTheme.typography.titleLarge
                )

                SectionTitle(text = Texts.identitasibu(lang))

                OutlinedTextField(
                    value = namaIbu,
                    onValueChange = {
                        namaIbu = it

                        viewModel.updateBalita { current ->
                            current.copy(namaIbu = it)
                        }
                    },
                    label = { Text(text = Texts.nama(lang)) },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = usiaMenikah,
                    onValueChange = {
                        usiaMenikah = it

                        viewModel.updateBalita { current ->
                            current.copy(usiaMenikah = it)
                        }
                    },
                    label = { Text(Texts.usiamenikah(lang)) },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = jumlahAnak,
                    onValueChange = {
                        jumlahAnak = it

                        viewModel.updateBalita { current ->
                            current.copy(jumlahAnak = it)
                        }
                    },
                    label = { Text(Texts.jumlahanak(lang)) },
                    modifier = Modifier.fillMaxWidth()
                )

                QuestionCard("2.", Texts.usiaibusaathamil(lang)) {
                    RadioGroup(
                        selected = state.ageRisk,
                        options = listOf(
                            Texts.usia20_35(lang) to 0,
                            Texts.usiaRiskEkstrem(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    ageRisk = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("3.", Texts.pendidikanibu(lang)) {
                    RadioGroup(
                        selected = state.education,
                        options = listOf(
                            Texts.pendidikanTinggi(lang) to 0,
                            Texts.pendidikanSD_SMA(lang) to 1,
                            Texts.tidakTamatSD(lang) to 2
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    education = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("4.", Texts.pendapatankeluarga(lang)) {
                    RadioGroup(
                        selected = state.income,
                        options = listOf(
                            Texts.pendapatanDiatasUMK(lang) to 0,
                            Texts.pendapatanDibawahUMK(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    income = value
                                )
                            }
                        }
                    )
                }


                HorizontalDivider()

                Text(
                    Texts.dataAnak(lang),
                    style = MaterialTheme.typography.titleLarge
                )

                OutlinedTextField(
                    value = namaAnak,
                    onValueChange = {
                        namaAnak = it

                        viewModel.updateBalita { current ->
                            current.copy(namaAnak = it)
                        }
                    },
                    label = { Text(Texts.namaAnak(lang)) },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = anakKe,
                    onValueChange = {
                        anakKe = it

                        viewModel.updateBalita { current ->
                            current.copy(anakKe = it)
                        }
                    },
                    label = { Text(Texts.anakKe(lang)) },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = usiabayi,
                    onValueChange = { value ->

                        usiabayi = value

                        viewModel.updateBalita { current ->
                            current.copy(
                                usiabayi = value.toIntOrNull()
                            )
                        }
                    },
                    label = { Text(Texts.usiaBayiBalita(lang))},
                    modifier = Modifier.fillMaxWidth()
                )

                QuestionCard("1.", Texts.jenisKelaminAnak(lang)) {
                    RadioGroup(
                        selected = state.childGender,
                        options = listOf(
                            Texts.perempuan(lang) to 0,
                            Texts.lakiLaki(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    childGender = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("2.", Texts.bukukia(lang)) {
                    RadioGroup(
                        selected = state.kiaBook,
                        options = listOf(
                            Texts.punyaBukuKIA(lang) to 0,
                            Texts.tidakPunyaBukuKIA(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    kiaBook = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("3.", Texts.jkn(lang)) {
                    RadioGroup(
                        selected = state.jkn,
                        options = listOf(
                            Texts.punya(lang) to 0,
                            Texts.tidakPunya(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    jkn = value
                                )
                            }
                        }
                    )
                }


                QuestionCard("4.", Texts.riwayatkelahiran(lang)) {

                    RadioGroup(
                        selected = state.birthHistory,
                        options = listOf(
                            Texts.bayiCukupUmur(lang) to 0,
                            Texts.bayiPrematur(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    birthHistory = value
                                )
                            }
                        }
                    )
                }

                Button(
                    onClick = {
                        viewModel.nextStep()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(Texts.lanjut(lang))
                }
            }
        }

        if (viewModel.formStep == 2) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = Texts.dataKhususBalita(lang),
                    style = MaterialTheme.typography.titleLarge
                )

                QuestionCard("1.", Texts.kekSaatHamil(lang)) {

                    RadioGroup(
                        selected = state.kek,
                        options = listOf(
                            Texts.ya(lang) to 2,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    kek = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("2.", Texts.kunjunganAntenatal(lang)) {

                    RadioGroup(
                        selected = state.anc,
                        options = listOf(
                            Texts.ya(lang) to 1,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    anc = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("3.", Texts.tabletTambahDarah(lang)) {

                    RadioGroup(
                        selected = state.feTablet,
                        options = listOf(
                            Texts.ya(lang) to 2,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    feTablet = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("4.", Texts.paparanAsapRokok(lang)) {

                    RadioGroup(
                        selected = state.smokingExposure,
                        options = listOf(
                            Texts.ya(lang)to 1,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    smokingExposure = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("5.", Texts.sanitasi(lang)) {

                    Text(Texts.sanitasiToilet(lang))

                    RadioGroupDouble(
                        selected = state.toilet,
                        options = listOf(
                            Texts.ya(lang) to 0.0,
                            Texts.tidak(lang) to 0.5
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(toilet = value)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // 2. Air Bersih
                    Text(Texts.sanitasiAirBersih(lang))

                    RadioGroupDouble(
                        selected = state.cleanWater,
                        options = listOf(
                            Texts.ya(lang) to 0.0,
                            Texts.tidak(lang) to 0.5
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(cleanWater = value)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // 3. Lingkungan Rumah
                    Text(Texts.sanitasiLingkungan(lang))

                    RadioGroupDouble(
                        selected = state.homeEnvironment,
                        options = listOf(
                            Texts.ya(lang) to 0.0,
                            Texts.tidak(lang) to 0.5
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(homeEnvironment = value)
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // 4. Air Minum
                    Text(Texts.sanitasiAirAman(lang))

                    RadioGroupDouble(
                        selected = state.drinkingWater,
                        options = listOf(
                            Texts.ya(lang) to 0.0,
                            Texts.tidak(lang) to 0.5
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(drinkingWater = value)
                            }
                        }
                    )
                }


                QuestionCard("6", Texts.pbTbBalita(lang)) {
                    OutlinedTextField(
                        value = tinggiBadanInput,
                        onValueChange = { newValue ->
                            // Mencegah input selain angka dan titik desimal
                            if (newValue.isEmpty() || newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                                tinggiBadanInput = newValue

                                // Parsing nilai dari String ke tipe data yang dibutuhkan
                                val tbDouble = newValue.toDoubleOrNull()
                                val usiaBulan = usiabayi.toIntOrNull() // Pastikan state 'usiabayi' menyimpan angka bulan

                                // Asumsi pemetaan jenis kelamin dari state Anda (Sesuaikan jika berbeda)
                                // Misalnya: 0 = Laki-laki, 1 = Perempuan
                                val jenisKelamin = if (state.childGender == 0) Texts.lakiLaki(lang) else Texts.perempuan(lang)

                                if (tbDouble != null && usiaBulan != null && state.childGender != null) {

                                    // 1. Hitung status gizi menggunakan fungsi dari SirantingViewModel.kt
                                    val status = getGrowthStatus(usiaBulan, jenisKelamin, tbDouble)
                                    statusTbu = status

                                    // 2. Konversi status string menjadi skor risiko (0, 2, atau 3)
                                    val skorRisiko = when (status.trim()) {
                                        Texts.stuntedSevere(lang) -> 3
                                        Texts.stuntedModerate(lang) -> 2
                                        else -> 0
                                    }

                                    // 3. Simpan nilai ke state lokal dan update ViewModel
                                    tbu = skorRisiko
                                    viewModel.updateBalita {
                                        it.copy(
                                            tinggiBadan = tbDouble,
                                            tbu = skorRisiko
                                        )
                                    }
                                } else {
                                    // Jika usia atau jenis kelamin belum diisi
                                    statusTbu = Texts.lengkapiDataUsiaDanGender(lang)
                                    tbu = null
                                }
                            }
                        },
                        label = { Text(Texts.masukkanTinggiBadan(lang))},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Menampilkan hasil interpretasi secara real-time di bawah text field
                    if (statusTbu.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Status: $statusTbu",
                            color = when (tbu) {
                                0 -> Color(0xFF4CAF50) // Hijau untuk Normal
                                2 -> Color(0xFFFFC107) // Kuning untuk Pendek (Stunting)
                                3 -> Color(0xFFF44336) // Merah untuk Sangat Pendek
                                else -> Color.Gray
                            },
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

// Pastikan dua variabel ini sudah Anda tambahkan di bagian atas file
// bersama dengan variabel state lainnya (di bawah var bbu...):
// var beratBadanInput by remember { mutableStateOf("") }
// var statusBbu by remember { mutableStateOf("") }

                QuestionCard("7", Texts.bbBalita(lang)) {
                    OutlinedTextField(
                        value = beratBadanInput,
                        onValueChange = { newValue ->
                            // Hanya mengizinkan angka dan titik desimal (misal: 8.5)
                            if (newValue.isEmpty() || newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                                beratBadanInput = newValue

                                val bbDouble = newValue.toDoubleOrNull()
                                val usiaBulan = state.usiabayi

                                // Konversi angka gender ke teks yang dikenali oleh tabel
                                val jenisKelamin = if (state.childGender == 0) Texts.lakiLaki(lang) else Texts.perempuan(lang)

                                if (bbDouble != null && usiaBulan != null && state.childGender != null) {

                                    // 1. Panggil fungsi perhitungan BB/U
                                    val status = getWeightStatus(usiaBulan, jenisKelamin, bbDouble)
                                    statusBbu = status

                                    // 2. Beri skor risiko sesuai interpretasi
                                    val skorRisiko = when (statusBbu.trim()) {
                                        Texts.bbSangatKurang(lang) -> 3
                                        Texts.bbKurang(lang) -> 2
                                        Texts.bbNormal(lang) -> 0
                                        else -> 0
                                    }

                                    // 3. Simpan ke state dan ViewModel
                                    bbu = skorRisiko
                                    viewModel.updateBalita {
                                        it.copy(
                                            bbu = skorRisiko
                                        )
                                    }
                                } else {
                                    statusBbu = Texts.lengkapiDataUsiaDanGender(lang)
                                    bbu = null
                                }
                            }
                        },
                        label = { Text(Texts.masukkanBeratBadan(lang))},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Menampilkan hasil interpretasi secara langsung di layar
                    if (statusBbu.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Status: $statusBbu",
                            color = when (bbu) {
                                0 -> Color(0xFF4CAF50) // Hijau untuk Gizi Baik/Normal
                                1 -> Color(0xFFFFC107) // Kuning untuk Gizi Kurang
                                2 -> Color(0xFFF44336) // Merah untuk Gizi Buruk/Sangat Kurang
                                else -> Color.Gray
                            },
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                QuestionCard("8.", Texts.asiEksklusif(lang)) {

                    RadioGroup(
                        selected = state.exclusiveBreastfeeding,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 2
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    exclusiveBreastfeeding = value
                                )
                            }
                        }
                    )
                }


                QuestionCard("9", Texts.riwayatBblr(lang)) {
                    RadioGroup(
                        selected = bblr,
                        options = listOf(
                            Texts.ya(lang) to 1,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->

                            bblr = value

                            viewModel.updateBalita {
                                it.copy(
                                    birthWeightRisk = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("10.", Texts.riwayatPanjangBadanLahir(lang)) {

                    RadioGroup(
                        selected = state.shortBirthLength,
                        options = listOf(
                            Texts.ya(lang) to 1,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    shortBirthLength = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("11.", Texts.kenaikanBeratBadanBalita(lang)) {
                    RadioGroup(
                        selected = state.kenaikanberat,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    kenaikanberat = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("12.", Texts.timbangBalitaRutin(lang)) {
                    RadioGroup(
                        selected = state.timbangbalita,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    timbangbalita = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("13.", Texts.ukurTinggiBalita(lang)) {
                    RadioGroup(
                        selected = state.ukurpanjang,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    ukurpanjang = value
                                )
                            }
                        }
                    )
                }


                QuestionCard("14.", Texts.imunisasiLengkap(lang)) {
                    RadioGroup(
                        selected = state.immunization,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 2
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    immunization = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("15.", Texts.vitaminA(lang)) {
                    RadioGroup(
                        selected = state.vitaminA,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    vitaminA = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("16.", Texts.riwayatIspa(lang)) {
                    RadioGroup(
                        selected = state.ispa,
                        options = listOf(
                            Texts.ya(lang) to 3,
                            Texts.tidak(lang) to 1
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    ispa = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("17.", Texts.riwayatPneumonia(lang)) {
                    RadioGroup(
                        selected = state.pneumonia,
                        options = listOf(
                            Texts.ya(lang) to 2,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    pneumonia = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("18.", Texts.riwayatDiare(lang)) {
                    RadioGroup(
                        selected = state.diarrhea,
                        options = listOf(
                            Texts.ya(lang) to 2,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    diarrhea = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("19.", Texts.riwayatRawatInap(lang)) {
                    RadioGroup(
                        selected = state.rawatinap,
                        options = listOf(
                            Texts.ya(lang) to 1,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    rawatinap = value
                                )
                            }
                        }
                    )
                }

                QuestionCard("20.", Texts.kebiasaanTidurBalita(lang)) {
                    RadioGroup(
                        selected = state.sleepHabit,
                        options = listOf(
                            Texts.ya(lang) to 1,
                            Texts.tidak(lang) to 0
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    sleepHabit = value
                                )
                            }
                        }
                    )
                }

                QuestionCard(
                    "21.", Texts.menuHarianBalita(lang)) {
                    RadioGroup(
                        selected = state.diet,
                        options = listOf(
                            Texts.ya(lang) to 0,
                            Texts.tidak(lang) to 2
                        ),
                        onSelect = { value ->
                            viewModel.updateBalita {
                                it.copy(
                                    diet = value
                                )
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        viewModel.calculateResult()
                        viewModel.saveBalitaData() // Pastikan fungsi ini memanggil collection("balita")
                        onSubmit()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(Texts.hitungRisiko(lang))
                }

                OutlinedButton(
                    onClick = { viewModel.backToStep1() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = Texts.back(lang))
                }
            }
        }
    }
}