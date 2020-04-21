package labors.labor10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {
    private Motorcycle moto1;
    private Motorcycle moto2;

    @BeforeEach
    void setUp() {
        moto1 = new Motorcycle("Honda", 80);
        moto2 = new Motorcycle("BMW", 3, 90, true);
    }

    @Test
    void startStop() {
        assertTrue(moto2.isStarted());
        assertFalse(moto1.isStarted());
        moto1.start();
        moto2.stop();
        assertTrue(moto1.isStarted());
        assertFalse(moto2.isStarted());
    }

    @Test
    void testGet() {
        assertEquals(moto1.getBrand(), "Honda");
        assertEquals(moto1.getWheels(), 2);
        assertEquals(moto1.getPower(), 80);
        assertEquals(moto2.getBrand(), "BMW");
        assertEquals(moto2.getWheels(), 3);
        assertEquals(moto2.getPower(), 90);
    }

    @Test
    void getIllegal() {
        assertThrows(IllegalArgumentException.class, () -> new Motorcycle("KTM", -10));
        assertThrows(IllegalArgumentException.class, () -> new Motorcycle("KTM", 4, -10, true));
        assertThrows(IllegalArgumentException.class, () -> new Motorcycle("KTM", 1, 10, false));
    }
}