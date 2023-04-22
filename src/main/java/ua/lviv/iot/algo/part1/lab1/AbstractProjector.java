package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Getter
@Setter
@SuperBuilder(builderMethodName = "init", buildMethodName = "constructor", toBuilder = true, setterPrefix = "")
@ToString
public abstract class AbstractProjector {
  private String model;
  private String resolution;
  private String connectedDevice;

  public abstract String addInputDevice(String device);

  public abstract String disconnectDevice();

  public abstract double getRemainingWorkingHours();
}
