import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "tonny", "postgres22");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteEndangeredAnimalsQuery = "DELETE FROM endangered_animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteEndangeredAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }


}