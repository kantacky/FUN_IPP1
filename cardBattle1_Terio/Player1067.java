import java.util.*;

public class Player1067 extends Player {
	// メンバ変数
	private Random rnd;
	private Scanner scanner;

	// コンストラクタ
	public Player1067() {
		super();
		this.rnd = new Random();
		// TODO: プレイヤー名を設定すること
		this.name = "ぺぱすのくん";
	}

	/*
	 * TODO: このメソッドを自分で作ること．
	 * 以下はサンプル
	 * 注意：
	 * 1. 札に書いてある得点がpointで与えられる
	 * 2. 初回かどうかはfirstでわかる
	 * 3. 前回全プレイヤーが出した札はlastCardsでわかる（初回以外）
	 * 4. 自分の残り手札はhandでわかる
	 * 5. 自分の得点はscoreでわかる
	 * 6. 前回重複したかどうかはduplicateでわかる
	 * 7. putCardメソッドを必ず呼んで，カードを場に出すこと
	 */
	@Override
	public void play(int point, boolean first) throws Exception {

		// 使える手札からランダムに提出

		int card = 0;
		do {
			if (point == -5) {
				card = 1;

			} else if (-5 < point && point < -2) {

				card = rnd.nextInt(2) + 2;
			} else if (-3 < point && point < 0) {

				card = rnd.nextInt(2) + 4;
			} else if (0 < point && point < 4) {

				card = rnd.nextInt(3) + 6;
			} else if (3 < point && point < 6) {

				card = rnd.nextInt(2) + 11;
			} else if (5 < point && point < 8) {

				card = rnd.nextInt(2) + 9;
			} else if (point == 8) {

				card = 15;
			} else if (point == 9) {

				card = 13;
			} else if (point == 10) {

				card = 14;
			}

		} while (!isInHand(card));

		// 選択を迫る
		/*
		 * int card = 0;
		 * do {
		 * System.out.print("カード番号を入力>");
		 * card = scanner.nextInt();
		 * } while (!isInHand(card));
		 */

		// 場に提出
		putCard(card);

		// メッセージを作る
		message = "を出してくよ～";
	}

	/*
	 * テスト用メイン
	 */
	public static void main(String[] args) throws Exception {
		// プレイヤーを作成して初期化
		Player p = new Player1067();
		// 15回手を出す
		for (int i = 0; i < 15; ++i) {
			p.play(15, true);
			System.out.println(p.getCard() + " " + p.say());
		}
	}
}
