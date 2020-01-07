package homeworks.homework1;

import java.util.Objects;

/**
 * @author LeeKrane
 */

public class Fraction {
	private long numerator;
	private long denominator;
	private static boolean fractionFormat;
	
	/**
	 * This constructor creates a new Fraction object from the numerator 0 and the denominator 1.
	 */
	Fraction () {
		numerator = 0;
		denominator = 1;
	}
	
	/**
	 * This constructor creates a new Fraction object from the given numerator and the denominator 1.
	 * @param numerator The numerator for the new Fraction object.
	 */
	Fraction (long numerator) {
		this.numerator = numerator;
		denominator = 1;
	}
	
	/**
	 * This constructor creates a new Fraction object from the given numerator and the given denominator.
	 * @param numerator The numerator for the new Fraction object.
	 * @param denominator The denominator for the new Fraction object.
	 * @throws IllegalArgumentException Throws if the denominator is 0.
	 */
	Fraction (long numerator, long denominator) {
		setFraction(numerator, denominator);
	}
	
	/**
	 * This constructor creates a new Fraction object from the given fraction string.
	 * @param fraction The string which contains the numerator and the denominator, or a decimal value for the new Fraction object.
	 * @throws IllegalArgumentException Throws if the denominator is 0.
	 */
	Fraction (String fraction) {
		if (!fraction.matches("-?\\d+(/-?\\d+|.\\d+)?"))
			throw new IllegalArgumentException("The given string does not contain a legal fraction.");
		String[] tokens = fraction.split("/");
		switch (tokens.length) {
			case 1:
				setFraction(Double.parseDouble(tokens[0]));
				break;
			case 2:
				setFraction(Long.parseLong(tokens[0]), Long.parseLong(tokens[1]));
		}
	}
	
	/**
	 * This constructor creates a new Fraction object from the given value.
	 * @param value The value for the new Fraction object.
	 */
	Fraction (double value) {
		setFraction(value);
	}
	
	/**
	 * This method creates a new Fraction object which is the sum of the this object and the given Fraction object and returns it.
	 * @param fraction The Fraction object which is added to the this object in a new sum Fraction object (the this object is not modified).
	 * @return The sum of the this object and the given Fraction object as new Fraction object.
	 * @throws IllegalArgumentException Throws if the given Fraction object is null.
	 */
	Fraction add (Fraction fraction) {
		if (fraction == null)
			throw new IllegalArgumentException("The fraction to add must not be null.");
		Fraction copy = this.copy();
		copy.addThis(fraction);
		return copy;
	}
	
	/**
	 * This method adds the given Fraction object to the this object.
	 * @param fraction The Fraction object which is added to the this object.
	 */
	void addThis (Fraction fraction) {
		if (fraction != null) {
			long leastCommonMultiple = leastCommonMultiple(denominator, fraction.denominator);
			numerator = numerator * (leastCommonMultiple / denominator) + fraction.numerator * (leastCommonMultiple / fraction.denominator);
			denominator = leastCommonMultiple;
			simplify();
		}
	}
	
	/**
	 * This method creates a new Fraction object which is the difference of the this object and the given Fraction object and returns it.
	 * @param fraction The Fraction object which is subtracted from the this object in a new difference Fraction object (the this object is not modified).
	 * @return The difference of the this object and the given Fraction object as new Fraction object.
	 * @throws IllegalArgumentException Throws if the given Fraction object is null.
	 */
	Fraction sub (Fraction fraction) {
		if (fraction == null)
			throw new IllegalArgumentException("The fraction to subtract must not be null.");
		Fraction copy = this.copy();
		copy.subThis(fraction);
		return copy;
	}
	
	/**
	 * This method subtracts the given Fraction object from the this object.
	 * @param fraction The Fraction object which is subtracted from the this object.
	 */
	void subThis (Fraction fraction) {
		if (fraction != null) {
			long leastCommonMultiple = leastCommonMultiple(denominator, fraction.denominator);
			numerator = numerator * (leastCommonMultiple / denominator) - fraction.numerator * (leastCommonMultiple / fraction.denominator);
			denominator = leastCommonMultiple;
			simplify();
		}
	}
	
	/**
	 * This method creates a new Fraction object which is the product of the this object and the given Fraction object and returns it.
	 * @param fraction The Fraction object which the this object is multiplied by in a new product Fraction object (the this object is not modified).
	 * @return The product of the this object and the given Fraction object as new Fraction object.
	 * @throws IllegalArgumentException Throws if the given Fraction object is null or it's denominator is 0.
	 */
	Fraction mul (Fraction fraction) {
		if (fraction == null)
			throw new IllegalArgumentException("The fraction to multiply with must not be null.");
		if (fraction.denominator == 0)
			throw new IllegalArgumentException("The fraction to multiply with must not have the denominator 0.");
		Fraction copy = this.copy();
		copy.mulThis(fraction);
		return copy;
	}
	
	/**
	 * This method multiplies the this object by the given Fraction object.
	 * @param fraction The Fraction object which the this object is multiplied by.
	 */
	void mulThis (Fraction fraction) {
		if (fraction != null) {
			numerator *= fraction.numerator;
			denominator *= fraction.denominator;
			simplify();
		}
	}
	
	/**
	 * This method creates a new Fraction object which is the quotient of the this object and the given Fraction object and returns it.
	 * @param fraction The Fraction object which the this object is divided by in a new quotient Fraction object (the this object is not modified).
	 * @return The quotient of the this object and the given Fraction object as new Fraction object.
	 * @throws IllegalArgumentException Throws if the given Fraction object is null or it's numerator is 0.
	 */
	Fraction div (Fraction fraction) {
		if (fraction == null)
			throw new IllegalArgumentException("The fraction to divide by must not be null.");
		if (fraction.numerator == 0)
			throw new IllegalArgumentException("The fraction to divide by must not have the numerator 0.");
		Fraction copy = this.copy();
		copy.divThis(fraction);
		return copy;
	}
	
	/**
	 * This method divides the this object by the given Fraction object.
	 * @param fraction The Fraction object which the this object is divided by.
	 * @throws IllegalArgumentException Throws if the numerator of the given Fraction object is 0.
	 */
	void divThis (Fraction fraction) {
		if (fraction != null) {
			if (fraction.numerator == 0)
				throw new IllegalArgumentException("The fraction to divide by must not have the numerator 0.");
			numerator *= fraction.denominator;
			denominator *= fraction.numerator;
			simplify();
		}
	}
	
	/**
	 * This method creates a new Fraction object which is the power of the this object to the given exponent and returns it.
	 * @param exponent The exponent which the this object is raised to the power of in a new power Fraction object (the this object is not modified).
	 * @return The power of the this object to the given exponent as new Fraction object.
	 */
	Fraction pow (int exponent) {
		Fraction copy = this.copy();
		copy.powThis(exponent);
		return copy;
	}
	
	/**
	 * This method divides the this object by the given Fraction object.
	 * @param exponent The exponent which the this object is raised to the power of.
	 * @throws IllegalArgumentException Throws if the numerator of the given Fraction object is 0 and the exponent is negative.
	 */
	void powThis (int exponent) {
		if (numerator == 0 && exponent < 0)
			throw new IllegalArgumentException("Can not take 0 to a negative power.");
		if (exponent < 0) {
			long orgNum = numerator;
			numerator = (long) Math.pow(denominator, -exponent);
			denominator = (long) Math.pow(orgNum, -exponent);
		}
		else {
			numerator = (long) Math.pow(numerator, exponent);
			denominator = (long) Math.pow(denominator, exponent);
		}
		simplify();
	}
	
	/**
	 * This method simplifies the this fraction and makes the denominator positive, if it is negative.
	 */
	private void simplify () {
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		long greatestCommonFactor = greatestCommonFactor(numerator, denominator);
		numerator /= greatestCommonFactor;
		denominator /= greatestCommonFactor;
	}
	
	/**
	 * This method determines the greatest common factor of the two given values and returns it.
	 * @param a The first value of which the greatest common factor is being determined.
	 * @param b The second value of which the greatest common factor is being determined.
	 * @return The determined greatest common factor of the two given values.
	 */
	static long greatestCommonFactor (long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return b == 0 ? a : greatestCommonFactor(b, a % b);
	}
	
	/**
	 * This method determines the least common multiple of the two given values and returns it.
	 * @param a The first value of which the least common multiple is being determined.
	 * @param b The second value of which the least common multiple is being determined.
	 * @return The determined least common multiple of the two given values.
	 */
	static long leastCommonMultiple (long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return (a*b) / greatestCommonFactor(a, b);
	}
	
	/**
	 * This method creates an exact copy of the this Faction object and returns it.
	 * @return An exact copy of the this Faction object.
	 */
	private Fraction copy () {
		return new Fraction(numerator, denominator);
	}
	
	/**
	 * This method sets whether all Factions are being output as faction or as decimal value.
	 * @param fractionFormat Whether all Factions are being output as faction (true) or as decimal value (false).
	 */
	static void setFractionFormat (boolean fractionFormat) {
		Fraction.fractionFormat = fractionFormat;
	}
	
	/**
	 * This method returns whether all Factions are being output as faction or as decimal value.
	 * @return Whether all Factions are being output as faction or as decimal value.
	 */
	static boolean isFractionFormat () {
		return fractionFormat;
	}
	
	/**
	 * This method sets the numerator to the given numerator and the denominator to the given denominator.
	 * @param numerator The new value of the numerator.
	 * @param denominator The new value of the denominator.
	 * @throws IllegalArgumentException Throws if the denominator is 0.
	 */
	private void setFraction (long numerator, long denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException("The denominator must not be 0.");
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * This method sets the numerator and the denominator to the shortest fraction of the given value.
	 * @param value The value of which shortest fraction is set as the this object.
	 */
	private void setFraction (double value) {
		long denominatorValue = 1;
		while ((double) Math.round(value * denominatorValue) / denominatorValue != value)
			denominatorValue *= 10;
		numerator = (long)(value * denominatorValue);
		denominator = denominatorValue;
	}
	
	@Override
	public String toString () {
		simplify();
		if (fractionFormat)
			return numerator + "/" + denominator;
		return String.format("%.3f", (double) numerator / (double) denominator);
	}
	
	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Fraction fraction = (Fraction) o;
		simplify();
		fraction.simplify();
		return numerator == fraction.numerator &&
				denominator == fraction.denominator;
	}
	
	@Override
	public int hashCode () {
		return Objects.hash(numerator, denominator);
	}
}
