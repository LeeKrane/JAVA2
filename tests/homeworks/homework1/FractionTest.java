package homeworks.homework1;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
	@Test
	public void constructorString_leadingPoint_valid() {
		Fraction b = new Fraction(".1");
		assertEquals(1, b.getNumerator());
		assertEquals(10, b.getDenominator());
	}
	
	@Test
	public void constructorString_invalidString_exception() {
		assertThrows(IllegalArgumentException.class, () -> new Fraction("string"));
		assertThrows(IllegalArgumentException.class, () -> new Fraction("-"));
		assertThrows(IllegalArgumentException.class, () -> new Fraction("3.-2"));
		assertThrows(IllegalArgumentException.class, () -> new Fraction("3/-2"));
		String errormsg = assertThrows(IllegalArgumentException.class, () -> new Fraction("3/0")).getMessage();
		assertTrue(errormsg.contains("denominator" /* original was: "Nenner" */) && errormsg.contains("0"));
	}
	
	@Test
	public void greatestCommonFactor_oneNegative_greatestCommonFactorOfAbs() {
		long result = Fraction.greatestCommonFactor(-12234L, 2445L);
		assertEquals(3, result);
		result = Fraction.greatestCommonFactor(12234L, -2445L);
		assertEquals(3, result);
	}
	
	@Test
	public void greatestCommonFactor_bothPositive_greatestCommonFactor() {
		long result = Fraction.greatestCommonFactor(72, 96);
		assertEquals(24, result);
	}
	
	@Test
	public void greatestCommonFactor_relativePrimes_1() {
		long result = Fraction.greatestCommonFactor(3, 5);
		assertEquals(1, result);
	}
	
	@Test
	public void greatestCommonFactor_oneZero_otherNumber() {
		long result = Fraction.greatestCommonFactor(3, 0);
		assertEquals(3, result);
		result = Fraction.greatestCommonFactor(0, 3);
		assertEquals(3, result);
	}
	
	@Test
	public void greatestCommonFactor_bothZero_exception() {
		assertThrows(IllegalArgumentException.class, () -> Fraction.greatestCommonFactor(0, 0));
	}
	
	@Test
	public void leastCommonMultiple_oneNegative_leastCommonMultipleOfAbs() {
		long result = Fraction.leastCommonMultiple(1234, -64);
		assertEquals(39488, result);
		result = Fraction.leastCommonMultiple(-1234, 64);
		assertEquals(39488, result);
	}
	
	@Test
	public void leastCommonMultiple_bothPositive_leastCommonMultiple() {
		long result = Fraction.leastCommonMultiple(12134, 624);
		assertEquals(3785808, result);
	}
	
	@Test
	public void greatestCommonFactor_oneZero_0() {
		long result = Fraction.leastCommonMultiple(3, 0);
		assertEquals(0, result);
		result = Fraction.leastCommonMultiple(0, 3);
		assertEquals(0, result);
	}
	
	@Test
	public void leastCommonMultiple_bothZero_exception() {
		assertThrows(IllegalArgumentException.class, () -> Fraction.leastCommonMultiple(0, 0));
	}
	
	@Test
	public void add_null_exception() {
		Fraction b = new Fraction(1);
		assertThrows(IllegalArgumentException.class, () -> b.add(null));
	}
	
	
	@Test
	public void add_anyFraction_callerUnchanged() {
		Fraction b = new Fraction(2, 3);
		b.add(new Fraction(3, 7));
		assertEquals(2, b.getNumerator());
		assertEquals(3, b.getDenominator());
	}
	
	@Test
	public void add_nennerFremderFraction_result() {
		Fraction b = new Fraction(5, 12);
		Fraction summand = new Fraction(11, 24);
		Fraction result = b.add(summand);
		assertEquals(7, result.getNumerator());
		assertEquals(8, result.getDenominator());
	}
	
	@Test
	public void addThis_null_callerUnchanged() {
		Fraction b = new Fraction(1);
		b.addThis(null);
		assertEquals(1, b.getNumerator());
		assertEquals(1, b.getDenominator());
	}
	
	@Test
	public void addThis_nennerFremderFraction_callerChanged() {
		Fraction b = new Fraction(5, 12);
		Fraction summand = new Fraction(11, 24);
		b.addThis(summand);
		assertEquals(7, b.getNumerator());
		assertEquals(8, b.getDenominator());
	}
	
	@Test
	public void sub_null_exception() {
		Fraction b = new Fraction(1);
		assertThrows(IllegalArgumentException.class, () -> b.sub(null));
	}
	
	@Test
	public void sub_anyFraction_callerUnchanged() {
		Fraction b = new Fraction(2, 3);
		b.sub(new Fraction(3, 7));
		assertEquals(2, b.getNumerator());
		assertEquals(3, b.getDenominator());
	}
	
	@Test
	public void sub_nennerFremderFraction_result() {
		Fraction b = new Fraction(4, 5);
		Fraction subtrahend = new Fraction(3, 7);
		Fraction result = b.sub(subtrahend);
		assertEquals(13, result.getNumerator());
		assertEquals(35, result.getDenominator());
	}
	
	@Test
	public void subThis_null_callerUnchanged() {
		Fraction b = new Fraction(1);
		b.subThis(null);
		assertEquals(1, b.getNumerator());
		assertEquals(1, b.getDenominator());
	}
	
	@Test
	public void subThis_nennerFremderFraction_callerChanged() {
		Fraction b = new Fraction(4, 5);
		Fraction subtrahend = new Fraction(3, 7);
		b.subThis(subtrahend);
		assertEquals(13, b.getNumerator());
		assertEquals(35, b.getDenominator());
	}
	
	@Test
	public void mul_null_exception() {
		Fraction b = new Fraction(1);
		assertThrows(IllegalArgumentException.class, () -> b.mul(null));
	}
	
	@Test
	public void mul_anyFraction_callerUnchanged() {
		Fraction b = new Fraction(2, 3);
		b.mul(new Fraction(3, 7));
		assertEquals(2, b.getNumerator());
		assertEquals(3, b.getDenominator());
	}
	
	@Test
	public void mul_anyFraction_result() {
		Fraction b = new Fraction(4, 5);
		Fraction factor = new Fraction(3, 7);
		Fraction result = b.mul(factor);
		assertEquals(12, result.getNumerator());
		assertEquals(35, result.getDenominator());
	}
	
	@Test
	public void mulThis_null_callerUnchanged() {
		Fraction b = new Fraction(1);
		b.mulThis(null);
		assertEquals(1, b.getNumerator());
		assertEquals(1, b.getDenominator());
	}
	
	@Test
	public void mulThis_anyFraction_callerChanged() {
		Fraction b = new Fraction(4, 5);
		Fraction subtrahend = new Fraction(3, 7);
		b.subThis(subtrahend);
		assertEquals(13, b.getNumerator());
		assertEquals(35, b.getDenominator());
	}
	
	@Test
	public void div_null_exception() {
		Fraction b = new Fraction(1);
		assertThrows(IllegalArgumentException.class, () -> b.div(null));
	}
	
	@Test
	public void div_anyFractionNot0_callerUnchanged() {
		Fraction b = new Fraction(2, 3);
		b.div(new Fraction(3, 7));
		assertEquals(2, b.getNumerator());
		assertEquals(3, b.getDenominator());
	}
	
	@Test
	public void div_anyFractionNot0_result() {
		Fraction b = new Fraction(3, 5);
		Fraction divisor = new Fraction(2, 7);
		Fraction result = b.div(divisor);
		assertEquals(21, result.getNumerator());
		assertEquals(10, result.getDenominator());
	}
	
	@Test
	public void div_0_exception() {
		Fraction b = new Fraction(3, 5);
		Fraction divisor = new Fraction(0);
		String errorMsg = assertThrows(IllegalArgumentException.class, () -> b.div(divisor)).getMessage();
		assertTrue(errorMsg.contains("0"));
	}
	
	@Test
	public void divThis_null_callerUnchanged() {
		Fraction b = new Fraction(1);
		b.divThis(null);
		assertEquals(1, b.getNumerator());
		assertEquals(1, b.getDenominator());
	}
	
	@Test
	public void divThis_anyFraction_callerChanged() {
		Fraction b = new Fraction(3, 5);
		Fraction divisor = new Fraction(2, 7);
		b.divThis(divisor);
		assertEquals(21, b.getNumerator());
		assertEquals(10, b.getDenominator());
	}
	
	@Test
	public void divThis_0_exception() {
		Fraction b = new Fraction(3, 5);
		Fraction divisor = new Fraction(0);
		String errorMsg = assertThrows(IllegalArgumentException.class, () -> b.divThis(divisor)).getMessage();
		assertTrue(errorMsg.contains("0"));
	}
	
	@Test
	public void pow_anyFractionNot0anyExponent_callerUnchanged() {
		Fraction b = new Fraction(2, 3);
		b.pow(3);
		assertEquals(2, b.getNumerator());
		assertEquals(3, b.getDenominator());
	}
	
	@Test
	public void pow_anyFractionNot0anyExponent_result() {
		Fraction b = new Fraction(3, 5);
		Fraction result = b.pow(3);
		assertEquals(27, result.getNumerator());
		assertEquals(125, result.getDenominator());
	}
	
	@Test
	public void pow_bruch0negativeExponent_exception() {
		Fraction b = new Fraction(0);
		assertThrows(IllegalArgumentException.class, () -> b.pow(-1));
	}
	
	@Test
	public void powThis_anyFraction_callerChanged() {
		Fraction b = new Fraction(3, 5);
		b.powThis(-3);
		assertEquals(125, b.getNumerator());
		assertEquals(27, b.getDenominator());
	}
	
	@Test
	public void powThis_bruch0negativeExponent_exception() {
		Fraction b = new Fraction(0);
		assertThrows(IllegalArgumentException.class, () -> b.powThis(-1));
	}
	
	@Test
	public void toString_bruchFormat_Fractiondarstellung() {
		Fraction b = new Fraction("2/4");
		Fraction.setFractionFormat(true);
		assertEquals("1/2", b.toString());
	}
	
	@Test
	public void toString_dezimalFormatLocaleGerman_kommadarstellung() {
		Fraction.setFractionFormat(false);
		Locale def = Locale.getDefault();
		Locale.setDefault(Locale.GERMAN);
		Fraction b = new Fraction("2/4");
		assertEquals("0,500", b.toString());
		Locale.setDefault(def);
	}
	
	@Test
	public void toString_dezimalFormatLocaleUS_kommadarstellung() {
		Fraction.setFractionFormat(false);
		Locale def = Locale.getDefault();
		Locale.setDefault(Locale.US);
		Fraction b = new Fraction("2/4");
		assertEquals("0.500", b.toString());
		Locale.setDefault(def);
	}
	
	@Test
	public void toString_dezimalFormat_kommadarstellung() {
		Fraction.setFractionFormat(false);
		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
		format.setMinimumFractionDigits(3);
		Fraction b = new Fraction(1, 10_000);
		String expected = format.format(0);
		assertEquals(expected, b.toString());
	}
	
	@Test
	public void toString_bruchFormat_bruchdarstellung() {
		Fraction.setFractionFormat(true);
		Fraction b = new Fraction(2, -100_000);
		assertEquals("-1/50000", b.toString());
	}
}