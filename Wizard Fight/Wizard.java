package quiz;

import java.util.ArrayList;

class Wizard {

	private String name;
	private int health;
	private int money;
	private int speed;
	private ArrayList<Item> items;
	private House house;
	private ArrayList<Attack> attacks;
	private boolean isProtected;
	private int attackBoost;
	private boolean onCooldown;

	private House Gryffindor = new House("Gryffindor", new Attack(100, "Special"), 300, 11);
	private House Ravenclaw = new House("Ravenclaw", new Attack(60, "Special"), 400, 5);
	private House Hufflepuff = new House("Hufflepuff", new Attack(80, "Special"), 350, 3);
	private House Slytherin = new House("Slytherin", new Attack(120, "Special"), 250, 1);
	private final House[] houses = { Gryffindor, Ravenclaw, Hufflepuff, Slytherin };

	public Wizard() {
		this.name = "Enemy";
		this.house = houses[(int) (Math.random() * 4)];
		this.health = house.getHealth();
		this.speed = house.getSpeed();
		this.money = 0;
		this.items = new ArrayList<Item>();
		this.attacks = new ArrayList<Attack>();
		addAttacks();
		this.attackBoost = 0;
		this.isProtected = false;
		this.onCooldown = false;
	}

//	public Wizard(String n) {
//		this.name = n;
//		this.house = houses[(int) (Math.random() * 4)];
//		this.health = house.getHealth();
//		this.speed = house.getSpeed();
//		this.money = 0;
//		this.items = new ArrayList<Item>();
//		addAttacks();
//	}

	public Wizard(String h) {
		this.name = "Wizard";
		for (House team : houses) {
			if (h.equalsIgnoreCase(team.getName())) {
				this.house = team;
				break;
			}
		}
		this.health = house.getHealth();
		this.speed = house.getSpeed();
		this.money = 0;
		this.items = new ArrayList<Item>();
		this.attacks = new ArrayList<Attack>();
		addAttacks();
		this.attackBoost = 0;
		this.isProtected = false;
		this.onCooldown = false;
	}

	void addAttacks() {
		attacks.add(house.getAttack());
		attacks.add(new Attack(50, "Quick Spell"));
		attacks.add(new Attack(0, "Magic Spell"));
		attacks.add(new Attack(0, "Protection"));
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMoney() {
		return money;
	}

	public int getSpeed() {
		return speed;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public int getAttackDamage() {
		return house.getAttackDamage();
	}

	public String getAttackName() {
		return house.getAttackName();
	}

	public House getHouse() {
		return house;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public boolean getIsProtected() {
		return isProtected;
	}
	
	public int getAttackBoost() {
		return attackBoost;
	}

	public boolean getOnCooldown() {
		return onCooldown;
	}
	
	public void setHealth(int h) {
		if (h < 0) {
			health = 0;
		} else {
			health = h;
		}
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public void setMoney(int m) {
		if (m < 0) {
			money = 0;
		} else {
			money = m;
		}
	}
	
	public void setIsProtected(boolean p) {
		isProtected = p;
	}
	
	public void setAttackBoost(int a) {
		attackBoost = a;
	}
	
	public void setOnCooldown(boolean c) {
		onCooldown = c;
	}

	public boolean buy(Item i) {
	    if (money >= i.getPrice()) {
	      items.add(i);
	      money -= i.getPrice();
	      switch(i.getName()) {
	        case "wand":
	          attacks.get(0).setDamage(attacks.get(0).getDamage() + 50);
	          attacks.get(1).setDamage(attacks.get(1).getDamage() + 30);
	        case "sneaker":
	          speed += 5;
	        case "broom" :
	          speed += 15;
	        case "invisible robe":
	          health += 100;
	      }
	      return true;
	    } else {
	      return false;

	    }
	  }

}
