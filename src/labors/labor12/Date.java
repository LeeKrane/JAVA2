package labors.labor12;

import java.time.LocalDate;

public class Date {

    public final static int FORMAT_SHORT = 0;
    public final static int FORMAT_NORMAL = 1;
    public final static int FORMAT_LONG = 2;
    public final static int FORMAT_US = 3;

    private int day;
    private int month;
    private int year;
    
    private void reduceMonth () {
        month--;
        switch (month) {
            case 0:
                year--;
                month = 12;
            case 1, 3, 5, 7, 8, 10, 12:
                day = 31;
                break;
            case 2:
                day = (isLeapYear(year) ? 29 : 28);
                break;
            case 4, 6, 9, 11:
                day = 30;
        }
    }
    
    private void increaseMonth () {
        month++;
        day = 1;
    }

    /**
     * Erzeugt eine Datumsinstanz mit dem aktuellen Systemdatum.
     */
    public Date () {
        LocalDate today = LocalDate.now();
        day = today.getDayOfMonth();
        month = today.getMonthValue();
        year = today.getYear();
    }

    /**
     * Erzeugt eine Datumsinstanz im Format TT.MM.YYYY.
     *
     * @param dateString zu parsender String
     */
    public Date (String dateString) {
        String[] split = dateString.split("\\.");
        if (!dateString.matches("\\d{2}\\.\\d{2}\\.\\d{4}"))
            throw new IllegalArgumentException();
        day = Integer.parseInt(split[0]);
        month = Integer.parseInt(split[1]);
        year = Integer.parseInt(split[2]);
    }

    /**
     * Erzeugt eine Datumsinstanz, die t Tage nach dem 1.1.1900 liegt.
     *
     * @param days die Tage seit dem 1.1.1900; muss >= 0 sein
     */
    public Date (int days) {
        this(1, 1, 1900);
        if (days < 0)
            throw new IllegalArgumentException("The given date is illegal.");
        else
            this.addDays(days);
    }

    /**
     * Erzeugt eine Datumsinstanz mit den gegebenen Werten.
     *
     * @param day   der Tag 1-31 ( abhaengig vom Monat)
     * @param month das Monat, 1 - 12
     * @param year  das Jahr, 1900 - 3000
     */
    public Date (int day, int month, int year) {
        IllegalArgumentException e = new IllegalArgumentException("The given date is illegal.");
        if (year < 1900 || year > 3000)
            throw e;
        
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                if (day > 31)
                    throw e;
                break;
            case 2:
                if ((isLeapYear(year) && day > 29) || day > 28)
                    throw e;
            case 4, 6, 9, 11:
                if (day > 30)
                    throw e;
        }
        
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Liefert die zwischen zwei Daten vergangenen Tage.
     *
     * @param d1 das erste Datum
     * @param d2 das zweite Datum
     * @return Tage zwischen <code>d1</code> und <code>d2</code>;
     * positiv wenn <code>d2</code> nach <code>d1</code> liegt, sonst negativ
     */
    public static int daysBetween (Date d1, Date d2) {
        int days = 0;
        
        if (d1.compareTo(d2) == 0)
            return 0;
        else if (d1.compareTo(d2) < 0) {
            while (d1.compareTo(d2) != 0) {
                d1.addDays(1);
                days++;
            }
        } else {
            while (d1.compareTo(d2) != 0) {
                d1.addDays(1);
                days--;
            }
        }
        
        return days;
    }

    /**
     * Prüft auf Schaltjahr.
     *
     * @param year die zu prüfende Jahreszahl
     * @return <code>true</code>, wenn <code>jahr</code> ein Schaltjahr ist, <code>false</code> sonst
     */
    public static boolean isLeapYear (int year) {
        return year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    /**
     * Liefert den Namen des Monats.
     *
     * @return den Monatsnamen
     */
    public String getMonthAsString () {
        return switch (month) {
            case 1 -> "Jaenner";
            case 2 -> "Februar";
            case 3 -> "Maerz";
            case 4 -> "April";
            case 5 -> "Mai";
            case 6 -> "Juni";
            case 7 -> "Juli";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "Oktober";
            case 11 -> "November";
            case 12 -> "Dezember";
            default -> throw new IllegalArgumentException("This date is illegal.");
        };
    }

    /**
     * Erhöht (vermindert) das gespeicherte Datum. Liegt nach dieser
     * Operation das Datum vor dem 1.1.1900,
     * so wird eine IllegalArgumentException geworfen und keine Änderung durchgeführt.
     *
     * @param days die Tage, um die dieses Datum erhöht (t > 0) bzw. vermindert (t < 0) wird
     */
    public void addDays (int days) {
        if (days < 0) {
            for (int i = days; i < 0; i++) {
                day--;
                if (day == 0)
                    reduceMonth();
            }
        } else {
            for (int i = 0; i < days; i++) {
                switch (month) {
                    case 1, 3, 5, 7, 8, 10, 12:
                        if (day == 31)
                            increaseMonth();
                        break;
                    case 2:
                        if ((day == 29 && isLeapYear(year)) || day == 28)
                            increaseMonth();
                        break;
                    case 4, 6, 9, 11:
                        if (day == 30)
                            increaseMonth();
                    default:
                        day++;
                }
            }
        }
    }

    /**
     * Liefert die Nummer des Wochentages.
     *
     * @return die Nummer des Wochentages im Bereich von 0(Montag) bis 6(Sonntag)
     */
    public int weekdayNumber () {
        int d = this.day;
        int m = this.month;
        int y = this.year;
    
        if (m < 3)
            y--;
    
        return (int)((d + Math.floor(2.6 * ((m + 9) % 12 + 1) - 0.2) + y % 100 + Math.floor(y % 100.0 / 4.0) + Math.floor(y / 400.0) - 2 * Math.floor(y / 100.0) - 1) % 7 + 7) % 7;
    }

    /**
     * Liefert den Wochentag als String.
     *
     * @return den Wochentag als String
     */
    public String weekday () {
        return switch (weekdayNumber()) {
            case 0 -> "Sonntag";
            case 1 -> "Montag";
            case 2 -> "Dienstag";
            case 3 -> "Mittwoch";
            case 4 -> "Donnerstag";
            case 5 -> "Freitag";
            case 6 -> "Samstag";
            default -> throw new IllegalArgumentException("This date is illegal.");
        };
    }

    /**
     * Vergleicht das <code>this</code>-Datum mit dem übergebenen.
     *
     * @param d das Datum, mit dem verglichen wird
     * @return eine negative Zahl, wenn d spaeter liegt, positiv, wenn d frueher l i egt und
     * 0 bei gleichem Datum
     */
    public int compareTo (Date d) {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert eine Stringdarstellung i n der Form <code>tt.mm.jjjj</code>
     *
     * @return Stringdarstellung i n der Form <code>tt.mm.jjjj</code>QA QA
     * @override
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO");
    }

    /**
     * Liefert eine Stringdarstellung unterschiedlichen Formats
     *
     * @param format Moegliche Werte sind:
     *               <code>Datum.FORMAT_SHORT, Datum.FORMAT_NORMAL, Datum.FORMAT_LONG, Datum.FORMAT_US</code>
     * @return Datum im Format <code>dd.mm.yy</code> bei <code>Datum.FORMAT_SHORT</code>,
     * im Format <code>dd.monat jjjj, wochentag (Monat ausgeschrieben)</code> bei
     * <code>Datum.FORMAT_LONG</code>, im Format <code>jjjj/tt/mm</code> bei
     * <code>Datum.FORMAT_US</code>
     */
    public String toString(int format) {
        throw new UnsupportedOperationException("TODO");
    }
}
