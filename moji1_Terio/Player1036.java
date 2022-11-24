public class Player1036 extends Player {

  // TODO 自分でつけた任意のチーム名，青空文庫のURLを設定してください．以下の例に上書きしてください．
  private static String name = "チームレモネード";
  private static String url = "https://www.aozora.gr.jp/cards/000074/files/46349_23843.html";

  // TODO コンストラクタもクラス名に直すのをわすれずに
  public Player1036() {
    super(name, url);
  }

  // TODO ここを自分のアルゴリズムに書き換えてください
  public Tango followTango(String word) {
    // 単語を自分の辞書から取る部分のサンプル
    for (Tango t : super.dicword) {
      if ((word.charAt(word.length() - 2) == t.getKana().charAt(0))
          && (word.charAt(word.length() - 1) == t.getKana().charAt(1))) {
        // if(word.charAt(word.length()-1)==t.getKana().charAt(0))
        return t;
      } else if (word.charAt(word.length() - 1) == t.getKana().charAt(0))
        return t;
    }

    // 文字が見つからないときには必ずnullを返すこと
    return null;

  }

  // TODO 文字決定後に出力されるメッセージです．自由に書いてください．文字決定の結果を反映させると良いです．
  public String say() {
    String[] messages = {
        "勉強が足りないようですネ\n",
        "修行が足りないのでは？\n",
        "まだまだ負けませんよ\n"
    };
    return messages[super.rnd.nextInt(messages.length)];
  }

  // テスト用メイン．五十音の1文字に対して続く語がきちんと選択されているかをチェック
  public static void main(String[] args) {
    Player1036 player = new Player1036();
    String test = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよわをんがぎぐげござじずぜそだぢづでどばびぶべぼぱぴぷぺぽ";
    for (int i = 0; i < test.length(); ++i)
      System.out.println(test.charAt(i) + "　→　" +
          player.followTango(test.substring(i, i + 1)));
  }
}