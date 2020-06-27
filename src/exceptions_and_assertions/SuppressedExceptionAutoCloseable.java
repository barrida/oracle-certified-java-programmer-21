package exceptions_and_assertions;

import java.io.IOException;

/**
 * @author suleyman.yildirim
 *
 */
public class SuppressedExceptionAutoCloseable implements AutoCloseable {
	
	//2. Java automatically calls the close() method
	public void close() throws IOException { 
		//3.It throws an IOException, which is added as a suppressed exception
		throw new IOException("IOException in close()");
	}

	public static void main(String[] args) throws IOException {
		try (SuppressedExceptionAutoCloseable t = new SuppressedExceptionAutoCloseable()) {
			//1. the try clause throws an IOException and calls the close method automatically
			throw new IOException("try throws an exception"); 
		} catch (IOException e) {
			//4. catches and prints the message for the primary exception
			System.out.println("inside catch: " + e.getMessage());
			
			//5. loops through the  suppressed exception and prints it
			for (Throwable t: e.getSuppressed())
				System.out.println(t.getMessage());
		}
	}
}

