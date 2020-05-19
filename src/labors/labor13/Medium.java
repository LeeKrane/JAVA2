package labors.labor13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public abstract class Medium {
    private String bezeichnung;
    private double preis;

    public Medium(String bezeichnung, double preis) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
    }

    /**
     * Erzeugt aus einem übergebenen String ein Medium-Objekt.
     *
     * @param csv ein csv-String. Format: bezeichnung, preis, seiten/spielzeit
     * @return ein entsprechendes Objekt
     */
    public static Medium of(String csv) {
        String[] split = csv.split(", ");
        Medium medium;
        
        if (split.length != 3)
            throw new IllegalArgumentException();
        
        try {
            medium = new Buch(split[0], Double.parseDouble(split[1]), Integer.parseInt(split[2]));
        } catch (NumberFormatException e) {
            try {
                medium = new AudioCD(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2]));
            } catch (NumberFormatException e1) {
                throw new IllegalArgumentException();
            }
        }
        
        return medium;
    }

    /**
     * Liest Mediendaten aus einer übergebenen Datei aus. Fehlerhafte Zeilen werden ignoriert.
     *
     * @param filename das zu lesende File
     * @return ein Array aller gelesenen Objekte
     * @throws IOException falls die Datei nicht gelesen werden kann
     */
    public static Medium[] readFile(String filename) throws IOException {
        Medium[] media = new Medium[0];
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            Medium[] storage;
            Medium medium;
            
            while (br.ready()) {
                try {
                    medium = of(br.readLine());
    
                    storage = media;
                    media = new Medium[media.length + 1];
    
                    if (storage.length >= 0)
                        System.arraycopy(storage, 0, media, 0, storage.length);
    
                    media[media.length - 1] = medium;
                } catch (IllegalArgumentException ignored) {
                
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("file: " + filename + " not found");
        }
        
        return media;
    }

    public abstract void printInfo();

    /**
     * Vergleicht das <code>this</code>-Objekt mit dem übergebenen.
     *
     * @param other zu vergleichendes Objekt
     * @return eine Zahl < 0, wenn <code>this</code> billiger ist, eine Zahl > 0, wenn <code>other</code> billiger ist,
     * 0 wenn beide den gleichen Preis haben
     */
    public int compareTo(Medium other) {
        return Double.compare(preis, other.preis);
    }
	
	/**
     * Sortiert das <code>feld</code>> aufsteigend nach Preis
	 * mittels Bubble-Sort Algorithmus
     *
     * @param feld das zu sortierende Feld
     */
    public static void sort (Medium[] feld){
        Medium temp;
    
        for (int i = 1; i < feld.length; i++) {
            for (int j = 0; j < feld.length - i; j++) {
                if (feld[j].compareTo(feld[j + 1]) == 1) {
                    temp = feld[j];
                    feld[j] = feld[j + 1];
                    feld[j + 1] = temp;
                }
            }
        }
    }
	
	/**
     * Zwei Medien gelten als gleich, wenn sie in Bezeichnung und Preis übereinstimmen.
	 * kann generiert werden
     *
     * @param o das zu vergleichende Objekt
     */
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medium medium = (Medium) o;
        return Double.compare(medium.preis, preis) == 0 &&
                Objects.equals(bezeichnung, medium.bezeichnung);
    }
    
    @Override
    public int hashCode () {
        return Objects.hash(bezeichnung, preis);
    }
    
    public String getBezeichnung () {
        return bezeichnung;
    }
    
    public double getPreis () {
        return preis;
    }
}
