package labors.labor02;

/**
 * @author LeeKrane
 */

/* public */ class Rectangle {
	private double length = 1.0;
	private double width = 1.0;
	
	/* public */ double face () {
		return length * width;
	}
	
	/* public */ double extent () {
		return length * 2 + width * 2;
	}
	
	/* public */ double getLength () {
		return length;
	}
	
	/* public */ double getWidth () {
		return width;
	}
	
	/* public */ void setLength (double length) {
		this.length = intervalCheck(length);
	}
	
	/* public */ void setWidth (double width) {
		this.width = intervalCheck(width);
	}
	
	static double intervalCheck (double d) {
		if (d < 1.0) return 1.0;
		return Math.min(d, 20.0); // returns the smallest value of the two arguments
	}
}
