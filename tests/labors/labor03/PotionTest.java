package labors.labor03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LeeKrane
 */

public class PotionTest {
	private static Ingredient testIngredient1 = new Ingredient("testIngredient1");
	private static Ingredient testIngredient2 = new Ingredient("testIngredient2");
	private static Ingredient testIngredient3 = new Ingredient("testIngredient3");
	
	@Test
	public void constructorTest () {
		Potion test = new Potion(testIngredient1, testIngredient2, testIngredient3);
		assertEquals(testIngredient1, test.getFirstIngredient());
		assertEquals(testIngredient2, test.getSecondIngredient());
		assertEquals(testIngredient3, test.getThirdIngredient());
		assertEquals(0, test.getStirred());
	}
	
	@Test
	public void stirAndIsReadyTest() {
		Potion test = new Potion(testIngredient1, testIngredient2, testIngredient3);
		assertEquals(0, test.getStirred());
		assertFalse(test.isReady());
		test.stir();
		test.stir();
		test.stir();
		assertEquals(3, test.getStirred());
		assertFalse(test.isReady());
		test.stir();
		test.stir();
		assertEquals(5, test.getStirred());
		assertTrue(test.isReady());
		
	}
	
	@Test
	public void powerTest () {
		Potion test = new Potion(testIngredient1, testIngredient2, testIngredient3);
		assertEquals(45, test.power());
		test.stir();
		test.stir();
		test.stir();
		test.stir();
		test.stir();
		assertEquals(90, test.power());
	}
	
	@Test
	public void toStringTest () {
		Potion test = new Potion(testIngredient1, testIngredient2, testIngredient3);
		String expected = "Ingredients: testIngredient1, testIngredient2, testIngredient3\nPower: 45\nReady: no";
		assertEquals(expected, test.toString());
		test.stir();
		test.stir();
		test.stir();
		test.stir();
		test.stir();
		expected = "Ingredients: testIngredient1, testIngredient2, testIngredient3\nPower: 90\nReady: yes";
		assertEquals(expected, test.toString());
	}
}