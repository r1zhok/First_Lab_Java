package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractProjector {

    protected String model;
    protected String resolution;
    protected String connectedDevice;

    public abstract void addInputDevice(String device);
    public abstract void disconnectDevice();
    public abstract double getRemainingWorkingHours();

}
