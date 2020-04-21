package labors.labor10;

@SuppressWarnings("SameParameterValue")
public class Bicycle extends Vehicle {
	Bicycle (String brand) {
		super(brand, 2);
	}
	
	Bicycle (String brand, int wheels) {
		super(brand, wheels);
		if (wheels < 2 || wheels > 3)
			throw new IllegalArgumentException("The number of wheels must be 2 or 3!");
	}
}
