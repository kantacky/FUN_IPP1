import java.util.*;

public class PlayerHuman extends Player {
	// メンバ変数
	private Random rnd;
	private Scanner scanner;

	// コンストラクタ
	public PlayerHuman() {
		super();
		this.rnd = new Random();
		// TODO: プレイヤー名を設定すること
		this.name = "人間";
		scanner = new Scanner(System.in);
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

		// まず手札を表示
		System.out.println("手札：" + hand.toString());

		// 選択を迫る
		int card = 0;
		do {
			System.out.print("カード番号を入力>");
			card = scanner.nextInt();
		} while (!isInHand(card));

		// 場に提出
		putCard(card);

		// メッセージを作る
		message = "を，俺は出す！";
	}

	/*
	 * テスト用メイン
	 */
	public static void main(String[] args) throws Exception {
		// プレイヤーを作成して初期化
		Player p = new PlayerHuman();
		// 15回手を出す
		for (int i = 0; i < 15; ++i) {
			p.play(15, true);
			System.out.println(p.getCard() + " " + p.say());
		}
	}
}
