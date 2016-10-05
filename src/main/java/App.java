import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("rangers", Ranger.all());
      model.put("animals", Animal.allAnimals());
      model.put("endangeredAnimals", EndangeredAnimal.allEndangeredAnimals());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/ranger/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      model.put("template", "templates/new-ranger.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/ranger/new", (request, response) -> {
      Map<String, Object> model = new HashMap<>();
      String name = request.queryParams("name");
      Ranger newRanger = new Ranger(name);
      newRanger.save();
      model.put("ranger", newRanger);
      model.put("animals", Animal.allAnimals());
      model.put("EndangeredAnimal", EndangeredAnimal.all());
      model.put("zoneA", Sighting.LOCATION_ZONEA);
      model.put("ne", Sighting.LOCATION_NE);
      model.put("river", Sighting.LOCATION_RIVER);
      model.put("template", "templates/ranger.vtl");
    }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
