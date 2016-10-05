import org.sql2o.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Sighting{
  private String location;
  private Timestamp date;
  private int animalId;
  private int id;

  public static final String LOCATION_ZONEA = "Zone A";
  public static final String LOCATION_RIVER = "Near The River";
  public static final String LOCATION_NE = "NE Quadrant";

  public Sighting(String location, String animalId) {
    this.location = location;
    this.animalId = animalId;
    this.date = new Timestamp(new Date().getTime());
  }

  public String getLocation() {
    return this.location;
  }

  public int getAnimalId() {
    return this.animalId;
  }

  public int getId() {
    return this.id;
  }

  public String getDate() {
    return DateFormat.getDateTimeInstance().format(this.date);
  }

  public void save() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO sightings (location, date, animalId) VALUES (:location, :date, :animalId)";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("location", this.location)
      .addParameter("date", this.date)
      .addParameter("animalId", this.animalId)
      .executeUpdate()
      .getKey();
  }
}

}
