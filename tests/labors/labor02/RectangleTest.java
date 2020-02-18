package labors.labor02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
	private static double delta = .01;
	
	@Test
	public void intervalCheckTest () {
		assertEquals(20.0, Rectangle.intervalCheck(69.420), delta);
		assertEquals(1.0, Rectangle.intervalCheck(-420.69), delta);
		assertEquals(4.2, Rectangle.intervalCheck(4.2), delta);
	}
	
	@Test
	public void setterInIntervalTest () {
		Rectangle rectangle = new Rectangle();
		assertEquals(1.0, rectangle.getLength(), delta);
		assertEquals(1.0, rectangle.getWidth(), delta);
		rectangle.setLength(69.420);
		assertEquals(20.0, rectangle.getLength(), delta);
		rectangle.setWidth(-420.69);
		assertEquals(1.0, rectangle.getWidth(), delta);
		rectangle.setLength(4.2);
		assertEquals(4.2, rectangle.getLength(), delta);
	}
	
	@Test
	public void faceTest () {
		Rectangle rectangle = new Rectangle();
		assertEquals(1.0, rectangle.face(), delta);
		rectangle.setLength(5.0);
		rectangle.setWidth(5.0);
		assertEquals(25.0, rectangle.face(), delta);
		rectangle.setLength(0.0);
		rectangle.setWidth(69.0);
		assertEquals(20.0, rectangle.face(), delta);
	}
	
	@Test
	public void extentTest () {
		Rectangle rectangle = new Rectangle();
		assertEquals(4.0, rectangle.extent(), delta);
		rectangle.setLength(10.0);
		rectangle.setWidth(5.0);
		assertEquals(30.0, rectangle.extent(), delta);
		rectangle.setLength(0.0);
		rectangle.setWidth(69.0);
		assertEquals(42.0, rectangle.extent(), delta);
	}
}