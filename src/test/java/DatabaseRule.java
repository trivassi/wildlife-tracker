import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deletePersonsQuery = "DELETE FROM ____ *;";
      String deleteMonstersQuery = "DELETE FROM _____ *;";
      con.createQuery(deletePersonsQuery).executeUpdate();
      con.createQuery(deleteMonstersQuery).executeUpdate();
    }
  }

}
