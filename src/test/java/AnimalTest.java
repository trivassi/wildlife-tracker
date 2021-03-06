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

  @Test
  public void all_returnsAllInstancesOfAnimal_true() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    Animal otherAnimal = new Animal("fox");
    otherAnimal.save();
    assertEquals(true, Animal.allAnimals().get(0).equals(testAnimal));
    assertEquals(true, Animal.allAnimals().get(1).equals(otherAnimal));
  }

  @Test
  public void save_insertsAnimalIntoDatabase_Animal() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    assertTrue(Animal.allAnimals().get(0).equals(testAnimal));
  }


  @Test
  public void updateName_updatesAnimalName() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    testAnimal.updateName("bear");
    assertEquals("bear", Animal.find(testAnimal.getId()).getName());
  }

  @Test
  public void find_FindsAnimalInstanceRelatedToId_Id() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    assertEquals(testAnimal, Animal.find(testAnimal.getId()));
  }

  @Test
  public void delete_deletesAnimal_null() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    int testAnimalId = testAnimal.getId();
    testAnimal.delete();
    assertEquals(null, Animal.find(testAnimalId));
  }

}
