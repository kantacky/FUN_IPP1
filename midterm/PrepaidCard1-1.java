public class PrepaidCard1 {
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

  public static void main(String[] args) {
    PrepaidCard1 cardA = new PrepaidCard1("A", 10000);
    PrepaidCard1 cardB = new PrepaidCard1("B", 20000);
    PrepaidCard1 cardC = new PrepaidCard1("C", 30000);
    System.out.println(cardA.toString() + cardB.toString() + cardC.toString());
    System.out.println(cardC.pay(cardA.getCredit()));
    System.out.println(cardC.pay(cardB.getCredit()));
    System.out.println(cardA.toString() + cardB.toString() + cardC.toString());
    System.out.println(cardA.pay(cardB.getCredit()));
    System.out.println(cardB.pay(cardA.getCredit()));
    System.out.println(cardB.pay(cardA.getCredit()));
    System.out.println(cardB.pay(cardA.getCredit()));
    System.out.println(cardA.toString() + cardB.toString() + cardC.toString());
    System.out.println(cardA.pay(cardA.getCredit()));
    System.out.println(cardA.toString() + cardB.toString() + cardC.toString());
  }
}
