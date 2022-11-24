public class Factorial {
  public int fact(int n) {
    // 停止条件を書く
    if (n < 2)
      return 1;
    // 再帰呼び出しを書く
    return n * fact(n - 1);
  }

  public static void main(String[] args) {
    int value = 5;
    Factorial fa = new Factorial();
    System.out.println(value + "! = " + fa.fact(value));
  }
}