public class Sum {
	static int sum = 0;

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++)
			sum += i;

		System.out.println("sum=" + sum);
	}
}
