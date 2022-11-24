public class PrepaidCardTest {
	public static void main(String[] args) {
		PrepaidCard c1 = new PrepaidCard("Mirai Masaru");

		// 課題3-2用 追加テストコード
		System.out.println("1. カードc1に100円チャージするときちんとチャージされる？");
		c1.charge(100);
		System.out.println("Card c1:: " + c1.toString());

		System.out.println("2. カードc1に0円チャージしてもできない？");
		c1.charge(0);
		System.out.println("Card c1:: " + c1.toString());

		System.out.println("3. カードc1から500円使おうとしてもできない？");
		c1.pay(500);
		System.out.println("Card c1:: " + c1.toString());

		System.out.println("4. カードc1から-100円使おうとしてもできない？");
		c1.pay(-100);
		System.out.println("Card c1:: " + c1.toString());

		System.out.println("5. カードc1に-100円チャージしようとしてもできない？");
		c1.charge(-100);
		System.out.println("Card c1:: " + c1.toString());

		System.out.println("6. カードc2を500円チャージ状態で作成できる？");
		PrepaidCard c2 = new PrepaidCard("Taro Mirai", 500);
		System.out.println("Card c1:: " + c1.toString());
		System.out.println("Card c2:: " + c2.toString());

		System.out.println("7. カードc1からカードc2に全額移動できる？");
		c1.transfer(c2);
		System.out.println("Card c1:: " + c1.toString());
		System.out.println("Card c2:: " + c2.toString());

		// 課題3-3用 追加テストコード
		System.out.println("8. クラスメソッドを使ってカードc2からカードc1に全額移動できる？");
		PrepaidCard.transfer(c2, c1);
		System.out.println("Card c1:: " + c1.toString());
		System.out.println("Card c2:: " + c2.toString());

		System.out.println("9. 同じ所有者のカードc3を100円チャージ状態で作成し，c1に残金を移動できない？");
		PrepaidCard c3 = new PrepaidCard("Mirai Masaru", 100);
		PrepaidCard.transfer(c3, c1);
		System.out.println("Card c1:: " + c1.toString());
		System.out.println("Card c2:: " + c2.toString());
		System.out.println("Card c3:: " + c3.toString());

		System.out.println("10. c3の残額を違う所有者のカードc2に移動できる？");
		PrepaidCard.transfer(c3, c2);
		System.out.println("Card c1:: " + c1.toString());
		System.out.println("Card c2:: " + c2.toString());
		System.out.println("Card c3:: " + c3.toString());
	}
}
