package labors.labor04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PortalCraneTest {
	@Test
	public void mainTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		assertEquals(5, crane.silos.length);
		assertEquals(10, crane.maximumFillValue);
		assertEquals(0, crane.position);
		crane.fill(4);
		assertEquals(4, crane.silos[0]);
		crane.fill(1);
		assertEquals(5, crane.silos[0]);
		crane.moveRight(2);
		assertEquals(2, crane.position);
		crane.fill(20);
		assertEquals(10, crane.silos[2]);
		crane.moveRight(2);
		assertEquals(4, crane.position);
		crane.fill(1);
		assertEquals(1, crane.silos[4]);
		crane.moveLeft(42);
		assertEquals(0, crane.position);
		int content = crane.dropAll();
		assertEquals(5, content);
		assertEquals(0, crane.silos[0]);
		crane.moveRight(1);
		assertEquals(1, crane.position);
		crane.fill(content);
		assertEquals(5, crane.silos[1]);
		String expected = "silo 1: 0\nsilo 2: 5 (current position)\nsilo 3: 10\nsilo 4: 0\nsilo 5: 1\n";
		assertEquals(expected, crane.toString());
	}
	
	@Test
	public void constructorTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		assertEquals(5, crane.silos.length);
		assertEquals(10, crane.maximumFillValue);
		assertEquals(0, crane.position);
	}
	
	@Test
	public void moveTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		assertEquals(0, crane.position);
		crane.moveLeft(69);
		assertEquals(0, crane.position);
		crane.moveRight(69);
		assertEquals(4, crane.position);
		crane.moveLeft(3);
		assertEquals(1, crane.position);
		crane.moveRight(2);
		assertEquals(3, crane.position);
	}
	
	@Test
	public void fillTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		crane.fill(69);
		assertEquals(10, crane.silos[0]);
		crane.moveRight(1);
		crane.fill(-69);
		assertEquals(0, crane.silos[1]);
		crane.fill(6);
		assertEquals(6, crane.silos[1]);
		crane.fill(-3);
		assertEquals(6, crane.silos[1]);
		crane.fill(420);
		assertEquals(10, crane.silos[1]);
	}
	
	@Test
	public void dropAllTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		crane.fancyFill(5);
		assertEquals(5, crane.dropAll());
		assertEquals(0, crane.silos[0]);
	}
	
	// fancy tests
	@Test
	public void fancyMoveTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		assertEquals(0, crane.position);
		crane.fancyMoveLeft(69);
		assertEquals(0, crane.position);
		crane.fancyMoveRight(69);
		assertEquals(4, crane.position);
		crane.fancyMoveLeft(3);
		assertEquals(1, crane.position);
		crane.fancyMoveRight(2);
		assertEquals(3, crane.position);
	}
	
	@Test
	public void fancyFillTest () {
		PortalCrane crane = new PortalCrane(5, 10);
		crane.fancyFill(-69);
		assertEquals(0, crane.silos[0]);
		crane.fancyFill(69);
		assertEquals(10, crane.silos[0]);
		crane.fancyMoveRight(1);
		crane.fancyFill(-69);
		assertEquals(0, crane.silos[1]);
		crane.fancyFill(6);
		assertEquals(6, crane.silos[1]);
		crane.fancyFill(-3);
		assertEquals(6, crane.silos[1]);
		crane.fancyFill(420);
		assertEquals(10, crane.silos[1]);
	}
}