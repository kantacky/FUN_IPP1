public class PrepaidCard {
	private String owner;
	private int credit;

	public PrepaidCard(String owner) {
		this.owner = owner;
		this.credit = 0;
	}

	public PrepaidCard(String owner, int credit) {
		this.owner = owner;
		this.credit = credit;
	}

	public String toString() {
		return "owner: " + this.owner + " (credit: " + this.credit + ")";
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public static void main(String[] args) {
		PrepaidCard c1 = new PrepaidCard("Mirai Masaru");
		System.out.println("Card Info.:: " + c1.toString());
	}
}
