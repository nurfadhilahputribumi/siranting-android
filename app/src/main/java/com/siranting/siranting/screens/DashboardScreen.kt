package com.siranting.siranting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siranting.siranting.R
import com.siranting.siranting.viewmodel.SirantingViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.siranting.siranting.utils.AppLanguage
import com.siranting.siranting.utils.Texts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: SirantingViewModel,
    onPregnancy: () -> Unit,
    onLactation: () -> Unit,
    onEducation: () -> Unit
) {

    val lang by AppLanguage.current.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "SIRANTING",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            // HEADER IMAGE
            Image(
                painter = painterResource(R.drawable.dashboard1),
                contentDescription = "Dashboard",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(20.dp))

            // WELCOME CARD
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                elevation = cardElevation(
                    defaultElevation = 6.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = Texts.welcome(lang),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = Texts.dashboardDescription(lang),
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // MENU 1
            DashboardMenuCard(
                emoji = "🤰",
                title = Texts.pregnancyScreening(lang),
                description = Texts.pregnancyDesc(lang),
                onClick = onPregnancy
            )

            Spacer(modifier = Modifier.height(16.dp))

            // MENU 2
            DashboardMenuCard(
                emoji = "👶",
                title = Texts.childScreening(lang),
                description = Texts.childDesc(lang),
                onClick = onLactation
            )

            Spacer(modifier = Modifier.height(16.dp))

            // MENU 3
            DashboardMenuCard(
                emoji = "🎓",
                title = Texts.education(lang),
                description = Texts.educationDesc(lang),
                onClick = onEducation
            )

            Spacer(modifier = Modifier.height(30.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = Texts.systemName(lang),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "SIRANTING v1.0",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.outline
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun DashboardMenuCard(
    emoji: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        elevation = cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = emoji,
                fontSize = 42.sp
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column {

                Text(
                    text = title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = description,
                    fontSize = 16.sp,
                    lineHeight = 22.sp
                )
            }
        }
    }
}