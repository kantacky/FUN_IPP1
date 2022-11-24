public class Circle {
	private String name = "no_name"; // 円の名称
	private int x = 0; // 円の中心位置 x
	private int y = 0; // 円の中心位置 y
	private double r = 1.0; // 円の半径

	/*
	 * コンストラクタ
	 */
	public Circle() {
	}

	/*
	 * インスタンスメソッド（ゲッターとセッター） DONE_TODO: クイズ3-2で指定されたメソッドを実装する
	 */

	public String getName() {
		return this.name;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public double getR() {
		return this.r;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setR(double r) {
		this.r = r;
	}

	public String toString() {
		return "Circle <" + name + ">: Position (" + x + "," + y + ") Radius " + r;
	}

	public static void main(String[] args) {
		// コンストラクタとインスタンスメソッド（ゲッターとセッター）の動作確認
		Circle c1 = new Circle();
		System.out.println(c1.toString());

		/*
		 * これ以降は必要に応じてコメントを外して利用する
		 */
		// クイズ3-2 チェック用
		c1.setName("c1");
		c1.setXY(1, 1);
		c1.setR(1.5);
		System.out.println(c1.toString());
	}

}
