import java.util.ArrayList;
import java.util.Collections;

public class Ranking2 {
  /* TODO Countryを格納するArrayListの宣言 */
  ArrayList<Country> countries;

  public Ranking2() {
    countries = new ArrayList<>();
  }

  /**
   * 指定された国がArrayListに登録されているか探し、見つけたらその要素を返す
   * 
   * @param name 国(3文字のIOCコード)
   * @return Countryインスタンス、なければnull
   */
  public Country findCountry(String name) {
    for (Country c : countries) {
      if (
      /* TODO cの名前がnameと一致するかどうか */
      c.getName().equals(name))
        return c;
    }
    return null; // 見つからなければ null を返す
  }

  /**
   * IOCコードで指定された国に指定された色のメダルを1つ追加
   * 
   * @param name  国(3文字のIOCコード)
   * @param color メダルの色
   */
  public void addMedal(Color color, String name) {
    Country c = findCountry(name);
    if (c == null) { // 見つからなかった場合...
      /* TODO Countryインスタンスを新たに作成し、countriesに追加 */
      c = new Country(name);
      countries.add(c);
    }
    // 色に対応するメダルの数を増やす
    c.add(color);
  }

  public void sortResults() {
    Collections.sort(countries);
  }

  public void printResults() {
    // 集計結果を表示
    for (
    /* TODO 出力結果が同じになるように拡張for文を記述 */
    Country c : countries) {
      System.out.println(c);
    }

  }
}