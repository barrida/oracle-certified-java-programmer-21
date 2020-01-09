package design.patterns.singleton.lazy_initialization;

/**
 * @author Suleyman Yildirim
 * <p>
 * Approach 3: Lazy Instantiation. Delay creation of the singleton until the first time the
 * getInstance() method is called
 * <p>
 * Pros: Lazy instantiation reduces memory usage and improves performance when an application
 * starts up.
 * <p>
 * Cons: Users may see a noticeable delay the first time a particular type of resource is needed
 */
public class Workout {

    private static Workout instance;

    private Workout(){}

    public static Workout getInstance() {
        if (instance == null) {
            instance = new Workout();
        }
        return instance;
    }

    public static void main(String[] args) {
        Workout w1 = Workout.getInstance();
        Workout w2 = Workout.getInstance();
        System.out.println(w1.equals(w2));
    }
}


