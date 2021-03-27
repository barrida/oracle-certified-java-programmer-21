package exceptions_and_assertions;

import java.util.Scanner;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	// throw new CustomException(); in main
	public CustomException() {
		super();
	}

	public CustomException(Exception e) {
		// throw new CustomException(new RuntimeException()); in main
		super(e);
	}

	public CustomException(String message) {
		// throw new CustomException(new RuntimeException()); in main
		super(message);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		try {

			if (number == 0) {
				throw new CustomException();
			}

			else if (number < 0) {
				throw new CustomException("Invalid nummber: " + number);
			}

			else if (number > 0) {
				throw new CustomException(new RuntimeException());
			}

		} catch (CustomException e) {
			e.printStackTrace();
		}

	}
}