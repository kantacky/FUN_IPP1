public class Country implements Comparable<Object> {
	private String name;
	private int gold, silver, bronze;

	public Country(String countryName) {
		this.name = countryName;
		this.gold = 0;
		this.silver = 0;
		this.bronze = 0;
	}

	public String getName() {
		return this.name;
	}

	public void add(Color color) {
		if (color == Color.Gold)
			this.gold++;
		if (color == Color.Silver)
			this.silver++;
		if (color == Color.Bronze)
			this.bronze++;
	}

	public String toString() {
		int total = this.gold + this.silver + this.bronze;
		return getName() + "(" + this.gold + "," + this.silver + "," + this.bronze + ")[" + total + "]";
	}

	@Override
	public int compareTo(Object obj) {
		Country c = (Country) obj;
		// ここに作業3で処理を加える
		if (this.gold > c.gold)
			return -1;
		if (this.gold < c.gold)
			return 1;
		if (this.silver > c.silver)
			return -1;
		if (this.silver < c.silver)
			return 1;
		if (this.bronze > c.bronze)
			return -1;
		if (this.bronze < c.bronze)
			return 1;
		return this.name.compareTo(c.getName());
	}
}
