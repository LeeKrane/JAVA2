package labors.labor05;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LeeKrane
 */

public class RecursionsTest {
	@ParameterizedTest
	@CsvSource({"1,1", "-2,2", "3,3", "69,69", "-72,72", "109,109", "-112,112", "-128,128", "-142,142", "187,187", "-420,420"})
	public void reciprocalTest (int i, int j) {
		assertEquals(i, Recursions.reciprocal(j));
	}
	
	@ParameterizedTest
	@CsvSource({"1,1", "-2,2", "3,3", "69,69", "-72,72", "109,109", "-112,112", "-128,128", "-142,142", "187,187", "-420,420"})
	public void reciprocalRecursiveTest (int i, int j) {
		assertEquals(i, Recursions.reciprocalRecursive(j));
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