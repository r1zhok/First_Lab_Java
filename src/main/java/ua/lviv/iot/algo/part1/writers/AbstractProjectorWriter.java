package ua.lviv.iot.algo.part1.writers;

import ua.lviv.iot.algo.part1.modules.*;

import java.io.*;
import java.util.*;

public class AbstractProjectorWriter {

    public String writeToFile(List<AbstractProjector> projectors) {
        if (projectors == null || projectors.isEmpty()) {
            return null;
        }

        String defaultFileName = "result.csv";
        List<String> nameOfFields = new LinkedList<>();
        List<AbstractProjector> sort = projectors.stream().sorted(Comparator.comparing(obj -> obj.getClass().getName())).toList();
        try (FileWriter writer = new FileWriter(defaultFileName)) {
            /*defaultFileName.getBytes(Charset.forName("UTF-8")*/
            for (var projector : sort) {
                if (nameOfFields.isEmpty()) {
                    nameOfFields.add(projector.getHeadersSmarter());
                    writer.write(projector.getHeadersSmarter());
                    writer.write("\r\n");
                    writer.write(projector.toCSVSmarter());
                    writer.write("\r\n");
                } else if (nameOfFields.contains(projector.getHeadersSmarter())) {
                    writer.write(projector.toCSVSmarter());
                    writer.write("\r\n");
                } else {
                    nameOfFields.add(projector.getHeadersSmarter());
                    writer.write(projector.getHeadersSmarter());
                    writer.write("\r\n");
                    writer.write(projector.toCSVSmarter());
                    writer.write("\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defaultFileName;
    }

    public static void main(String... strings) {
        AbstractProjectorWriter writer = new AbstractProjectorWriter();

        writer.writeToFile(List.of(
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
}
