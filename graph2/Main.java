public class Main {
  public static void main(String[] args) {
    // サンプルデータ
    int[][] paths = {
        { 0, 1, 2 }, // p0からp1に時間2
        { 0, 2, 5 }, // p0からp2に時間5
        { 1, 2, 1 }, // p1からp2に時間1
        { 1, 3, 7 }, // p1からp3に時間7
        { 2, 3, 3 } // p2からp3に時間3
    };
    // データ格納先
    Point[] points = new Point[4];

    // pathsの情報をpointsに変換
    for (int[] p : paths) {
      if (points[p[0]] == null)
        points[p[0]] = new Point(p[0]);
      if (points[p[1]] == null)
        points[p[1]] = new Point(p[1]);
      points[p[0]].addPath(points[p[1]], p[2]);
    }

    // 結果出力
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points.length; j++) {
        int t = points[i].timeTo(points[j]);
        if (t == Integer.MAX_VALUE) {
          System.out.print(" .");
        } else {
          System.out.print(" ");
          System.out.print(t);
        }
      }
      System.out.println("");
    }
  }
}
