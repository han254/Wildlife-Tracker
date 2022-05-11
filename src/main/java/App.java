import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get( "/animals/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "animal-form.hbs");
        }, new HandlebarsTemplateEngine());

        get( "/endangered/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals",(request, response) ->{
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals =Animals.all();
            model.put("animals", animals);
            return new ModelAndView(model,"animals.hbs" );
            }, new HandlebarsTemplateEngine());

        post("/animals",(request, response) -> {
            Map<String,Object> model=new HashMap<String, Object>();
            String type=request.queryParams("type");
            String health=request.queryParams("health");
            String age=request.queryParams("age");
            String name=request.queryParams("name");
            EndangeredAnimal endangeredAnimal= new EndangeredAnimal(type,health,age,name);
            endangeredAnimal.save();
//            if(type.equals(EndangeredAnimal.kind)){
//                EndangeredAnimal endangered=new EndangeredAnimal(name,health,age,EndangeredAnimal.kind);
//                endangered.save();
//            }
//            else  {
//                int id = 0;
//                Animals animal=new Animals(id,name,health,age,Animals.kind);
//                animal.save();
//            }

            return new ModelAndView(model,"animal-success.hbs");
        },new HandlebarsTemplateEngine());
    }
}