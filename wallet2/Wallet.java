import java.util.*;

public class Wallet {
  private ArrayList<PrepaidCard> cards;
  private String owner;

  public Wallet(String owner) {
    // 作業1: ここで変数cardsを初期化する
    this.cards = new ArrayList<>();
    this.owner = owner;
  }

  public void sort() {
    Collections.sort(this.cards);
  }

  public void add(PrepaidCard c) {
    if (c.getOwner().equals(this.owner)) {
      this.cards.add(c);
    }
  }

  public boolean remove(String name) {
    for (PrepaidCard c : this.cards) {
      if (c.getName().equals(name)) {
        this.cards.remove(c);

        this.sort();
        this.cards.get(this.cards.size() - 1).charge(c.getCredit());

        return true;
      }
    }

    return false;
  }

  public String toString() {
    String s = "Wallet owner:: " + this.owner + "\n";

    for (PrepaidCard c : this.cards)
      s += "Card: " + c + "\n";

    return s;
  }

  public static void main(String[] args) {
    Wallet w = new Wallet("Taro Mirai");
    w.add(new PrepaidCard("Taro Mirai", "nimoca", 100));
    w.add(new PrepaidCard("Taro Mirai", "Suica", 200));
    w.add(new PrepaidCard("Taro Mirai", "PiTaPa", 300));
    w.add(new PrepaidCard("Taro Mirai", "SAPICA", 400));
    w.add(new PrepaidCard("Hana Mirai", "nimoca", 200));
    w.add(new PrepaidCard("Taro Mirai", "Sugoca", 10));
    w.add(new PrepaidCard("Taro Mirai", "Kitaca", 20));

    w.sort();

    System.out.println("--- before ---");
    System.out.print(w);

    w.remove("nimoca");
    w.remove("Sugoca");

    System.out.println("--- after ---");
    System.out.print(w);
  }
}
