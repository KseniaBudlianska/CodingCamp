import com.ksenia.codingcamp.domain.Recipe
import com.ksenia.codingcamp.service.RecipeService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Collections.emptyList

class RecipeServiceTest {

    private val mockAdapter = RecipeMockAdapter()
    private val recipeService = RecipeService(mockAdapter)

    @Test
    fun createRecipe() {
        val recipe = Recipe("My Recipe", "", emptyList(), "")

        recipeService.createRecipe(recipe)

        val createRecipe = mockAdapter.getCreatedRecipe()

        assertTrue(createRecipe == recipe)
    }

    /*@Test
    fun readRecipe() {
        recipeSrvice.readRecipe()
    }

    @Test
    fun updateRecipe() {
        recipeSrvice.updateRecipe(recipe)
    }

    @Test
    fun deleteRecipe() {
        recipeSrvice.deleteRecipe(recipe)
    }*/
}
