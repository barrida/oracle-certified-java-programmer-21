package exceptions_and_assertions;

public class InvalidAutoClosable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Inside close method");
	}
	
	public static void main(String[] args) {
//		try (InvalidAutoClosable c = new InvalidAutoClosable()) {
//			System.out.println("Inside try-with-resources statement");
//		}
	}

}
