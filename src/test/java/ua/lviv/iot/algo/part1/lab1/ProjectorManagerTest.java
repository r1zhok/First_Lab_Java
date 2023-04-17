package ua.lviv.iot.algo.part1.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectorManagerTest {

    private ProjectorManager projectorManager;


    @BeforeEach
    public void setUp() {
        projectorManager = new ProjectorManager();
        projectorManager.addProjector(LampProjector.init()
                        .connectedDevice("HDMI")
                        .resolution("1920x1080").model("Panasonic").lampHours(5)
                        .descriptionOfTheInformationOutputMode("sport")
                        .theMaximumPermissibleLampOperatingTime(5)
                        .constructor(),
                LampProjector.init().model("Epson").lampHours(5)
                        .connectedDevice("HDMI").resolution("4k")
                        .descriptionOfTheInformationOutputMode("normal").constructor(),
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
    }

    @Test
    void findProjectorByModel() {


        var results = projectorManager.findProjectorByModel("Samsung");
        Assertions.assertEquals(2, results.size());

        for (var projector : results) {
            Assertions.assertEquals("Samsung", projector.getModel());
        }
    }

    @Test
    void findProjectorByResolution() {
        var results = projectorManager.findProjectorByResolution("1920x1080");
        Assertions.assertEquals(2, results);

        for (var projector : results) {
            Assertions.assertEquals("1920x1080", projector.getResolution());
        }
    }
}