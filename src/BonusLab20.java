import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* Task	:
 * 	-Make a Shopping list application which uses collections to store your items
 * Build Specifications:
 * 	-Use HashMap to keep track of the menu items(you can code it with literals)
 * 	-Use PArellel ArrayLists (one of strings, one of doubles) to store the items ordered and their prices
 * 	-Write 3 methods to find 1) the average of the items ordered and the indexes of the 2) highest and 3) Lowest
 * 
 *  @author Kaelan Richards
 *
 */

public class BonusLab20 {

	public static void main(String[] args) {

		// Display a list of at least 8 item names and prices
		HashMap<String, Double> shoppingList = new HashMap<>();

		shoppingList.put("Beans", 4.54);
		shoppingList.put("Peanuts", 2.37);
		shoppingList.put("Spinach", 7.35);
		shoppingList.put("Banana", 1.56);
		shoppingList.put("Bread", 3.78);
		shoppingList.put("Eggs", .76);
		shoppingList.put("Milk", 4.63);
		shoppingList.put("Cheetos", 2.48);

		// Ask the User to enter an item name
		// If that item exist, display that item and price and add that item and its
		// price to the users order
		// If that item doesn't exist, display an error and re-prompt the user. (Display
		// the menu again if you'd like)
		Scanner scan = new Scanner(System.in);
		String userOrder = null;
		String cont;
		
		// Double average = 0.00;
		// Double total = 0.00;
		ArrayList<Double> priceList = new ArrayList<>();
		ArrayList<String> foodList = new ArrayList<>();
		System.out.println("Welcome to Kaelan's Market");
		System.out.println();
		do {
			displayList(shoppingList);
			userOrder = Validator.getString(scan, "What item would you like to order?");
			userOrder.toLowerCase();

			// userOrder = addItem(shoppingList, scan, userOrder);

			while (true) {

				if (shoppingList.containsKey(userOrder)) {
					System.out.println("Adding " + userOrder + " to cart at " + shoppingList.get(userOrder));

					priceList.add(shoppingList.get(userOrder));
					foodList.add(userOrder);

					break;
				} else {
					System.out.println("Sorry, we don't currently have that item. Please try again");
					userOrder = Validator.getString(scan, "What item would you like to order?");
				}
			}

			// Ask if they want to add another. Repeat if they do (User can enter an item
			// more than once; we're not taking quantity at this point)
			cont = Validator.getString(scan, "Would you like to order anything else? (y/n)");

		} while (cont.equalsIgnoreCase("y"));

		// When they're done adding items, display a list of all items ordered with
		// prices in columns.
		System.out.println("Thanks for the order!");
		System.out.println("Here's what you got");
		printShoppingCart(priceList, foodList);

		// Display the average price of items ordered
		// average = getAverage(priceList);
		// System.out.println(average);
		System.out.println("Average price per item in order was " + getAverage(priceList));
		
		System.out.println("The index of your most expensive item is " + getMaxPrice(priceList));
		System.out.println("The index of your least expensive item is " + getMinPrice(priceList));
		
	}

	public static int getMaxPrice(ArrayList<Double> priceList) {
		int max = 0;
		for (int i = 1; i < priceList.size(); i++) {
			
			if(priceList.get(i) > max) {
				max = i;
			}
		}
		return max;
	}
	public static int getMinPrice(ArrayList<Double> priceList) {
		int min = 1000;
		for (int i = 1; i < priceList.size(); i++) {
			
			if(priceList.get(i) < min) {
				min = i;
			}
		}
		return min;
	}

	private static void printShoppingCart(ArrayList<Double> priceList, ArrayList<String> foodList) {
		for (int i = 0; i < foodList.size(); i++) {
			System.out.println(foodList.get(i) + "	" + "$" + priceList.get(i));
		}
	}

	private static Double getAverage(ArrayList<Double> priceList) {
		double average;
		double total = 0.00;
		for (Double item : priceList) {
			total += item;

		}
		average = total / priceList.size();

		return average;
	}

	private static void displayList(HashMap<String, Double> shoppingList) {
		System.out.println("Item" + "	" + "	" +"Price");
		System.out.println("========================");
		for (String food : shoppingList.keySet()) {

			String foodItem = food.toString();
			String price = shoppingList.get(food).toString();
			System.out.println(foodItem + "	" + "	" +"$" + price);
		}
	}

}
