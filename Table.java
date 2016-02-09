import java.util.ArrayList;

/**
 * Table.java
 * 
 * @author Patrick
 * 
 * @version 1.1
 *
 * Feb 3, 2016
 */

public class Table {
	
	private ArrayList<Ingredient> contents;
	private boolean empty = true;
	private int counter;
	
	public Table() {
		contents = new ArrayList<Ingredient>();
		counter = 0;
	}
	
	/*
	 * Places an arraylist of two ingredients on the table and notifies all the threads
	 */
	public synchronized void put(ArrayList<Ingredient> ingredients) {
		while(contents.size() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		empty = false;
		contents = ingredients;
		notifyAll();
	}
	
	public int getSize() {
		return contents.size();
	}
	
	public int getCount() {
		return counter;
	}
	
	/*
	 * Allows a Chef to make a sandwich if he has the missing ingredient 
	 */
	public synchronized void makeSandwich(Ingredient ingredient) {
		while(contents.contains(ingredient) || empty) {
			try {
				wait(); //Force the chefs to wait if the table is empty or their ingredient is on it
			} catch (InterruptedException e) {}
		}
			counter++;
			contents.clear();
			empty = true;
			notifyAll();
	}
	
	public void clear() {
		contents.clear();
	}
	
	public String toString() {
		String s = "";
		for(Ingredient i:contents) {
			s+=i.toString();
			s+=", ";
		}
		return s;
	}
}
