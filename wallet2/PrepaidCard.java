import java.util.Arrays;

public class PrepaidCard implements Comparable<Object> {
	private String owner;
	private String name;
	private int credit;

	public PrepaidCard(String owner) {
		this.owner = owner;
		this.name = "";
		this.credit = 0;
	}

	public PrepaidCard(String owner, int credit) {
		this.owner = owner;
		this.name = "";
		this.credit = credit;
	}

	public PrepaidCard(String owner, String name, int credit) {
		this.owner = owner;
		this.name = name;
		this.credit = credit;
	}

	public String toString() {
		return this.name + " (owner: " + this.owner + ", credit: " + this.credit + ")";
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return this.name;
	}

	public int getCredit() {
		return this.credit;
	}

	public int charge(int amount) {
		if (amount < 0)
			return this.getCredit();

		this.credit += amount;
		return this.getCredit();
	}

	public boolean pay(int amount) {
		if (amount < 0)
			return false;

		if (amount <= this.credit) {
			this.credit -= amount;
			return true;
		}

		return false;
	}

	public void transfer(PrepaidCard c2) {
		if (!(c2.getOwner().equals(this.getOwner()))) {
			int current_credit = this.getCredit();

			c2.charge(current_credit);
			this.pay(current_credit);
		}
	}

	public static void transfer(PrepaidCard c1, PrepaidCard c2) {
		if (!(c1.getOwner().equals(c2.getOwner()))) {
			int c1_current_credit = c1.getCredit();

			c2.charge(c1_current_credit);
			c1.pay(c1_current_credit);
		}
	}

	public static boolean transfer(PrepaidCard c1, PrepaidCard c2, int amount) {
		if (c1.getOwner().equals(c2.getOwner()))
			return false;
		if (amount < 0 || amount > c1.getCredit())
			return false;

		c2.charge(amount);
		c1.pay(amount);

		return true;
	}

	@Override
	public int compareTo(Object o) {
		PrepaidCard c = (PrepaidCard) o;
		return Integer.valueOf(this.credit).compareTo(Integer.valueOf(c.credit));
	}

	public static void main(String[] args) {
		PrepaidCard[] cards = new PrepaidCard[5];
		cards[0] = new PrepaidCard("Taro Mirai", "nimoca", 100);
		cards[1] = new PrepaidCard("Taro Mirai", "Suica", 200);
		cards[2] = new PrepaidCard("Taro Mirai", "PiTaPa", 300);
		cards[3] = new PrepaidCard("Taro Mirai", "SAPICA", 400);
		cards[4] = new PrepaidCard("Hana Mirai", "nimoca", 250);

		Arrays.sort(cards);
		for (int i = 0; i < 5; i++) {
			System.out.println("Card Info.:: " + cards[i].toString());
		}
	}
}
