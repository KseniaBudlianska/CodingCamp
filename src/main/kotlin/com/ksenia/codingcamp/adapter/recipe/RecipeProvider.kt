package com.ksenia.codingcamp.adapter.recipe

import com.ksenia.codingcamp.domain.Recipe

interface RecipeProvider {

    fun createRecipe(recipe: Recipe)
    fun readRecipes(): String
    fun updateRecipe(recipe: Recipe, updatedRecipe: Recipe)
    fun deleteRecipe(recipe: Recipe)
}
