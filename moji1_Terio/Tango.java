public class Tango implements Comparable<Tango> {
  private String kanji;
  private String kana;

  public Tango(String kanji, String kana) {
    this.kanji = kanji;

    // convert small hiragana to big ones
    String sml = "ぁぃぅぇぉっゃゅょ";
    String big = "あいうえおつやゆよ";
    for (int j = 0; j < sml.length(); ++j)
      this.kana = kana.replace(sml.charAt(j), big.charAt(j));

    // String katakana =
    // "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨワヲンガギグゲゴザジズゼソダヂヅデドバビブベボパピプペポ";
    // String hiragana =
    // "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよわをんがぎぐげござじずぜそだぢづでどばびぶべぼぱぴぷぺぽ";
    // for (int j = 0; j < sml.length(); ++j)
    // this.kana = kana.replace(katakana.charAt(j), hiragana.charAt(j));
  }

  public String getKanji() {
    return kanji;
  }

  public String getKana() {
    return kana;
  }

  @Override
  public int compareTo(Tango o) {
    // TODO Auto-generated method stub
    return this.kana.compareTo(o.getKana());
  }

  public String toString() {
    return "「" + kana + "（" + kanji + "）」";
  }
}
