package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

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


    @Override
    public String toString() {
        return "Projector{" +
                "model='" + model + '\'' +
                ", resolution='" + resolution + '\'' +
                ", lampHours=" + lampHours +
                ", connectedDevice='" + connectedDevice + '\'' +
                '}';
    }
}
