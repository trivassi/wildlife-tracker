import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimal extends Animal {
  private String health;
  private String age;


  public EndangeredAnimal(String name, String health, String age) {
    super(name);
    this.health = health;
    this.age = age;
  }

  public String getHealth() {
    return this.health;
  }

  public String getAge() {
    return this.age;
  }

  @Override
  public boolean equals(Object otherEndangeredAnimal) {
    if (!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
      return true;
    } else {
      EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
      return this.getName().equals(newEndangeredAnimal.getName()) &&
      this.getHealth().equals(newEndangeredAnimal.getHealth()) &&
      this.getAge().equals(newEndangeredAnimal.getAge()) &&
      this.getId() == newEndangeredAnimal.getId();
    }
  }

  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, health, age) VALUES (:name, :health, :age)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .executeUpdate()
        .getKey();
    }
  }

  public void updateHealth(String health) {
    this.health = health;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET health = :health WHERE id = :id";
      con.createQuery(sql)
        .addParameter("health", health)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void updateAge(String age) {
    this.age = age;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET age = :age WHERE id = :id";
      con.createQuery(sql)
        .addParameter("age", age)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  // public static List<EndangeredAnimal> all() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM animals";
  //     return con.createQuery(sql)
  //       .executeAndFetch(EndangeredAnimal.class);
  //   }
  // }


}
