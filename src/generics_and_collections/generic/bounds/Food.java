package generics_and_collections.generic.bounds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suleyman Yildirim
 */
public class Food {

    /**
     * This method that works on lists of Integer and the supertypes of Integer, such as Integer, Number, and Object
     * <p>
     * A lower bounded wildcard is expressed using List< ? super Integer>
     *
     * @param list
     */
    private static void lowerBound(List<? super Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " ");
        }
    }

    /**
     * This method works on lists of Number and the subtypes of Number, such as Integer, Double, and Float
     * <p>
     * An upper bounded wildcard is specified using List< ? extends Integer>
     *
     * @param list
     */
    private static double upperBound(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    /**
     * The unbounded wildcard type is specified using the wildcard character (?), for example, List< ?>. This is called a list of unknown type
     * <p>
     * The goal of the function is to print a list of any type
     *
     * @param list
     */
    private static void unbound(List<?> list) {
        System.out.println();
        for (Object elem : list)
            System.out.print(elem + " ");

    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        System.out.println(upperBound(intList));

        List<Double> doubleList = new ArrayList<Double>();
        doubleList.add(4.3);
        doubleList.add(7.1);
        doubleList.add(2.4);

        System.out.println(upperBound(doubleList));
        System.out.println(intList);
        lowerBound(intList);
        //lowerBound(doubleList); // compile error

        unbound(intList);
        unbound(doubleList);
    }
}