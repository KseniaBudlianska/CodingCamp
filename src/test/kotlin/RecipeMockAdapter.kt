import com.ksenia.codingcamp.adapter.recipe.RecipeProvider
import com.ksenia.codingcamp.domain.Recipe

class RecipeMockAdapter : RecipeProvider {

    private lateinit var createdRecipe: Recipe

    override fun createRecipe(recipe: Recipe) {
        createdRecipe = recipe
    }

    fun getCreatedRecipe(): Recipe {
        return createdRecipe
    }

    override fun readRecipes(): List<Recipe> {
        TODO("Not yet implemented")
    }

    override fun updateRecipe(recipe: Recipe) {
        TODO("Not yet implemented")
    }

    override fun deleteRecipe(recipe: Recipe) {
        TODO("Not yet implemented")
    }
}
