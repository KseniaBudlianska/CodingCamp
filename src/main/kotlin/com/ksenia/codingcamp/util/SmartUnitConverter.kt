package com.ksenia.codingcamp.util

import com.ksenia.codingcamp.domain.MeasurementUnit
import com.ksenia.codingcamp.domain.MeasurementUnit.GRAM
import com.ksenia.codingcamp.domain.MeasurementUnit.LITER
import com.ksenia.codingcamp.domain.MeasurementUnit.MILLILITER
import com.ksenia.codingcamp.domain.MeasurementUnit.OUNCE
import com.ksenia.codingcamp.domain.Unit
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.GRAMS_TO_OUNCES
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.LITERS_TO_MILLILITERS
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.MILLILITERS_TO_LITERS
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.OUNCES_TO_GRAMS
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToInt

class SmartUnitConverter {

    fun smarterConverter(amount: Double, originUnit: Unit, convertedUnit: Unit): Double {
        val inboundConversionFactor = originUnit.getFactor()  // Unit -> Base
        val outboundConversionFactor = 1 / convertedUnit.getFactor() // Base -> New unit
        if (originUnit.javaClass != convertedUnit.javaClass) {
            throw InputMismatchException("Not the same types.")
        } else return roundToTwoDecimalPlaces(amount * inboundConversionFactor * outboundConversionFactor, 2)
    }

    fun smartConvert(amount: Double, originUnit: MeasurementUnit, convertedUnit: MeasurementUnit): Double {
        return when {
            (originUnit == GRAM) && (convertedUnit == OUNCE) -> convert(amount, GRAMS_TO_OUNCES)
            (originUnit == OUNCE) && (convertedUnit == GRAM) -> convert(amount, OUNCES_TO_GRAMS)
            (originUnit == MILLILITER) && (convertedUnit == LITER) -> convert(amount, MILLILITERS_TO_LITERS)
            (originUnit == LITER) && (convertedUnit == MILLILITER) -> convert(amount, LITERS_TO_MILLILITERS)
            else -> throw IllegalStateException("Not supported conversion: from $originUnit to $convertedUnit.")
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

    private enum class ConverterType(val conversionRatio: Double) {
        MILLILITERS_TO_LITERS(0.001),
        LITERS_TO_MILLILITERS(1000.0),
        GRAMS_TO_OUNCES(0.035274),
        OUNCES_TO_GRAMS(28.34952)
    }
}
