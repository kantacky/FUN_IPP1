import java.util.*;

public class Airport {
	private String name; // 空港の名前
	private String type; // 空港の種類
	private double lat; // 空港の緯度
	private double lng; // 空港の経度
	private int[] runways; // 滑走路リスト

	public Airport(String n, String t, double lat, double lng, String l) {
		name = n;
		type = t;
		this.lat = lat;
		this.lng = lng;
		runways = parseRunways(l);
	}

	private int[] parseRunways(String list) {
		// 複数の滑走路の情報を分離し，ArrayListに格納して長い順に並べ替える
		String[] s = list.split("\\|");
		ArrayList<Integer> tmp = new ArrayList<>();
		for (String r : s) {
			tmp.add(Integer.valueOf(r));
		}
		Collections.sort(tmp, Collections.reverseOrder());

		// ArrayListをint型の配列に変換
		int[] runways = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			runways[i] = tmp.get(i).intValue();
		}
		return runways;
	}

	public int[] getRunways() {
		return runways;
	}

	public String toString() {
		return name + "[" + type + "] 位置：(" + lat + "," + lng + ") 滑走路数: " + runways.length;
	}

	public double getLat() {
		return this.lat;
	}

	public double getLng() {
		return this.lng;
	}

	public int getTotalRunway() {
		return this.runways.length;
	}

	public int getMaxLength() {
		int max = 0;

		for (int l : this.runways)
			if (l > max)
				max = l;

		return max;
	}

	public int getRunwaysLength() {
		int sum = 0;

		for (int l : this.runways)
			sum += l;

		return sum;
	}

	public double getAverageLength() {
		return (double) this.getRunwaysLength() / this.getTotalRunway();
	}
}