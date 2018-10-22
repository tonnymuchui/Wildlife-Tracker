
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class EndangeredAnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", "Healthy", "Adult");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void getHealth_returnsHealthAttribute_true() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", "Healthy", "Young");
        assertEquals("Healthy", testEndangeredAnimal.getHealth());
    }

    @Test
    public void save_toDatabase() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Hyena", "Healthy", "Adult");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }

    @Test
    public void all() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Hyena", "Healthy", "Young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("lion", "ill", "Adult");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    @Test
    public void find() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("hypo", "Healthy", "Young");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("leopard", "ill", "Adult");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

    @Test
    public void update() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("lion", "Healthy", "Adult");
        testEndangeredAnimal.save();
        testEndangeredAnimal.updateHealth("ill");
        assertEquals("ill", EndangeredAnimal.find(testEndangeredAnimal.getId()).getHealth());
    }

    @Test
    public void update_updatesAge() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("lion", "Healthy", "Young");
        testEndangeredAnimal.save();
        testEndangeredAnimal.updateAge("Adult");
        assertEquals("Adult", EndangeredAnimal.find(testEndangeredAnimal.getId()).getAge());
    }

}
