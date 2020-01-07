package labors.labor03;

/**
 * @author LeeKrane
 */

public class Ingredient {
	private String ingredientName;
	
	public Ingredient (String name) {
		this.ingredientName = name;
	}
	
	public int power () {
		return ingredientName.length();
	}
	
	public void setIngredientName (String ingredientName) {
		this.ingredientName = ingredientName;
	}
	
	@Override
	public String toString () {
		return ingredientName;
	}
	
	// the following method is used in my self written test
	public String getIngredientName () { return ingredientName; }
}
