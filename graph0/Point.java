import java.util.*;

public class Point {
  // DONE_TODO インスタンス変数(フィールド)は必要に応じて宣言
  private int id;
  private HashMap<Point, Integer> map;

  /**
   * コンストラクタ
   * 
   * @param id 地点id
   */
  public Point(int id) {
    // DONE_TODO どんな処理が必要か各自で判断して実装
    this.id = id;
    this.map = new HashMap<>();
  }

  /**
   * 地点idのゲッターメソッド
   * 
   * @return 地点id
   */
  public int getId() {
    // DONE_TODO どんな処理が必要か各自で判断して実装

    return this.id;
  }

  /**
   * 地点pへの経路を追加
   * 
   * @param p 行き先
   * @param t 移動時間
   */
  public void addPath(Point p, int t) {
    // DONE_TODO どんな処理が必要か各自で判断して実装

    this.map.put(p, Integer.valueOf(t));
  }

  /**
   * 地点goalへの移動時間を返す
   * 
   * @param goal 行き先
   * @return 移動時間
   */
  public int timeTo(Point goal) {
    // DONE_TODO 問題文の指示に沿って実装

    if (goal.getId() == this.getId())
      return 0;

    for (Point p : this.map.keySet())
      if (p.getId() == goal.getId())
        return this.map.get(p).intValue();

    return Integer.MAX_VALUE;
  }

  /*
   * @return idを文字列化したもの
   */
  public String toString() {
    // DONE_TODO どんな処理が必要か各自で判断して実装

    return String.valueOf(this.getId());
  }
}
