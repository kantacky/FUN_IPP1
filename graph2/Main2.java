public class Main2 {

  public static void main(String[] args) {
    int[][] paths = {
        { 0, 1, 2 },
        { 0, 2, 2 },
        { 0, 3, 2 },
        { 1, 2, 5 },
        { 1, 4, 3 },
        { 2, 3, 4 },
        { 2, 4, 1 },
        { 2, 5, 7 },
        { 3, 7, 9 },
        { 3, 8, 8 },
        { 4, 6, 6 },
        { 5, 6, 1 },
        { 5, 7, 4 },
        { 6, 11, 8 },
        { 7, 10, 4 },
        { 7, 11, 8 },
        { 8, 7, 2 },
        { 8, 9, 5 },
        { 9, 10, 3 },
        { 9, 12, 5 },
        { 10, 12, 1 },
        { 11, 12, 4 }
    };
    Point[] points = new Point[13];

    // pathsの情報をpointsに変換
    for (int[] p : paths) {
      if (points[p[0]] == null)
        points[p[0]] = new Point(p[0]);
      if (points[p[1]] == null)
        points[p[1]] = new Point(p[1]);
      points[p[0]].addPath(points[p[1]], p[2]);
    }

    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points.length; j++) {
        int t = points[i].timeTo(points[j]);
        if (t == Integer.MAX_VALUE) {
          System.out.print(" ..");
        } else {
          System.out.print(String.format(" %02d", t));
        }
      }
      System.out.println("");
    }
  }
}