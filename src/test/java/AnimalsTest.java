import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AnimalsTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals(45, "Giraffe");
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void getName_animalInstantiatesWithName_String() {
        Animals testAnimal = new Animals(4,"Cheetah");
        assertEquals("Cheetah", testAnimal.getName());
    }
    @Test
    public void getId_animalInstantiatesWithId_int() {
        Animals testAnimal = new Animals(4,"Cheetah");
        assertEquals(4, testAnimal.getId());
    }
}