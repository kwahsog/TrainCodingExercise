package exerciseone.traindetails;

import exerciseone.traindetails.Train;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Train class.
 */
public class TrainTest {

    @Test
    void toStringMaxSpeedRequestTest() {
        Train trainOne = new Train("156A", 1, 10 ,50);
        assertEquals("The max speed for this train is: 10" ,trainOne.toStringMaxSpeedRequest());
    }

    @Test
    void toStringTrainAndEnergyRequestTest() {
        Train trainOne = new Train("156A", 1, 10 ,50);
        assertEquals("The best train type for this gear is: 156A with the energy consumption of: 50", trainOne.toStringTrainAndEnergyRequest());
    }
}
