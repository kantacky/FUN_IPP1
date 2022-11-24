import java.util.*;

public class Dealer {
	// メンバ変数
	private ArrayList<Player> players;
	private ArrayList<Integer> deck;
	private ArrayList<Integer> cards;
	private int turn;
	private Random rnd;

	// コンストラクタ（初期化）
	public Dealer(ArrayList<Player> allPlayers) {
		// プレイヤーを受け取る
		players = allPlayers;
		turn = 0;
		rnd = new Random();
		// 直前に出されたプレイヤーのカードリストは0で初期化
		cards = new ArrayList<Integer>();
		for (int i = 0; i < players.size(); ++i)
			cards.add(0);
		// 山札(deck)に-5から10までの数字の札を詰めて100回シャッフル
		deck = new ArrayList<Integer>();
		for (int i = -5; i < 11; ++i)
			if (i != 0)
				deck.add(i);
		for (int i = 0; i < 100; ++i) {
			int j = rnd.nextInt(deck.size());
			int k = rnd.nextInt(deck.size());
			int a = deck.get(j);
			deck.set(j, deck.get(k));
			deck.set(k, a);
		}
	}

	public void game() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=====================");
		System.out.println("== cardBattle1   ====");
		System.out.println("== ハゲタカのえじき対戦 ==");
		System.out.println("=====================");

		// System.out.println("（こっそり教えます．山札は"+deck+")");

		// ゲーム開始
		while (!deck.isEmpty()) {
			++turn;
			System.out.println("\n------ 第" + turn + "回戦 ------");

			// 山札をめくる
			int layout = deck.remove(0);
			System.out.print("場札は　「" + layout + "」");
			if (layout < 0)
				System.out.print("\t**危険！マイナス札登場**");
			System.out.println("\n");

			// プレイヤーに手を出してもらう
			for (int i = 0; i < players.size(); ++i) {
				Player p = players.get(i);
				try {
					p.play(layout, (turn == 1));
					System.out.println("プレイヤー:" + p.getName() + " (" + p.getScore() + "点)");
					System.out.println(" 「" + p.getCard() + " " + p.say() + "」");
				} catch (Exception e) {
					// エラーを出したプレイヤーはその時点で切り捨て
					System.out.println("プレイヤー" + p.getName() + "はエラーで退場");
					players.remove(p);
					System.out.println(e);
				}
			}

			// プレイヤーのカード間の重複チェック
			for (Player p : players) {
				p.setDuplicate(false);
				for (Player q : players) {
					if (p.equals(q))
						continue;
					if (p.getCard() == q.getCard()) {
						// 重複発見
						p.setDuplicate(true);
						System.out.println("プレイヤー" + p.getName() + " 重複で失格");
					}
				}
			}

			// 失格者以外から勝者（場札のスコアを得る者）を決める
			System.out.println("\n（チェック中）");
			Player winPlay = null;
			int sign = 1;
			int minmax = 0;
			if (layout < 0) {
				sign = -1;
				minmax = 16;
			}
			for (Player p : players) {
				if (p.getDuplicate())
					continue;
				if (minmax * sign < p.getCard() * sign) {
					winPlay = p;
					minmax = p.getCard();
				}
			}
			if (winPlay == null)
				System.out.println("今回は獲得者なし！");
			else {
				// 勝者に場札のスコアを与える
				winPlay.addScore(layout);
				System.out.println("プレイヤー " + winPlay.getName() + "が，場札の"
						+ layout + "ポイントを獲得して， "
						+ winPlay.getScore() + "点になりました！");
			}

			// この回に全プレイヤーが出したカードの一覧を得て，各プレイヤーに通知
			cards.clear();
			for (Player p : players)
				cards.add(p.getCard());
			for (Player p : players)
				p.setLastCards(cards);

			// ユーザ入力待ち
			System.out.print(">");
			// scanner.next();
		}
		// 山札がなくなってゲーム終了
		System.out.println("\n======== ゲーム終了 =========");
		// プレイヤーが残っているか確認
		if (players.isEmpty()) {
			System.out.println("全員退場で勝者なし...");
			return;
		}
		// 点数順に並べ替え
		Collections.sort(players, Collections.reverseOrder());
		for (Player p : players)
			System.out.println(p.getName() + " (" + p.getScore() + "　点)");
		System.out.print("\n勝者は");
		System.out.println(players.get(0).getName() + "さんです．");
		System.out.println("おめでとう！");
	}

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();

		// 各学生のプレイヤーのインスタンスを生成してリストに詰める
		// players.add(new PlayerHuman());
		players.add(new Player());
		players.add(new Player1120());

		// ディーラーを初期化して起動
		Dealer d = new Dealer(players);
		d.game();

	}

}
