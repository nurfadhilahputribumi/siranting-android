package com.siranting.siranting.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siranting.siranting.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts

data class EducationVideo(
    val title: String,
    val description: String,
    val url: String,
    val thumbnailRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationScreen(
    onBack: () -> Unit
) {

    val context = LocalContext.current
    val lang by AppLanguage.current.collectAsState()

    val videos = listOf(
        EducationVideo(
            title = Texts.videoSirantingBalitaTitle(lang),
            description = Texts.videoSirantingBalitaDesc(lang),
            url = "https://drive.google.com/file/d/12xXWMF8Z-vUy3mZHlCNgVu4b6Xjvd4K-/view?usp=sharing",
            thumbnailRes = R.drawable.video_stunting_4
        ),

        EducationVideo(
            title = Texts.videoSirantingHamilBalitaRendah(lang),
            description = Texts.videoSirantingHamilBalitaRendahDesc(lang),
            url = "https://drive.google.com/file/d/1Syz9xUqitcoTfT83Sfp0DLELTGA22gIo/view?usp=drive_link",
            thumbnailRes = R.drawable.video_risiko_rendah
        ),

        EducationVideo(
            title = Texts.videoHamilSedangTitle(lang),
            description = Texts.videoHamilSedangDesc(lang),
            url = "https://drive.google.com/file/d/1gGnos64nki_TJoPgrPeRHHNWBOKX_APA/view?usp=drive_link",
            thumbnailRes = R.drawable.ibu_hamil_sedang

        ),

        EducationVideo(
            title = Texts.videoHamilTinggiTitle(lang),
            description = Texts.videoHamilTinggiDesc(lang),
            url = "https://drive.google.com/file/d/1aB-fQK_LkOIvFlpxg1DfQoFTQ-MFpIkD/view?usp=drive_link",
            thumbnailRes = R.drawable.ibu_hamil_tinggi

        ),

        EducationVideo(
            title = Texts.videoBalitaSedangTitle(lang),
            description = Texts.videoBalitaSedangDesc(lang),
            url = "https://drive.google.com/file/d/1gGnos64nki_TJoPgrPeRHHNWBOKX_APA/view?usp=sharing",
            thumbnailRes = R.drawable.balita_sedang
        ),

        EducationVideo(
            title = Texts.videoBalitaSedangTitle(lang),
            description = Texts.videoBalitaSedangDesc(lang),
            url = "https://drive.google.com/file/d/18WswamLxQ9MhXEURTFbX5kCOsJqRy7e0/view?usp=drive_link",
            thumbnailRes = R.drawable.balita_sedang_new
        ),

        EducationVideo(
            title = Texts.videoBalitaTinggiTitle(lang),
            description = Texts.videoBalitaTinggiDesc(lang),
            url = "https://drive.google.com/file/d/1BMTGWBN2U44mVYZmdVIopIxV93cerz-P/view?usp=drive_link",
            thumbnailRes = R.drawable.ibu_balita_tinggi

        ),

        EducationVideo(
            title = Texts.videoApaItuStuntingTitle(lang),
            description = Texts.videoApaItuStuntingDesc(lang),
            url = "https://youtu.be/NU_MDQ2iNYE",
            thumbnailRes = R.drawable.video_stunting_1
        ),
        EducationVideo(
            title = Texts.videoPencegahanStuntingTitle(lang),
            description = Texts.videoPencegahanStuntingDesc(lang),
            url = "https://youtube.com/shorts/uvttdgsMxz8",
            thumbnailRes = R.drawable.video_stunting_2
        ),
        EducationVideo(
            title = Texts.videoKesehatanIbuBalitaTitle(lang),
            description = Texts.videoKesehatanIbuBalitaDesc(lang),
            url = "https://youtube.com/shorts/hDxuh3z4n_I",
            thumbnailRes = R.drawable.video_stunting_3
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = Texts.educationTitle(lang),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // HEADER
            item {
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = Texts.educationHeader(lang),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = Texts.EDUeducationDesc(lang),
                            fontSize = 16.sp
                        )
                    }
                }
            }

            // LIST VIDEO
            items(videos) { video ->

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Image(
                            painter = painterResource(id = video.thumbnailRes),
                            contentDescription = video.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = video.title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = video.description,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(video.url)
                                )
                                context.startActivity(intent)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(Texts.watchNow(lang))
                        }
                    }
                }
            }

            // BACK BUTTON
            item {

                Spacer(modifier = Modifier.height(8.dp))

                ElevatedCard(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Button(
                            onClick = onBack,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(Texts.back(lang))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}