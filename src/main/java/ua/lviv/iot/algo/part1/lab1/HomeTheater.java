package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@ToString(callSuper = true)
@SuperBuilder(builderMethodName = "init", buildMethodName = "constructor", toBuilder = true, setterPrefix = "")
@Getter
@Setter
public class HomeTheater extends AbstractProjector {

  private double yearOfASale;
  private double screenSizeInInches;
  private String versionOfSmartTV;
  private double guarantee;
  private static final double WORKING_HOURS_PER_YEAR = 3650;

  @Override
  public String addInputDevice(String device) {
      setConnectedDevice(device);
      return getConnectedDevice();
  }

  @Override
  public String disconnectDevice() {
      setConnectedDevice(null);
      return getConnectedDevice();
  }

  @Override
  public double getRemainingWorkingHours() {
        return guarantee * WORKING_HOURS_PER_YEAR;
    }
}
