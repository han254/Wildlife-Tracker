import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "pk","peter254");
//    static String connectionString = "jdbc:postgresql://ec2-3-224-164-189.compute-1.amazonaws.com:5432/darr6e90le3u8d";
//    public static Sql2o sql2o  = new Sql2o(connectionString, "sskdptbecsypux", "440a9524ec02d24968721bd6e6c9539a4ad3e1d4f59cf4e5f4e88cc32944c1c4");

}