public class Sequence3 {
  public int calcNum(int n) {
    // DONE_TODO 適切に実装せよ
    if (n < 3)
      return n;
    return calcNum(n - 1) + calcNum(n - 2) + calcNum(n - 3);
  }

  public static void main(String[] args) {
    int n = 20;
    Sequence3 seq = new Sequence3();
    for (int i = 0; i < n; i++) {
      System.out.print(seq.calcNum(i) + " ");
    }
  }
}
