/**
 * Start.java
 * 
 * This class creates the necessary threads and instances and runs the simulation.
 * 
 * @author Patrick
 * 
 * @version 1.0
 *
 * Jan 29, 2016
 */

/*
 * Consider a system with three chef threads and one agent thread. 
 * Each chef continuously makes a sandwich and then eats it. But to make and eat a sandwich, the chef needs three ingredients: bread, peanut butter, and jam. 
 * One of the chef threads has an infinite supply of bread, another has peanut butter, and the third has jam. 
 * The agent has an infinite supply of all three ingredients. The agent randomly selects two of the ingredients and places them on a table. 
 * The chef who has the remaining ingredient then makes and eats a sandwich, signalling the agent on completion. 
 * The agent then puts out another two of the three ingredients, and the cycle repeats.
 */

public class Start extends Thread {
	
	public static void main(String[] args) {
		Table table = new Table();
		Chef chef1 = new Chef(Ingredient.BREAD, table, "Chef 1");
		Chef chef2 = new Chef(Ingredient.PEANUT_BUTTER, table, "Chef 2");
		Chef chef3 = new Chef(Ingredient.GRAPE_JELLY, table, "Chef 3");
		Agent agent = new Agent(table);
		
		agent.start();
		chef1.start();
		chef2.start();
		chef3.start();
	}
}
