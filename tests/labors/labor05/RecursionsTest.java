package labors.labor05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
	
	@Test
	public void fibonacciTest () {
		int[] expected = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
		for (int i = 0; i < expected.length; i++)
			assertEquals(expected[i], Recursions.fibonacci(i + 1));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"7;21;56", "4;16;20", "6;12;18", "60;120;900", "1;105;26"})
	public void greatestCommonDivisorTest (String argument) {
		String[] split = argument.split(";");
		assertEquals(Integer.parseInt(split[0]), Recursions.greatestCommonDivisor(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1;0;0", "1;9;9", "1;5;0", "6;4;2", "10;5;2", "5;5;4", "20;6;3", "35;7;4", "56;8;5"})
	public void pascalsParadoxTest (String argument) {
		String[] split = argument.split(";");
		assertEquals(Integer.parseInt(split[0]), Recursions.pascalsParadox(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
	}
}