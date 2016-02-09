/**
 * Ingredient.java
 * 
 * Enumerates the ingredients used for the sandwiches
 *
 * @author Patrick
 * 
 * V1.0
 *
 * Jan 28, 2016
 */

public enum Ingredient {
	BREAD("Bread"),PEANUT_BUTTER("Peanut Butter"), GRAPE_JELLY("Grape Jelly");
	
	private final String name;
	
	private Ingredient(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

