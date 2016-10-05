import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

public class SightingTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Sighting_instantiatesCorrectly_true() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    assertEquals(true, testSighting instanceof Sighting);
  }

  @Test
  public void getLocation_returnsLocation_String() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    assertEquals(Sighting.LOCATION_ZONEA, testSighting.getLocation());
  }

  @Test
  public void getAnimalId_returnsAnimalId_int() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    assertEquals(1, testSighting.getAnimalId());
  }

  @Test
  public void getDate_returnsDate_String() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    testSighting.save();
    Timestamp rightNow = new Timestamp(new Date().getTime());
    assertEquals(DateFormat.getDateTimeInstance().format(rightNow), testSighting.getDate());
  }

  @Test
  public void save_returnsTrueIfLocationsAreTheSame() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    testSighting.save();    assertTrue(Sighting.all().get(0).equals(testSighting));
  }

  @Test
  public void save_assignsIdToObject() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    testSighting.save();
    Sighting savedSighting = Sighting.all().get(0);
    assertEquals(testSighting.getId(), savedSighting.getId());
  }

  @Test
  public void find_returnsSightingWithSameId() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    testSighting.save();
    Sighting secondSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    secondSighting.save();
    assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
  }

  @Test
  public void delete_deleteSighting() {
    Sighting testSighting = new Sighting(Sighting.LOCATION_ZONEA, "Randy", 1);
    testSighting.save();
    int testSightingId = testSighting.getId();
    testSighting.delete();
    assertEquals(null, Sighting.find(testSightingId));
  }

}
