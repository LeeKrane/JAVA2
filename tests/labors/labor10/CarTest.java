package labors.labor10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void setUp() {
        car1 = new Car("Audi", 120);
        car2 = new Car("BMW",  190, true);
    }

    @Test
    void startStop() {
        assertTrue(car2.isStarted());
        assertFalse(car1.isStarted());
        car1.start();
        car2.stop();
        assertTrue(car1.isStarted());
        assertFalse(car2.isStarted());
    }

    @Test
    void testGet() {
        assertEquals(car1.getBrand(), "Audi");
        assertEquals(car1.getWheels(), 4);
        assertEquals(car1.getPower(), 120);
        assertEquals(car2.getBrand(), "BMW");
        assertEquals(car2.getWheels(), 4);
        assertEquals(car2.getPower(), 190);
    }

    @Test
    void getIllegal() {
        assertThrows(IllegalArgumentException.class, () -> new Car("VW", -10));
        assertThrows(IllegalArgumentException.class, () -> new Car("VW", -10, true));
        assertThrows(IllegalArgumentException.class, () -> new Car("KTM", -10, false));
    }
}