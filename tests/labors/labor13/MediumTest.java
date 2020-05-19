package labors.labor13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MediumTest {
    Medium feld[];

    @BeforeEach
    void setUp() {
        try {
            feld = Medium.readFile("res/labors/labor13/media.csv");
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }
    }

    @Test
    void getBezeichnung_Preis() {
        assertEquals(feld.length, 8);
        assertEquals(feld[0].getBezeichnung(),"The Lord of the Rings");
        assertEquals(feld[3].getBezeichnung(),"Back in Black");
        assertEquals(feld[5].getBezeichnung(),"Dune");
        assertEquals(feld[7].getBezeichnung(),"Abbey Road");
        assertEquals(feld[0].getPreis(), 15.69);
        assertEquals(feld[2].getPreis(), 30.38);
        assertEquals(feld[4].getPreis(), 8.3);
        assertEquals(feld[6].getPreis(), 9.2);
    }

    @Test
    void of() {
        assertEquals(feld[1], Medium.of("Thriller, 7.80, 42.33"));
        assertEquals(feld[4], Medium.of("Bat Out of Hell, 8.30, 46.53"));
        assertThrows(IllegalArgumentException.class, () -> Medium.of("Ein Test"));
        assertThrows(IllegalArgumentException.class, () -> Medium.of("Hugo, 12, 12, 3"));
        assertThrows(IllegalArgumentException.class, () -> Medium.of("Ein Test, 3.45"));
        assertThrows(IllegalArgumentException.class, () -> Medium.of("Ein Test, text, 3.45"));
        assertThrows(IllegalArgumentException.class, () -> Medium.of("Ein Test, 13, 3.45."));
    }

    @Test
    void compareTo() {
        assertEquals(feld[1].compareTo(feld[2]), -1);
        assertEquals(feld[2].compareTo(feld[3]), 1);
        assertEquals(feld[1].compareTo(feld[7]), -1);
        assertEquals(feld[7].compareTo(feld[1]), 1);
        assertEquals(feld[3].compareTo(feld[3]), 0);
    }

    @Test
    void sort() {
        Medium.sort(feld);
        assertEquals(feld.length, 8);
        assertEquals(feld[0].getBezeichnung(),"Thriller");
        assertEquals(feld[3].getBezeichnung(),"Sgt. Pepper's Lonely Hearts Club Band");
        assertEquals(feld[5].getBezeichnung(),"Back in Black");
        assertEquals(feld[7].getBezeichnung(),"Design Patterns: Elements of Reusable Object-Oriented Software");
        assertEquals(feld[0].getPreis(), 7.8);
        assertEquals(feld[2].getPreis(), 8.69);
        assertEquals(feld[4].getPreis(), 9.99);
        assertEquals(feld[6].getPreis(), 15.69);
        assertEquals(feld[1], Medium.of("Bat Out of Hell, 8.30, 46.53"));
        assertEquals(feld[5], Medium.of("Back in Black, 10.20, 42.23"));
    }
}