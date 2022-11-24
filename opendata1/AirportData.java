
// import opendata0.ReadFromURL;
import java.util.*;

public class AirportData {
  private static final String URL = "http://linkdata.org/download/rdf1s2795i/link/airport_japan.txt";
  private static final String CODE = "UTF-8";
  private final int INDEX_NICKNAME = 2;
  protected ArrayList<String> data;
  protected int count;

  public AirportData() {
    ReadFromURL read_from_url = new ReadFromURL(URL, CODE);
    if (read_from_url.readData())
      this.data = read_from_url.getData();

    this.count = 0;
  }

  public int getCount() {
    return this.count;
  }

  public void preview() {
    for (String l : this.data) {
      if (l.charAt(0) != '#') {
        String[] cells = l.split("\t");
        try {
          System.out.println(cells[INDEX_NICKNAME].trim());
        } catch (Exception e) {
          this.count++;
        }
      }
    }
  }

  public static void main(String[] args) {
    AirportData trfd = new AirportData();
    trfd.preview();
    System.out.println("Exceptions: " + trfd.getCount());
  }
}
