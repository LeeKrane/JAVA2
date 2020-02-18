package labors.labor05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO: make all tests parameterized
 * @author LeeKrane
 */

public class RecursionsTest {
	@Test
	public void reciprocalTest () {
		for (int i = 1, j = 1; i < 187; i++, j *= -1)
			assertEquals(i * j, Recursions.reciprocal(i));
	}
	
	@Test
	public void reciprocalRecursiveTest () {
		for (int i = 1, j = 1; i < 187; i++, j *= -1)
			assertEquals(i * j, Recursions.reciprocalRecursive(i));
	}
	
	@ParameterizedTest
	@CsvSource({"1,1", "1,2", "2,3", "3,4", "5,5", "8,6", "13,7", "21,8", "34,9", "55,10", "89,11", "144,12", "233,13", "377,14", "610,15"})
	public void fibonacciTest (int expected, int i) {
		assertEquals(expected, Recursions.fibonacci(i));
	}
	
	@ParameterizedTest
	@CsvSource({"7,21,56", "4,16,20", "6,12,18", "60,120,900", "1,105,26"})
	public void greatestCommonDivisorTest (int expected, int x, int y) {
		assertEquals(expected, Recursions.greatestCommonDivisor(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({"1,0,0", "1,9,9", "1,5,0", "6,4,2", "10,5,2", "5,5,4", "20,6,3", "35,7,4", "56,8,5"})
	public void pascalsParadoxTest (int expected, int x, int y) {
		assertEquals(expected, Recursions.pascalsParadox(x, y));
	}
}