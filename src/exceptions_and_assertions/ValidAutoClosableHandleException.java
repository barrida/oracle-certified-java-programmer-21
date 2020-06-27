package exceptions_and_assertions;

public class ValidAutoClosableHandleException implements AutoCloseable {

	public void close() throws IllegalStateException {
		throw new IllegalStateException("IllegalStateException in close()");
	}

	public static void main(String[] args) {
		try (ValidAutoClosableHandleException t = new ValidAutoClosableHandleException()) {
			System.out.println("inside try-with-resources");
		} catch (IllegalStateException e) {
			System.out.println("inside catch: " + e.getMessage());
		}
	}
}
