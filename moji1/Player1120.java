import java.util.*;

public class Player1120 extends Player {
  // DONE_TODO 自分でつけた任意のチーム名，青空文庫のURLを設定してください．以下の例に上書きしてください．
  private static String name = "紅葉";
  private static String url = "https://www.aozora.gr.jp/cards/000091/files/522_19603.html";

  private ArrayList<String> used;
  private boolean isFirst = true;
  private int max_len = 0;

  // DONE_TODO コンストラクタもクラス名に直すのをわすれずに
  public Player1120() {
    super(name, url);
    this.used = new ArrayList<>();
  }

  // DONE_TODO ここを自分のアルゴリズムに書き換えてください
  public Tango followTango(String word) {
    Tango set_word = null;

    this.used.add(word);

    if (isFirst) {
      for (Tango t : super.dicword)
        if (this.max_len < t.getKana().length())
          this.max_len = t.getKana().length();

      isFirst = false;
    }

    // Match (i + 1) chars
    for (int i = 0; i < max_len; i++) {
      for (Tango t : super.dicword) {
        if (i < word.length() && i < t.getKana().length()) {
          boolean is_matched = true;

          for (int j = 0; j <= i; j++)
            if (word.charAt(word.length() - 1 - i + j) != t.getKana().charAt(j)) {
              is_matched = false;
              break;
            } else if (j >= t.getKana().length()) {
              is_matched = false;
              break;
            }

          if (is_matched && !this.used.contains(t.getKana()) && t.getKana().charAt(t.getKana().length() - 1) != 'ん')
            set_word = t;
        }
      }
    }

    if (set_word != null)
      this.used.add(set_word.getKana());

    return set_word;
  }

  // DONE_TODO 文字決定後に出力されるメッセージです．自由に書いてください．文字決定の結果を反映させると良いです．
  public String say() {
    String[] messages = { "LET'S GOOOOOOO!!\n", "HOOOOOOOOO!!\n", "YEAAAAAAAH!!\n" };
    return messages[super.rnd.nextInt(messages.length)];
  }

  // テスト用メイン．五十音の1文字に対して続く語がきちんと選択されているかをチェック
  public static void main(String[] args) {
    Player1120 player = new Player1120();
    String test = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよわをんがぎぐげござじずぜそだぢづでどばびぶべぼぱぴぷぺぽ";
    for (int i = 0; i < test.length(); ++i)
      System.out.println(test.charAt(i) + "　→　" + player.followTango(test.substring(i, i + 1)));
  }
}
