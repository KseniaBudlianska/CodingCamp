package com.ksenia.codingcamp.adapter.recipe

import com.ksenia.codingcamp.domain.Recipe

/**
 * Adapter pattern based on Design pattern.
 */
class RecipeMemoryAdapter : RecipeProvider {

    private val repository = mutableSetOf<Recipe>()

    override fun createRecipe(recipe: Recipe) {
        this.repository.add(recipe)
    }

    override fun readRecipes(): List<Recipe> {
        return this.repository.toList()
    }

    override fun updateRecipe(recipe: Recipe) {
        val foundRecipe = this.repository.find { it.recipeName == recipe.recipeName }
        this.repository.remove(foundRecipe)
        this.repository.add(recipe)
    }

    override fun deleteRecipe(recipe: Recipe) {
        this.repository.remove(recipe)
    }

    override fun findRecipeByName(recipeName: String): Recipe? {
        return this.repository.find { it.recipeName == recipeName }
    }
}
