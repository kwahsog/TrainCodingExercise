package exercisethree.driveranddelaydetails;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

/**
 * Tests for TrainDataProcessor class.
 */
public class TrainDataProcessorTest {

    @Test
    void loadContentTrainDriverDetailsTest() {
        TrainDataProcessor trainDataProcessor = new TrainDataProcessor();

        String testFile = "src/test/resources/data/DriverAndDelayDetails.txt";
        trainDataProcessor.loadContent(testFile);

        assertEquals(6, trainDataProcessor.getTrainDriverDetails().size());

        TrainDriverDetails driverOne = new TrainDriverDetails("2C33", "London Waterloo", "Staines", "Barry Williams", "INPROGRESS");
        TrainDriverDetails driverTwo = new TrainDriverDetails("2C33", "Virginia Water", "Winnersh", "Alastair Philps", "INPROGRESS");
        TrainDriverDetails driverThree = new TrainDriverDetails("2D29", "London Waterloo", "Guildford", "John Major", "COMPLETED");
        TrainDriverDetails driverFour = new TrainDriverDetails("2F29", "London Waterloo", "Surbiton", "John Scott", "INPROGRESS");
        TrainDriverDetails driverFive = new TrainDriverDetails("2F29", "Esher", "Weybridge", "Shane Watson", "INPROGRESS");
        TrainDriverDetails driverSix = new TrainDriverDetails("5Y41", "London Waterloo", "Clapham Yard Sidings", "Andrew Lees", "COMPLETED");

        assertEquals(driverOne, trainDataProcessor.getTrainDriverDetails().get(0));
        assertEquals(driverTwo, trainDataProcessor.getTrainDriverDetails().get(1));
        assertEquals(driverThree, trainDataProcessor.getTrainDriverDetails().get(2));
        assertEquals(driverFour, trainDataProcessor.getTrainDriverDetails().get(3));
        assertEquals(driverFive, trainDataProcessor.getTrainDriverDetails().get(4));
        assertEquals(driverSix, trainDataProcessor.getTrainDriverDetails().get(5));
    }

    @Test
    void loadContentTrainDelayDetailsTest() {
        TrainDataProcessor trainDataProcessor = new TrainDataProcessor();

        String testFile = "src/test/resources/data/DriverAndDelayDetails.txt";
        trainDataProcessor.loadContent(testFile);

        assertEquals(30, trainDataProcessor.getTrainDelayDetails().size());

        TrainDelayDetails delayOne = new TrainDelayDetails("2C33", "London Waterloo",
                LocalDateTime.of(2018, Month.SEPTEMBER, 4, 14, 40), "120");
        TrainDelayDetails delayTwo = new TrainDelayDetails("2C33", "Vauxhall",
                LocalDateTime.of(2018, Month.SEPTEMBER, 4, 14, 44), "110");
        TrainDelayDetails delayLast = new TrainDelayDetails("5Y41", "Clapham Yard Sidings",
                LocalDateTime.of(2018, Month.SEPTEMBER, 4, 14, 58), "NA");

        assertEquals(delayOne, trainDataProcessor.getTrainDelayDetails().get(0));
        assertEquals(delayTwo, trainDataProcessor.getTrainDelayDetails().get(1));
        assertEquals(delayLast, trainDataProcessor.getTrainDelayDetails().get(29));

    }
}
