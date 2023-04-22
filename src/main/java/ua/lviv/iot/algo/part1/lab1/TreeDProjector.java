package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder(builderMethodName = "init", buildMethodName = "constructor", toBuilder = true, setterPrefix = "")
@Getter
@Setter
public class TreeDProjector extends AbstractProjector {
    private double guarantee;
    private static final double WORKING_HOURS_PER_YEAR = 3650;
    private double energyConsumption;

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
        return guarantee * WORKING_HOURS_PER_YEAR;
    }
}
