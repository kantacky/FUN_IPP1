public class Fibonacci {
  public int calcFn(int n) {
    // 再帰処理を書く
    if (n < 1)
      return 0;
    if (n < 2)
      return 1;
    return calcFn(n - 1) + calcFn(n - 2);
  }

  public static void main(String[] args) {
    int n = 20;
    Fibonacci fib = new Fibonacci();
    for (int i = 0; i < n; i++) {
      System.out.print(fib.calcFn(i) + " ");
    }
  }
}
