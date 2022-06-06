package quiz;

import java.util.Scanner;
import java.util.ArrayList;

class Shop {

	private ArrayList<Item> items;

	public Shop() {
		items = new ArrayList<Item>();
		items.add(new Item("sneaker", 200));
		items.add(new Item("wand", 200));
		items.add(new Item("broom", 400));
		items.add(new Item("invisible robe", 800));
	}

	
	public void start(String playMore, Scanner play, Wizard p1, Wizard p2) {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getName() + ": $" + items.get(i).getPrice());
		}
		System.out.println("" + p1.getName() + " You have $" + p1.getMoney()
				+ " remaining, would you like to make a purchase? Y/N");
		if (play.nextLine().equals("Y")) {
			System.out.println("Type what item you would like to purchase");
			String purchase = play.nextLine();
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getName().equals(purchase)) {
					p1.buy(items.get(i));
				}
			}
		}
		System.out.println("" + p2.getName() + " You have $" + p2.getMoney()
				+ " remaining, would you like to make a purchase? Y/N");
		if (play.nextLine().equals("Y")) {
			System.out.println("Type what item you would like to purchase");
			String purchase2 = play.nextLine();
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).getName().equals(purchase2)) {
					p2.buy(items.get(i));
				}
			}
		}
		System.out.println("Thank you, and good luck in your future battles!");
	}

}
