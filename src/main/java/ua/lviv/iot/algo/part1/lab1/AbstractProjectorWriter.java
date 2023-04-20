package ua.lviv.iot.algo.part1.lab1;

import java.io.*;
import java.util.*;


public class AbstractProjectorWriter {

    public String writeToFile (List<AbstractProjector> projectors) {
        if (projectors == null || projectors.isEmpty()) {
            return null;
        }
        String defaultFileName = "result.csv";
        List<String> nameOfColons = new LinkedList<>();          //Collections.newSetFromMap(new ConcurrentHashMap<>())

        try (FileWriter writer = new FileWriter(defaultFileName)) {
            for (var projector : projectors) {
                if (nameOfColons.isEmpty()) {
                    nameOfColons.add(projector.getHeadersSmarter());
                    writer.write(projector.getHeadersSmarter());
                    writer.write("\r\n");
                    writer.write(projector.toCSVSmarter());
                    writer.write("\r\n");
                } else if (nameOfColons.contains(projector.getHeadersSmarter())) {
                    writer.write(projector.toCSVSmarter());
                    writer.write("\r\n");
                } else {
                    nameOfColons.add(projector.getHeadersSmarter());
                    writer.write(projector.getHeadersSmarter());
                    writer.write("\r\n");
                    writer.write(projector.toCSVSmarter());
                    writer.write("\r\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return defaultFileName;
    }


    public static void main(String[] args) {
        AbstractProjectorWriter writer = new AbstractProjectorWriter();

        writer.writeToFile(List.of(LampProjector.init().
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
