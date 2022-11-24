public class PrepaidPointCardABC extends PrepaidPointCard {
  private int abcPoint;

  public PrepaidPointCardABC(String owner, String name, int credit) {
    super(owner, name, credit);
    abcPoint = 0;
  }

  public int getAbcPoint() {
    return this.abcPoint;
  }

  public boolean pay(int amount) {
    boolean result = super.pay(amount);

    if (result)
      this.abcPoint++;

    return result;
  }

  public String toString() {
    return this.getName() + " (owner: " + this.getOwner() + ", credit: " + super.getCredit() + ", point: "
        + this.getCommonPoint() + ", ABC point: " + this.getAbcPoint() + ")";
  }
}
