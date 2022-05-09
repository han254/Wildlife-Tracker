public class Animals {
    private int id;
    private String name;
    private String health;
    private String age;
    public Animals (int id, String name,String age, String health) {
        this.id= id;
        this.name= name;
        this.health =health;
        this.age= age;
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
}
