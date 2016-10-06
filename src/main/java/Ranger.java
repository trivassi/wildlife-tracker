import org.sql2o.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Ranger {
  private String name;
  private int id;

  public Ranger(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public boolean equals(Object otherRanger) {
    if (!(otherRanger instanceof Ranger)) {
      return false;
    } else {
      Ranger newRanger = (Ranger) otherRanger;
      return this.getName().equals(newRanger.getName()) &&
      this.getId() == newRanger.getId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO rangers (name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Ranger> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM rangers";
      return con.createQuery(sql).executeAndFetch(Ranger.class);
    }
  }

  public void updateName(String name) {
    this.name = name;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE rangers SET name = :name";
      con.createQuery(sql)
        .addParameter("name", name)
        .executeUpdate();
    }
  }

  public static Ranger find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM rangers WHERE id = :id";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Ranger.class);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM rangers WHERE id = :id";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public List<Sighting> getSightings() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE rangerid = :id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Sighting.class);
    }
  }

}
