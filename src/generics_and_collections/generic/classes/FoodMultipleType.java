package generics_and_collections.generic.classes;

public class FoodMultipleType<K, V> implements FoodPair<K, V> {
    private K name;
    private V calories;

    public FoodMultipleType(K name, V value) {
        this.name = name;
        this.calories = value;
    }

    @Override
    public K getName() {
        return name;
    }

    @Override
    public V getCalories() {
        return calories;
    }

    public static void main(String[] args) {
        FoodPair<String, Integer> tuna = new FoodMultipleType<String, Integer>("tuna", 205);
        FoodPair<String, Integer> brownRice = new FoodMultipleType<String, Integer>("brown rice", 214);
    }
}
