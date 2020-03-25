package labors.labor09;

public class Circle extends Figure {
	private double radius;
	
	public Circle (double x, double y, double radius) {
		super(x, y);
		if (radius < 0 || Double.isInfinite(radius))
			throw new IllegalArgumentException("The given radius is invalid");
		this.radius = radius;
	}
	
	@Override
	public void scale (double s) {
		if (s < 0 || Double.isInfinite(s))
			throw new IllegalArgumentException("The given scaling-factor is invalid");
		radius *= s;
	}
	
	@Override
	public double calcArea () {
		return Math.pow(radius, 2) * Math.PI;
	}
	
	@Override
	public double calcPerimeter () {
		return 2 * Math.PI * radius;
	}
}
