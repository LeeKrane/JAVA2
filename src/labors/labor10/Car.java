package labors.labor10;

public class Car extends Vehicle implements Motorized {
	private double power;
	private boolean started;
	
	Car (String brand, double power) {
		this(brand, power, false);
	}
	
	Car (String brand, double power, boolean started) {
		super(brand, 4);
		if (power < 0)
			throw new IllegalArgumentException("The power must be positive!");
		this.power = power;
		this.started = started;
	}
	
	@Override
	public void start () {
		if (!started) // this if statement is not necessary, but the interface specifies that no operation should be done, if the motor is already started.
			started = true;
	}
	
	@Override
	public void stop () {
		if (started) // this if statement is not necessary, but the interface specifies that no operation should be done, if the motor is already stopped.
			started = false;
	}
	
	@Override
	public boolean isStarted () {
		return started;
	}
	
	@Override
	public double getPower () {
		return power;
	}
}
