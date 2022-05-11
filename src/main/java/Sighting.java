

import org.sql2o.Connection;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int id;
    private int animalId;
    private String location;
    private String rangerName;

    private Date date= new Date();
    private LocalDateTime time;


    public Sighting(int animalId, String location, String rangerName) {


        this.rangerName=rangerName;
        this.location = location;
        this.animalId=animalId;
        this.time = LocalDateTime.now();

        if (rangerName.equals("")) {
            throw new IllegalArgumentException("Please enter Ranger name.");
        }
    }
    public String getRangerName() {
        return rangerName;
    }

    public String getLocation() {
        return location;
    }

    public int getAnimalId() {
        return animalId;
    }

    public LocalDateTime getTime() {
        return time;
    }
    public int getId() {
        return id;
    }
    public static List<Sighting> all() {

        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings";
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }


    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (animalId,location,rangerName,time) VALUES (:animalId,:location,:rangerName,:time)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("time", this.time)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id=:id;";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return getId() == sighting.getId() && getAnimalId() == sighting.getAnimalId() && Objects.equals(getLocation(), sighting.getLocation()) && Objects.equals(getRangerName(), sighting.getRangerName()) && Objects.equals(date, sighting.date) && Objects.equals(getTime(), sighting.getTime());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnimalId(), getLocation(), getRangerName(), date, getTime());
    }
}