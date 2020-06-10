package streams.advanced_concepts.chaining_optionals;

import java.util.Optional;

public class ChainingOptionals {

	public static void main(String[] args) {

		Optional<String> optional = Optional.of("Covid-19");
		printVirus(optional);
		printVirusUsingChaining(optional);

	}

	/**
	 * Prints the full name if it contains the string "Covid-19"
	 * 
	 * @param optional
	 */
	private static void printVirus(Optional<String> optional) {
		if (optional.isPresent()) {
			String virus = optional.get();
			if (virus.contains("Covid-19"))
				System.out.println(virus);
		}
	}

	/**
	 * Filters the optional
	 * 
	 * Prints the result if it is present
	 * 
	 * @param optional
	 */
	private static void printVirusUsingChaining(Optional<String> optional) {
	     optional.filter(s -> s.contains("Covid-19"))
	             .ifPresent(System.out::println);
	}

}
