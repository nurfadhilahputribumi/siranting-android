package com.siranting.siranting.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.siranting.siranting.models.PregnancyRecord
import com.siranting.siranting.models.BalitaRecord
import com.siranting.siranting.viewmodel.AdminViewModel
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Divider
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import com.siranting.siranting.components.DataRow
import android.os.Build

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardScreen(adminViewModel: AdminViewModel = viewModel()) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Ibu Hamil", "Balita")
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        adminViewModel.fetchPregnancyData()
        adminViewModel.fetchBalitaData()

    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Dashboard Admin") },
                    actions = {
                        Button(
                            onClick = {

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                                    if (selectedTabIndex == 0) {
                                        adminViewModel.exportPregnancyData(context)
                                    } else {
                                        adminViewModel.exportBalitaData(context)
                                    }

                                }
                            }
                        ) {
                            Text("Download")
                        }
                    }
                )
                TabRow(selectedTabIndex = selectedTabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = { Text(title) }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            if (adminViewModel.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn(contentPadding = PaddingValues(16.dp)) {
                    if (selectedTabIndex == 0) {
                        items(adminViewModel.pregnancyDataList) { record -> AdminDataCard(record) }
                    } else {
                        items(adminViewModel.balitaDataList) { record -> BalitaDataCard(record) }
                    }
                }
            }
        }
    }
}

@Composable
fun AdminDataCard(record: PregnancyRecord) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // TAMPILAN UTAMA
            Text(text = "Nama: ${record.nama}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Mode: Ibu Hamil", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Risiko: ${record.category}",
                style = MaterialTheme.typography.bodyMedium,
                color = if (record.category == "Tinggi") MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
            )

            // TAMPILAN DETAIL
            if (expanded) {
                Divider(modifier = Modifier.padding(vertical = 8.dp))

                Text("Detail Jawaban Form:", style = MaterialTheme.typography.labelLarge)
                Spacer(modifier = Modifier.height(8.dp))

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    DataRow("Usia Menikah (Tahun):", "${record.usiaMenikah}")
                    DataRow("Usia Kehamilan (Minggu):", "${record.usiaKehamilan}")
                    DataRow("Jumlah Anak:", "${record.jumlahAnak}")
                    DataRow("Usia Ibu Saat Hamil:", if (record.ageRisk == 1) "<20 atau >35 tahun" else "20-35 tahun")
                    DataRow("Pendidikan Ibu:", when(record.education) {
                        2 -> "Pendidikan Tinggi"
                        1 -> "SD-SMA"
                        else -> "Tidak Tamat SD"
                    })
                    DataRow("Pendapatan Keluarga:", if (record.income == 1) "Di atas UMK (>Rp. 3.268.000)" else "Di bawah UMK (<= Rp. 3.268.000)")
                    DataRow("Memiliki Buku KIA:", if (record.kiaBook == 0) "Ya" else "Tidak")
                    DataRow("Kepimilikan JKN/JAMHESDA/BPJS:", if (record.jkn == 0) "Ya" else "Tidak")
                    DataRow("Riwayat Kelahiran:", if (record.birthRisk == 1) "Bayi Lahir Prematur (<37 Minggu)" else "Bayi Lahir Cukup Umur (≥37 Minggu)")

                    DataRow("Penyakit Infeksi:", when(record.infection) {
                        0 -> "0 Penyakit"
                        1 -> "1 Penyakit"
                        2 -> "2 Penyakit"
                        else -> ">3 Penyakit"
                    })
                    DataRow("Penyakit Tidak Menular:", when(record.nonCommunicable) {
                        0 -> "0 Penyakit"
                        1 -> "1 Penyakit"
                        2 -> "2 Penyakit"
                        else -> ">3 Penyakit"
                    })
                    DataRow("Status Gizi (KEK):", if (record.kek == 1) "Ya" else "Tidak")
                    DataRow("Riwayat ANC (4-6 Kali):", if (record.anc == 1) "Ya" else "Tidak")
                    DataRow("Tablet Tambah Darah:", if (record.feTablet == 1) "Ya" else "Tidak")
                    DataRow("LILA:", if (record.lila == 1) "Ya (Risiko)" else "Tidak (Normal)")
                    DataRow("Berat Badan Sebelum Hamil:", "${record.bbSebelumHamil} kg")
                    DataRow("Berat Badan Saat Hamil:", "${record.bbSaatHamil} kg")
                    DataRow("Tinggi Badan:", "${record.tinggiBadan} cm")
                    DataRow("Status Berat Badan:", when(record.weightGain) {
                        1 -> "Sesuai"
                        0 -> "Kurang/Lebih"
                        else -> "Tidak Terdata"
                    })
                    DataRow("Sanitasi Lingkungan:", if (record.sanitation == 1) "Layak" else "Tidak Layak")
                    DataRow("Skor Risiko:", "${record.score}")
                }
            }
        }
    }
}

@Composable
fun BalitaDataCard(record: BalitaRecord) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { expanded = !expanded },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // --- RINGKASAN (Selalu Tampil) ---
            Text(text = "Nama Ibu: ${record.namaIbu}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Nama Anak: ${record.namaAnak}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Risiko: ${record.category}", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)

            if (expanded) {
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                // --- DETAIL LENGKAP (Scrollable) ---
                Column(modifier = Modifier.heightIn(max = 350.dp).verticalScroll(rememberScrollState())) {

                    Text("Identitas Ibu", style = MaterialTheme.typography.titleSmall)
                    DataRow("Usia Menikah (Tahun):", "${record.usiaMenikah}")
                    DataRow("Jumlah Anak:", "${record.jumlahAnak}")
                    DataRow("Anak Ke:", "${record.anakKe}")
                    DataRow("Usia Bayi:", "${record.usiabayi} bulan")

                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Data Kesehatan & Risiko Ibu:", style = MaterialTheme.typography.titleSmall)
                    DataRow("Usia Ibu Saat Hamil:", if (record.ageRisk == 1) "<20 atau >35 tahun" else "20-35 tahun")
                    DataRow("Pendidikan Ibu:", when(record.education) {
                        2 -> "Pendidikan Tinggi"
                        1 -> "SD-SMA"
                        else -> "Tidak Tamat SD"
                    })
                    DataRow("Pendapatan Keluarga:", if (record.income == 1) "Di atas UMK (>Rp. 3.268.000)" else "Di bawah UMK (<= Rp. 3.268.000)")

                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Data Khusus Balita", style = MaterialTheme.typography.titleSmall)
                    DataRow("Jenis Kelamin:", when (record.childGender) {
                        1 -> "Laki-laki"
                        0 -> "Perempuan"
                        else -> "Tidak diketahui"
                    })
                    DataRow("Memiliki Buku KIA:", if (record.kiaBook == 1) "Tidak Punya" else "Punya")
                    DataRow("Kepemilikan JKN/JAMHESDA/BPJS:", if (record.jkn == 1) "Tidak Punya" else "Punya")
                    DataRow("Riwayat Kelahiran:", if (record.birthHistory == 1) "Prematur" else "Cukup Umur")
                    DataRow("Saat Hamil Anak ini, Apakah Ibu Pernah DIberitahu Oleh Petugas Kesehatan Bahwa Ibu Mengalami Kekurangan Gizi Atau Kekurangan Energi Kronik (KEK):", if (record.kek == 2) "Ya" else "Tidak")
                    DataRow("Saat Hamil Anak ini, Ibu Melakukan Pemeriksaan Kehamilan Sebanyak 4-6 Kali (Rutin):", if (record.anc == 1) "Ya" else "Tidak")
                    DataRow("Saat Hamil Anak Ini, Ibu Mendapat Tablet Tambah Darah:", if (record.feTablet == 2) "Ya" else "Tidak")
                    DataRow("Apakah Ada Anggota Keluarga Yang Merokok Di DalamRUmah Atau Dekat Bayi/Balita:", if (record.smokingExposure == 1) "Ya" else "Tidak")

                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Kondisi Sanitasi Lingkungan", style = MaterialTheme.typography.titleSmall)
                    DataRow("TApakah Keluarga Memiliki Jamban/Toilet Sendiri Yang Digunakan Sehari-Hari:", if (record.toilet == 0.5) "Tidak" else "Ya")
                    DataRow("Apakah Keluarga Memiliki Air Bersih Yang Cukup Untuk Minum, Memasak, Dan Mandi Setiap Hari:", if (record.cleanWater == 0.5) "Tidak" else "Ya")
                    DataRow("Apakah Lingkungan Sekitar RUmah Terlihat Bersih Dan Tidak Berbau:", if (record.homeEnvironment == 0.5) "Tidak" else "Ya")
                    DataRow("Apakah Kelurga Menggunakan Air Yang Aman Untuk Diminum Air Matang, Air Isi Ulang, Atau Air Kemasan:", if (record.drinkingWater == 0.5) "Tidak" else "Ya")

                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Pertumbuhan & Perkembangan:", style = MaterialTheme.typography.titleSmall)
                    DataRow("PB/TB Bayi/Balita:", "${record.tinggiBadan ?: "-"} cm")
                    DataRow("Status PB/TB (TB/U):", when (record.tbu) {
                        3 -> "Sangat Pendek (Severe Stunting)"
                        2 -> "Pendek (Moderate Stunting)"
                        0 -> "Normal"
                        else -> "Data tidak valid/belum diisi"
                    })
                    DataRow("Berat Badan:", "${record.tinggiBadan} kg")
                    DataRow("Status BB/U:", when (record.bbu) {
                        3 -> "Gizi Buruk / Sangat Kurang"
                        1 -> "Gizi Kurang"
                        0 -> "Gizi Baik / Normal"
                        else -> "Data belum lengkap"
                    })
                    DataRow("Pemberian Asi Eksklusif:", if (record.exclusiveBreastfeeding == 2) "Tidak" else "Ya")
                    DataRow("Riwayat Berat Badan Lahir <2500 Gram:", if (record.birthWeightRisk == 1) "Ya" else "Tidak")
                    DataRow("Riwayat Panjang Bayi Lahir <= 48 cm:", when (record.shortBirthLength) {
                        1 -> "Ya (<= 48 cm)"
                        0 -> "Tidak (> 48 cm)"
                        else -> "Data tidak tersedia"
                    })
                    DataRow("Kenaikan Berat Badan per Bulan:", when (record.kenaikanberat) {
                        0 -> "Ya (Normal/Naik)"
                        1 -> "Tidak (Tidak Naik)"
                        else -> "Data tidak tersedia"
                    })
                    DataRow("Timbang Balita Rutin (>= 8x/thn):", when (record.timbangbalita) {
                        0 -> "Ya (Rutin)"
                        1 -> "Tidak (Tidak Rutin)"
                        else -> "Data tidak tersedia"
                    })
                    DataRow("Pengukuran Panjang/TB Rutin (>= 2x/thn):", when (record.ukurpanjang) {
                        0 -> "Ya (Rutin)"
                        1 -> "Tidak (Tidak Rutin)"
                        else -> "Data belum diisi"
                    })
                    DataRow("Bayi Menerima Imunisasi Dasar:", if (record.immunization == 0) "Ya" else "Tidak Lengkap")
                    DataRow("Balita Menerima VitaminA Sesuai Umur:", if (record.vitaminA == 0) "Ya" else "Tidak")
                    DataRow("Riwayat Balita Menderita ISPA Dalam 3 Bulan Terakhir:", if (record.ispa == 3) "Ya" else "Tidak")
                    DataRow("Riwayat Balita Menderita Oneumonia (Penyakit Paru):", if (record.pneumonia == 2) "Ya" else "Tidak")
                    DataRow("Pernah Diare Dalam 3 Bulan Terakhir:", if (record.diarrhea == 2) "Ya" else "Tidak")
                    DataRow("Riwayat Balita Pernah Rawat Inap Di Rumah Sakit/Puskesmas:", if (record.rawatinap == 1) "Ya" else "Tidak")
                    DataRow("Balita Memiliki Kebiasaan Tidur Larut Malam:", if (record.sleepHabit == 1) "Ya" else "Tidak")
                    DataRow("Menu Harian Sehat:", if (record.diet == 0) "Ya" else "Tidak")
                    if (record.diet == 0) {
                        Text(
                            text = "Detail Menu: Karbohidrat (Nasi/Kentang/Ubi/Roti) & Protein Hewani (Ikan/Telur/Daging/Ayam)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}