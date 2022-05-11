import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class EndangeredAnimalTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void getName_personInstantiatesWithName_String() {
        EndangeredAnimal testEndangered = new EndangeredAnimal( "Hyena", "okay", "adult", "endangered");
        assertEquals("Hyena", testEndangered.getName());
    }

    @Test
    public void all_returnsAllInstancesOfEndangeredAnimals_true() {
        EndangeredAnimal firstEndangered = new EndangeredAnimal( "Jaquar", "healthy", "adult", "endangered");
        firstEndangered.save();
        EndangeredAnimal secondEndangered = new EndangeredAnimal( "Cheetah", "ill", "young","endangered");
        secondEndangered.save();
        assertTrue(true, String.valueOf(EndangeredAnimal.all().get(0).equals(firstEndangered)));
        assertTrue(true, String.valueOf(EndangeredAnimal.all().get(1).equals(secondEndangered)));
    }
}