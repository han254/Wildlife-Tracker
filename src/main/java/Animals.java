import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animals implements DatabaseManagement {

    public static String kind;
    public String name;
    public int id;
    public  String health;
    public  String age;
    public String type;
    public static String species="Not endangered";


    public static final String WELLNESS="healthy";
    public static final String SICK="ill";
    public static final String FINE="okay";

  
    public static final String INFANT="newborn";
    public static final String YOUNG="young";
    public static final String ADULT="adult";



    public Animals(int id,String name,String type, String age, String health) {

        this.id = id;
        this.name = name;
        this.age =age;
        this.health = health;
        this.type= type;

        if(name.equals("")){
            throw new IllegalArgumentException("Please input name of animal");
        }
    }


    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getAge() {
        return age;
    }
    public String getHealth() {
        return health;
    }
    public String getType() {
        return type;
    }


    public static List<Animals> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }
    }

    public void save() {

        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,type) VALUES (:name,:type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Animals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animals animal = con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animals.class);
            return animal;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animals)) return false;
        Animals animal = (Animals) o;
        return getId() == animal.getId() && Objects.equals(getName(), animal.getName()) && Objects.equals(getHealth(), animal.getHealth()) && Objects.equals(getAge(), animal.getAge()) && Objects.equals(getType(), animal.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getHealth(), getAge(), getType());
    }
}
