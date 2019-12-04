package labors.labor02;

import org.junit.Test;

import static org.junit.Assert.*;

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
		Rectangle r = new Rectangle();
		assertEquals(1.0, r.getLength(), delta);
		assertEquals(1.0, r.getWidth(), delta);
		r.setLength(69.420);
		assertEquals(20.0, r.getLength(), delta);
		r.setWidth(-420.69);
		assertEquals(1.0, r.getWidth(), delta);
		r.setLength(4.2);
		assertEquals(4.2, r.getLength(), delta);
	}
	
	@Test
	public void faceTest () {
		Rectangle r = new Rectangle();
		assertEquals(1.0, r.face(), delta);
		r.setLength(5.0);
		r.setWidth(5.0);
		assertEquals(25.0, r.face(), delta);
		r.setLength(0.0);
		r.setWidth(69.0);
		assertEquals(20.0, r.face(), delta);
	}
	
	@Test
	public void extentTest () {
		Rectangle r = new Rectangle();
		assertEquals(4.0, r.extent(), delta);
		r.setLength(10.0);
		r.setWidth(5.0);
		assertEquals(30.0, r.extent(), delta);
		r.setLength(0.0);
		r.setWidth(69.0);
		assertEquals(42.0, r.extent(), delta);
	}
}