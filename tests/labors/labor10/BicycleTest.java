package labors.labor10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BicycleTest {
    private Bicycle bike;

    @BeforeEach
    void setUp() {
        bike = new Bicycle("KTM");
    }

    @Test
    void testBike() {
        assertEquals(bike.getWheels(), 2);
        assertEquals(bike.getBrand(), "KTM");
        assertThrows(IllegalArgumentException.class, ()-> new Bicycle("KTM", 4));
        assertThrows(IllegalArgumentException.class, ()-> new Bicycle("KTM", 1));
    }
}