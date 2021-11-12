import com.ksenia.codingcamp.domain.Ingredient
import com.ksenia.codingcamp.domain.Recipe

fun main() {
    val lemonCake = createRecipe(
        "Lemon Cake",
        "60 minutes",
        "Bla bla bla",
        Ingredient(
            "Lemon",
            1.0,
            "unit"
        ),
        Ingredient(
            "Predefined Cake",
            1.0
        ),
        Ingredient(
            "Cream",
            200.0,
            "ml"
        )
    )

    val teaDrink = createRecipe(
        "Herbal Tea",
        "1 minute",
        "Bla bla bla",
        Ingredient(
            "Herbal tea bag",
            1.0,
            "unit"
        ),
        Ingredient(
            "Water",
            500.0,
            "ml"
        )
    )

    println(lemonCake)
    println(teaDrink)
}

fun createRecipe(recipeName: String, timeToPrepare : String, instruction: String, vararg ingredients: Ingredient): Recipe {
    return Recipe(
        recipeName = recipeName,
        timeToPrepare = timeToPrepare,
        ingredients = ingredients.toList(),
        instruction = instruction
    );
}
