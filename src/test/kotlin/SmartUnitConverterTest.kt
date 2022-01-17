import com.ksenia.codingcamp.util.SmartUnitConverter
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.GRAMS_TO_OUNCES
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.LITERS_TO_MILLILITERS
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.MILLILITERS_TO_LITERS
import com.ksenia.codingcamp.util.SmartUnitConverter.ConverterType.OUNCES_TO_GRAMS
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SmartUnitConverterTest {

    private val converter = SmartUnitConverter()

    @Test
    fun shouldConvertOneHundredGramsToOunces() {
        val ounces = converter.convert(100.0, GRAMS_TO_OUNCES)

        assertEquals(3.53, ounces)
    }

    @Test
    fun shouldConvertZeroGramsToOunces() {
        val ounces = converter.convert(0.0, GRAMS_TO_OUNCES)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenGramsToOunces() {
        val ounces = converter.convert(10.0, GRAMS_TO_OUNCES)

        assertEquals(0.35, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeGramsToOunces() {
        assertThrows(NumberFormatException::class.java) {
            converter.convert(-28.34952, GRAMS_TO_OUNCES)
        }
    }

    @Test
    fun shouldConvertOneHundredOuncesToGrams() {
        val ounces = converter.convert(100.0, OUNCES_TO_GRAMS)

        assertEquals(2834.95, ounces)
    }

    @Test
    fun shouldConvertZeroOuncesToGrams() {
        val ounces = converter.convert(0.0, OUNCES_TO_GRAMS)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenOuncesToGrams() {
        val ounces = converter.convert(10.0, OUNCES_TO_GRAMS)

        assertEquals(283.5, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeOuncesToGrams() {
        assertThrows(NumberFormatException::class.java) {
            converter.convert(-28.34952, OUNCES_TO_GRAMS)
        }
    }

    @Test
    fun shouldConvertOneHundredMillilitersToLiters() {
        val ounces = converter.convert(100.0, MILLILITERS_TO_LITERS)

        assertEquals(0.1, ounces)
    }

    @Test
    fun shouldConvertZeroMillilitersToLiters() {
        val ounces = converter.convert(0.0, MILLILITERS_TO_LITERS)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenMillilitersToLiters() {
        val ounces = converter.convert(10.0, MILLILITERS_TO_LITERS)

        assertEquals(0.01, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeMillilitersToLiters() {
        assertThrows(NumberFormatException::class.java) {
            converter.convert(-28.34952, MILLILITERS_TO_LITERS)
        }
    }

    @Test
    fun shouldConvertOneHundredLitersToMilliliters() {
        val ounces = converter.convert(100.0, LITERS_TO_MILLILITERS)

        assertEquals(100000.0, ounces)
    }

    @Test
    fun shouldConvertZeroLitersToMilliliters() {
        val ounces = converter.convert(0.0, LITERS_TO_MILLILITERS)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenLitersToMilliliters() {
        val ounces = converter.convert(10.0, LITERS_TO_MILLILITERS)

        assertEquals(10000.0, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeLitersToMilliliters() {
        assertThrows(NumberFormatException::class.java) {
            converter.convert(-28.34952, LITERS_TO_MILLILITERS)
        }
    }
}
