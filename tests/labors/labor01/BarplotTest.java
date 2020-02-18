package labors.labor01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BarplotTest {

    @Test
    public void repeat_validArgs_repeatedChar() {
        assertEquals("****", Barplot.repeat('*', 4));
    }

    @Test
    public void repeat_n0_emptyString() {
        assertEquals("", Barplot.repeat('a', 0));
    }

    @Test
    public void drawLabel_tooShort_labelPadded() {
        assertEquals("abc   ", Barplot.drawLabel("abc", 6));
    }

    @Test
    public void drawLabel_tooLong_labelShortened() {
        assertEquals("abcdef", Barplot.drawLabel("abcdefghijk", 6));
    }

    @Test
    public void drawBar_labelTooShortValueValid_bar() {
        String result = Barplot.drawBar("2XHIF", 15);
        assertEquals("2XHIF   |###############               |", result);
    }

    @Test
    public void drawBar_labelTooLongValueValid_bar() {
        String result = Barplot.drawBar("Informatik", 3);
        assertEquals("Informat|###                           |", result);
    }

    @Test
    public void drawBar_intInvalid_null() {
        assertNull(Barplot.drawBar("Informatik", 33));
    }

    @Test
    public void drawBar_doubleValueValid_bar() {
        String result = Barplot.drawBar("Informatik", 0.8);
        assertEquals("Informat|########################      |", result);
    }

    @Test
    public void drawBar_doubleRoundedUp_bar() {
        String result = Barplot.drawBar("Informatik", 0.15);
        assertEquals("Informat|#####                         |", result);
    }

    @Test
    public void drawBar_doubleInvalid_null() {
        assertNull(Barplot.drawBar("Informatik", 1.01));
    }

}
