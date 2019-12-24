package labors.labor03;

/**
 * @author LeeKrane
 */

public class Potion {
	private Ingredient firstIngredient;
	private Ingredient secondIngredient;
	private Ingredient thirdIngredient;
	private int stirred;
	
	public static void main (String[] args) {
		// Ingredients are created
		Ingredient ingredient1 = new Ingredient("Toad");
		Ingredient ingredient2 = new Ingredient("Lizard");
		Ingredient ingredient3 = new Ingredient("Spider");
		// the name of ingredient1 gets changed to "Fly"
		ingredient1.setIngredientName("Fly");
		
		// Potion is created with 3 Ingredients
		Potion potion = new Potion(ingredient1, ingredient2, ingredient3);
		// Potion is stirred 3 times
		potion.stir();
		potion.stir();
		potion.stir();
		// Potion information gets logged
		System.out.println(potion);
		// Ingredients: Fly, Lizard, Spider
		// Power: 15
		// Ready: no
		
		// Potion is stirred another 2 times
		potion.stir();
		potion.stir();
		// Potion information gets logged
		System.out.println(potion);
		// Ingredients: Fly, Lizard, Spider
		// Power: 30
		// Ready: yes
	}
	
	public Potion (Ingredient firstIngredient, Ingredient secondIngredient, Ingredient thirdIngredient) {
		this.firstIngredient = firstIngredient;
		this.secondIngredient = secondIngredient;
		this.thirdIngredient = thirdIngredient;
		this.stirred = 0;
	}
	
	public void stir () {
		stirred++;
	}
	
	public boolean isReady () {
		return stirred >= 5;
	}
	
	public int power () {
		if (isReady())
			return (firstIngredient.power() + secondIngredient.power() + thirdIngredient.power()) * 2;
		return firstIngredient.power() + secondIngredient.power() + thirdIngredient.power();
	}
	
	@Override
	public String toString () {
		// (isReady() ? "yes" : "no") is like an if statement but in short.
		// after the ? is what gets executed in the if(){} block.
		// after the : is what gets executed in the else{} block.
		return "Ingredients: " + firstIngredient + ", " + secondIngredient + ", " + thirdIngredient + "\nPower: " + power() + "\nReady: " + (isReady() ? "yes" : "no");
	}
	
	// the following methods are used in my self written test
	public Ingredient getFirstIngredient () { return firstIngredient; }
	public Ingredient getSecondIngredient () { return secondIngredient; }
	public Ingredient getThirdIngredient () { return thirdIngredient; }
	public int getStirred () { return stirred; }
}
