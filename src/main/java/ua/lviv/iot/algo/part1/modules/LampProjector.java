package ua.lviv.iot.algo.part1.modules;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder(builderMethodName = "init",
        buildMethodName = "constructor",
        toBuilder = true, setterPrefix = "")
@Getter
@Setter
public class LampProjector extends AbstractProjector {

    private double lampHours;
    private String descriptionOfTheInformationOutputMode;
    private double theMaximumPermissibleLampOperatingTime;

    public double increaseLampHours(int hours) {
        return this.lampHours += hours;
    }


    @Override
    public String addInputDevice(String device) {
        setConnectedDevice(device);
        return getConnectedDevice();
    }

    @Override
    public String disconnectDevice() {
        setConnectedDevice(null);
        return getConnectedDevice();
    }

    @Override
    public double getRemainingWorkingHours() {
        return theMaximumPermissibleLampOperatingTime;
    }
}
