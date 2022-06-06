package quiz;

class Attack {
	private int damage;
	private String name;

	public Attack(int d, String n) {
		this.damage = d;
		this.name = n;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return name;
	}

	public void setDamage(int n) {
		damage = n;
	}

}