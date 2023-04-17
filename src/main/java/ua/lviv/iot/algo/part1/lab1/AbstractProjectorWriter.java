package ua.lviv.iot.algo.part1.lab1;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class AbstractProjectorWriter {

    public String writeToFile(List<AbstractProjector> projectors) throws IOException {
        if (projectors == null) {
            return null;
        }
        String defaultFileName = "result.csv";
        List<String> nameOfColons = new LinkedList<>();          //Collections.newSetFromMap(new ConcurrentHashMap<>())
        List<Field> fields = new LinkedList<>();
        try (FileWriter writer = new FileWriter(defaultFileName)) {
            for (var projector : projectors) {
                fields.addAll(List.of(projector.getClass().getSuperclass().getDeclaredFields()));

                for (int i = 0; i < 2; i++) {

                    for (var field : fields) {
                        field.setAccessible(true);
                        if (nameOfColons.isEmpty()) {
                            nameOfColons.add(field.getName());
                        } else if (!nameOfColons.contains(field.getName())) {
                            nameOfColons.add(field.getName());
                        }
                    }
                    fields.addAll(List.of(projector.getClass().getDeclaredFields()));
                }
            }
            for (int i = 0; i < nameOfColons.size(); i++){
                writer.write(nameOfColons.get(i));
                if (i < nameOfColons.size() - 1){
                    writer.write(",");
                }
            }
            fields.clear();
            for (var projector: projectors){
                writer.write(System.getProperty("line.separator"));
                List<Field> parentFields = List.of(projector.getClass().getSuperclass().getDeclaredFields());
                List<Field> childFields = List.of(projector.getClass().getDeclaredFields());
                for (var field: nameOfColons){
                    int fieldNull = 0;
                    for (var parentField: parentFields){
                        if (parentField.getName().equals(field)){
                            parentField.setAccessible(true);
                            writer.write(String.valueOf(parentField.get(projector)));
                            fieldNull++;
                        }
                    }
                    for (var childField: childFields){
                        if (childField.getName().equals(field)){
                            childField.setAccessible(true);
                            writer.write(String.valueOf(childField.get(projector)));
                            fieldNull++;
                        }
                    }
                    if (fieldNull == 0){
                        writer.write("no data");
                    }
                    if (!field.equals(nameOfColons.get(nameOfColons.size() - 1))){
                        writer.write(",");
                    }
                }
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return defaultFileName;
    }



    public static void main(String[] args) throws IOException {
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
