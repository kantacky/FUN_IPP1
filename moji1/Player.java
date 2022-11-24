import java.io.*;
import java.net.URL;
import java.util.*;

public class Player {
  protected int score;
  protected String name;
  protected String book;
  protected Random rnd;
  // DONE_TODO ここにTangoクラスのオブジェクトを格納するTreeSetを，dicwordという名前でprotectedで宣言
  protected TreeSet<Tango> dicword;

  public Player(String name, String site) {
    this.name = name;
    this.score = 0;
    this.rnd = new Random();
    this.dicword = new TreeSet<>();

    System.out.print(name + "が読書中... ");

    try {
      BufferedReader br = null;
      URL url = new URL(site);
      InputStream is = url.openStream();
      InputStreamReader isr = new InputStreamReader(is, "SJIS");
      br = new BufferedReader(isr);
      String str;

      while ((str = br.readLine()) != null) {
        // read a title
        if (str.contains("<title>")) { // <title>が含まれている行を抽出
          // DONE_TODO 先頭から任意の文字列で<title>までを削除し，</title>から任意の文字列で末尾までを削除
          book = str.replaceAll("^.*<title>", "").replaceAll("</title>.*$", "");
        }
        String[] s = str.split("</ruby>"); // </ruby>で区切ってsに格納

        for (int i = 0; i < s.length; ++i)
          if (s[i].contains("<rt>")) { // <rt>が含まれている文字列を抽出
            String s2 = s[i];
            s2 = s2.replaceAll("<rp>.</rp>", ""); // DONE_TODO <rp>任意1字</rp>で囲まれる部分を削除
            s2 = s2.replaceAll("^.*<rb>", ""); // DONE_TODO 先頭から任意文字列<rb>までの部分を削除
            s2 = s2.replaceAll("</rt>", ""); // </rt>を削除
            s2 = s2.replaceAll("<img .* />", ""); // DONE_TODO <img 任意文字列 />の部分を削除
            String[] s3 = s2.split("</rb><rt>"); // </rb><rt>で区切る，s3[0]は漢字，s3[1]はかな
            if (s3[1].length() > 1) {
              // DONE_TODO ここにdicword（辞典）にs3[0]とs3[1]を漢字かなとするTangoオブジェクトを生成して追加
              Tango new_word = new Tango(s3[0], s3[1]);
              dicword.add(new_word);
            }
          }
      }
      br.close();
      System.out.println("図書名：" + book + "を読み終えました");
    } catch (IOException e) {
      System.out.println("URL read error.");
    }
  }

  public String say() {
    return "";
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void addScore(int score) {
    this.score = this.score + score;
  }

  public Tango followTango(String word) {
    return null;
  }

  public String getBook() {
    return book;
  }

  // テスト用のメイン
  public static void main(String[] args) {
    int count = 0;
    Player rdr = new Player("テストユーザ", "https://www.aozora.gr.jp/cards/000879/files/92_14545.html"); //
    for (Tango t : rdr.dicword) {
      System.out.println(t);
      ++count;
    }
    System.out.println("トータル単語数：" + count);
  }
}
