package com.ksenia.codingcamp.adapter.recipe

import com.ksenia.codingcamp.domain.Recipe

interface RecipeProvider {

    fun createRecipe(recipe: Recipe)

    fun readRecipes(): List<Recipe>

    fun updateRecipe(recipe: Recipe)

    fun deleteRecipe(recipe: Recipe)

    fun findRecipesByName(recipeName: String) : List<Recipe?>
}
