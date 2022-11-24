import java.util.*;

public class Player1031 extends Player {
	// メンバ変数
	private Random rnd;

	// コンストラクタ
	public Player1031() {
		super();
		this.rnd = new Random();
		// TODO: プレイヤー名を設定すること
		// this.name = "1031" + rnd.nextInt(5);
		this.name = "めいめい";
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

		int card = 0;
		do {
			if (point <= 0) {
				card = (rnd.nextInt(15) + 1) - (rnd.nextInt(10) + 1);
			} else {
				card = rnd.nextInt(15) + 1;
			}
		} while (!isInHand(card));

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
		Player p = new Player1031();
		// 15回手を出す
		for (int i = 0; i < 15; ++i) {
			p.play(15, true);
			System.out.println(p.getCard() + " " + p.say());
		}
	}
}
