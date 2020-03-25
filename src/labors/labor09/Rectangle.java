package labors.labor09;

public class Rectangle extends Figure {
	private double width;
	private double height;
	
	public Rectangle (double x, double y, double width, double height) {
		super(x, y);
		if (width < 0 || Double.isInfinite(width) || height < 0 || Double.isInfinite(height))
			throw new IllegalArgumentException("The given " + ((width < 0 || Double.isInfinite(width)) ? "width" : "height") + " is invalid");
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void scale (double s) {
		if (s < 0 || Double.isInfinite(s))
			throw new IllegalArgumentException("The given scaling-factor is invalid");
		width *= s;
		height *= s;
	}
	
	@Override
	public double calcArea () {
		return width * height;
	}
	
	@Override
	public double calcPerimeter () {
		return width * 2 + height * 2;
	}
}
