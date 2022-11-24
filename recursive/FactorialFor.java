public class FactorialFor {
  public static int fact(int n) {
    int ans = 1;
    // 階乗の処理を書く
    for (int i = 2; i <= n; i++)
      ans *= i;
    return ans;
  }

  public static void main(String[] args) {
    int value = 5;
    System.out.println(value + "! = " + fact(value));
  }
}
