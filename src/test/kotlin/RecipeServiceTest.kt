import com.ksenia.codingcamp.domain.Recipe
import com.ksenia.codingcamp.service.RecipeService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Collections.emptyList

class RecipeServiceTest {

    private val mockAdapter = RecipeSpyAdapter()
    private val recipeService = RecipeService(mockAdapter)

    @Test
    fun createRecipe() {
        val recipe = Recipe("My Recipe", "", emptyList(), "")

        recipeService.createRecipe(recipe)

        val createdRecipe = mockAdapter.createdRecipe

        assertTrue(createdRecipe == recipe)
    }

    @Test
    fun readRecipe() {
        val recipes = listOf(
            Recipe("My recipe 1", "", emptyList(), ""),
            Recipe("My recipe 1", "", emptyList(), ""),
            Recipe("My recipe 1", "", emptyList(), ""),
            Recipe("My recipe 1", "", emptyList(), "")
        )
        mockAdapter.repositoryRecipes = recipes

        val returnedRecipes = recipeService.readRecipes()

        assertTrue(returnedRecipes == recipes)
    }

    @Test
    fun updateRecipe() {
        val recipe = Recipe("My recipe 1", "", emptyList(), "")

        recipeService.updateRecipe(recipe)

        val updatedRecipe = mockAdapter.updatedRecipe

        assertTrue(recipe == updatedRecipe)
    }

    @Test
    fun deleteRecipe() {
        val recipe = Recipe("My recipe 1", "", emptyList(), "")

        recipeService.deleteRecipe(recipe)

        val deletedRecipe = mockAdapter.deletedRecipe

        assertTrue(recipe == deletedRecipe)
    }
}
