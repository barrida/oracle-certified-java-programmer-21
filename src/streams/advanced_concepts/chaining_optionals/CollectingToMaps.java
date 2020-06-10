package streams.advanced_concepts.chaining_optionals;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingToMaps {

	public static void main(String[] args) {

		List<CoronavirusCase> cases = new ArrayList<>();
		cases.add(new CoronavirusCase("TURKEY", 170000));
		cases.add(new CoronavirusCase("SPAIN", 242000));
		cases.add(new CoronavirusCase("SWEEDEN", 287000));
		cases.add(new CoronavirusCase("ITALY", 235000));
		cases.add(new CoronavirusCase("USA", 287000));
		cases.add(new CoronavirusCase("UK", 287000));

		// merge without duplicated keys
		Map<String, Long> map1 = cases.stream()
				.collect(Collectors.toMap(CoronavirusCase::getCountry, CoronavirusCase::getNumberOfCases));
		System.out.println(map1); 

		// merge with duplicated keys
		 Map<Long, String> mapDuplicated = cases.stream()
		 .collect(Collectors.toMap(CoronavirusCase::getNumberOfCases,
		 CoronavirusCase::getCountry));
		 System.out.println(mapDuplicated); ////throws Exception in thread "main" java.lang.IllegalStateException: Duplicate key SWEEDEN

		// merge with duplicated keys but don't sort the map
		BinaryOperator<String> mergeFunction = (case1, case2) -> case1 + "-" + case2;
		Map<Long, String> map2 = cases.stream().collect(
				Collectors.toMap(CoronavirusCase::getNumberOfCases, CoronavirusCase::getCountry, mergeFunction));

		System.out.println(map2);

		// merge with duplicated keys and sort the map
		TreeMap<Long, String> treeMap = cases.stream().collect(Collectors.toMap(CoronavirusCase::getNumberOfCases,
				CoronavirusCase::getCountry, mergeFunction, TreeMap::new));

		System.out.println(treeMap);
		System.out.println(treeMap.getClass());

	}

}
