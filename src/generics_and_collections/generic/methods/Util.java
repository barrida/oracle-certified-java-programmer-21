package generics_and_collections.generic.methods;

import generics_and_collections.generic.classes.FoodMultipleType;
import generics_and_collections.generic.classes.FoodPair;

/**
 * @author Suleyman Yildirim
 */
public class Util {
    public static <K, V> boolean compare(FoodMultipleType<K, V> p1, FoodMultipleType<K, V> p2) {
        return p1.getName().equals(p2.getName()) &&
                p1.getCalories().equals(p2.getCalories());
    }

    public static void main(String[] args){
        FoodPair<String, Integer> tuna = new FoodMultipleType<String,Integer>("tuna",205);
        FoodMultipleType<String, Integer> brownRice = new FoodMultipleType<String,Integer>("brown rice",214);
        Util.<String,Integer>compare((FoodMultipleType<String, Integer>) tuna,brownRice);
        Util.compare((FoodMultipleType<String, Integer>) tuna,brownRice);//

    }
}
