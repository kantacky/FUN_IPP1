public class Combination {
  public int nCr(int n, int r) {
    // nCrを求める再帰メソッドを実装
    if (r < 0 || n < r)
      return 0;
    if (r < 1 || n == r)
      return 1;
    return nCr(n - 1, r - 1) + nCr(n - 1, r);
  }

  public static void main(String[] args) {
    int n = 4;
    int r = 2;
    Combination comb = new Combination();
    System.out.println(n + "C" + r + " = " + comb.nCr(n, r));
  }
}
