package labors.labor13;

public class Buch extends Medium {
	private int seiten;
	
	public Buch (String bezeichnung, double preis, int seiten) {
		super(bezeichnung, preis);
		this.seiten = seiten;
	}
	
	@Override
	public void printInfo () {
		System.out.format("%8s%s\n%8s%f\n%8s%d", "Buch:", getBezeichnung(), "Preis:", getPreis(), "Seiten:", getSeiten());
	}
	
	public int getSeiten () {
		return seiten;
	}
	
	@Override
	public String toString () {
		return "Buch{" + getBezeichnung() + ", " + getPreis() + ", " + getSeiten() + '}';
	}
}
