import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.sql2o.*;

class AnimalsTest {
    @Test
    public void animal_instantiatesCorrectly_true() {
        Animals testAnimal = new Animals(45,"Giraffe","Non-Endangered","young", "okay");
        assertEquals(true, testAnimal instanceof Animals);
    }
    @Test
    public void getName_animalInstantiatesWithName_String() {
        Animals testAnimal = new Animals(4,"Cheetah","Non-Endangered","newborn", "ill");
        assertEquals("Cheetah",testAnimal.getName());
    }
    @Test
    public void getId_animalInstantiatesWithId_int() {
        Animals testAnimal = new Animals(4,"Cheetah", "Non-Endangered","adult","okay");
        assertEquals(4, testAnimal.getId());
    }
    @Test
    public void getType_animalInstantiatesWithId_String() {
        Animals testAnimal = new Animals(4,"Cheetah", "Non-Endangered","young", "healthy");
        assertEquals("adult", testAnimal.getAge());
    }
}