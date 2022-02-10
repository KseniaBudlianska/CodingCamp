package com.ksenia.codingcamp.service

import com.ksenia.codingcamp.adapter.recipe.RecipeProvider
import com.ksenia.codingcamp.domain.Recipe

class RecipeService(
    private val recipeAdapter: RecipeProvider
) {

    fun createRecipe(recipe: Recipe) {
        recipeAdapter.createRecipe(recipe)
    }

    fun readRecipes(): List<Recipe> {
        return recipeAdapter.readRecipes()
    }

    fun updateRecipe(recipe: Recipe) {
        recipeAdapter.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe) {
        recipeAdapter.deleteRecipe(recipe)
    }

    fun findRecipeByName(recipe: String) : List<Recipe?> {
        return recipeAdapter.findRecipesByName(recipe)
    }
}
