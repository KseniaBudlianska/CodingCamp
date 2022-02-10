import com.ksenia.codingcamp.domain.Recipe
import com.ksenia.codingcamp.service.RecipeService
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.Collections.emptyList
import kotlin.test.assertEquals

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

    @Test
    fun findRecipeByNameReturnsNullIfNoRecipe() {
        val returnedRecipes = recipeService.findRecipeByName("My recipe 2")

        assertEquals(returnedRecipes, emptyList())
        assertEquals(mockAdapter.recipeToBeSearched, "My recipe 2")
    }

    @Test
    fun findRecipeByNameReturnsRecipeIfValidRecipe() {
        val recipeName = "My recipe 1"
        val recipeToBeReturn = listOf(Recipe(recipeName, "", emptyList(), ""))

        mockAdapter.foundRecipe = recipeToBeReturn

        val recipe = recipeService.findRecipeByName(recipeName)

        assertEquals(recipeToBeReturn, recipe)
        assertEquals(mockAdapter.recipeToBeSearched, recipeName)
    }

    @Test
    fun findRecipeByNameReturnsNullIfNotValidRecipe() {
        val recipeName = "My recipe 1"
        val recipeToBeReturn = Recipe(recipeName, "", emptyList(), "")

        mockAdapter.foundRecipe = emptyList()

        val recipe = recipeService.findRecipeByName(recipeToBeReturn.recipeName + "!")

        assertEquals(emptyList(), recipe)
        assertEquals(mockAdapter.recipeToBeSearched, recipeName + "!")
    }
}
