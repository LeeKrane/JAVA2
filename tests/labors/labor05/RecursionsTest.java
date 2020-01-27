package labors.labor05;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
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
	
	@Test
	public void greatestCommonDivisorTest () {
		int[] expected = new int[]{7, 4, 6, 60, 1};
		int[][] indices =  new int[][]{{21, 56}, {16, 20}, {12, 18}, {120, 900}, {105, 26}};
		for (int i = 0; i < expected.length; i++)
			assertEquals(expected[i], Recursions.greatestCommonDivisor(indices[i][0], indices[i][1]));
	}
	
	@Test
	public void pascalsParadoxTest () {
		int[] expected = new int[]{1, 1, 1, 6, 10, 5, 20, 35, 56};
		int[][] indices = new int[][]{{0, 0}, {9, 9}, {5, 0}, {4, 2}, {5, 2}, {5, 4}, {6, 3}, {7, 4}, {8, 5}};
		for (int i = 0; i < expected.length; i++)
			assertEquals(expected[i], Recursions.pascalsParadox(indices[i][0], indices[i][1]));
	}
}