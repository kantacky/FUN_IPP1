public class Ranking {
	final int NUM_OF_COUNTRIES = 1000;
	String[] countryName;
	int[] gold, silver, bronze;
	int next;

	public Ranking() {
		countryName = new String[NUM_OF_COUNTRIES];
		gold = new int[countryName.length];
		silver = new int[countryName.length];
		bronze = new int[countryName.length];
		next = 0;
	}

	// 指定された国が配列の何番に登録されているか探し、その添え字を返す
	public int indexOfCountry(String name) {
		for (int i = next - 1; i >= 0; i--) {
			// i番目の国名がcountryNameと同じ文字列ならば i を返す
			if (countryName[i].equals(name))
				return i;
		}
		return -1; // 見つからなければ -1 を返す
	}

	// IOCコードで指定された国に指定された色のメダルを1つ追加
	public void addMedal(Color color, String name) {
		// countryNameが配列の何番目に格納されているか探す
		int index = indexOfCountry(name);
		if (index < 0) { // 見つからなかった場合は新たに格納し、nextを増やす
			countryName[next] = name;
			index = next;
			next++;
		}
		// 色に対応するメダルの数を増やす
		if (color == Color.Gold) {
			gold[index]++;
		} else if (color == Color.Silver) {
			silver[index]++;
		} else if (color == Color.Bronze) {
			bronze[index]++;
		}
	}

	public void sortResults() {
		// DONE_TODO 並べ替えを実装したらどうなる?!

		for (int i = 1; i < countryName.length && countryName[i] != null; i++) {
			int j = i - 1;
			// i番目のデータを待避しておく
			String c = countryName[i];
			int g = gold[i];
			int s = silver[i];
			int b = bronze[i];
			// i番目の国名がj番目の国名よりも前である間くり返す
			while (j >= 0 && c.compareTo(countryName[j]) < 0) {
				// j番目のデータをj+1番目にコピー
				countryName[j + 1] = countryName[j];
				gold[j + 1] = gold[j];
				silver[j + 1] = silver[j];
				bronze[j + 1] = bronze[j];
				j--;
			}
			j++;
			// 待避しておいたi番目のデータをj番目にコピー
			countryName[j] = c;
			gold[j] = g;
			silver[j] = s;
			bronze[j] = b;
		}
	}

	public void printResults() {
		// 集計結果を表示
		for (int i = 0; i < countryName.length && countryName[i] != null; i++) {
			System.out.print(countryName[i]);
			int sum = gold[i];
			System.out.print("(" + gold[i]);
			sum += silver[i];
			System.out.print("," + silver[i]);
			sum += bronze[i];
			System.out.print("," + bronze[i]);
			System.out.println(")[" + sum + "]");
		}

	}
}