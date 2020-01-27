package labors.labor05;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LeeKrane
 */

public class RecursionsTest {
	@Test
	public void reciprocalTest () {
		for (int i = 1, j = 1; i < 50; i++) {
			assertEquals(i * j, Recursions.reciprocal(i));
			j *= -1;
		}
	}
	
	@Test
	public void reciprocalRecursiveTest () {
		for (int i = 1, j = 1; i < 50; i++) {
			assertEquals(i * j, Recursions.reciprocalRecursive(i));
			j *= -1;
		}
	}
	
	@Test
	public void fibonacciTest () {
		int[] fib = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
		for (int i = 0; i < fib.length; i++)
			assertEquals(fib[i], Recursions.fibonacci(i + 1));
	}
	
	@Test
	public void greatestCommonDivisorTest () {
		int[] expected = new int[]{7, 4, 6, 60, 1};
		int[][] values =  new int[][]{{21, 56}, {16, 20}, {12, 18}, {120, 900}, {105, 26}};
		for (int i = 0; i < expected.length; i++)
			assertEquals(expected[i], Recursions.greatestCommonDivisor(values[i][0], values[i][1]));
	}
	
	@Test
	public void pascalsParadoxTest () { // TODO
		int[] expected = new int[]{1, 1, 1, 6, 10, 5, 20};
		int[][] values = new int[][]{{0, 0}, {9, 9}, {5, 0}, {4, 2}, {5, 4}, {6, 3}, {}};
		for (int i = 0; i < expected.length; i++)
			assertEquals(expected[i], Recursions.pascalsParadox(values[i][0], values[i][1]));
	}
}