public class FtoC {

	public static double ftoc(int deg_f) {
		// DONE_TODO Cのソースを参考に、華氏温度を摂氏温度に変換する処理を実装
		return (deg_f - 32.0) / 1.8;
	}

	public static void main(String[] args) {
		int deg_f = 100;
		// DONE_TODO ftocメソッドを呼び出して結果を表示
		// System.out.println(deg_f + " Degrees Fahrenheit is " + ftoc(deg_f) + "
		// Degrees Celsius.");
		System.out.print(deg_f);
		System.out.print(" Degrees Fahreheit is ");
		System.out.print(ftoc(deg_f));
		System.out.println(" Degrees Celsius.");
	}
}
