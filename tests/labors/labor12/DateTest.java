package labors.labor12;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    private static final String[] MONTHS = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
            "August", "September", "Oktober", "November", "Dezember"};
    private static final String[] TAGE = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};

    private static Stream<Arguments> dayProvider() {
        return IntStream.range(5, 32).mapToObj(Arguments::of);
    }

    @Test
    public void constructorNoArgs_systemDateobjectCreated() {
        LocalDate today = LocalDate.now();
        Date expected = new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear());

        Date shouldBeSystemDate = new Date();

        assertEquals(expected, shouldBeSystemDate);
    }

    @ParameterizedTest(name = "date = {0}")
    @ValueSource(strings = {"", "text", "01012000", "01.13.2000", "32.01.2000", "31.12.1899", "29.02.2001"})
    public void constructorString_invalid_exception(String date) {
        assertThrows(IllegalArgumentException.class, () -> new Date(date));
    }

    @Test
    public void constructorDays_daysNegative_exception() {
        assertThrows(IllegalArgumentException.class, () -> new Date(-1));
    }

    @Test
    public void constructorDays_0_objectCreated() {
        Date d = new Date(0);

        assertEquals(new Date(1, 1, 1900), d);
    }

    @Test
    public void constructorDays_31_objectCreated() {
        Date d = new Date(31);

        assertEquals(new Date(1, 2, 1900), d);
    }

    @Test
    public void constructorDays_365_objectCreated() {
        Date d = new Date(365);

        assertEquals(new Date(1, 1, 1901), d);
    }

    @Test
    public void constructorDays_40000_objectCreated() {
        Date d = new Date(40_000);

        assertEquals(new Date(8, 7, 2009), d);
    }

    @ParameterizedTest(name = "{0}.12.2016")
    @MethodSource("dayProvider")
    public void wochentag_correctDayOfWeek(int day) {
        Date d = new Date(day, 12, 2016);

        assertEquals(TAGE[(day - 5) % TAGE.length], d.weekday());
    }

    @ParameterizedTest
    @MethodSource("dayProvider")
    public void wochentagNummer_correctDayOfWeek(int day) {
        Date d = new Date(day, 12, 1988);

        assertEquals((day - 5) % TAGE.length, d.weekdayNumber());
    }

    @Test
    public void addiereTage_0_noChange() {
        Date d = new Date(1, 1, 2000);
        Date expected = new Date(1, 1, 2000);

        d.addDays(0);

        assertEquals(expected, d);
    }

    @Test
    public void addiereTage_daysNegativeResultBefore1900_exception() {
        Date d = new Date(1, 1, 1900);

        assertThrows(IllegalArgumentException.class, () -> d.addDays(-1));
    }

    @Test
    public void addiereTage_daysNegativeResultBefore1900complex_exception() {
        Date d = new Date(20, 2, 1982);

        assertThrows(IllegalArgumentException.class, () -> d.addDays(-30_001));
    }

    @Test
    public void addiereTage_daysNegativeResultExactly1900_daysSubtractedFromDate() {
        Date d = new Date(20, 2, 1982);
        Date expected = new Date(1, 1, 1900);

        d.addDays(-30_000);

        assertEquals(expected, d);
    }

    @Test
    public void addiereTage_daysBig_daysAddedToDate() {
        Date d = new Date(1, 1, 1900);
        Date expected = new Date(1, 1, 2300);

        d.addDays(146_097);

        assertEquals(expected, d);
    }

    @Test
    public void addiereTage_anyBeginDate_daysAddedToDate() {
        Date d = new Date(18, 8, 1983);
        Date expected = new Date(7, 9, 2016);

        d.addDays(12_074);

        assertEquals(expected, d);
    }

    @Test
    public void tageZwischen_firstEqualSecond_result0() {
        Date from = new Date(1, 1, 2003);
        Date to = new Date(1, 1, 2003);

        assertEquals(0, Date.daysBetween(from, to));
    }

    @Test
    public void tageZwischen_oneYearBetween_365() {
        Date from = new Date(1, 1, 2003);
        Date to = new Date(1, 1, 2004);

        assertEquals(365, Date.daysBetween(from, to));
    }

    @Test
    public void tageZwischen_oneYearBetweenLaterFirst_negative365() {
        Date from = new Date(1, 1, 2004);
        Date to = new Date(1, 1, 2003);

        assertEquals(-365, Date.daysBetween(from, to));
    }

    @Test
    public void tageZwischen_leapYear_daysBetween() {
        Date from = new Date(31, 12, 2003);
        Date to = new Date(1, 3, 2004);

        assertEquals(61, Date.daysBetween(from, to));
    }

    @Test
    public void tageZwischen_largeTimespanLaterLast_daysBetween() {
        Date from = new Date(1, 1, 1900);
        Date to = new Date(1, 1, 2300);

        assertEquals(146_097, Date.daysBetween(from, to));
    }

    @Test
    public void tageZwischen_largeTimespanLaterFirst_negativeDaysBetween() {
        Date from = new Date(1, 1, 2300);
        Date to = new Date(1, 1, 1900);

        assertEquals(-146_097, Date.daysBetween(from, to));
    }

    @Test
    public void toString_formatShort_correctResult() {
        Date d = new Date(14, 4, 2008);

        assertEquals("14.04.08", d.toString(Date.FORMAT_SHORT));
    }

    @Test
    public void toString_formatNormal_correctResult() {
        Date d = new Date(14, 4, 2008);

        assertEquals("14.04.2008", d.toString(Date.FORMAT_NORMAL));
    }

    @Test
    public void toString_formatLong_correctResult() {
        Date d = new Date(14, 4, 2008);

        assertEquals("14.April 2008, Montag", d.toString(Date.FORMAT_LONG));
    }

    @Test
    public void toString_formatUS_correctResult() {
        Date d = new Date(14, 4, 2008);

        assertEquals("2008/14/04", d.toString(Date.FORMAT_US));
    }

    @Test
    public void toString_formatIllegal_exception() {
        Date d = new Date(14, 4, 2008);

        assertThrows(IllegalArgumentException.class, () -> d.toString(42));
    }

    @Test
    public void toString_noArgs_correctResult() {
        Date d = new Date(14, 4, 2008);

        assertEquals("14.04.2008", d.toString());
    }

    @Test
    public void compareTo_firstBeforeSecond_negativeResult() {
        Date from = new Date(12, 2, 2007);
        Date to = new Date(13, 2, 2007);

        assertTrue(from.compareTo(to) < 0);
    }

    @Test
    public void compareTo_firstAfterSecond_positiveResult() {
        Date from = new Date(13, 2, 2007);
        Date to = new Date(12, 2, 2007);

        assertTrue(from.compareTo(to) > 0);
    }

    @Test
    public void compareTo_firstEqualToSecond_result0() {
        Date from = new Date(13, 2, 2007);
        Date to = new Date(13, 2, 2007);

        assertEquals(0, from.compareTo(to));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12})
    public void getMonatAsString_firstDay_correctMonth(int month) {
        Date d = new Date(1, month, 2000);

        assertEquals(MONTHS[month - 1], d.getMonthAsString());
    }

    @ParameterizedTest
    @ValueSource(ints = {1900, 1907, 1901, 1999})
    public void isSchaltjahr_noLeapYear_false(int year) {
        assertFalse(Date.isLeapYear(year));
    }

    @ParameterizedTest
    @ValueSource(ints = {2000, 1600, 2004})
    public void isSchaltjahr_leapYear_true(int year) {
        assertTrue(Date.isLeapYear(year));
    }

    @Nested
    class ConstructorDayMonthYear {

        @Test
        public void _29022004_objectCreated() {
            assertDoesNotThrow(() -> new Date(29, 2, 2004));
        }

        @Test
        public void _29022000_objectCreated() {
            assertDoesNotThrow(() -> new Date(29, 2, 2000));
        }

        @Test
        public void _29021900_exception() {
            assertThrows(IllegalArgumentException.class, () -> new Date(29, 2, 1900));
        }

        @Test
        public void _29022001_exception() {
            assertThrows(IllegalArgumentException.class, () -> new Date(29, 2, 2001));
        }

        @Test
        public void dayNegative_exception() {
            assertThrows(IllegalArgumentException.class, () -> new Date(-1, 3, 2010));
        }

        @Test
        public void monthTooLarge_exception() {
            assertThrows(IllegalArgumentException.class, () -> new Date(4, 13, 2010));
        }

        @Test
        public void month0_exception() {
            assertThrows(IllegalArgumentException.class, () -> new Date(4, 0, 2010));
        }

        @Test
        public void yearBefore1900_exception() {
            assertThrows(IllegalArgumentException.class, () -> new Date(31, 12, 1899));
        }

        @ParameterizedTest(name = "{0}.{1}.{2}")
        @CsvSource({
                "31, 1, 2000",
                "29, 2, 2000",
                "28, 2, 2001",
                "28, 2, 1900",
                "31, 3, 2000",
                "30, 4, 2000",
                "31, 5, 2000",
                "30, 6, 2000",
                "31, 7, 2000",
                "31, 8, 2000",
                "30, 9, 2000",
                "31, 10, 2000",
                "30, 11, 2000",
                "31, 12, 2000"})
        public void lastDayOfMonth_objectCreated(int day, int month, int year) {
            assertDoesNotThrow(() -> new Date(day, month, year));
        }

        @ParameterizedTest(name = "{0}.{1}.{2}")
        @CsvSource({
                "32, 1, 2000",
                "30, 2, 2000",
                "29, 2, 2001",
                "29, 2, 1900",
                "32, 3, 2000",
                "31, 4, 2000",
                "32, 5, 2000",
                "31, 6, 2000",
                "32, 7, 2000",
                "32, 8, 2000",
                "31, 9, 2000",
                "32, 10, 200",
                "31, 11, 200",
                "32, 12, 200"})
        public void dayTooLarge_exception(int day, int month, int year) {
            assertThrows(IllegalArgumentException.class, () -> new Date(day, month, year));
        }

        @ParameterizedTest(name = "{0}.{1}.{2}")
        @CsvSource({
                "1, 1, 1900",
                "17, 12, 1937",
                "31, 8, 2020"})
        public void objectCreated(int day, int month, int year) {
            assertDoesNotThrow(() -> new Date(17, 12, 2017));
        }
    }
}