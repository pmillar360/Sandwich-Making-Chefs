/**
 * Chef.java
 * 
 * @author Patrick
 * 
 * @version 1.1
 *
 * Feb 3, 2016
 */

public class Chef extends Thread {

	private Ingredient ingredient;
	private Table table;
	private String name;

	public Chef(Ingredient i, Table t, String n) {
		this.table = t;
		this.ingredient = i;
		this.name = n;
	}
	
	/*
	 * Waits for the missing ingredients to be placed on the table then makes+eats the sandwich
	 */
	public void run() {
		while(table.getCount() < 20) {
			table.makeSandwich(ingredient);
				System.out.println(name+" has the missing ingredient "+ingredient.getName());
				System.out.println(name+" has made and eaten sandwich "+table.getCount()+"!\n");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
