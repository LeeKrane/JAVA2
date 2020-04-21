package labors.labor10;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public abstract class Vehicle {
    public static final String[] CAR_BRANDS = {"BMW", "Honda", "Suzuki",
            "VW", "Ferrari", "Alfa Romeo", "Mercedes", "Maserati", "Tesla"};
    public static final String[] MOTORCYCLE_BRANDS = {"BMW", "Honda", "Suzuki",
            "Ducati", "Moto Guzzi", "Kawasaki"};
    public static final String[] BICYCLE_BRANDS = {"Bianchi", "Giant", "Trek", "Scott", "Fuji"};
    private static final Random RANDOM = new Random();
    private String brand;
    private int wheels;

    /**
     * Creates a new vehicle.
     *
     * @param brand  the brad
     * @param wheels the number of wheels on the vehicle. Must be positive.
     */
    public Vehicle (String brand, int wheels) {
        if (wheels < 0)
            throw new IllegalArgumentException("The number of wheels must be positive!");
        this.brand = brand;
        this.wheels = wheels;
    }

    public static void main (String[] args) {
        Vehicle[] vehicles = getNRandom(30);
        System.out.println(Arrays.toString(getStartedCars(vehicles)));
        System.out.println(countMotorized(vehicles));
    }

    /**
     * Counts how many vehicles have a motor in a given array.
     *
     * @param vehicles an array of vehicles
     * @return number of motorized Objects in array
     */
    private static int countMotorized (Vehicle[] vehicles) {
        int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Motorized)
                count++;
        }
        return count;
    }

    /**
     * Filters all cars with running motor from a given array.
     *
     * @param vehicles an array of vehicles
     * @return an array of vehicles containing only Cars with running motor
     */
    private static Vehicle[] getStartedCars (Vehicle[] vehicles) {
        Vehicle[] temp = new Vehicle[vehicles.length];
        int i = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car && ((Car) vehicle).isStarted())
                temp[i++] = vehicle;
        }
        
        Vehicle[] ret = new Vehicle[i + 1];
        i = 0;
        for (Vehicle vehicle : temp)
            ret[i++] = vehicle;
        return ret;
    }

    /**
     * Creates an array of random Vehicles. Type is random, brand is random. If the vehicle has a motor, the power is
     * also randomized.
     *
     * @param n the number of desired Vehicles
     * @return an array of random Vehicles.
     */
    private static Vehicle[] getNRandom (int n) {
        int rand;
        Vehicle vehicle;
        Vehicle[] vehicles = new Vehicle[n];
        
        for (int i = 0; i < n; i++) {
            rand = RANDOM.nextInt() % 3;
            
            switch (rand) {
                case 0:
                    vehicle = new Bicycle(BICYCLE_BRANDS[RANDOM.nextInt() % BICYCLE_BRANDS.length], RANDOM.nextInt() % 2 + 2);
                    break;
                case 1:
                    vehicle = new Motorcycle(MOTORCYCLE_BRANDS[RANDOM.nextInt() % MOTORCYCLE_BRANDS.length], RANDOM.nextInt() % 2 + 2, RANDOM.nextInt() % 1000, RANDOM.nextBoolean());
                    break;
                default:
                    vehicle = new Car(CAR_BRANDS[RANDOM.nextInt() % CAR_BRANDS.length], RANDOM.nextInt() % 1000, RANDOM.nextBoolean());
            }
            
            vehicles[i] = vehicle;
        }
        
        return vehicles;
    }
    
    String getBrand () {
        return brand;
    }
    
    int getWheels () {
        return wheels;
    }
}