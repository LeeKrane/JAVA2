package labors.labor10;

public class Motorcycle extends Vehicle implements Motorized {
	private double power;
	private boolean started;
	
	Motorcycle (String brand, double power) {
		this(brand, 2, power, false);
	}
	
	Motorcycle (String brand, int wheels, double power, boolean started) {
		super(brand, wheels);
		if (wheels < 2 || wheels > 3)
			throw new IllegalArgumentException("The number of wheels must be 2 or 3!");
		if (power < 0)
			throw new IllegalArgumentException("The power must be positive!");
		this.power = power;
		this.started = started;
	}
	
	@Override
	public void start () {
		if (!started) // this if statement is not needed, but the interface says no operation should be done, if the motor is already started.
			started = true;
	}
	
	@Override
	public void stop () {
		if (started) // this if statement is not needed, but the interface says no operation should be done, if the motor is already stopped.
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
