package ua.lviv.iot.algo.part1.lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MultiBoardTest {

    private MultiBoard multiBoard = MultiBoard.init().model("Prestigio").resolution("1920x1080")
            .connectedDevice("HDMI").colorOfSurface("black")
            .isHasMagniteSurface(true).thePossibilityOfRecordingTheScreen(false)
            .guarantee(5).constructor();

    @Test
    void addInputDevice() throws Exception {

        var arrayDevices = new ArrayList<String>();

        arrayDevices.add("HDMI");
        arrayDevices.add("VGA");
        arrayDevices.add("USB");

        if (multiBoard.addInputDevice("HDMI").equals(arrayDevices.get(0))) {
            assertEquals(arrayDevices.get(0), multiBoard.getConnectedDevice());
        } else if (multiBoard.addInputDevice("HDMI").equals(arrayDevices.get(1))) {
            assertEquals(arrayDevices.get(1), multiBoard.getConnectedDevice());
        } else if (multiBoard.addInputDevice("HDMI").equals(arrayDevices.get(2))) {
            assertEquals(arrayDevices.get(2), multiBoard.getConnectedDevice());
        } else {
            throw new Exception("not valid variable");
        }
    }

    @Test
    void disconnectDevice() {

        assertNull(multiBoard.disconnectDevice());
    }

    @Test
    void getRemainingWorkingHours() throws Exception {
        if(multiBoard.getRemainingWorkingHours() < 0){
            throw new Exception("working hours cant be less than zero");
        }
        assertEquals(18250.0, multiBoard.getRemainingWorkingHours());
    }

    @Test
    void testToString() {
        ToStringVerifier.forClass(MultiBoard.class).verify();
    }

    @Test
    void getColorOfSurface() throws Exception {
        if(multiBoard.getRemainingWorkingHours() < 0 ){
            throw  new Exception("working hours cant be less than zero");
        }
        assertEquals(18250.0, multiBoard.getRemainingWorkingHours());
    }
}