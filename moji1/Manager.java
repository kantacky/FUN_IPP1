import java.util.*;

public class Manager {
  // プレイヤーのリスト
  public static ArrayList<Player> players;
  // いままで使われた単語のリスト
  public static ArrayList<String> usedTangos;

  public Manager() {
    usedTangos = new ArrayList<>();
    players = new ArrayList<>();
    // TODO 各学生のプレイヤーのインスタンスを生成．ここではダミー1つだけ
    // テストするときには自分のクラス名にすること
    players.add(new Player1120());
  }

  public static void main(String[] args) {
    System.out.println("========　多重しりとり対戦 moji1");
    System.out.println();
    Manager game = new Manager();
    System.out.println();
    System.out.println("========　対戦スタート");
    // shiri-tori starting word
    Random rnd = new Random(); // for test = 206
    String ja = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわ";
    String word = ja.charAt(rnd.nextInt(44)) + "" + ja.charAt(rnd.nextInt(44)) + "" + ja.charAt(rnd.nextInt(44));
    System.out.println("最初のことばは「" + word + "」");

    // game loop
    for (int i = 1; i < 10; ++i) {
      // pickup next player
      Player player = players.get(i % players.size());
      System.out.println();
      System.out.print(i + "回目-------");
      System.out.println(player.getName() + "(" + player.getScore() + "点)の攻撃");

      // user finds next tango
      Tango nextTango = player.followTango(word);

      // check
      int score = game.checkScore(word, nextTango);
      if (score > 0) {
        // replace target word
        word = nextTango.getKana();

        // convert small hiragana to big ones
        String sml = "ぁぃぅぇぉっゃゅょ";
        String big = "あいうえおつやゆよ";
        for (int j = 0; j < sml.length(); ++j)
          word = word.replace(sml.charAt(j), big.charAt(j));

        // delete non-hiragana characters
        word = word.replaceAll("[^あ-ん]", "");

        // put the used Tango into usedTangos
        usedTangos.add(nextTango.toString());

        // give score
        player.addScore(score);
      }

      // say something
      System.out.println(player.say());
    }
  }

  public int checkScore(String t, Tango u) {
    // null check
    if (u == null) {
      System.out.println("Ｘ「" + t + "」　→　パス...");
      return 0;
    }
    // terminal condition check
    if (u.getKana().endsWith("ん")) {
      System.out.println("Ｘ " + u + "が「ん」でおわった");
      return 0;
    }
    // only one word
    if (u.getKana().length() == 1) {
      System.out.println("Ｘ " + u + "は1文字");
      return 0;
    }
    // duplication check
    if (usedTangos.contains(u.toString())) {
      System.out.println("Ｘ" + u + "は，すでに使われています");
      return 0;
    }

    // ok, get score
    for (int i = Math.min(t.length(), u.getKana().length()); 0 < i; --i) {
      if (t.endsWith(u.getKana().substring(0, i))) {
        System.out.println("○「" + t + "」　→　" + u + " " + i + "個のつながり");
        // give bonus if more than 1 char found
        int score = i;
        if (1 < i) {
          score = score * 2;
          System.out.print("ボーナス点！，");
        }
        System.out.print(score + "点ゲット，");
        return score;
      }
    }
    // in case where no match is found
    System.out.println("Ｘ " + u + "は，しりとっていない！");
    return 0;
  }
}
