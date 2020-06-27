package exceptions_and_assertions;

public class ValidAutoClosableDeclareException implements AutoCloseable {

	@Override
	public void close() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Inside close method");
	}
	
	public static void main(String[] args) throws Exception{
		try (ValidAutoClosableDeclareException c = new ValidAutoClosableDeclareException()) {
			System.out.println("Inside try-with-resources statement");
		}
	}

}
