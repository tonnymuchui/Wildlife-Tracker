
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_false() {
        Animal testAnimal = new Animal("Deer");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName() {
        Animal testAnimal = new Animal("lion");
        assertEquals("lion", testAnimal.getName());
    }

    @Test
    public void equals() {
        Animal firstAnimal = new Animal("lion");
        Animal anotherAnimal = new Animal("lion");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void save() {
        Animal testAnimal = new Animal("Hyena");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void all() {
        Animal firstAnimal = new Animal("lion");
        firstAnimal.save();
        Animal secondAnimal = new Animal("jackal");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find() {
        Animal firstAnimal = new Animal("lion");
        firstAnimal.save();
        Animal secondAnimal = new Animal("jackal");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void delete() {
        Animal testAnimal = new Animal("lion");
        testAnimal.save();
        testAnimal.delete();
        assertEquals(0, Animal.all().size());
    }
        @Test
    public void updateName() {
        Animal testAnimal = new Animal("lion");
        testAnimal.save();
        testAnimal.updateName("Hyena");
        assertEquals("lion", testAnimal.getName());
    }

    @Test
    public void find_returnsNullWhenNoAnimalFound_null() {
        assertTrue(Animal.find(999) == null);
    }

}