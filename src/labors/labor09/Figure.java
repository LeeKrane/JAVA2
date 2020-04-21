package labors.labor09;

@SuppressWarnings("unused")
public abstract class Figure implements GeometricObject {
	private double x;
	private double y;
	
	public Figure (double x, double y) {
		checkLegality(x, y);
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void translate (double x, double y) {
		checkLegality(x, y);
		this.x += x;
		this.y += y;
	}
	
	private void checkLegality (double x, double y) {
		if (isInvalid(x) || isInvalid(y))
			throw new IllegalArgumentException("The given " + (isInvalid(x) ? 'x' : 'y') + " coordinate is invalid!");
	}
	
	private boolean isInvalid (double d) {
		return Double.isNaN(d) || !Double.isFinite(d);
	}
}