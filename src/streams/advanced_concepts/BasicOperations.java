package streams.advanced_concepts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicOperations {

	public static void main(String[] args) {
		Stream<String> streamJoin = Stream.of("the", "new", "normal");
		String resultJoin = streamJoin.collect(Collectors.joining(", "));
		System.out.println(resultJoin); // the, new, normal

		Stream<String> streamAverage = Stream.of("the", "new", "normal");
		Double resultAverage = streamAverage.collect(Collectors.averagingInt(String::length));
		System.out.println(resultAverage); // 4.0

		Stream<String> streamCollection = Stream.of("the", "new", "normal");
		Set<String> result = streamCollection
								.filter(s -> s.startsWith("n"))
								.collect(Collectors.toCollection(HashSet::new));
		System.out.println(result); // [new, normal]

		Stream<String> streamList = Stream.of("the", "new", "normal");
		List<String> resultList = streamList.collect(Collectors.toList());
		System.out.println(resultList); // [the, new normal]

	}
}
