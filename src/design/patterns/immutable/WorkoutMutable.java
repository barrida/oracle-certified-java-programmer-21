package design.patterns.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suleyman Yildirim
 * How to make a class immuatable
 *
 * 1. Use a constructor to set all properties of the object.
 * 2. Mark all of the instance variables private and final .
 * 3. Don’t define any setter methods.
 * 4. If the instance fields include references to mutable objects, don't allow those objects to be changed
 * 5. Prevent methods from being overridden.
 */
public final class WorkoutMutable {

    //rule 2 and 5
    private final String type;
    private final List<String> exercises;

    //rule 1 passed
    public WorkoutMutable(String type, List<String> exercises) {
        if (exercises == null && type.isEmpty())
            throw new RuntimeException("Workout type and exercise list are required");
        this.type = type;
        this.exercises = new ArrayList<String>(exercises);
    }

    //rule 3 passed: Don’t define any setter methods

    //String class is immutable so we can return it
    public String getType() {
        return type;
    }

    //rule 4 failed: List interface is mutable. The client of this function can modify the state of the list.
    public List<String> getExercises() {
        return exercises;
    }

}
