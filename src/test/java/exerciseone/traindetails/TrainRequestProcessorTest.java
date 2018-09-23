package exerciseone.traindetails;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests for TrainRequestProcessor class.
 */
public class TrainRequestProcessorTest {

    @Test
    void processContentTest() {
        TrainRequestProcessor trainRequestProcessor = new TrainRequestProcessor();

        Train trainOne = new Train("156A", 1, 10 ,50);
        Train trainTwo = new Train("156A", 1, 20 ,100);
        Train trainThree = new Train("156A", 2, 30 ,80);

        String[] headers = {"TrainType", "Gear", "Speed(KMPH)", "Energy(KWH)"};
        String[] testDataOne =  {"156A", "1" , "10", "50"};
        String[] testDataTwo =  {"156A", "1" , "20", "100"};
        String[] testDataThree =  {"156A", "2" , "30", "80"};

        List<String[]> content = new ArrayList<>();
        content.add(headers);
        content.add(testDataOne);
        content.add(testDataTwo);
        content.add(testDataThree);

        trainRequestProcessor.processContent(content);

        assertEquals(3, trainRequestProcessor.getTrains().size());
        assertEquals(trainOne, trainRequestProcessor.getTrains().get(0));
        assertEquals(trainTwo, trainRequestProcessor.getTrains().get(1));
        assertEquals(trainThree, trainRequestProcessor.getTrains().get(2));
    }

    @Test
    void loadContentTest() {
        TrainRequestProcessor trainRequestProcessor = new TrainRequestProcessor();
        String csvFile = "src/test/resources/data/TrainDetailsFeed.txt";
        trainRequestProcessor.loadContent(csvFile);
        Train trainOne = new Train("156A", 1, 10 ,50);
        Train trainTwo = new Train("156A", 1, 20 ,100);
        Train trainElven = new Train("201V", 2, 45 ,200);

        assertEquals(11, trainRequestProcessor.getTrains().size());
        assertEquals(trainOne, trainRequestProcessor.getTrains().get(0));
        assertEquals(trainTwo, trainRequestProcessor.getTrains().get(1));
        assertEquals(trainElven, trainRequestProcessor.getTrains().get(10));
    }

    @Test
    void processInputTest() {
        TrainRequestProcessor trainRequestProcessor = new TrainRequestProcessor();
        String testFile = "src/test/resources/data/TrainDetailsFeed.txt";
        trainRequestProcessor.loadContent(testFile);

        assertEquals("The max speed for this train is: 20 (KMPH)", trainRequestProcessor.processInput("156A,1"));
        assertEquals("The max speed for this train is: 40 (KMPH)", trainRequestProcessor.processInput("156A,2"));
        assertEquals("The max speed for this train is: 30 (KMPH)", trainRequestProcessor.processInput("157P,1"));
        assertEquals("The max speed for this train is: 50 (KMPH)", trainRequestProcessor.processInput("157P,2"));
        assertEquals("The max speed for this train is: 40 (KMPH)", trainRequestProcessor.processInput("201V,1"));
        assertEquals("The max speed for this train is: 45 (KMPH)", trainRequestProcessor.processInput("201V,2"));

        assertEquals("The best train type for this gear is: 157P with the energy consumption of: 40 (KWH)", trainRequestProcessor.processInput("1"));
        assertEquals("The best train type for this gear is: 156A with the energy consumption of: 80 (KWH)", trainRequestProcessor.processInput("2"));


        assertEquals("No details found", trainRequestProcessor.processInput("3"));
        assertEquals("No details found", trainRequestProcessor.processInput("Invalid,3"));
        assertEquals("No details found", trainRequestProcessor.processInput("157P,3"));
        assertEquals("No details found", trainRequestProcessor.processInput("###///"));
    }

}
