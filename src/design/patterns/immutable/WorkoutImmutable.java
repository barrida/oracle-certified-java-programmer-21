package design.patterns.immutable;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Suleyman Yildirim
 */
public final class WorkoutImmutable {

    //rule 2 and 5
    private final String type;
    private final List<String> exercises;

    //rule 1 passed
    public WorkoutImmutable(String type, List<String> exercises) {
        if (type.isEmpty() && exercises == null)
            throw new RuntimeException("Workout type and exercise list are required");
        this.type = type;
        this.exercises = new ArrayList<String>(exercises);
    }

    //rule 3 passed: Don’t define any setter methods

    //String class is immutable so we can return it

    public String getType() {
        return type;
    }

    /**
     * We need to make sure that no references to the "exercises" object are publicly available.
     * If the user does need access to the data in the List, we can create a one‐time copy of the data that is
     * returned to the user
     *
     * @return copyOfExercises
     */
    public List<String> getCopyOfExercises() {
        List<String> copyOfExercises = new ArrayList<>(exercises);
        Collections.copy(copyOfExercises, exercises);
        return copyOfExercises;
    }

    public static void main(String[] args) {
        WorkoutImmutable w1 = new WorkoutImmutable("suleyman", Arrays.asList("chest press", "lat pull down"));
        w1.getCopyOfExercises();
    }

}
