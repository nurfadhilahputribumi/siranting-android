package com.siranting.siranting.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siranting.siranting.viewmodel.SirantingViewModel
import com.siranting.siranting.components.SectionTitle
import com.siranting.siranting.components.RadioGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts


@Composable
fun PregnancyFormScreen(
    viewModel: SirantingViewModel,
    onSubmit: () -> Unit
) {
    val lang by AppLanguage.current.collectAsState()

    val state = viewModel.pregnancyInput

    var infeksi by remember { mutableStateOf<Int?>(null) }
    var nonInfeksi by remember { mutableStateOf<Int?>(null) }
    var kek by remember { mutableStateOf<Int?>(null) }
    var anc by remember { mutableStateOf<Int?>(null) }
    var ttd by remember { mutableStateOf<Int?>(null) }
    var lila by remember { mutableStateOf<Int?>(null) }
    var bb by remember { mutableStateOf<Int?>(null) }
    var sanitasi by remember { mutableStateOf<Int?>(null) }
    var bbSebelumHamil by remember { mutableStateOf("") }
    var bbSaatHamil by remember { mutableStateOf("") }
    var tinggiBadan by remember { mutableStateOf("") }


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
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("🤰 SIRANTING", style = MaterialTheme.typography.headlineSmall)
                Text(text = Texts.judulibu(lang))
            }
        }

        // ================= PROGRESS =================
        Card {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Step ${viewModel.formStep} / 2")
                LinearProgressIndicator(
                    progress = { viewModel.formStep / 2f },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // =====================================================
        // STEP 1
        // =====================================================
        if (viewModel.formStep == 1) {

            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(text = Texts.dataibuumum(lang), style = MaterialTheme.typography.titleMedium)

                    var nama by remember { mutableStateOf("") }
                    var usiaMenikah by remember { mutableStateOf("") }
                    var jumlahAnak by remember { mutableStateOf("") }
                    var usiaKehamilan by remember { mutableStateOf("") }

                    SectionTitle(text = Texts.identitasibu(lang))

                    TextField(
                        value = state.nama,
                        onValueChange = { value ->
                            viewModel.updatePregnancy { current ->
                                current.copy(nama = value)
                            }
                        },
                        label = {Text(text = Texts.nama(lang))},
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = state.usiaMenikah,
                        onValueChange = { value ->
                            viewModel.updatePregnancy { it.copy(usiaMenikah = value) }
                        },
                        label = { Text(Texts.usiamenikah(lang)) },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    TextField(
                        value = state.usiaKehamilan,
                        onValueChange = { value ->
                            viewModel.updatePregnancy { it.copy(usiaKehamilan = value) }
                        },
                        label = { Text(Texts.usiakehamilan(lang)) },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    TextField(
                        value = state.jumlahAnak, // Ambil dari state
                        onValueChange = { value ->
                            viewModel.updatePregnancy { it.copy(jumlahAnak = value) }
                        },
                        label = { Text(Texts.jumlahanak(lang)) },
                        modifier = Modifier.fillMaxWidth()
                    )

                    QuestionCard("2.",Texts.usiaibusaathamil(lang)) {
                        RadioGroup(
                            selected = state.ageRisk,
                            options = listOf(
                                Texts.usia20_35(lang) to 0,
                                Texts.usiaRiskEkstrem(lang) to 1
                            ),
                            onSelect = { value ->
                                viewModel.updatePregnancy { it.copy(ageRisk = value) }
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
                                viewModel.updatePregnancy { it.copy(education = value) }
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
                                viewModel.updatePregnancy { it.copy(income = value) }
                            }
                        )
                    }

                    QuestionCard("5.", Texts.bukukia(lang)) {
                        RadioGroup(
                            selected = state.kiaBook,
                            options = listOf(
                                Texts.punyaBukuKIA(lang) to 0,
                                Texts.tidakPunyaBukuKIA(lang) to 1
                            ),
                            onSelect = { value ->
                                viewModel.updatePregnancy { it.copy(kiaBook = value) }
                            }
                        )
                    }

                    QuestionCard("6.", Texts.jkn(lang)) {
                        RadioGroup(
                            selected = state.jkn,
                            options = listOf(
                                Texts.punya(lang) to 0,
                                Texts.tidakPunya(lang) to 1
                            ),
                            onSelect = { value ->
                                viewModel.updatePregnancy { it.copy(jkn = value) }
                            }
                        )
                    }

                    QuestionCard("7.", Texts.riwayatkelahiran(lang)) {
                        RadioGroup(
                            selected = state.birthRisk,
                            options = listOf(
                                Texts.bayiCukupUmur(lang) to 0,
                                Texts.bayiPrematur(lang) to 1
                            ),
                            onSelect = { value ->
                                viewModel.updatePregnancy { it.copy(birthRisk = value) }
                            }
                        )
                    }

                    Button(
                        onClick = { viewModel.nextStep() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(Texts.lanjut(lang))
                    }
                }
            }
        }

        // =====================================================
        // STEP 2
        // =====================================================
        if (viewModel.formStep == 2) {

            Card {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Text(Texts.datakhususibuhamil(lang), style = MaterialTheme.typography.titleMedium)

                    QuestionCard("1.", Texts.infeksiIbuHamil(lang)) {
                        RadioGroup(
                            selected = infeksi,
                            options = listOf(
                                Texts.infeksi0(lang) to 0,
                                Texts.infeksi1(lang) to 1,
                                Texts.infeksi2(lang) to 2,
                                Texts.infeksi3plus(lang) to 3
                            ),
                            onSelect = { value ->

                                infeksi = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        infection = value
                                    )
                                }
                            }
                        )
                    }

                    QuestionCard("2.", Texts.penyakitTidakMenularHamil(lang)) {
                        RadioGroup(
                            selected = nonInfeksi,
                            options = listOf(
                                Texts.infeksi0(lang) to 0,
                                Texts.infeksi1(lang) to 1,
                                Texts.infeksi2(lang) to 2,
                                Texts.infeksi3plus(lang) to 3
                            ),
                            onSelect = { value ->

                                nonInfeksi = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        nonCommunicable = value
                                    )
                                }
                            }
                        )
                    }

                    QuestionCard("3.", Texts.statusgiziibuhamil(lang)) {
                        RadioGroup(
                            selected = kek,
                            options = listOf(
                                Texts.ya(lang) to 2,
                                Texts.tidak(lang) to 0
                            ),
                            onSelect = { value ->

                                kek = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        kek = value
                                    )
                                }
                            }
                        )
                    }

                    QuestionCard("4.", Texts.anc(lang)) {
                        RadioGroup(
                            selected = anc,
                            options = listOf(Texts.ya(lang) to 1, Texts.tidak(lang) to 0),
                            onSelect = { value ->

                                anc = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        anc = value
                                    )
                                }
                            }
                        )
                    }

                    QuestionCard("5.", Texts.tambahdarah(lang)) {
                        RadioGroup(
                            selected = ttd,
                            options = listOf(Texts.ya(lang) to 2, Texts.tidak(lang) to 0),
                            onSelect = { value ->

                                ttd = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        feTablet = value
                                    )
                                }
                            }
                        )
                    }

                    QuestionCard("6.", "LILA") {
                        RadioGroup(
                            selected = lila,
                            options = listOf(
                                Texts.lingkarLenganKecil(lang) to 2,
                                Texts.lingkarLenganNormal(lang) to 0
                            ),
                            onSelect = { value ->

                                lila = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        lila = value
                                    )
                                }
                            }
                        )
                    }

                    QuestionCard("7.", Texts.statusberatbadanibu(lang)) {

                        OutlinedTextField(
                            value = bbSebelumHamil,
                            onValueChange = { bbSebelumHamil = it },
                            label = { Text(Texts.bbSebelumHamil(lang))},
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = bbSaatHamil,
                            onValueChange = { bbSaatHamil = it },
                            label = { Text(Texts.bbSaatHamil(lang)) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = tinggiBadan,
                            onValueChange = { tinggiBadan = it },
                            label = { Text(Texts.tinggiBadan(lang)) },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )

                        val bbHamil = bbSaatHamil.toDoubleOrNull()
                        val tb = tinggiBadan.toDoubleOrNull()

                        if (bbHamil != null && tb != null && tb > 0) {

                            val bmi = bbHamil / ((tb / 100.0) * (tb / 100.0))

                            val kategori = when {
                                bmi < 18.5 -> "Underweight"
                                bmi < 25.0 -> "Normal"
                                bmi < 30.0 -> "Overweight"
                                else -> "Obese"
                            }

                            val skor = when {
                                bmi < 18.5 -> 2
                                bmi < 25.0 -> 0
                                bmi < 30.0 -> 1
                                else -> 2
                            }

                            bb = skor

                            viewModel.updatePregnancy {
                                it.copy(
                                    weightGain = skor,
                                    bbSebelumHamil = bbSebelumHamil, // Tambahkan ini
                                    bbSaatHamil = bbSaatHamil,       // Tambahkan ini
                                    tinggiBadan = tinggiBadan        // Tambahkan ini

                                )
                            }

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                ),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(12.dp)
                                ) {

                                    Text(
                                        text = "IMT : %.1f".format(bmi),
                                        style = MaterialTheme.typography.titleMedium
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

                                    Text(
                                        text = "${Texts.kategori(lang)} : $kategori",
                                        style = MaterialTheme.typography.bodyLarge
                                    )

                                    Spacer(modifier = Modifier.height(4.dp))

//                                    Text(
//                                        text = "Skor Risiko : $skor",
//                                        style = MaterialTheme.typography.bodyMedium
//                                    )
                                }
                            }
                        }
                    }

                    QuestionCard("8.", Texts.sanitasi(lang)) {
                        RadioGroup(
                            selected = sanitasi,
                            options = listOf(
                                Texts.sanitasiBaik(lang) to 0,
                                Texts.sanitasiCukup(lang) to 2,
                                Texts.sanitasiBuruk(lang) to 3
                            ),
                            onSelect = { value ->

                                sanitasi = value

                                viewModel.updatePregnancy {
                                    it.copy(
                                        sanitation = value
                                    )
                                }
                            }
                        )
                    }

                    Button(
                        onClick = {
                            viewModel.calculateResult()

                            // 👉 SIMPAN DATA KE FIRESTORE
                            viewModel.savePregnancyData()

                            // lanjut ke result screen
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
                        Text(Texts.back(lang))
                    }
                }
            }
        }
    }
}

@Composable
fun QuestionCard(
    number: String,
    question: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = number,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Text(
                    text = question,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            HorizontalDivider()

            content()
        }
    }
}