import java.util.*;

public class AirportData2 extends AirportData {
	private final int INDEX_NAME = 1;
	private final int INDEX_TYPE = 8;
	private final int INDEX_LAT = 19;
	private final int INDEX_LNG = 20;
	private final int INDEX_RUNWAY = 30;
	protected ArrayList<Airport> data2;
	protected int total;
	protected double average;

	public AirportData2() {
		super();
		data2 = new ArrayList<>();
		this.total = 0;
		this.average = 0;
	}

	public void register() {
		for (String l : super.data) {
			if (l.charAt(0) != '#') {
				try {
					String[] cells = l.split("\t");
					String name = cells[INDEX_NAME];
					String type = cells[INDEX_TYPE];
					double lat = Double.parseDouble(cells[INDEX_LAT]);
					double lng = Double.parseDouble(cells[INDEX_LNG]);
					String runway = cells[INDEX_RUNWAY];

					Airport new_airport = new Airport(name, type, lat, lng, runway);

					this.data2.add(new_airport);

					this.total += new_airport.getRunways().length;
				} catch (Exception e) {
					this.count++;
				}
			}
		}

		this.average = (double) this.total / this.data2.size();
	}

	public String toString() {
		String s = "";

		for (Airport d : this.data2)
			s += d.toString() + '\n';

		s += "Airport total: " + this.data2.size() + "\n";
		s += "Runway total: " + this.total + "\n";
		s += "average: " + this.average;

		return s;
	}

	public static void main(String[] args) {
		AirportData2 trfd = new AirportData2();
		trfd.register();
		System.out.println(trfd.toString());
	}
}
