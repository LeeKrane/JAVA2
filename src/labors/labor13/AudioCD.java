package labors.labor13;

public class AudioCD extends Medium {
	private double spielzeit;
	
	public AudioCD (String bezeichnung, double preis, double spielzeit) {
		super(bezeichnung, preis);
		this.spielzeit = spielzeit;
	}
	
	@Override
	public void printInfo () {
		System.out.format("%11s%s\n%11s%f\n%11s%2.0f:%2.0f", "Buch:", getBezeichnung(), "Preis:", getPreis(), "Spielzeit:", getSpielzeit(), getSpielzeit() * 100 % 100);
	}
	
	public double getSpielzeit () {
		return spielzeit;
	}
	
	@Override
	public String toString () {
		return "AudioCD{" + getBezeichnung() + ", " + getPreis() + ", " + getSpielzeit() + '}';
	}
}
