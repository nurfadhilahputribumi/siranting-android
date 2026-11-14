package com.siranting.siranting.utils

import com.siranting.siranting.models.*

object ScoringEngine {

    fun pregnancyScore(input: MotherPregnancyInput): Int {
        return listOfNotNull(
            input.ageRisk,
            input.education,
            input.income,
            input.kiaBook,
            input.jkn,
            input.birthRisk,
            input.infection,
            input.nonCommunicable,
            input.kek,
            input.anc,
            input.feTablet,
            input.lila,
            input.weightGain,
            input.sanitation
        ).sum()
    }

    fun balitaScore(input: BalitaInput): Int {
        return (input.ageRisk ?: 0) +
                (input.education ?: 0) +
                (input.income ?: 0) +
                (input.childGender ?: 0) +
                (input.kiaBook ?: 0) +
                (input.jkn ?: 0) +
                (input.birthHistory ?: 0) +
                (input.kek ?: 0) +
                (input.anc ?: 0) +
                (input.feTablet ?: 0) +
                (input.smokingExposure ?: 0) +
                ((input.toilet ?: 0.0).toInt()) +
                ((input.cleanWater ?: 0.0).toInt()) +
                ((input.homeEnvironment ?: 0.0).toInt()) +
                ((input.drinkingWater ?: 0.0).toInt()) +
                (input.tbu ?: 0) +
                (input.bbu ?: 0) +
                (input.birthWeightRisk ?: 0) +
                (input.exclusiveBreastfeeding ?: 0) +
                (input.shortBirthLength ?: 0) +
                (input.kenaikanberat ?: 0) +
                (input.timbangbalita ?: 0) +
                (input.ukurpanjang ?: 0) +
                (input.immunization ?: 0) +
                (input.vitaminA ?: 0) +
                (input.ispa ?: 0) +
                (input.pneumonia ?: 0) +
                (input.diarrhea ?: 0) +
                (input.rawatinap ?: 0) +
                (input.sleepHabit ?: 0) +
                (input.diet ?: 0)
    }

    fun pregnancyRiskCategory(score: Int): String {
        return when {
            score <= 6 -> "Risiko Rendah"
            score <= 12 -> "Risiko Sedang"
            else -> "Risiko Tinggi"
        }
    }

    fun balitaRiskCategory(score: Int): String {
        return when {
            score <= 11 -> "Risiko Rendah"
            score <= 23 -> "Risiko Sedang"
            else -> "Risiko Tinggi"
        }
    }
}