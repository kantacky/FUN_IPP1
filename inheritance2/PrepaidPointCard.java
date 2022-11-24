public class PrepaidPointCard extends PrepaidCard {
  private int commonPoint;

  public PrepaidPointCard(String owner, String name, int credit) {
    super(owner, name, credit);
    commonPoint = 0;
  }

  public int getCommonPoint() {
    return this.commonPoint;
  }

  public boolean pay(int amount) {
    boolean result = super.pay(amount);

    if (result)
      this.commonPoint += amount * 0.1;

    return result;
  }

  public String toString() {
    return this.getName() + " (owner: " + this.getOwner() + ", credit: " + this.getCredit() + ", point: "
        + this.getCommonPoint() + ")";
  }
}