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
    assertEquals(true, Animal.all().get(0).equals(testAnimal));
    assertEquals(true, Animal.all().get(1).equals(otherAnimal));
  }

  @Test
  public void save_insertsAnimalIntoDatabase_Animal() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    assertTrue(Animal.all().get(0).equals(testAnimal));
  }


  @Test
  public void updateName_updatesAnimalName_true() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    testAnimal.updateName("bear");
    assertEquals("bear", Animal.findAnimals(testAnimal.getId()).getName());
  }

  @Test
  public void find_FindsAnimalInstanceRelatedToId_true() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    assertEquals(testAnimal, Animal.find(testAnimal.getId()));
  }

  @Test
  public void detele_deleteFromJoinTable_true() {
    Animal testAnimal = new Animal("fox");
    testAnimal.save();
    testSighting.save();
    testAnimal.delete();
    assertEquals(0, testAnimal.getId().size());
  }
}

}
