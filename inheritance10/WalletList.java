import java.util.*;

public class WalletList {
  private ArrayList<Wallet> list;

  public WalletList() {
    list = new ArrayList<>();
  }

  public void addWallet(Wallet w) {
    list.add(w);
  }

  public String toString() {
    String s = "";

    for (Wallet w : this.list)
      s += w.toString();

    return s;
  }

  public static void main(String[] args) {
    WalletList list = new WalletList();
    list.addWallet(new Wallet("first"));
    list.addWallet(new Wallet("second"));
    list.addWallet(new Wallet("third"));
    list.addWallet(new Wallet("fourth"));
    System.out.print(list.toString());
  }
}
