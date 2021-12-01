package com.ksenia.codingcamp.service

import com.ksenia.codingcamp.adapter.recipe.RecipeMemoryAdapter
import com.ksenia.codingcamp.domain.Recipe

class RecipeService {

    private val adapter = RecipeMemoryAdapter()

    fun createRecipe(recipe: Recipe) {
        adapter.createRecipe(recipe)
    }

    fun readRecipes(): String {
        return adapter.readRecipes()
    }

    fun updateRecipe(recipe: Recipe, updateRecipe: Recipe) {
        adapter.updateRecipe(recipe, updateRecipe)
    }

    fun deleteRecipe(recipe: Recipe) {
        adapter.deleteRecipe(recipe)
    }
}
