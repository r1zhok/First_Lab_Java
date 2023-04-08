package ua.lviv.iot.algo.part1.lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import java.util.List;

class ProjectorManagerTest {

    private final List<AbstractProjector> testMassive = new LinkedList<>();
    private final ProjectorManager projectorManager = new ProjectorManager();

    @BeforeEach
    void setUp() {
        projectorManager.addProjector(LampProjector.init().
                        connectedDevice("HDMI").
                        resolution("1920x1080").model("Panasonic").lampHours(5).
                        descriptionOfTheInformationOutputMode("sport").
                        theMaximumPermissibleLampOperatingTime(5)
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
    }

    @Test
    void addProjector() {

        testMassive.addAll(List.of(LampProjector.init().
                        connectedDevice("HDMI").
                        resolution("1920x1080").model("Panasonic").lampHours(5).
                        descriptionOfTheInformationOutputMode("sport").
                        theMaximumPermissibleLampOperatingTime(5)
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
                        .energyConsumption(30).constructor()));

        Assertions.assertEquals(testMassive.toString(), projectorManager.addProjector().toString());
    }

    @Test
    void findProjectorByModel() {

        testMassive.addAll(List.of(HomeTheater.init().model("Samsung").resolution("4k")
                        .connectedDevice("HDMI, USB").yearOfASale(2023)
                        .screenSizeInInches(57).versionOfSmartTV("last")
                        .guarantee(5).constructor(),
                HomeTheater.init().model("Samsung").resolution("8k")
                        .connectedDevice("HDMI").yearOfASale(2021)
                        .screenSizeInInches(77).versionOfSmartTV("last")
                        .constructor()));

        Assertions.assertEquals(testMassive.toString(), projectorManager.findProjectorByModel("Samsung").toString());
    }

    @Test
    void findProjectorByResolution() {

        testMassive.addAll(List.of(LampProjector.init().
                connectedDevice("HDMI").
                resolution("1920x1080").model("Panasonic").lampHours(5).
                descriptionOfTheInformationOutputMode("sport").
                theMaximumPermissibleLampOperatingTime(5)
                .constructor(),
                MultiBoard.init().model("Prestigio").resolution("1920x1080")
                        .connectedDevice("HDMI").colorOfSurface("black")
                        .isHasMagniteSurface(true).thePossibilityOfRecordingTheScreen(false)
                        .guarantee(5).constructor(),
                MultiBoard.init().model("Prestigio").resolution("1920x1080")
                        .connectedDevice("HDMI").colorOfSurface("black")
                        .guarantee(5).constructor()));

        Assertions.assertEquals(testMassive.toString(), projectorManager.findProjectorByResolution("1920x1080").toString());
    }

    @Test
    void testToString() {
        ToStringVerifier.forClass(ProjectorManager.class).verify();
    }
}