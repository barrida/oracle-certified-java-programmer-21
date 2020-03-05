package streams.primitives;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.DoubleSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

/**
 * @author Suleyman Yildirim
 */
public class OptionalTypes {
	public static void main(String[] args) {

		// max
		IntStream streamIntMax = IntStream.of(10, 32, 13, 44);
		OptionalInt optionalInt = streamIntMax.max();
		int intValue = optionalInt.getAsInt();
		assertEquals(44, intValue);

		DoubleStream streamDoubleMax = DoubleStream.of(3, 5, 10);
		OptionalDouble optionalDouble = streamDoubleMax.max();
		double doubleValue = optionalDouble.getAsDouble();
		assertTrue(doubleValue == 10);

		LongStream streamLongMax = LongStream.of(2L, 5L, 10L);
		OptionalLong optionalLong = streamLongMax.max();
		long longValue = optionalLong.getAsLong();
		assertEquals(10L, longValue);
		
		//min
		IntStream streamIntMin = IntStream.of(10, 32, 13, 44);
		OptionalInt optionalMin = streamIntMin.min();
		int minValue = optionalMin.getAsInt();
		assertEquals(10, minValue);

		

		// sum
		IntStream streamIntSum = IntStream.of(10, 32, 13, 44);
		int sumInt = streamIntSum.sum();
		assertEquals(99, sumInt);

		DoubleStream streamDoubleSum = DoubleStream.of(3, 5, 10);
		double sumDouble = streamDoubleSum.sum();
		assertTrue(18.0 == sumDouble);

		LongStream streamLongSum = LongStream.of(2L, 5L, 10L);
		long sumLong = streamLongSum.sum();
		assertEquals(17L, sumLong);

		// avg
		IntStream streamIntAvg = IntStream.of(10, 32, 13, 44);
		OptionalDouble avgInt = streamIntAvg.average();
		avgInt.ifPresent(System.out::println);
		assertTrue(avgInt.isPresent());
		assertTrue(avgInt.getAsDouble() == 24.75);

		DoubleStream streamDoubleAvg = DoubleStream.of(3, 5, 10);
		OptionalDouble avgDouble = streamDoubleAvg.average();
		avgDouble.ifPresent(System.out::println);
		assertTrue(avgDouble.isPresent());
		assertTrue(avgDouble.getAsDouble() == 6.0);

		LongStream streamLongAvg = LongStream.of(2L, 9L, 10L);
		OptionalDouble avgLong = streamLongAvg.average();
		assertTrue(avgLong.isPresent());
		avgLong.ifPresent(System.out::println);
		assertTrue(avgLong.getAsDouble() == 7.0);

		System.out.println(avgLong.orElseGet(()-> Double.NaN));
		
		// statistics
		IntStream streamStatistics = IntStream.of(10, 32, 13, 44);
		IntSummaryStatistics stats = streamStatistics.summaryStatistics();
		assertEquals("IntSummaryStatistics{count=4, sum=99, min=10, average=24.750000, max=44}", stats.toString());
		assertEquals(99, stats.getSum());
		assertEquals(10, stats.getMin());
		assertTrue(24.750000 == stats.getAverage());
		assertEquals(44, stats.getMax());
	}
}
