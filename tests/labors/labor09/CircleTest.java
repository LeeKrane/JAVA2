package labors.labor09;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LeeKrane
 */

public class CircleTest {
	@ParameterizedTest
	@CsvSource({"-69,-69,69", "0,0,0", "69,69,420"})
	public void constructor_validValues_doesNotThrow (double x, double y, double radius) {
		assertDoesNotThrow(() -> new Circle(x, y, radius));
	}
	
	@ParameterizedTest
	@CsvSource({"NaN,42,42", "42,NaN,42", "42,42,-42"})
	public void constructor_invalidValues_throwsIllegalArgumentException (double x, double y, double radius) {
		assertThrows(IllegalArgumentException.class, () -> new Circle(x, y, radius));
	}
	
	@Test
	public void constructor_invalidValues2_throwsIllegalArgumentException () {
		assertThrows(IllegalArgumentException.class, () -> new Circle(Double.NEGATIVE_INFINITY, 42, 42));
		assertThrows(IllegalArgumentException.class, () -> new Circle(Double.POSITIVE_INFINITY, 42, 42));
		assertThrows(IllegalArgumentException.class, () -> new Circle(42, Double.NEGATIVE_INFINITY, 42));
		assertThrows(IllegalArgumentException.class, () -> new Circle(42, Double.POSITIVE_INFINITY, 42));
		assertThrows(IllegalArgumentException.class, () -> new Circle(42, 42, Double.NEGATIVE_INFINITY));
		assertThrows(IllegalArgumentException.class, () -> new Circle(42, 42, Double.POSITIVE_INFINITY));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {42, 69, 420})
	public void scale_validValue_doesNotThrow (double s) {
		assertDoesNotThrow(() -> new Circle(1, 1, 1).scale(s));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {-42, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
	public void scale_invalidValue_throwsIllegalArgumentException (double s) {
		assertThrows(IllegalArgumentException.class, () -> new Circle(1, 1, 1).scale(s));
	}
	
	@ParameterizedTest
	@CsvSource({"-42,-42", "0,0", "42,42"})
	public void translate_validValues_doesNotThrow (double x, double y) {
		assertDoesNotThrow(() -> new Circle(1, 1, 1).translate(x, y));
	}
	
	@ParameterizedTest
	@CsvSource({"NaN,42", "42,NaN"})
	public void translate_invalidValues_throwsIllegalArgumentException (double x, double y) {
		assertThrows(IllegalArgumentException.class, () -> new Circle(1, 1, 1).translate(x, y));
	}
	
	@Test
	public void translate_invalidValues2_throwsIllegalArgumentException () {
		assertThrows(IllegalArgumentException.class, () -> new Circle(1, 1, 1).translate(Double.POSITIVE_INFINITY, 42));
		assertThrows(IllegalArgumentException.class, () -> new Circle(1, 1, 1).translate(Double.NEGATIVE_INFINITY, 42));
		assertThrows(IllegalArgumentException.class, () -> new Circle(1, 1, 1).translate(42, Double.POSITIVE_INFINITY));
		assertThrows(IllegalArgumentException.class, () -> new Circle(1, 1, 1).translate(42, Double.NEGATIVE_INFINITY));
	}
}