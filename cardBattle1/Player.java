import java.util.*;

public class Player implements Comparable<Player> {
	// メンバ変数
	// private boolean[] inHand;
	private ArrayList<Integer> hand;
	protected int playCard;
	protected int score;
	protected ArrayList<Integer> lastCards;
	protected String message;
	protected String name;
	protected boolean duplicate;
	private Random rnd;

	// コンストラクタ
	public Player() {
		// inHand = new boolean[15];
		// for (int i = 0; i < 15; ++i)
		// inHand[i] = true;
		rnd = new Random();

		hand = new ArrayList<Integer>();
		for (int i = 0; i < 15; ++i)
			hand.add(i + 1);

		lastCards = new ArrayList();
		message = "";
		name = "継承元" + rnd.nextInt(10);
		duplicate = false;
		score = 0;
		playCard = 0;
	}

	/*
	 * getHand()メソッド
	 * 呼び元：自分
	 * 機能：手札を取り出す
	 */
	protected ArrayList<Integer> getHand() {
		return this.hand;
	}

	/*
	 * isInHand(int card)メソッド
	 * 呼び元：自分
	 * 機能：cardの番号の手札が残っていたらtrueを返す
	 */
	// private boolean isInHand(int card) {
	// return inHand[card-1];
	// }
	protected boolean isInHand(int card) {
		for (int n : hand)
			if (n == card)
				return true;
		return false;
	}

	/*
	 * removeFromHand(int card)
	 * 呼び元：自分
	 * 機能：cardの数字のカードを手札から削除する
	 */
	private void removeFromHand(int card) {
		for (int i = 0; i < hand.size(); ++i)
			if (hand.get(i) == card) {
				hand.remove(i);
				return;
			}
	}

	/*
	 * putCard(int card)メソッド
	 * 呼び元：継承先のクラス（PlayerXXX）
	 * 機能：cardの数字を場に出す
	 * 備考：手札に残っていない数字を出そうとしたらエラーを出す
	 */
	public final void putCard(int card) throws Exception {
		// 手札(hand)に出そうとする手(card)が含まれていないときはエラー
		if (!isInHand(card))
			throw new Exception();

		// 場に出すカードをセットして
		playCard = card;

		// 手札から取り除いて終了
		removeFromHand(card);
	}

	/*----------
	 * getCardメソッド
	 * 呼び元：ディーラークラス
	 * 機能：プレイヤーが場に出している数字を返す
	 */
	public int getCard() {
		return playCard;
	}

	/*----------
	 * addSoreメソッド
	 * 呼び元：ディーラークラス
	 * 機能：点数を加える
	 */
	public void addScore(int s) {
		score += s;
	}

	public final int getScore() {
		return score;
	}

	public final String getName() {
		return name;
	}

	/*----------
	 * setLastCards
	 * 呼び元：ディーラークラス
	 * 機能：直前の回で全プレイヤーが出した手札のリストをセットする
	 */
	public final void setLastCards(ArrayList<Integer> list) {
		lastCards = (ArrayList<Integer>) list.clone();
	}

	/*---------
	 * say
	 * 呼び元：ディーラークラス
	 * 機能：手を出した時に発するメッセージを得る
	 */
	public String say() {
		return message;
	}

	/*--------
	 * setDuplicate(boolean a)
	 * 呼び元：ディーラークラス
	 * 機能：直前の回で数字がかぶっていたかどうかを知らせる
	 */
	public void setDuplicate(boolean a) {
		duplicate = a;
	}

	public boolean getDuplicate() {
		return duplicate;
	}

	/*--------
	 * compareTo
	 * 呼び元：Array
	 * 機能：ソート用
	 */
	@Override
	public int compareTo(Player other) {
		return this.score - other.score;
	}

	/*---------
	 * play
	 * 呼び元：ディーラークラス，山札として出された数字がpointに入る．
	 * 初回はfirstがtrueで，それ以降はfalseで設定される．
	 * 機能：出す数字を選んで，その数字でputCard()を呼んで，数字を場に出す．
	 * 同時にmessageも設定する．
	 * 備考：これは単なるサンプル．継承先で必ずオーバライド（上書き）すること．
	 */
	public void play(int point, boolean first) throws Exception {
		// 場札に書いてある得点がpointで与えられる．初回かどうかはfirstでわかる

		// サンプル（手札からランダムに提出）
		int card = 0;
		do {
			card = rnd.nextInt(15) + 1;
		} while (!isInHand(card));

		// 場に提出
		putCard(card);

		// メッセージを作る
		String[] tail = { "します", "せば", "すぜ！", "すのかよ", "そう", "すよ" };
		message = "を出"
				+ tail[rnd.nextInt(tail.length)];
	}

	/*----------
	 * テスト用メイン
	 */
	public static void main(String[] args) throws Exception {
		// プレイヤーを作成して初期化
		Player p = new Player();
		// 15回手を出す
		for (int i = 0; i < 15; ++i) {
			p.play(15, true);
			System.out.println(p.getCard() + " " + p.say());
		}
	}

}