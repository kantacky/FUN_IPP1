public class Player1125 extends Player {

	// TODO 自分でつけた任意のチーム名，青空文庫のURLを設定してください．以下の例に上書きしてください．
	private static String name = "ヒナゲシ";
	private static String url = "https://www.aozora.gr.jp/cards/000148/files/761_14485.html";

	// TODO コンストラクタもクラス名に直すのをわすれずに
	public Player1125() {
		super(name, url);
	}

	// TODO ここを自分のアルゴリズムに書き換えてください
	public Tango followTango(String word) {
		// 単語を自分の辞書から取る部分のサンプル
		for (Tango t : super.dicword) {
			if (word.charAt(word.length() - 1) == t.getKana().charAt(0)) {
				if (Manager.usedTangos.contains(t.toString()) || t.getKana().charAt(t.getKana().length() - 1) == 'ん') {
					return null;
				}
				return t;
			}
		}
		// 文字が見つからないときには必ずnullを返すこと
		return null;
	}

	// TODO 文字決定後に出力されるメッセージです．自由に書いてください．文字決定の結果を反映させると良いです．
	public String say() {
		String[] messages = {
				"OvO\n",
				">A<\n",
				"T^T\n"
		};
		return messages[super.rnd.nextInt(messages.length)];
	}

	// テスト用メイン．五十音の1文字に対して続く語がきちんと選択されているかをチェック
	public static void main(String[] args) {
		Player1125 player = new Player1125();
		String test = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんがぎぐげござじずぜそだぢづでどばびぶべぼぱぴぷぺぽ";
		for (int i = 0; i < test.length(); ++i)
			System.out.println(test.charAt(i) + "　→　" +
					player.followTango(test.substring(i, i + 1)));
	}
}
