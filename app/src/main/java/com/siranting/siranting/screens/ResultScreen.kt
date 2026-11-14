package com.siranting.siranting.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.siranting.siranting.R
import com.siranting.siranting.viewmodel.ModeType
import com.siranting.siranting.viewmodel.SirantingViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts

data class RecommendationVideo(
    val title: String,
    val description: String,
    val url: String,
    val thumbnailRes: Int
)

@Composable
fun ResultScreen(
    viewModel: SirantingViewModel,
    onFinish: () -> Unit
) {
    val lang by AppLanguage.current.collectAsState()

    val result = viewModel.riskResult
    val color = viewModel.getRiskColor(result.category)

    Text("VM Lang = ${viewModel.lang}")
    Text("App Lang = $lang")
    Text("Category = ${result.category}")
    Text("Low = ${Texts.risikoRendah(lang)}")

    val mode = viewModel.mode
    val context = LocalContext.current

    val progress = ((result.score.coerceIn(0.0, 20.0)) / 20.0).toFloat()

    val recommendedVideos = when (mode) {

        ModeType.PREGNANCY -> {

            when (result.category) {

                Texts.risikoRendah(lang) -> listOf(
                    RecommendationVideo(
                        title = Texts.videoSirantingHamilBalitaRendah(lang),
                        description = Texts.videoSirantingHamilBalitaRendahDesc(lang),
                        url = "https://drive.google.com/file/d/1Syz9xUqitcoTfT83Sfp0DLELTGA22gIo/view?usp=drive_link",
                        thumbnailRes = R.drawable.video_risiko_rendah
                    ),
                )

                Texts.risikoSedang(lang) -> listOf(
                    RecommendationVideo(
                        title = Texts.videoHamilSedangTitle(lang),
                        description = Texts.videoHamilSedangDesc(lang),
                        url = "https://drive.google.com/file/d/1gGnos64nki_TJoPgrPeRHHNWBOKX_APA/view?usp=drive_link",
                        thumbnailRes = R.drawable.ibu_hamil_sedang

                    )
                )

                else -> listOf(
                    RecommendationVideo(
                        title = Texts.videoHamilTinggiTitle(lang),
                        description = Texts.videoHamilTinggiDesc(lang),
                        url = "https://drive.google.com/file/d/1aB-fQK_LkOIvFlpxg1DfQoFTQ-MFpIkD/view?usp=drive_link",
                        thumbnailRes = R.drawable.ibu_hamil_tinggi
                    )
                )
            }
        }

        ModeType.LACTATION -> {

            when (result.category) {

                Texts.risikoRendah(lang) -> listOf(
                    RecommendationVideo(
                        title = Texts.videoSirantingHamilBalitaRendah(lang),
                        description = Texts.videoSirantingHamilBalitaRendahDesc(lang),
                        url = "https://drive.google.com/file/d/1Syz9xUqitcoTfT83Sfp0DLELTGA22gIo/view?usp=drive_link",
                        thumbnailRes = R.drawable.video_risiko_rendah
                    ),
                )

                Texts.risikoSedang(lang) -> listOf(
                    RecommendationVideo(
                        title = Texts.videoBalitaSedangTitle(lang),
                        description = Texts.videoBalitaSedangDesc(lang),
                        url = "https://drive.google.com/file/d/1gGnos64nki_TJoPgrPeRHHNWBOKX_APA/view?usp=sharing",
                        thumbnailRes = R.drawable.balita_sedang
                    ),
                    RecommendationVideo(
                        title = Texts.videoBalitaSedangTitle(lang),
                        description = Texts.videoBalitaSedangDesc(lang),
                        url = "https://drive.google.com/file/d/18WswamLxQ9MhXEURTFbX5kCOsJqRy7e0/view?usp=sharing",
                        thumbnailRes = R.drawable.balita_sedang_new
                    )
                )

                else -> listOf(
                    RecommendationVideo(
                        title = Texts.videoBalitaTinggiTitle(lang),
                        description = Texts.videoBalitaTinggiDesc(lang),
                        url = "https://drive.google.com/file/d/1BMTGWBN2U44mVYZmdVIopIxV93cerz-P/view?usp=drive_link",
                        thumbnailRes = R.drawable.ibu_balita_tinggi
                    )
                )
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            // ================= HEADER =================

            Text(
                text = Texts.hasilPemeriksaanPasien(lang),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            // ================= IDENTITAS =================

            Card(
                elevation = CardDefaults.cardElevation(2.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {

                    Text(
                        text = "👤${Texts.identitasibu(lang)}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    HorizontalDivider()

                    when (mode) {

                        ModeType.PREGNANCY -> {
                            Text("${Texts.nama(lang)}: ${viewModel.pregnancyInput.nama}")
                            Text("${Texts.usiamenikah(lang)}: ${viewModel.pregnancyInput.usiaMenikah} Tahun")
                            Text("${Texts.usiakehamilan(lang)}: ${viewModel.pregnancyInput.usiaKehamilan} Minggu")
                            Text(Texts.statusIbuHamil(lang))
                        }

                        ModeType.LACTATION -> {
                            Text("${Texts.nama(lang)}: ${viewModel.balitaInput.namaIbu}")
                            Text("${Texts.namaAnak(lang)}: ${viewModel.balitaInput.namaAnak}")
                            Text("${Texts.anakKe(lang)}: ${viewModel.balitaInput.anakKe}")
                            Text(Texts.statusIbuBalita(lang))
                        }
                    }

                    Text(
                        "Mode: ${
                            when (mode) {
                                ModeType.PREGNANCY -> "Pregnancy Screening"
                                ModeType.LACTATION -> "Balita Screening"
                            }
                        }"
                    )
                }
            }

            // ================= HASIL RISIKO =================

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = color.copy(alpha = 0.15f)
                )
            ) {

                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        Texts.hasilRisiko(lang),
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = result.category,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = color
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier.fillMaxWidth(),
                        color = color
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("Skor: ${result.score}")
                }
            }

            // ================= DETAIL =================

            Card(
                elevation = CardDefaults.cardElevation(2.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(
                            Texts.kategori(lang),
                            style = MaterialTheme.typography.labelMedium
                        )

                        Text(
                            result.category,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .background(
                                color,
                                shape = MaterialTheme.shapes.small
                            )
                    )
                }
            }

            // ================= INTERPRETASI =================

            Card(
                elevation = CardDefaults.cardElevation(2.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = Texts.interpretasiKlinis(lang),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    HorizontalDivider()

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(result.explanation)
                }
            }

            // ================= EDUKASI =================

            Text(
                text = Texts.rekomendasiEdukasi(lang),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            recommendedVideos.forEach { video ->

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Image(
                            painter = painterResource(video.thumbnailRes),
                            contentDescription = video.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            video.title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(video.description)

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {
                                context.startActivity(
                                    Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(video.url)
                                    )
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(Texts.tontonSekarang(lang))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ================= BUTTON =================

            Button(
                onClick = onFinish,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(Texts.selesai(lang))
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}