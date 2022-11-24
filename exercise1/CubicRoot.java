public class CubicRoot {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * Integer.MAX_VALUE);
			System.out.print(n);
			System.out.print("=>");
			double cbrt = calcCBRoot(n);
			System.out.print(cbrt);
			System.out.print("=>");
			System.out.println(cbrt * cbrt * cbrt);
		}
	}

	public static double calcCBRoot(int s) {
		if (s > 0) {
			double x0 = 1.0;
			double x1 = 0.0;
			boolean converged = false;
			double epsilon = 1e-10;

			while (!converged) {
				x1 = ((2 * x0) + (s / (x0 * x0))) / 3;

				if (Math.abs(x0 - x1) < epsilon)
					converged = true;

				x0 = x1;
			}

			return x1;
		}

		return 0.0;
	}

	// private static boolean floatCheck(double x1, double x2) {
	// double epsilon = 1e-10;
	// if (Math.abs(x1 - x2) < epsilon) return true;
	// return false;
	// }
}
