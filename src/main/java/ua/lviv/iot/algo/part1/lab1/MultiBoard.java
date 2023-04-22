package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder(builderMethodName = "init", buildMethodName = "constructor", toBuilder = true, setterPrefix = "")
@ToString(callSuper = true)
@Getter
@Setter
public class MultiBoard extends AbstractProjector {
    private String colorOfSurface;
    private boolean isHasMagniteSurface;
    private boolean thePossibilityOfRecordingTheScreen;
    private double guarantee;
    private static final double WORKING_HOURS_PER_YEAR = 3650;

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
