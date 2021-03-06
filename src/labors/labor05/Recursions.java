package labors.labor05;

/**
 * @author LeeKrane
 */

public class Recursions {
	// 1
	static int reciprocal (int n) {
		return n % 2 == 0 ? -n : n;
	}
	
	/* the code above brings the same result as the one below
	static int reciprocal (int n) {
		int denominator = 0;
		for (int i = 0, j = 1; i < n; i++, j+=2) {
			if (i % 2 == 0)
				denominator += j;
			else
				denominator -= j;
		}
		return denominator;
	}
	 */
	
	static int reciprocalRecursive (int n) {
		if (n == 1)
			return 1;
		return reciprocalRecursive(n - 1) + ((2 * n - 1) * (n % 2 == 0 ? -1 : 1));
	}
	
	/* the code above brings the same result as the one below
	static int reciprocalRecursive (int n) {
		if (n == 1)
			return 1;
		if (n % 2 == 0)
			return reciprocalRecursive(n - 1) - (2 * n - 1);
		return reciprocalRecursive(n - 1) + (2 * n - 1);
	}
	 */
	
	// 2
	static int fibonacci (int n) {
		if (n < 3)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	// 3
	static int greatestCommonDivisor (int a, int b) {
		if (b == 0)
			return a;
		return greatestCommonDivisor(b, a%b);
	}
	
	// 4
	static int pascalsParadox (int a, int b) {
		if (b == 0 || a == b)
			return 1;
		return pascalsParadox(a - 1, b) + pascalsParadox(a - 1, b - 1);
	}
}
