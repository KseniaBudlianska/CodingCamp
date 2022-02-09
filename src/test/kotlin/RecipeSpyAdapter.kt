import com.ksenia.codingcamp.adapter.recipe.RecipeProvider
import com.ksenia.codingcamp.domain.Recipe

class RecipeSpyAdapter : RecipeProvider {

    lateinit var createdRecipe: Recipe
    lateinit var repositoryRecipes: List<Recipe>
    lateinit var updatedRecipe: Recipe
    lateinit var deletedRecipe: Recipe
    var recipeToBeSearched: Recipe? = null
    var foundRecipe: Recipe? = null

    override fun createRecipe(recipe: Recipe) {
        createdRecipe = recipe
    }

    override fun readRecipes(): List<Recipe> {
        return repositoryRecipes
    }

    override fun updateRecipe(recipe: Recipe) {
        updatedRecipe = recipe
    }

    override fun deleteRecipe(recipe: Recipe) {
        deletedRecipe = recipe
    }

    override fun findRecipeByName(recipeName: String) : Recipe? {
        recipeToBeSearched = Recipe(recipeName, "", emptyList(), "")
        return foundRecipe
    }
}
