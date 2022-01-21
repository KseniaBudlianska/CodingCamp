import com.ksenia.codingcamp.domain.MeasurementUnit.GRAMS
import com.ksenia.codingcamp.domain.MeasurementUnit.LITERS
import com.ksenia.codingcamp.domain.MeasurementUnit.MILLILITERS
import com.ksenia.codingcamp.domain.MeasurementUnit.OUNCES
import com.ksenia.codingcamp.domain.MeasurementUnit.TBSP
import com.ksenia.codingcamp.util.SmartUnitConverter
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SmartUnitConverterTest {

    private val converter = SmartUnitConverter()

    @Test
    fun shouldConvertOneHundredGramsToOunces() {
        val ounces = converter.smartConvert(100.0, GRAMS, OUNCES)

        assertEquals(3.53, ounces)
    }

    @Test
    fun shouldConvertZeroGramsToOunces() {
        val ounces = converter.smartConvert(0.0, GRAMS, OUNCES)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenGramsToOunces() {
        val ounces = converter.smartConvert(10.0, GRAMS, OUNCES)

        assertEquals(0.35, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeGramsToOunces() {
        assertThrows(NumberFormatException::class.java) {
            converter.smartConvert(-28.34952, GRAMS, OUNCES)
        }
    }

    @Test
    fun shouldConvertOneHundredOuncesToGrams() {
        val ounces = converter.smartConvert(100.0, OUNCES, GRAMS)

        assertEquals(2834.95, ounces)
    }

    @Test
    fun shouldConvertZeroOuncesToGrams() {
        val ounces = converter.smartConvert(0.0, OUNCES, GRAMS)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenOuncesToGrams() {
        val ounces = converter.smartConvert(10.0, OUNCES, GRAMS)

        assertEquals(283.5, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeOuncesToGrams() {
        assertThrows(NumberFormatException::class.java) {
            converter.smartConvert(-28.34952, OUNCES, GRAMS)
        }
    }

    @Test
    fun shouldConvertOneHundredMillilitersToLiters() {
        val ounces = converter.smartConvert(100.0, MILLILITERS, LITERS)

        assertEquals(0.1, ounces)
    }

    @Test
    fun shouldConvertZeroMillilitersToLiters() {
        val ounces = converter.smartConvert(0.0, MILLILITERS, LITERS)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenMillilitersToLiters() {
        val ounces = converter.smartConvert(10.0, MILLILITERS, LITERS)

        assertEquals(0.01, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeMillilitersToLiters() {
        assertThrows(NumberFormatException::class.java) {
            converter.smartConvert(-28.34952, MILLILITERS, LITERS)
        }
    }

    @Test
    fun shouldConvertOneHundredLitersToMilliliters() {
        val ounces = converter.smartConvert(100.0, LITERS, MILLILITERS)

        assertEquals(100000.0, ounces)
    }

    @Test
    fun shouldConvertZeroLitersToMilliliters() {
        val ounces = converter.smartConvert(0.0, LITERS, MILLILITERS)

        assertEquals(0.0, ounces)
    }

    @Test
    fun shouldConvertTenLitersToMilliliters() {
        val ounces = converter.smartConvert(10.0, LITERS, MILLILITERS)

        assertEquals(10000.0, ounces)
    }

    @Test
    fun shouldFailToConvertNegativeLitersToMilliliters() {
        assertThrows(NumberFormatException::class.java) {
            converter.smartConvert(-28.34952, LITERS, MILLILITERS)
        }
    }

    @Test
    fun shouldFailToConvertLitersToLiters() {
        assertThrows(IllegalStateException::class.java) {
            converter.smartConvert(28.34952, LITERS, LITERS)
        }
    }

    @Test
    fun shouldFailToConvertLitersToTbsp() {
        assertThrows(IllegalStateException::class.java) {
            converter.smartConvert(20.0, LITERS, TBSP)
        }
    }
}
