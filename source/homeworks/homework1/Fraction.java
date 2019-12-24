package homeworks.homework1;

import java.util.Objects;

/**
 * TODO:
 *  write JavaDocs
 *  write Test
 */
public class Fraction {
	private long numerator;
	private long denominator;
	private static boolean fractionFormat;
	
	Fraction () throws FractionException {
		this(0, 1);
	}
	
	Fraction (long numerator) throws FractionException {
		this(numerator, 1);
	}
	
	Fraction (long numerator, long denominator) throws FractionException {
		setFraction(numerator, denominator);
	}
	
	Fraction (String fraction) throws FractionException {
		if (!fraction.matches("-?\\d+(/-?\\d+|.\\d+)?"))
			throw new FractionException("The given string does not contain a legal fraction.");
		String[] tokens = fraction.split("/");
		switch (tokens.length) {
			case 1:
				setFraction(Double.parseDouble(tokens[0]));
				break;
			case 2:
				setFraction(Long.parseLong(tokens[0]), Long.parseLong(tokens[1]));
		}
	}
	
	Fraction (double value) {
		setFraction(value);
	}
	
	Fraction add (Fraction fraction) throws FractionException {
		if (fraction == null)
			throw new FractionException("The fraction to add must not be null.");
		Fraction copy = this.copy();
		copy.addThis(fraction);
		return copy;
	}
	
	void addThis (Fraction fraction) {
		if (fraction != null) {
			long leastCommonMultiple = leastCommonMultiple(denominator, fraction.denominator);
			numerator = numerator * (leastCommonMultiple / denominator) + fraction.numerator * (leastCommonMultiple / fraction.denominator);
			denominator = leastCommonMultiple;
		}
		simplify();
	}
	
	Fraction sub (Fraction fraction) throws FractionException {
		if (fraction == null)
			throw new FractionException("The fraction to subtract must not be null.");
		Fraction copy = this.copy();
		copy.subThis(fraction);
		return copy;
	}
	
	void subThis (Fraction fraction) {
		if (fraction != null) {
			long leastCommonMultiple = leastCommonMultiple(denominator, fraction.denominator);
			numerator = numerator * (leastCommonMultiple / denominator) - fraction.numerator * (leastCommonMultiple / fraction.denominator);
			denominator = leastCommonMultiple;
			simplify();
		}
	}
	
	Fraction mul (Fraction fraction) throws FractionException {
		if (fraction == null)
			throw new FractionException("The fraction to multiply with must not be null.");
		Fraction copy = this.copy();
		copy.mulThis(fraction);
		return copy;
	}
	
	void mulThis (Fraction fraction) {
		if (fraction != null) {
			numerator *= fraction.numerator;
			denominator *= fraction.denominator;
		}
		simplify();
	}
	
	Fraction div (Fraction fraction) throws FractionException {
		if (fraction == null)
			throw new FractionException("The fraction to divide by must not be null.");
		Fraction copy = this.copy();
		copy.divThis(fraction);
		return copy;
	}
	
	void divThis (Fraction fraction) throws FractionException {
		if (fraction != null) {
			if (fraction.numerator == 0)
				throw new FractionException("The fraction to divide by must not have the numerator 0.");
			numerator *= fraction.denominator;
			denominator *= fraction.numerator;
		}
		simplify();
	}
	
	Fraction pow (int exponent) throws FractionException {
		Fraction copy = this.copy();
		copy.powThis(exponent);
		return copy;
	}
	
	void powThis (int exponent) throws FractionException {
		if (numerator == 0 && exponent < 0)
			throw new FractionException("Can not take 0 to a negative power.");
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
	
	private void simplify () {
		if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		long greatestCommonFactor = greatestCommonFactor(numerator, denominator);
		numerator /= greatestCommonFactor;
		denominator /= greatestCommonFactor;
	}
	
	static long greatestCommonFactor (long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return b == 0 ? a : greatestCommonFactor(b, a % b);
	}
	
	static long leastCommonMultiple (long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		return (a*b) / greatestCommonFactor(a, b);
	}
	
	private Fraction copy () throws FractionException {
		return new Fraction(numerator, denominator);
	}
	
	public static void setFractionFormat (boolean fractionFormat) {
		Fraction.fractionFormat = fractionFormat;
	}
	
	public static boolean isFractionFormat () {
		return fractionFormat;
	}
	
	private void setFraction (long numerator, long denominator) throws FractionException {
		if (denominator == 0)
			throw new FractionException("The denominator must not be null.");
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
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

class FractionException extends Exception {
	public FractionException (String message) {
		super(message);
	}
}