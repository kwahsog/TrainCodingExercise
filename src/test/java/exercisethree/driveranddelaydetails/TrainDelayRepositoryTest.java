package exercisethree.driveranddelaydetails;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Example test class for TrainDelayRepository.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainDelayRepositoryTest {

    @Autowired
    TrainDelayRepository trainDelayRepository;

    TrainDelayDetails delayOne, delayTwo;

    @Before
    public void setUp() {

        trainDelayRepository.deleteAll();

        delayOne = trainDelayRepository.save(new TrainDelayDetails("2C33", "London Waterloo",
                LocalDateTime.of(2018, Month.SEPTEMBER, 4, 14, 40), "120"));
        delayTwo = trainDelayRepository.save(new TrainDelayDetails("5Y41", "Clapham Yard Sidings",
                LocalDateTime.of(2018, Month.SEPTEMBER, 4, 14, 58), "NA"));
    }

    @Test
    public void findByTrainIdTest() {
        List<TrainDelayDetails> result = trainDelayRepository.findByTrainId("2C33");
        assertEquals(1, result.size());
        assertEquals(delayOne, result.get(0));

        List<TrainDelayDetails> resultTwo = trainDelayRepository.findByTrainId("5Y41");
        assertEquals(1, resultTwo.size());
        assertEquals(delayTwo, resultTwo.get(0));
    }

    @Test
    public void findAllTest() {
        List<TrainDelayDetails> result = trainDelayRepository.findAll();
        assertEquals(2, result.size());
    }
}
