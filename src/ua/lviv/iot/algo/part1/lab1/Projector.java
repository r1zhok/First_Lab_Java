package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Projector {

    private String model;
    private String resolution;
    private int lampHours;
    private String connectedDevice;

    private static Projector instance;

    public void addInputDevice(String device){
        this.connectedDevice = device;
    }

    public void disconnectDevice(){
        this.connectedDevice = null;
    }

    public void increaseLampHours(int hours){
        this.lampHours+=hours;
    }
    public static Projector getInstance(){
        if (instance == null) {
            instance = new Projector();
        }
        return instance;
    }

    public static void main(String[] args) {
        Projector[] projectors = {new Projector(), new Projector("Epson", "1920x1080", 5, "HDMI"), Projector.getInstance(), Projector.getInstance()};

        for (Projector projector:projectors){
            System.out.println(projector);
        }
    }

}
