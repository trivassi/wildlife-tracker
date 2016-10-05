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

  @Override
  public boolean equals(Object otherSighting) {
    if (!(otherSighting instanceof Sighting)) {
      return true;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation()) &&
      this.getDate().equals(newSighting.getDate()) &&
      this.getAnimalId() == newSighting.getAnimalId() &&
      this.getId() == newSighting.getId();
    }
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

  public static List<Sighting> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings";
      return con.createQuery(sql)
        .executeAndFetch(Sighting.class);
    }
  }

  public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE id = :id";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
    }
  }

}
