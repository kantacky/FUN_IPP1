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
  public int timeTo(Point goal, ArrayList<Point> list) {
    // DONE_TODO 問題文の指示に沿って実装

    list.add(this);

    if (goal.getId() == this.getId()) {
      System.out.println(list);

      list.remove(list.size() - 1);

      return 0;
    }

    int min = Integer.MAX_VALUE;

    for (Map.Entry<Point, Integer> e : this.map.entrySet()) {
      int cost = e.getValue().intValue();

      int t = e.getKey().timeTo(goal, list);

      if (t < Integer.MAX_VALUE - cost) {
        cost += t;

        if (cost < min)
          min = cost;
      }
    }

    list.remove(list.size() - 1);

    return min;
  }

  public int lessTimeTo(Point goal, ArrayList<Point> list, int border) {
    list.add(this);

    if (goal.getId() == this.getId()) {
      System.out.println(list);

      list.remove(list.size() - 1);

      return 0;
    }

    int min = Integer.MAX_VALUE;

    for (Map.Entry<Point, Integer> e : this.map.entrySet()) {
      int cost = e.getValue().intValue();

      if (cost < border) {
        int t = e.getKey().lessTimeTo(goal, list, border - cost);
        border = cost + t;

        if (t < Integer.MAX_VALUE - cost) {
          cost += t;

          if (cost < min)
            min = cost;
        }
      }
    }

    list.remove(list.size() - 1);

    if (min > border)
      return border;
    return min;
  }

  /*
   * @return idを文字列化したもの
   */
  public String toString() {
    // DONE_TODO どんな処理が必要か各自で判断して実装

    return String.valueOf(this.getId());
  }

  public void pathTo(Point goal, ArrayList<Point> record) {
    record.add(this);

    if (goal.getId() == this.getId()) {
      System.out.println(record);
    } else {
      for (Point p : this.map.keySet())
        p.pathTo(goal, record);
    }

    record.remove(record.size() - 1);
  }
}
