public class Main {
	// 動作確認用のmainメソッド
	public static void main(String[] args) {
		// Rankingインスタンスを作成
		Ranking2 rank = new Ranking2();
		// サンプルデータを登録
		rank.addMedal(Color.Bronze, "SUI");
		rank.addMedal(Color.Gold, "CHN");
		rank.addMedal(Color.Bronze, "CHN");
		rank.addMedal(Color.Gold, "JPN");
		rank.addMedal(Color.Gold, "USA");
		rank.addMedal(Color.Silver, "USA");
		rank.addMedal(Color.Bronze, "JPN");
		rank.addMedal(Color.Bronze, "ITA");
		rank.addMedal(Color.Silver, "NED");
		rank.addMedal(Color.Bronze, "ESP");
		rank.addMedal(Color.Silver, "NZL");
		rank.addMedal(Color.Silver, "AUS");
		rank.addMedal(Color.Silver, "SWE");
		rank.addMedal(Color.Silver, "ESP");
		rank.addMedal(Color.Silver, "USA");
		rank.addMedal(Color.Silver, "JPN");
		rank.addMedal(Color.Bronze, "GER");
		rank.addMedal(Color.Gold, "CHN");
		rank.addMedal(Color.Gold, "GBR");
		rank.addMedal(Color.Silver, "GBR");
		rank.addMedal(Color.Bronze, "ROC");
		rank.addMedal(Color.Silver, "CHN");
		rank.addMedal(Color.Bronze, "CAN");
		rank.addMedal(Color.Silver, "ROC");
		rank.addMedal(Color.Bronze, "KOR");
		rank.addMedal(Color.Bronze, "CUB");
		rank.addMedal(Color.Bronze, "BRA");
		rank.addMedal(Color.Silver, "ROC");
		rank.addMedal(Color.Silver, "CHN");
		rank.addMedal(Color.Gold, "GBR");
		rank.addMedal(Color.Gold, "CHN");
		rank.addMedal(Color.Bronze, "AUT");
		rank.addMedal(Color.Bronze, "UKR");
		rank.addMedal(Color.Bronze, "HUN");
		rank.addMedal(Color.Bronze, "USA");
		rank.addMedal(Color.Bronze, "ROC");
		rank.addMedal(Color.Bronze, "USA");
		rank.addMedal(Color.Gold, "HUN");
		rank.addMedal(Color.Gold, "CUB");
		rank.addMedal(Color.Gold, "NED");
		rank.addMedal(Color.Silver, "FRA");
		rank.addMedal(Color.Bronze, "CHN");
		rank.addMedal(Color.Bronze, "NZL");
		rank.addMedal(Color.Gold, "USA");
		rank.addMedal(Color.Silver, "ROC");
		rank.addMedal(Color.Gold, "FRA");
		rank.addMedal(Color.Silver, "POL");
		rank.addMedal(Color.Gold, "BRA");
		rank.addMedal(Color.Gold, "GER");
		rank.addMedal(Color.Gold, "KOR");
		rank.addMedal(Color.Bronze, "SRB");
		rank.addMedal(Color.Silver, "GER");
		rank.addMedal(Color.Silver, "CAN");
		rank.addMedal(Color.Bronze, "TUR");
		rank.addMedal(Color.Silver, "USA");
		rank.addMedal(Color.Gold, "JPN");
		rank.addMedal(Color.Gold, "ROC");
		rank.addMedal(Color.Silver, "GBR");
		rank.addMedal(Color.Gold, "AUS");
		rank.addMedal(Color.Silver, "HUN");
		rank.addMedal(Color.Bronze, "GER");
		rank.addMedal(Color.Bronze, "JPN");
		rank.addMedal(Color.Gold, "CHN");
		rank.addMedal(Color.Bronze, "USA");
		rank.addMedal(Color.Bronze, "GBR");
		rank.addMedal(Color.Silver, "GEO");
		rank.addMedal(Color.Bronze, "TPE");
		rank.addMedal(Color.Gold, "NZL");
		rank.addMedal(Color.Bronze, "POL");
		rank.addMedal(Color.Gold, "CAN");
		rank.addMedal(Color.Silver, "ITA");
		rank.addMedal(Color.Silver, "USA");
		rank.addMedal(Color.Bronze, "ITA");
		rank.addMedal(Color.Gold, "ROC");
		rank.addMedal(Color.Gold, "USA");
		rank.addMedal(Color.Bronze, "GBR");
		rank.addMedal(Color.Gold, "ITA");
		rank.addMedal(Color.Bronze, "FRA");
		rank.addMedal(Color.Gold, "USA");
		rank.addMedal(Color.Silver, "BRA");
		rank.addMedal(Color.Bronze, "NED");
		rank.addMedal(Color.Silver, "CHN");
		rank.addMedal(Color.Bronze, "AUS");
		rank.addMedal(Color.Gold, "JPN");
		rank.addMedal(Color.Silver, "UKR");
		rank.addMedal(Color.Bronze, "AUS");
		rank.addMedal(Color.Gold, "AUS");
		rank.addMedal(Color.Bronze, "KAZ");

		// ランキングで並び替えて
		rank.sortResults();

		// 結果出力
		rank.printResults();
	}

}