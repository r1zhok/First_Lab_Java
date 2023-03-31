package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MultiBoard extends AbstractProjector{
    private String colorOfSurface;
    private boolean isHasMagniteSurface;
    private boolean thePossibilityOfRecordingTheScreen;
    private double guarantee;
    private static final double WORKING_HOURS_PER_YEAR = 3650;

    public MultiBoard(String model, String resolution, String connectedDevice,
                      String colorOfSurface, boolean isHasMagniteSurface,
                      boolean thePossibilityOfRecordingTheScreen, double guarantee) {
        super(model, resolution, connectedDevice);
        this.colorOfSurface = colorOfSurface;
        this.isHasMagniteSurface = isHasMagniteSurface;
        this.thePossibilityOfRecordingTheScreen = thePossibilityOfRecordingTheScreen;
        this.guarantee = guarantee;
    }

    @Override
    public void addInputDevice(String device) {
        this.connectedDevice = device;
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
        return "MultiBoard{" +
                "colorOfSurface='" + colorOfSurface + '\'' +
                ", isHasMagniteSurface=" + isHasMagniteSurface +
                ", thePossibilityOfRecordingTheScreen=" + thePossibilityOfRecordingTheScreen +
                ", guarantee=" + guarantee +
                ", model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", connectedDevice='" + connectedDevice + '\'' +
                '}';
    }
}
