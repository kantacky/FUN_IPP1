import java.util.Arrays;

public class Wallet {
  private PrepaidCard[] cards;
  private int next;
  private String owner;

  public Wallet(String owner, int max_cards) {
    this.cards = new PrepaidCard[max_cards];
    this.next = 0;
    this.owner = owner;
  }

  public void sort() {
    Arrays.sort(this.cards, 0, this.next);
  }

  public void add(PrepaidCard c) {
    this.cards[this.next++] = c;
  }

  public static void main(String[] args) {
    Wallet w = new Wallet("Taro Mirai", 10);
    w.add(new PrepaidCard("Hana Mirai", "nimoca", 250));
    w.add(new PrepaidCard("Taro Mirai", "Suica", 200));
    w.add(new PrepaidCard("Taro Mirai", "PiTaPa", 300));
    w.add(new PrepaidCard("Taro Mirai", "nimoca", 100));
    w.add(new PrepaidCard("Taro Mirai", "SAPICA", 400));

    w.sort();

    for (int i = 0; i < w.cards.length; i++) {
      if (w.cards[i] != null) {
        System.out.println(w.cards[i]);
      }
    }
  }
}
