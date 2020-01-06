package functional.interfacee;

public class ValidAndInvalidFunctionalInterfaces {

	/**
	 * 
	 * This is a functional interface as it has a single abstract method
	 * 
	 * @author suleyman.yildirim
	 *
	 */
	@FunctionalInterface
	interface A {
		int run();
	}

	/**
	 * B is also a functional interface. It inherits run() method from the
	 * interface Workout. Therefore, it has a single abstract method
	 * 
	 * @author suleyman.yildirim
	 *
	 */
	@FunctionalInterface
	interface B extends A {
	}

	/**
	 * D is a valid functional interface for the same reasons above
	 * 
	 * @author suleyman.yildirim
	 *
	 */
	@FunctionalInterface
	interface D extends A, B {
	}

	/**
	 * C is not a functional interface as it has "two" abstract methods.
	 * run() and lift(). run() is inherited from the interface Workout
	 * 
	 * If it is marked with the @FunctionalInterface, this will result in
	 * compile error
	 * 
	 * @author suleyman.yildirim
	 *
	 */
	interface C extends A {
		void lift();
	}

}
