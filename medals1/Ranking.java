public class Ranking {
	final int NUM_OF_COUNTRIES = 1000;
	int next;
	Country countries[];

	public Ranking() {
		this.next = 0;
		this.countries = new Country[NUM_OF_COUNTRIES];
	}

	// 指定された国が配列の何番に登録されているか探し、その添え字を返す
	public int indexOfCountry(String name) {
		for (int i = this.next - 1; i >= 0; i--) {
			// i番目の国名がcountryNameと同じ文字列ならば i を返す
			if (this.countries[i].getName().equals(name))
				return i;
		}
		return -1; // 見つからなければ -1 を返す
	}

	// IOCコードで指定された国に指定された色のメダルを1つ追加
	public void addMedal(Color color, String name) {
		// countryNameが配列の何番目に格納されているか探す
		int index = indexOfCountry(name);
		if (index < 0) { // 見つからなかった場合は新たに格納し、nextを増やす
			this.countries[this.next] = new Country(name);
			index = this.next;
			this.next++;
		}
		// 色に対応するメダルの数を増やす
		this.countries[index].add(color);
	}

	public void sortResults() {
		// DONE_TODO 並べ替えを実装したらどうなる?!
	}

	public void printResults() {
		// 集計結果を表示
		for (int i = 0; i < this.countries.length && this.countries[i] != null; i++) {
			System.out.println(this.countries[i].toString());
		}

	}
}