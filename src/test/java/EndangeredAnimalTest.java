import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// String HEALTH_HEALTHY = "healthy";
// String HEALTH_OKAY = "okay";
// String HEALTH_ILL = "ill";
// String AGE_NEWBORN = "newborn";
// String AGE_YOUNG = "young";
// String AGE_ADULT = "adult";

public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void getName_returnsName_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    assertEquals("fox", testEndangeredAnimal.getName());
  }

  @Test
  public void getHealth_returnsHealth_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    assertEquals("healthy", testEndangeredAnimal.getHealth());
  }

  @Test
  public void getAge_returnsAge_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    assertEquals("young", testEndangeredAnimal.getAge());
  }

  @Test
  public void getId_returnsId_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    assertTrue(testEndangeredAnimal.getId() > 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAreTheSame() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    assertTrue(testEndangeredAnimal.equals(secondEndangeredAnimal));
  }


  @Test
  public void save_returnsTrueIfNamesAreTheSame() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    assertTrue(EndangeredAnimal.allEndangeredAnimals().get(0).equals(testEndangeredAnimal));
  }

  @Test
  public void save_assignsIdToObject() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.allEndangeredAnimals().get(0);
    assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
  }

  @Test
  public void all_returnsAllInstancesOfEndangeredAnimal_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    secondEndangeredAnimal.save();
    assertTrue(EndangeredAnimal.allEndangeredAnimals().get(0).equals(testEndangeredAnimal));
    assertTrue(EndangeredAnimal.allEndangeredAnimals().get(1).equals(secondEndangeredAnimal));
  }

  @Test
  public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    secondEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
  }

  @Test
  public void updateName_updatesEndangeredAnimalName() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    testEndangeredAnimal.updateName("lion");
    assertEquals("lion", EndangeredAnimal.find(testEndangeredAnimal.getId()).getName());
  }

  @Test
  public void updateHealth_updatesEndangeredAnimalHealth() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    testEndangeredAnimal.updateHealth("okay");
    assertEquals("okay", EndangeredAnimal.find(testEndangeredAnimal.getId()).getHealth());
  }

  @Test
  public void updateAge_updatesEndangeredAnimalAge() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();    testEndangeredAnimal.updateAge("adult");
    assertEquals("adult", EndangeredAnimal.find(testEndangeredAnimal.getId()).getAge());
  }

  @Test
  public void delete_deletesEndangeredAnimal_null() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("fox", "healthy", "young");
    testEndangeredAnimal.save();
    int testEndangeredAnimalId = testEndangeredAnimal.getId();
    testEndangeredAnimal.delete();
    assertEquals(null, EndangeredAnimal.find(testEndangeredAnimalId));
  }

}
