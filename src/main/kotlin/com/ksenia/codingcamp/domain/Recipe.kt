package com.ksenia.codingcamp.domain

data class Recipe(
    val recipeName: String,
    val timeToPrepare: String, // todo review
    val ingredients: List<Ingredient>,
    val instruction: String
)

data class Ingredient(
    val name: String,
    val amount: Double,
    val unit: Unit?
)
