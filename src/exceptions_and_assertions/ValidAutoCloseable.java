package exceptions_and_assertions;

public class ValidAutoCloseable implements AutoCloseable {

	@Override
	public void close() {
		System.out.println("Close the " + this.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		try (ValidAutoCloseable c = new ValidAutoCloseable()) {
			System.out.println("Inside try-with-resources statement");
		}
	}

}
