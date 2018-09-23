package exercisethree;

import exercisethree.driveranddelaydetails.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainDetailsEx3 implements CommandLineRunner {

    private TrainDataProcessor trainDataProcessor;

    @Autowired
    private TrainDelayRepository trainDelayRepository;

    @Autowired
    private TrainDriverRepository trainDriverRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrainDetailsEx3.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String csvFile = "src/main/resources/data/DriverAndDelayDetails.txt";

        trainDataProcessor = new TrainDataProcessor();
        trainDataProcessor.loadContent(csvFile);

        for (TrainDelayDetails t : trainDataProcessor.getTrainDelayDetails()) {
            trainDelayRepository.save(t);
        }

        for (TrainDriverDetails t : trainDataProcessor.getTrainDriverDetails()) {
            trainDriverRepository.save(t);
        }

        //OPTIONAL LOGGING
        /*
        for (TrainDelayDetails xx : trainDelayRepository.findAll()) {
            System.out.println(xx);
        }
        System.out.println("------------------------------------------------------");
        for (TrainDriverDetails xy : trainDriverRepository.findAll()) {
            System.out.println(xy);
        }
        */
    }
}
