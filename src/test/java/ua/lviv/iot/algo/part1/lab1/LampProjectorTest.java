package ua.lviv.iot.algo.part1.lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LampProjectorTest {

    private final LampProjector lampProjector = LampProjector
            .init().
            connectedDevice("HDMI")
            .resolution("1920x1080").model("Panasonic").lampHours(5)
            .descriptionOfTheInformationOutputMode("sport").
            theMaximumPermissibleLampOperatingTime(5)
            .constructor();

    @Test
    void increaseLampHours() {

        assertEquals(10, lampProjector.increaseLampHours(5));
    }

    @Test
    void addInputDevice() throws Exception {
        var arrayDevices = new ArrayList<String>();

        arrayDevices.add("HDMI");
        arrayDevices.add("VGA");
        arrayDevices.add("USB");

        if (lampProjector.addInputDevice("HDMI").equals(arrayDevices.get(0))) {
            assertEquals(arrayDevices.get(0), lampProjector.getConnectedDevice());
        } else if (lampProjector.addInputDevice("HDMI").equals(arrayDevices.get(1))) {
            assertEquals(arrayDevices.get(1), lampProjector.getConnectedDevice());
        } else if (lampProjector.addInputDevice("HDMI").equals(arrayDevices.get(2))) {
            assertEquals(arrayDevices.get(2), lampProjector.getConnectedDevice());
        } else {
            throw new Exception("not valid variable");
        }
    }

    @Test
    void disconnectDevice() {
        assertNull(lampProjector.disconnectDevice());
    }

    @Test
    void getRemainingWorkingHours() throws Exception {
        if (lampProjector.getRemainingWorkingHours() < 0) {
            throw new Exception("working hours cant be less than zero");
        }
        assertEquals(5, lampProjector.getRemainingWorkingHours());
    }
}