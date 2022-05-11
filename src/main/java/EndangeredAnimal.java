import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animals implements DatabaseManagement {
    private static int id;

//    public static String kind= "EndangeredAnimal";


    public EndangeredAnimal( String name, String health, String age, String type) {
        super(id, name, type, age, health);
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = type;
    }
            public void save(){
            try (Connection con = DB.sql2o.open()) {
                String sql = "INSERT INTO animals (name,health,age,type) VALUES (:name,:health,:age,:type)";
                this.id = (int) con.createQuery(sql, true)
                        .addParameter("name", this.name)
                        .addParameter("health", this.health)
                        .addParameter("age", this.age)
                        .addParameter("type", this.type)
                        .executeUpdate()
                        .getKey();
            }
        }
        public List<EndangeredAnimal> getAll(){
        try (Connection con=DB.sql2o.open()){
            String sql="SELECT * FROM animals";
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);
        }
        }
    }
