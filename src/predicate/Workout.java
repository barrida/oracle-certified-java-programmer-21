package predicate;

import java.util.function.Predicate;

/**
 * @author suleyman.yildirim
 *
 * Custom predicate example
 */
public class Workout {

    private String person;
    private boolean lift;
    private boolean run;

    public Workout(String person, boolean lift, boolean run) {
        super();
        this.person = person;
        this.lift = lift;
        this.run = run;
    }

    boolean isLifting() {
        return lift;
    }

    boolean isRunning() {
        return run;
    }

    @Override
    public String toString() {
        return "Name: " + person + ", Lifting: " + lift + ", Running: " + run;
    }

    private static void printMyWorkout(Workout workout, Predicate<Workout> p) {
        if (p.test(workout)) {
            System.out.println(workout.toString());
        }
    }

    public static void main(String args[]) {
        Workout workout = new Workout("Suleyman", true, false);
        printMyWorkout(workout, p -> p.isLifting());
        printMyWorkout(workout, p -> p.isRunning());
    }
}
