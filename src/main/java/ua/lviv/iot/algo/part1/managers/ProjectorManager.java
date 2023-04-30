package ua.lviv.iot.algo.part1.managers;

import lombok.ToString;
import ua.lviv.iot.algo.part1.modules.*;

import java.util.LinkedList;
import java.util.List;

@ToString(callSuper = true)
public class ProjectorManager {

    private static final List<AbstractProjector> projectors = new LinkedList<>();

    public static void main(String... args) {
        ProjectorManager projectorManager = new ProjectorManager();

        projectorManager.addProjector(
                LampProjector.init().
                        connectedDevice("HDMI")
                        .resolution("1920x1080").model("Panasonic").lampHours(5)
                        .descriptionOfTheInformationOutputMode("sport")
                        .theMaximumPermissibleLampOperatingTime(5)
                        .constructor(),
                LampProjector.init().model("Epson").lampHours(5)
                        .connectedDevice("HDMI").resolution("4k").
                        descriptionOfTheInformationOutputMode("normal").constructor(),
                HomeTheater.init().model("Samsung").resolution("4k")
                        .connectedDevice("HDMI, USB").yearOfASale(2023)
                        .screenSizeInInches(57).versionOfSmartTV("last")
                        .guarantee(5).constructor(),
                HomeTheater.init().model("Samsung").resolution("8k")
                        .connectedDevice("HDMI").yearOfASale(2021)
                        .screenSizeInInches(77).versionOfSmartTV("last")
                        .constructor(),
                MultiBoard.init().model("Prestigio").resolution("1920x1080")
                        .connectedDevice("HDMI").colorOfSurface("black")
                        .isHasMagniteSurface(true).thePossibilityOfRecordingTheScreen(false)
                        .guarantee(5).constructor(),
                MultiBoard.init().model("Prestigio").resolution("1920x1080")
                        .connectedDevice("HDMI").colorOfSurface("black")
                        .guarantee(5).constructor(),
                TreeDProjector.init().model("Panasonic").resolution("4k")
                        .connectedDevice("HDMI").guarantee(4)
                        .energyConsumption(30).constructor(),
                TreeDProjector.init().model("Panasonic").resolution("4k")
                        .connectedDevice("HDMI")
                        .energyConsumption(30).constructor());


        System.out.println("All my objects: ");

        for (AbstractProjector projector : projectors) {
            System.out.println(projector);
        }

        System.out.println("------------------------------------------");

        for (AbstractProjector projector : projectorManager.findProjectorByModel("Samsung")) {
            System.out.println(projector);
        }

        System.out.println("-------------------------------------------");

        for (AbstractProjector projector : projectorManager.findProjectorByResolution("1920x1080")) {
            System.out.println(projector);
        }
    }


    public List<AbstractProjector> addProjector(AbstractProjector... abstractProjector) {
        projectors.addAll(List.of(abstractProjector));
        return projectors;
    }

    public List<AbstractProjector> findProjectorByModel(String model) {
        return projectors.stream().
                filter(abstractProjector -> abstractProjector.getModel().equals(model)).
                toList();
    }

    public List<AbstractProjector> findProjectorByResolution(String resolution) {
        return projectors.stream().
                filter(abstractProjector -> abstractProjector.getResolution().equals(resolution)).
                toList();
    }
}
