package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class LampProjector extends AbstractProjector {

    private double lampHours;
    private String descriptionOfTheInformationOutputMode;
    private double theMaximumPermissibleLampOperatingTime;

    public LampProjector(String model, String resolution, String connectedDevice,
                         double lampHours, String descriptionOfTheInformationOutputMode,
                         double theMaximumPermissibleLampOperatingTime) {
        super(model, resolution, connectedDevice);
        this.lampHours = lampHours;
        this.descriptionOfTheInformationOutputMode = descriptionOfTheInformationOutputMode;
        this.theMaximumPermissibleLampOperatingTime = theMaximumPermissibleLampOperatingTime;
    }

    public void increaseLampHours(int hours){
        this.lampHours += hours;
        System.out.println(lampHours);
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
        return theMaximumPermissibleLampOperatingTime;
    }

    @Override
    public String toString() {
        return "LampProjector{" +
                "lampHours=" + lampHours +
                ", descriptionOfTheInformationOutputMode='" + descriptionOfTheInformationOutputMode + '\'' +
                ", theMaximumPermissibleLampOperatingTime=" + theMaximumPermissibleLampOperatingTime +
                ", model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", connectedDevice='" + connectedDevice + '\'' +
                '}';
    }
}
