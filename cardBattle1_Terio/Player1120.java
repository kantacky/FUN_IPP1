import java.util.*;

public class Player1120 extends Player {
	// メンバ変数
	private Random rnd;

	// コンストラクタ
	public Player1120() {
		super();
		this.rnd = new Random();
		// DONE_TODO: プレイヤー名を設定すること
		this.name = "かんたっきー";
	}

	/*
	 * DONE_TODO: このメソッドを自分で作ること．
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
		int card = 0;
		ArrayList<Integer> hand = this.getHand();

		Collections.sort(hand);
		Collections.reverse(hand);

		if (point > 8) {
			for (int i = 0; i < hand.size(); i++) {
				card = hand.get(rnd.nextInt(hand.size())).intValue();
				if (!lastCards.contains(card))
					break;
			}
		} else if (point > 0) {
			for (int i = 0; i < hand.size(); i++) {
				if (Math.abs(point - 8) + i > hand.size() - 1) {
					card = hand.get(hand.size() - 1);
					break;
				}
				card = hand.get(Math.abs(point - 8) + i).intValue();
				if (!lastCards.contains(card))
					break;
			}
		} else {
			for (int i = 0; i < hand.size(); i++) {
				if (point + 5 + i > hand.size() - 1) {
					card = hand.get(hand.size() - 1);
					break;
				}
				card = hand.get(point + 5 + i).intValue();
				if (!lastCards.contains(card))
					break;
			}
		}

		// 場に提出
		putCard(card);

		// メッセージを作る
		message = "を出します";
	}

	/*
	 * テスト用メイン
	 */
	public static void main(String[] args) throws Exception {
		// プレイヤーを作成して初期化
		Player p = new Player1120();
		// 15回手を出す
		for (int i = 0; i < 15; ++i) {
			p.play(15, true);
			System.out.println(p.getCard() + " " + p.say());
		}
	}
}
