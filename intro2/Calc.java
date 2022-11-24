public class Calc {
	public static int add(int a, int b) {
		// 結果を保存する変数
		int result = 0;
		// aとbの和を求めて、結果をresultに格納
		result = a + b;
		// 結果を返す
		return result;
	}

	/**
	 * この下に差を求めるメソッドの定義を書く
	 */
	public static int sub(int a, int b) {
		// 結果を保存する変数
		int result = 0;
		// aとbの差を求めて、結果をresultに格納
		result = a - b;
		// 結果を返す
		return result;
	}

	/**
	 * この下に積を求めるメソッドの定義を書く
	 */
	public static int multi(int a, int b) {
		// 結果を保存する変数
		int result = 0;
		// aとbの積を求めて、結果をresultに格納
		result = a * b;
		// 結果を返す
		return result;
	}

	/**
	 * この下に商を求めるメソッドの定義を書く
	 */
	public static int div(int a, int b) {
		// 結果を保存する変数
		int result = 0;
		// aとbの商を求めて、結果をresultに格納
		result = a / b;
		// 結果を返す
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 10, 35 };
		int[] b = { 3, 5, 10, 18 };
		int i;

		for (i = 0; i < 4; i++) {
			System.out.println(add(a[i], b[i]));
			System.out.println(sub(a[i], b[i]));
			System.out.println(multi(a[i], b[i]));
			System.out.println(div(a[i], b[i]));
		}
	}
}
