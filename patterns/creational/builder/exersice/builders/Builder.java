package patterns.creational.builder.exersice.builders;

import patterns.creational.builder.exersice.cars.CarType;
import patterns.creational.builder.exersice.components.Engine;
import patterns.creational.builder.exersice.components.GPSNavigator;
import patterns.creational.builder.exersice.components.Transmission;
import patterns.creational.builder.exersice.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
