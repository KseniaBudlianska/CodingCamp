package com.ksenia.codingcamp.util

import kotlin.math.pow
import kotlin.math.roundToInt

class SmartUnitConverter {

    fun convert(weight: Double, converterType: ConverterType): Double {
        return if (weight >= 0) {
            val weight = weight * converterType.conversionRatio
            roundToTwoDecimalPlaces(weight, decimalPlaces = 2)
        } else {
            throw NumberFormatException("Negative weight cannot be converted.")
        }
    }

    private fun roundToTwoDecimalPlaces(number: Double, decimalPlaces: Int): Double {
        val shift = 10.0.pow(decimalPlaces.toDouble())
        return (number * shift).roundToInt().toDouble() / shift
    }

    enum class ConverterType(val conversionRatio: Double) {
        MILLILITERS_TO_LITERS(0.001),
        LITERS_TO_MILLILITERS(1000.0),
        GRAMS_TO_OUNCES(0.035274),
        OUNCES_TO_GRAMS(28.34952);
    }
}
