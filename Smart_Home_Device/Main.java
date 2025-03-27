// package Smart_Home_Device;

// Abstract class representing a smart device
abstract class SmartDevice {
    String deviceName; // Name of the device

    // Constructor to initialize device name
    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    // Abstract methods to be implemented by subclasses
    abstract void turnOn();

    abstract void turnOff();

    // Concrete method to show the device status
    void showStatus() {
        System.out.println("Device: " + deviceName);
    }
}

// Class representing a smart light that extends SmartDevice
class SmartLight extends SmartDevice {

    // Constructor to set the device name
    SmartLight(String deviceName) {
        super(deviceName);
    }

    // Implement turnOn method
    @Override
    void turnOn() {
        System.out.println("Light is now ON");
    }

    // Implement turnOff method
    @Override
    void turnOff() {
        System.out.println("Light is now OFF");
    }
}

// Class representing a smart speaker that extends SmartDevice
class SmartSpeaker extends SmartDevice {

    // Constructor to set the device name
    SmartSpeaker(String deviceName) {
        super(deviceName);
    }

    // Implement turnOn method
    @Override
    void turnOn() {
        System.out.println("Speaker is now playing music");
    }

    // Implement turnOff method
    @Override
    void turnOff() {
        System.out.println("Speaker is now OFF");
    }
}

// Class representing a smart thermostat that extends SmartDevice
class SmartThermostat extends SmartDevice {
    private int temperature; // Temperature setting

    // Constructor to set the device name and initial temperature
    SmartThermostat(String deviceName, int temperature) {
        super(deviceName);
        this.temperature = temperature;
    }

    // Implement turnOn method
    @Override
    void turnOn() {
        System.out.println("Thermostat is now set to " + temperature + "°C");
    }

    // Implement turnOff method
    @Override
    void turnOff() {
        System.out.println("Thermostat is turned off");
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiate SmartLight and SmartSpeaker
        SmartDevice light = new SmartLight("Smart Light");
        SmartDevice speaker = new SmartSpeaker("Smart Speaker");

        // Interact with SmartLight
        System.out.println(light.deviceName + ":");
        light.turnOn();
        light.showStatus();
        light.turnOff();
        System.out.println(); // For better readability

        // Interact with SmartSpeaker
        System.out.println(speaker.deviceName + ":");
        speaker.turnOn();
        speaker.showStatus();
        speaker.turnOff();
        System.out.println(); // For better readability

        // Bonus Challenge: Instantiate SmartThermostat
        SmartDevice thermostat = new SmartThermostat("Smart Thermostat", 22);
        thermostat.turnOn();
        thermostat.showStatus();
        thermostat.turnOff();
    }
}
