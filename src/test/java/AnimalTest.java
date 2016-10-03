import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal testAnimal = new Animal("fox");
    assertEquals(true, testAnimal instanceof Animal);
  }

  @Test
  public void getName_returnsName_String() {
    Animal testAnimal = new Animal("fox");
    assertEquals("fox", testAnimal.getName());
  }

  @Test
  public void equals_returnsTrueIfNameIsSame_true() {
    Animal testAnimal = new Animal("fox");
    Animal otherAnimal = new Animal("fox");
    assertTrue(testAnimal.equals(otherAnimal));
  }

  @Test
  public void getId_returnsId_true() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    assertTrue(testAnimal.getId() > 0);
  }

  


}
