package exceptions_and_assertions;

public class ValidAutoClosableDefault implements AutoCloseable {

	@Override
	public void close()  {
		// TODO Auto-generated method stub
		System.out.println("Inside close method");
	}
	
	public static void main(String[] args) {
		try (ValidAutoClosableDefault c = new ValidAutoClosableDefault()) {
			System.out.println("Inside try-with-resources statement");
		}
	}

}
