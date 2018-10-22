import org.junit.*;
import org.sql2o.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DateFormat;
import java.util.Date;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting() {
        Animal testAnimal = new Animal("Deer");
        testAnimal.save();
        Sighting testSighting = new Sighting(testAnimal.getId(), "34334", "kim");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void equals() {
        Animal testAnimal = new Animal("Deer");
        testAnimal.save();
        Sighting testSighting = new Sighting(testAnimal.getId(), "456", "kim");
        Sighting anotherSighting = new Sighting(testAnimal.getId(), "456", "kim");
        assertTrue(testSighting.equals(anotherSighting));
    }

    @Test
    public void save() {
        Animal testAnimal = new Animal("lion");
        testAnimal.save();
        Sighting testSighting = new Sighting (testAnimal.getId(), "456", "kim");
        testSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(testSighting));
    }

    @Test
    public void all() {
        Animal testAnimal = new Animal("lion");
        testAnimal.save();
        Sighting testSighting = new Sighting (testAnimal.getId(), "456", "kim");
        testSighting.save();
        Animal secondTestAnimal = new Animal("Badger");
        secondTestAnimal.save();
        Sighting secondTestSighting = new Sighting (testAnimal.getId(), "456", "kim");
        secondTestSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(testSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondTestSighting));
    }

    @Test
    public void find() {
        Animal testAnimal = new Animal("lion");
        testAnimal.save();
        Sighting testSighting = new Sighting (testAnimal.getId(), "456", "kim");
        testSighting.save();
        Animal secondTestAnimal = new Animal("lion");
        secondTestAnimal.save();
        Sighting secondTestSighting = new Sighting (testAnimal.getId(), "456", "kim");
        secondTestSighting.save();
        assertEquals(Sighting.find(secondTestSighting.getId()), secondTestSighting);
    }

    @Test
    public void find_returnsNullWhenNoAnimalFound_null() {
        assertTrue(Animal.find(999) == null);
    }

}