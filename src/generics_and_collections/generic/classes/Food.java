package generics_and_collections.generic.classes;

/**
 * @author Suleyman Yildirim
 *
 */
public class Food<T> {
    private T ingredients;

    public T getIngredients(){
        return ingredients;
    }

    public void setIngredients(T ingredients) {
        this.ingredients = ingredients;
    }

    public static void main(String[] args){
        Food<String> food = new Food<>();
        food.setIngredients("protein: 200 gr");

        Ingredients ingredients = new Ingredients("protein", 200);
        Food<Ingredients> ingredientsFood = new Food<>();
        ingredientsFood.setIngredients(ingredients);
    }
}

class Ingredients {

    private String name;
    private int calorie;

    Ingredients(String name, int calorie){
        this.name = name;
        this.calorie = calorie;
    }
}
