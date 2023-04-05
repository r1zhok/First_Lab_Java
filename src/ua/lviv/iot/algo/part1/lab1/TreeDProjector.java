package ua.lviv.iot.algo.part1.lab1;

public class TreeDProjector extends AbstractProjector{
    private double guarantee;
    private static final double WORKING_HOURS_PER_YEAR = 3650;
    private double energyConsumption;

    public TreeDProjector(String model, String resolution, String connectedDevice, double guarantee, double energyConsumption) {
        super(model, resolution, connectedDevice);
        this.guarantee = guarantee;
        this.energyConsumption = energyConsumption;
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
        return "TreeDProjector{" +
                "guarantee=" + guarantee +
                ", energyConsumption=" + energyConsumption +
                ", model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", connectedDevice='" + connectedDevice + '\'' +
                '}';
    }
}
