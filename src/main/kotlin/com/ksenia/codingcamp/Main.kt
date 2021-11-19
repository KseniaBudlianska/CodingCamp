import com.ksenia.codingcamp.domain.Ingredient
import com.ksenia.codingcamp.domain.Recipe

fun main() {
    /**
     * Problems:
     * - amount of steps is not clear
     * - time is in text
     * - unit has different meaning across different countries and it needs convertation (Cup, Tbsp to Gram).
     */
    val brownies = createRecipe("Squash Fudge Brownies", "60 minutes",
        """
            Preheat the oven to 350 degrees and coat a small 4 x 6 or 6 x 6 loaf pan with cooking spray and set aside- A smaller pan yields thicker brownies.
            Add all your ingredients into a high speed blender, food processor or large bowl and mix until fully immersed and a thick batter is formed.
            Transfer brownie batter to loaf pan and bake for 12-15 minutes, or until a skewer comes out just clean. 
            Allow the brownies to cool in the pan completely before frosting. Brownies need to kept refrigerated for the best texture.
        """.trimIndent(),
        Ingredient("Butternut squash puree", 1.0, "Cup"),
        Ingredient("Drippy almond butter", 0.5, "Cup"),
        Ingredient("Cocoa powder", 0.5, "Cup"),
        Ingredient("Mashed banana", 0.5, "Cup")
    )

    val redPepperFettuccini = createRecipe("Red Pepper Fettucini Alfredo", "25 minutes",
        """
            Bring a large pot of salted water to a boil. Add the pasta and cook until al dente (usually about 30 seconds to a minute less than the package instructions recommend).
            Meanwhile, melt the butter in a medium saucepan over medium heat.
            Stir in the flour and cook for a minute, until the two are fully incorporated. Slowly add the milk and half and half, whisking to help prevent lumps from forming.
            Add the red pepper and garlic.
            Turn the heat to low and simmer for 10 minutes.
            Pour the mixture into a blender and purée until smooth and uniform in color.
            Return to the pan and stir in the Parmesan.
            Season with salt and pepper and simmer until the pasta is done cooking.
            Drain the pasta and add directly to the saucepan.
            Toss to coat evenly.
            Divide among 4 warm bowls or plates.
        """.trimIndent(),
        Ingredient("Dried fettuccine", 1.0, "unit"),
        Ingredient("Butter", 1.5, "Tbsp"),
        Ingredient("Flour", 1.5, "Tbsp"),
        Ingredient("Milk", 1.0, "Cup"),
        Ingredient("Red peppers", 0.75, "Cup"),
        Ingredient("Garlic", 2.0, "unit"),
        Ingredient("Parmesan", 0.5, "Cup"),
        Ingredient("Salt", 1.0, ""),
        Ingredient("Black pepper", 1.0, "")
    )

    /**
     * Problem:
     * - println shows results not structurally, we need to override toString()
     */
    println(brownies)
    println(redPepperFettuccini)
}

fun createRecipe(recipeName: String, timeToPrepare : String, instruction: String, vararg ingredients: Ingredient): Recipe {
    return Recipe(
        recipeName = recipeName,
        timeToPrepare = timeToPrepare,
        ingredients = ingredients.toList(),
        instruction = instruction
    );
}
