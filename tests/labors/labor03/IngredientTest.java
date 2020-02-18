package labors.labor03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author LeeKrane
 */

public class IngredientTest {
	@Test
	public void constructorTest () {
		Ingredient test = new Ingredient("test");
		assertEquals("test", test.getIngredientName());
	}
	
	@Test
	public void powerTest () {
		assertEquals(4, new Ingredient("test").power());
		assertEquals(0, new Ingredient("").power());
		assertEquals(15, new Ingredient("thisIsJustATest").power());
	}
	
	@Test
	public void setterTest () {
		Ingredient test = new Ingredient("test");
		test.setIngredientName("setterTest");
		assertEquals("setterTest", test.getIngredientName());
	}
	
	@Test
	public void toStringTest () {
		Ingredient test = new Ingredient("test");
		assertEquals("test", test.toString());
	}
}