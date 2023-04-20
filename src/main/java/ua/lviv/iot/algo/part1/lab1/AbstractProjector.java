package ua.lviv.iot.algo.part1.lab1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Field;
import java.util.*;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Getter
@Setter
@SuperBuilder(builderMethodName = "init",
        buildMethodName = "constructor",
        toBuilder = true, setterPrefix = "")
@ToString
public abstract class AbstractProjector {
    private String model;
    private String resolution;
    private String connectedDevice;

    public abstract String addInputDevice(String device);

    public abstract String disconnectDevice();

    public abstract double getRemainingWorkingHours();

    public String getHeadersSmarter() {
//        return "model," + "resolution," + "connectedDevice"
        Class<?> clazz = this.getClass().getSuperclass();
        Field[] fields;
        String result = "";
        try {
            for (int i = 0; i < 2; i++) {
                fields = clazz.getDeclaredFields();
                for (var field : fields) {
                    field.setAccessible(true);
                    result += field.getName();
                    result += ",";
                }
                clazz = this.getClass();
            }
            String newResult = result.substring(0,result.length()-1);
            return newResult;
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String toCSVSmarter() {
        Class<?> clazz = this.getClass().getSuperclass();
        Field[] fields;
        String result = "";
        try {
            for(int i=0; i<2; i++){
                fields = clazz.getDeclaredFields();
                for(var field:fields){
                    field.setAccessible(true);
                    result += field.get(this);
                    result += ",";
                }
                clazz = this.getClass();
            }
            String newResult = result.substring(0,result.length()-1);
            return newResult;
        }catch (SecurityException | IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }
}
