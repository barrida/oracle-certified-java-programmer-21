package design.interfacee;

public interface Workout {

	public static final int MAX_DURATION = 90; // in minutes

	public int calculateCalories(int duration);

	public default void snatch() {
		System.out.println("I lift 50kg!");
	}
}

class Weightlifting implements Workout {

	@Override
	public int calculateCalories(int duration) {
		return duration * 5;
	}

	public void snatch() {
		System.out.println("I am redefining the default method. I lift 80 kg!");
	}

}
