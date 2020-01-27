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
		assertEquals(7, Recursions.greatestCommonDivisor(21, 56));
		// TODO
	}
	
	@Test
	public void pascalsParadoxTest () {
		// TODO
	}
}