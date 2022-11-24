import java.util.Arrays;

public class PrepaidCard1 implements Comparable {
  private String name;
  private int credit;

  public PrepaidCard1(String name, int credit) {
    this.name = name;
    this.credit = credit;
  }

  public String getName() {
    return this.name;
  }

  public int getCredit() {
    return this.credit;
  }

  public int pay(int amount) {
    if (amount >= 0 && amount <= this.getCredit()) {
      this.credit -= amount;
      return this.getCredit();
    } else
      return this.getCredit();
  }

  public String toString() {
    return "(" + name + "," + credit + ")";
  }

  @Override
  public int compareTo(Object obj) {
    PrepaidCard1 c = (PrepaidCard1) obj;
    if (this.getCredit() < c.getCredit())
      return -1;
    if (this.getCredit() > c.getCredit())
      return 1;
    return 0;
  }

  public static void main(String[] args) {
    PrepaidCard1[] cards = {
        new PrepaidCard1("A", 10000),
        new PrepaidCard1("B", 20000),
        new PrepaidCard1("C", 30000),
    };
    Arrays.sort(cards);
    System.out.println(cards[0].toString() + cards[1].toString() + cards[2].toString());
    System.out.println(cards[2].pay(cards[0].getCredit()));
    System.out.println(cards[2].pay(cards[1].getCredit()));
    Arrays.sort(cards);
    System.out.println(cards[0].toString() + cards[1].toString() + cards[2].toString());
    System.out.println(cards[1].pay(cards[2].getCredit()));
    System.out.println(cards[2].pay(cards[1].getCredit()));
    System.out.println(cards[2].pay(cards[1].getCredit()));
    Arrays.sort(cards);
    System.out.println(cards[0].toString() + cards[1].toString() + cards[2].toString());
    System.out.println(cards[2].pay(cards[2].getCredit()));
    Arrays.sort(cards);
    System.out.println(cards[0].toString() + cards[1].toString() + cards[2].toString());
  }
}
