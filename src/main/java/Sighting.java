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
  private String rangerId;
  private int id;


  public Sighting(String location, String rangerId) {
    this.location = location;
    this.rangerId = rangerId;
    this.date = new Timestamp(new Date().getTime());
  }

  public String getLocation() {
    return this.location;
  }

  public int getRangerId() {
    return this.rangerId;
  }

  public int getId() {
    return this.id;
  }

  public String getDate() {
    return DateFormat.getDateTimeInstance().format(this.date);
  }


}
