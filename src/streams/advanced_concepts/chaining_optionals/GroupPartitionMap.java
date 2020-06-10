package streams.advanced_concepts.chaining_optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupPartitionMap {

	public static void main(String[] args) {

		List<CoronavirusCase> cases = new ArrayList<>();
		cases.add(new CoronavirusCase("TURKEY", 170000));
		cases.add(new CoronavirusCase("SPAIN", 242000));
		cases.add(new CoronavirusCase("SWEEDEN", 287000));
		cases.add(new CoronavirusCase("ITALY", 235000));
		cases.add(new CoronavirusCase("USA", 287000));
		cases.add(new CoronavirusCase("UK", 287000));

		Map<Long, List<CoronavirusCase>> groupingBy1 = cases.stream()
				.collect(Collectors.groupingBy(CoronavirusCase::getNumberOfCases));
		System.out.println(groupingBy1);

		Map<Long, List<CoronavirusCase>> groupingBy2 = cases.stream()
				.collect(Collectors.groupingBy(CoronavirusCase::getNumberOfCases, Collectors.toList()));
		System.out.println(groupingBy2);

		TreeMap<Long, List<CoronavirusCase>> groupingBy3 = cases.stream()
				.collect(Collectors.groupingBy(CoronavirusCase::getNumberOfCases, TreeMap::new, Collectors.toList()));
		System.out.println(groupingBy3);

		Map<Boolean, List<CoronavirusCase>> partitioningBy1 = cases.stream()
				.collect(Collectors.partitioningBy(s -> s.getNumberOfCases() <= 200000));
		System.out.println(partitioningBy1);

		Map<Boolean, Set<CoronavirusCase>> partitioningBy2 = cases.stream()
				.collect(Collectors.partitioningBy(s -> s.getNumberOfCases() <= 12000, Collectors.toSet()));
		System.out.println(partitioningBy2);

		Map<Long, Set<String>> countryByCases = cases.stream()
				.collect(Collectors.groupingBy(CoronavirusCase::getNumberOfCases,
						Collectors.mapping(CoronavirusCase::getCountry, Collectors.toSet())));

		System.out.println(countryByCases);

		Map<String, Set<Long>> casesByCountry = cases.stream()
				.collect(Collectors.groupingBy(CoronavirusCase::getCountry,
						Collectors.mapping(CoronavirusCase::getNumberOfCases, Collectors.toSet())));
		System.out.println(casesByCountry);
	}

}
