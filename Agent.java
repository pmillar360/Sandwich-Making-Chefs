import java.util.ArrayList;
import java.util.Random;

/**
 * Agent.java
 * 
 * @author Patrick
 * 
 * @version 1.1
 *
 * Feb 3, 2016
 */

public class Agent extends Thread {
	
	private Ingredient firstIngredient;
	private Ingredient secondIngredient;
	private ArrayList<Ingredient> ingredients;
	private Table table;
	private int i;
	
	public Agent(Table t) {
		this.table = t;
		i = 1;
	}
	
	/*
	 * Places the chosen ingredients on the table
	 */
	public void run(){
			while(i <= 20){
				pickIngredients();
				ingredients.toString();
				table.put(ingredients);
				System.out.println("Ingredients "+firstIngredient.getName()+" and "+secondIngredient.getName()+" placed on the table by the Agent");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				i++;
			}
	}
	
	/*
	 * Creates an arraylist consisting of two distinct ingredients
	 */
	public void pickIngredients(){
		ingredients = new ArrayList<>();
		int rand = new Random().nextInt(3);
		firstIngredient = Ingredient.values()[rand];
		ingredients.add(firstIngredient);
		secondIngredient = firstIngredient;
		while(secondIngredient == firstIngredient) {
			secondIngredient = Ingredient.values()[new Random().nextInt(3)];
			ingredients.add(secondIngredient);
		}
	}
}
