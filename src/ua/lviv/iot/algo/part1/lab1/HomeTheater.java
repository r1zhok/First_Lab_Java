package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class HomeTheater extends AbstractProjector{

    private double yearOfASale;
    private double screenSizeInInches;
    private String versionOfSmartTV;
    private double guarantee;
    private static final double WORKING_HOURS_PER_YEAR = 3650;

    public HomeTheater(String model, String resolution, String connectedDevice,
                       int yearOfASale, int screenSizeInInches, String versionOfSmartTV,
                       int guarantee) {
        super(model, resolution, connectedDevice);
        this.yearOfASale = yearOfASale;
        this.screenSizeInInches = screenSizeInInches;
        this.versionOfSmartTV = versionOfSmartTV;
        this.guarantee = guarantee;
    }

    @Override
    public void addInputDevice(String device) {
        this.connectedDevice = device;
        System.out.println(connectedDevice);
    }

    @Override
    public void disconnectDevice() {
        this.connectedDevice = null;
    }

    @Override
    public double getRemainingWorkingHours() {
        return guarantee * WORKING_HOURS_PER_YEAR;
    }

    @Override
    public String toString() {
        return "HomeTheater{" +
                "yearOfASale=" + yearOfASale +
                ", screenSizeInInches=" + screenSizeInInches +
                ", versionOfSmartTV='" + versionOfSmartTV + '\'' +
                ", guarantee=" + guarantee +
                ", model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", connectedDevice='" + connectedDevice + '\'' +
                '}';
    }
}
