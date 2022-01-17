package com.ksenia.codingcamp.util

import com.ksenia.codingcamp.domain.MeasurementUnit
import com.ksenia.codingcamp.domain.MeasurementUnit.GRAMS
import com.ksenia.codingcamp.domain.MeasurementUnit.LITERS
import com.ksenia.codingcamp.domain.MeasurementUnit.MILLILITERS
import com.ksenia.codingcamp.domain.MeasurementUnit.OUNCES
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.GRAMS_TO_OUNCES
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.LITERS_TO_MILLILITERS
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.MILLILITERS_TO_LITERS
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.OUNCES_TO_GRAMS
import kotlin.math.pow
import kotlin.math.roundToInt

class SmartUnitConverter {

    fun smartConvert(amount: Double, originUnit: MeasurementUnit, convertedUnit: MeasurementUnit): Double {
        return when {
            (originUnit == GRAMS) && (convertedUnit == OUNCES) -> convert(amount, GRAMS_TO_OUNCES)
            (originUnit == OUNCES) && (convertedUnit == GRAMS) -> convert(amount, OUNCES_TO_GRAMS)
            (originUnit == MILLILITERS) && (convertedUnit == LITERS) -> convert(amount, MILLILITERS_TO_LITERS)
            (originUnit == LITERS) && (convertedUnit == MILLILITERS) -> convert(amount, LITERS_TO_MILLILITERS)
            else -> throw IllegalStateException("Not supported conversion.")
        }
    }

    private fun convert(weight: Double, converterType: ConverterType): Double {
        return if (weight >= 0) {
            val newWeight = weight * converterType.conversionRatio
            roundToTwoDecimalPlaces(newWeight, decimalPlaces = 2)
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
