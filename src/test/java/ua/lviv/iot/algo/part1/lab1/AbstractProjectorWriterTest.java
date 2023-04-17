package ua.lviv.iot.algo.part1.lab1;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractProjectorWriterTest {
    private AbstractProjectorWriter writer;
    private List<AbstractProjector> projectors;
    private static final String RESULT_FILE_NAME = "result.csv";
    private static final String EXPECTED_FILENAME = "result.csv";

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        writer = new AbstractProjectorWriter();
        projectors = new LinkedList<>();
        projectors.addAll(List.of(LampProjector.init().
                        connectedDevice("HDMI")
                        .resolution("1920x1080").model("Panasonic").lampHours(5)
                        .descriptionOfTheInformationOutputMode("sport")
                        .theMaximumPermissibleLampOperatingTime(5)
                        .constructor(),
                LampProjector.init().model("Epson").lampHours(5)
                        .connectedDevice("HDMI").resolution("4k").
                        descriptionOfTheInformationOutputMode("normal").constructor(),
                HomeTheater.init().model("Samsung").resolution("4k")
                        .connectedDevice("HDMI").yearOfASale(2023)
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
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(RESULT_FILE_NAME));
    }

    @Test
    public void testEmptyWrite() throws IOException {
        writer.writeToFile(null);
        File file = new File(RESULT_FILE_NAME);
        Assert.assertFalse(file.exists());
    }

    @Test
    public void testWriteListOfProjectors() throws IOException {
        writer.writeToFile(projectors);
        File file = new File(RESULT_FILE_NAME);

        Path expected = new File(EXPECTED_FILENAME).toPath();
        Path actual = file.toPath();

        assertEquals(-1L,Files.mismatch(expected, actual));
    }

    @Test
    public void testFileOverride() throws IOException {
        testWriteListOfProjectors();
    }
}