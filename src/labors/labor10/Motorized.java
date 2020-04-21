package labors.labor10;

public interface Motorized {
    /**
     * Starts the motor. If it is already running no-op.
     */
    void start();

    /**
     * Stops the motor. If it is already stopped no-op.
     */
    void stop();

    /**
     * Returns whether the motor is running or not.
     *
     * @return <code>true</code> if the motor is running; <code>false</code> otherwise
     */
    boolean isStarted();

    /**
     * Returns the power of the motor in kW.
     *
     * @return the power[kW]
     */
    double getPower();
}
