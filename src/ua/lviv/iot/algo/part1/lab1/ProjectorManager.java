package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class ProjectorManager {

    private static List<AbstractProjector> projectors = new LinkedList<>();

    public static void main(String[] args) {
        ProjectorManager projectorManager = new ProjectorManager();

        projectorManager.addProjector(new HomeTheater("Samsung", "8k", "HDMI, USB", 2023,
                57, "last", 5));

        projectorManager.addProjector(new LampProjector("Panasonic", "480p", "HDMI",
                5, "presentation", 15),
                new LampProjector("Epson", "4k", "HDMI",
                        5, "sport", 15),
                new HomeTheater("Samsung", "8k", "HDMI, USB", 2023,
                        57, "last", 5),
                new HomeTheater("Samsung", "4k", "HDMI", 2021,
                        45, "last", 3),
                new MultiBoard("Prestigio", "1920x1080", "HDMI",
                        "multicolor", true, true, 5),
                new MultiBoard("Prestigio", "1920x1080", "HDMI",
                        "black", true, false, 4),
                new TreeDProjector("Panasonic", "4k", "HDMI", 4, 30),
                new TreeDProjector("Epson", "4k", "HDMI", 2, 45));

        System.out.println("All my objects: ");

        for(AbstractProjector projector: projectors){
            System.out.println(projector);
        }

        System.out.println("------------------------------------------");
        projectorManager.findProjectorByModel("Samsung");
        System.out.println("-------------------------------------------");
        projectorManager.findProjectorByResolution("1920x1080");
    }

    public void addProjector(AbstractProjector ... abstractProjector){
        projectors.addAll(List.of(abstractProjector));
    }

    public void findProjectorByModel(String model){
        projectors.stream().
                filter(abstractProjector -> abstractProjector.getModel().equals(model)).
                collect(Collectors.toList()).forEach(System.out::println);
    }

    public void findProjectorByResolution(String resolution){
        projectors.stream().
                filter(abstractProjector -> abstractProjector.getResolution().equals(resolution)).
                collect(Collectors.toList()).forEach(System.out::println);
    }
}
