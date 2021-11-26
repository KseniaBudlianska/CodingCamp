package com.ksenia.codingcamp.adapter.recipe

import com.ksenia.codingcamp.domain.Recipe

/**
 * Adapter pattern based on Design pattern.
 */
class RecipeMemoryAdapter : RecipeProvider {

    private val repository = mutableListOf<Recipe>()

    override fun createRecipe(recipe: Recipe) {
        this.repository.add(recipe)
    }

    override fun readRecipes(): String {
        return this.repository.map { it.recipeName }.toString() // todo update it to return it better
    }

    override fun updateRecipe(recipe: Recipe, updatedRecipe: Recipe) {
        this.repository.forEach { if (it == recipe) updatedRecipe else it } // todo doesn't work, update
    }

    override fun deleteRecipe(recipe: Recipe) {
        this.repository.remove(recipe)
    }
}
