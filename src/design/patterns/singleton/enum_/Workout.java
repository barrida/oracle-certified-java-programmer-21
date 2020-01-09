package design.patterns.singleton.enum_;

/**
 * @author Suleyman Yildirim
 * <p>
 * A single-element enum type is often the best way to implement a singleton, Bloch, Joshua. Effective Java (pp. 37-38).
 */
public enum Workout {
    INSTANCE;
    private int duration;
    public int getDuration(){
        return duration;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }

    public static void main(String[] args) {
        Workout singleton = Workout.INSTANCE;
        System.out.println(singleton.getDuration());
        singleton.setDuration(2);
        System.out.println(singleton.getDuration());
    }
}
