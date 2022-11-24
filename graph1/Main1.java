import java.util.ArrayList;

public class Main1 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[][] paths = {
        { 0, 1, 2 }, // p0からp1に時間2
        { 0, 2, 5 }, // p0からp2に時間5
        { 1, 2, 1 }, // p1からp2に時間1
        { 1, 3, 7 }, // p1からp3に時間7
        { 2, 3, 3 } // p2からp3に時間3
    };
    Point[] points = new Point[4];

    // pathsの情報をpointsに変換
    for (int[] p : paths) {
      if (points[p[0]] == null)
        points[p[0]] = new Point(p[0]);
      if (points[p[1]] == null)
        points[p[1]] = new Point(p[1]);
      points[p[0]].addPath(points[p[1]], p[2]);
    }

    points[0].pathTo(points[3], new ArrayList<>());
  }

}