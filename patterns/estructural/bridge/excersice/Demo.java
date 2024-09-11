package patterns.estructural.bridge.excersice;

import patterns.estructural.bridge.excersice.devices.Device;
import patterns.estructural.bridge.excersice.devices.Radio;
import patterns.estructural.bridge.excersice.devices.Tv;
import patterns.estructural.bridge.excersice.remotes.AdvancedRemote;
import patterns.estructural.bridge.excersice.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
