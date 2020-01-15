package generics_and_collections.generic.classes;

import java.util.*;

/**
 * @author Suleyman Yildirim
 */
public class Food<T> {
    private T ingredients;

    public T getIngredients() {
        return ingredients;
    }

    public void setIngredients(T ingredients) {
        this.ingredients = ingredients;
    }

    public static void main(String[] args) {

        //create food with String data type
        Food<String> food = new Food<>();
        food.setIngredients("protein: 200 gr; carb: 300, fat: 75");

        //create food with ingredients data type
        Ingredients ingredients = new Ingredients("protein", 200);
        Food<Ingredients> ingredientsFood = new Food<>();
        ingredientsFood.setIngredients(ingredients);

        //create food with a map
        Food<Map<String, Integer>> foodAsMap = new Food<>();
        Map<String, Integer> foods = new HashMap<String,Integer>();
        foods.put("protein", 200);
        foods.put("carb", 300);
        foods.put("fat", 75);
        foodAsMap.setIngredients(foods);
    }
}

class Ingredients {
    private String name;
    private int calories;

    Ingredients(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
}
