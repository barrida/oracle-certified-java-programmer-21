package exceptions_and_assertions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TryWithResources {

	public static void main(String[] args) throws IOException {

		String path = new File(".").getAbsoluteFile() + "/src/exceptions_and_assertions/asd.txt";
		FileReader fr = new FileReader(path);

		try (BufferedReader br = new BufferedReader(fr);) {
			br.lines().distinct().forEach(System.out::println);
		}

	}

}
