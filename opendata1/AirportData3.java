import java.util.*;

public class AirportData3 extends AirportData2 {
  public AirportData3() {
    super();
    super.register();
  }

  public String toString() {
    String s = "";

    for (Airport d : super.data2)
      s += d.toString() + ", max. " + d.getMaxLength() + "m\n";

    return s;
  }

  public void sortByRunways() {
    Collections.sort(
        super.data2,
        new Comparator<Airport>() {
          @Override
          public int compare(Airport a1, Airport a2) {
            if (a1.getTotalRunway() < a2.getTotalRunway())
              return 1;
            if (a1.getTotalRunway() > a2.getTotalRunway())
              return -1;

            if (a1.getMaxLength() < a2.getMaxLength())
              return 1;
            if (a1.getMaxLength() > a2.getMaxLength())
              return -1;

            if (a1.getLat() < a2.getLat())
              return 1;
            if (a1.getLat() > a2.getLat())
              return -1;

            return 0;
          }
        });
  }

  public void sortByAverageLength() {
    Collections.sort(
        super.data2,
        new Comparator<Airport>() {
          @Override
          public int compare(Airport a1, Airport a2) {
            if (a1.getAverageLength() < a2.getAverageLength())
              return 1;
            if (a1.getAverageLength() > a2.getAverageLength())
              return -1;

            if (a1.getMaxLength() < a2.getMaxLength())
              return 1;
            if (a1.getMaxLength() > a2.getMaxLength())
              return -1;

            if (a1.getLng() > a2.getLng())
              return 1;
            if (a1.getLng() < a2.getLng())
              return -1;

            return 0;
          }
        });
  }

  public static void main(String[] args) {
    AirportData3 apd3 = new AirportData3();
    System.out.println(apd3.toString());
    apd3.sortByRunways();
    System.out.println(apd3.toString());
    apd3.sortByAverageLength();
    System.out.println(apd3.toString());
  }
}
