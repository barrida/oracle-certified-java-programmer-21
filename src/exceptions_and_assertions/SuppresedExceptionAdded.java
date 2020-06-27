package exceptions_and_assertions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SuppresedExceptionAdded {

	public static void main(String[] args) throws Exception {

		String path = new File(".").getAbsoluteFile() + "/src/exceptions_and_assertions/asd.txt";

		try {
			processFile(path);
		} catch (IOException e) {
//			System.err.println(e);
//			for (Throwable t: e.getSuppressed())
//				System.out.println(t.getMessage());
		}
	}

	private static void processFile(String path) throws IOException {

		BufferedReader br = null;
		Throwable catchedException = null;

		try {
			br = new BufferedReader(new FileReader(path));
			br.lines().distinct().forEach(System.out::println);

		} catch (IOException fe) {
			catchedException = fe;
		} finally {

			try {
				br.close();
			} catch (NullPointerException ne) {
				if (catchedException != null) {
					ne.addSuppressed(catchedException);
					throw ne;
				}
			}
		}
	}

}
