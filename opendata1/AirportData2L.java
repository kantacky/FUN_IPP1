public class AirportData2L extends AirportData2 {
  private final int INDEX_NAME = 1;
  private final int INDEX_TYPE = 8;
  private final int INDEX_LAT = 19;
  private final int INDEX_LNG = 20;
  private final int INDEX_RUNWAY = 30;

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

          this.total += new_airport.getRunwaysLength();
        } catch (Exception e) {
          this.count++;
        }
      }
    }

    this.average = (double) this.total / this.data2.size();
  }

  public static void main(String[] args) {
    AirportData2L trfd = new AirportData2L();
    trfd.register();
    System.out.println(trfd.toString());
  }
}
