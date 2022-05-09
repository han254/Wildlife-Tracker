import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.sql2o.*;

class AnimalsTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals(45,"Giraffe", "newborn", "healthy");
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void getName_animalInstantiatesWithName_String() {
        Animals testAnimal = new Animals(4,"Cheetah","young", "ill");
        assertEquals("Cheetah",testAnimal.getName());
    }
    @Test
    public void getId_animalInstantiatesWithId_int() {
        Animals testAnimal = new Animals(4,"Cheetah", "adult", "okay");
        assertEquals(4, testAnimal.getId());
    }
//    @Test
//    public void save_insertsObjectIntoDatabase_Animal() {
//        Animals testAnimal = new Animals(4,"Cheetah","adult","okay");
//        testAnimal.save();
//        assertTrue(Animals.all().get(0).equals(testAnimal));
//    }
}