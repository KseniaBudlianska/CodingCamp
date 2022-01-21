package com.ksenia.codingcamp.domain

data class Recipe(
    val recipeName: String,
    val timeToPrepare: String, // todo review
    val ingredients: List<Ingredient>,
    val instruction: String
)

data class Ingredient(
   val name: String,
   val amount: Double,
   val unit: MeasurementUnit? = null
)

enum class MeasurementUnit {
    UNIT,
    TBSP,
    CUP,
    GRAM,
    OUNCE,
    LITER,
    MILLILITER
}

enum class VolumeMeasurementUnit(
    private val inboundConversionFactor: Double
): Unit {
    LITER(1000.0),
    MILLILITER(1.0),
    FLUID_OUNCE(29.5735);

    override fun getFactor(): Double {
        return this.inboundConversionFactor
    }
}

enum class MassMeasurementUnit(
    private val inboundConversionFactor: Double
): Unit {
    GRAM(0.001),
    KILOGRAM(1.0),
    OUNCE(0.0283495);

    override fun getFactor(): Double {
        return this.inboundConversionFactor
    }
}

interface Unit {
    fun getFactor(): Double
}
