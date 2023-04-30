package ua.lviv.iot.algo.part1.modules;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TreeDProjectorTest {

    private final TreeDProjector treeDProjector =
            TreeDProjector
                    .init()
                    .model("Panasonic").resolution("4k")
                    .connectedDevice("bxx").guarantee(4)
                    .energyConsumption(30).constructor();


    @Test
    public void addInputDevice() throws Exception {

        var arrayDevices = new ArrayList<String>();

        arrayDevices.add("HDMI");
        arrayDevices.add("VGA");
        arrayDevices.add("USB");

        if (treeDProjector.addInputDevice("HDMI").equals(arrayDevices.get(0))) {
            assertEquals(arrayDevices.get(0), treeDProjector.getConnectedDevice());
        } else if (treeDProjector.addInputDevice("HDMI").equals(arrayDevices.get(1))) {
            assertEquals(arrayDevices.get(1), treeDProjector.getConnectedDevice());
        } else if (treeDProjector.addInputDevice("HDMI").equals(arrayDevices.get(2))) {
            assertEquals(arrayDevices.get(2), treeDProjector.getConnectedDevice());
        } else {
            throw new Exception("not valid variable");
        }
    }

    @Test
    public void disconnectDevice() {

        assertNull(treeDProjector.disconnectDevice());
    }

    @Test
    public void getRemainingWorkingHours() {

        assertEquals(14600.0, treeDProjector.getRemainingWorkingHours());
    }
}