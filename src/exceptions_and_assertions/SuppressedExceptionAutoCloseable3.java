package exceptions_and_assertions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author suleyman.yildirim
 *
 */
public class SuppressedExceptionAutoCloseable3 implements AutoCloseable {

	// 2. Java automatically calls the close() method
	public void close() throws IOException {
		// 3.It throws an IOException, which is added as a suppressed exception
		throw new IOException("IOException in close()" + this.getClass().getName());
	}

	public static void main(String[] args) throws IOException {
		try (SuppressedExceptionAutoCloseable t1 = new SuppressedExceptionAutoCloseable();
				SuppressedExceptionAutoCloseable t2 = new SuppressedExceptionAutoCloseable()) {
			// 1. the try clause throws an IOException and calls the close
			// method automatically
			throw new IOException("try throws an exception");
		} catch (IOException e) {
			// 4. catches and prints the message for the primary exception
			System.out.println("inside catch: " + e.getMessage());

			// 5. loops through the suppressed exception and prints it
			for (Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		}
	}
}
