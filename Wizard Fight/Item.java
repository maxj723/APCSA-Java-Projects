package quiz;

class Item {

	private String name;
	private int price;

	public Item(String n, int p) {
		this.name = n;
		this.price = p;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int p) {
		price = p;
	}

}