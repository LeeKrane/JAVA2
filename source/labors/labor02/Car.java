package labors.labor02;

public class Car {
	private String type;
	private boolean engineActive;
	
	public static void main (String[] args) {
		Car c1 = new Car("BMW");
		Car c2 = new Car("Porsche", true);
		System.out.println(c1);
		c1.start();
		System.out.println(c1);
		System.out.println(c2);
		c2.stop();
		System.out.println(c2);
	}
	
	private Car (String type) {
		this(type, false);
	}
	
	private Car (String type, boolean engineActive) {
		this.type = type;
		this.engineActive = engineActive;
	}
	
	private void start () {
		engineActive = true;
	}
	
	private void stop () {
		engineActive = false;
	}
	
	@Override
	public String toString () {
		String string = type + ", engine is ";
		if (engineActive)
			return string + "on";
		return string + "off";
	}
}
