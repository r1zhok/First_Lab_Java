package ua.lviv.iot.algo.part1.lab1;

import com.jparams.verifier.tostring.ToStringVerifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HomeTheaterTest {

    private HomeTheater homeTheater = HomeTheater.init().model("Samsung").resolution("4k")
            .connectedDevice("HDMI, USB").yearOfASale(2023)
            .screenSizeInInches(57).versionOfSmartTV("last")
            .guarantee(5).constructor();

    @Test
    void addInputDevice() throws Exception {

        var arrayDevices = new ArrayList<String>();

        arrayDevices.add("HDMI");
        arrayDevices.add("VGA");
        arrayDevices.add("USB");

        if (homeTheater.addInputDevice("HDMI").equals(arrayDevices.get(0))) {
            assertEquals(arrayDevices.get(0), homeTheater.getConnectedDevice());
        } else if (homeTheater.addInputDevice("HDMI").equals(arrayDevices.get(1))) {
            assertEquals(arrayDevices.get(1), homeTheater.getConnectedDevice());
        } else if (homeTheater.addInputDevice("HDMI").equals(arrayDevices.get(2))) {
            assertEquals(arrayDevices.get(2), homeTheater.getConnectedDevice());
        } else {
            throw new Exception("not valid variable");
        }
    }

    @Test
    void disconnectDevice() {
        assertNull(homeTheater.disconnectDevice());
    }

    @Test
    void getRemainingWorkingHours() throws Exception {
        if(homeTheater.getRemainingWorkingHours() < 0 ){
            throw  new Exception("working hours cant be less than zero");
        }
        assertEquals(18250.0, homeTheater.getRemainingWorkingHours());
    }

    @Test
    void testToString() {
        ToStringVerifier.forClass(HomeTheater.class).verify();
    }

    @Test
    void getYearOfASale() {

        assertEquals(2023, homeTheater.getYearOfASale());
    }

    @Test
    void init() {
    }

    @Test
    void toBuilder() {
    }
}