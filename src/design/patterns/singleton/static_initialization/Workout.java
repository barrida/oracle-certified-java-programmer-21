package design.patterns.singleton.static_initialization;

/**
 * @author Suleyman Yildirim
 * <p>
 * Approach 2: Create a singleton using a static initialization block when the class is loaded
 */
public class Workout {

    private static final Workout instance;

    //Create a singleton using a static initialization block when the class is loaded
    static {
        instance = new Workout();
    }

    //Access the instance via static method, name it as getInstance()
    public static Workout getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Workout w1 = Workout.getInstance();
        Workout w2 = Workout.getInstance();
        System.out.println(w1.equals(w2));
    }
}
