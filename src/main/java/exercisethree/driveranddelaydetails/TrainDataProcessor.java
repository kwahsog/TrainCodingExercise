package exercisethree.driveranddelaydetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class to load all data from delimited file, then process and store in arrays.
 * Data then can be saved to the database as required.
 */
public class TrainDataProcessor {

    private List<DriverAndDelayEntry> loadedInput;
    private List<TrainDriverDetails> trainDriverDetails;
    private List<TrainDelayDetails> trainDelayDetails;

    public TrainDataProcessor() {
        loadedInput = new ArrayList<>();
        trainDriverDetails = new ArrayList<>();
        trainDelayDetails = new ArrayList<>();
    }

    public List<TrainDriverDetails> getTrainDriverDetails() {
        return trainDriverDetails;
    }

    public List<TrainDelayDetails> getTrainDelayDetails() {
        return trainDelayDetails;
    }

    /**
     * Load raw data in from file location into a string array.
     * @param fileLocation location of file.
     */
    public void loadContent(String fileLocation) {

        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split("\\|"));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred loading the file");
        } catch (IOException e) {
            System.out.println("An error has occurred loading the file");
        }

        this.convertData(content);
        this.processData();
    }

    /**
     * Convert raw string data into a sorted array of DriverAndDelayEntry.
     * @param content raw data array.
     */
    private void convertData(List<String[]> content) {
        try {
            for (int i = 1; i < content.size(); i++) { //ignore header
                DriverAndDelayEntry dataEntry = new DriverAndDelayEntry(content.get(i)[0], content.get(i)[1], LocalDateTime.parse(content.get(i)[2]), content.get(i)[3], content.get(i)[4]);
                loadedInput.add(dataEntry);
            }
        } catch (Exception e) {
            System.out.println("An error has occurred loading the file");
        }

        loadedInput.sort(Comparator.comparing(DriverAndDelayEntry::getTrainId).thenComparing(DriverAndDelayEntry::getActualDepartureTime));

        //OPTIONAL LOGGING
        /*
        for (DriverAndDelayEntry d: loadedInput) {
            System.out.println(d.toString());
        }
        */
    }

    /**
     * Process DriverAndDelayEntry array to populate trainDriverDetails and trainDelayDetails arrays.
     */
    private void processData() {
        int i = 0;
        int j = 0;
        while ( i < loadedInput.size()) {
            boolean found = false;
            TrainDriverDetails tempDetails = new TrainDriverDetails(loadedInput.get(i).getTrainId(), loadedInput.get(i).getStation(),
                    "TBC", loadedInput.get(i).getDriverName(), "INPROGRESS" );

            j = i;
            while (!found) {

                if( (j == loadedInput.size() - 1) || (!loadedInput.get(j).getTrainId().equals(loadedInput.get(j+1).getTrainId())
                        || !(loadedInput.get(j).getDriverName().equals(loadedInput.get(j+1).getDriverName())))) {

                    tempDetails.setToStation(loadedInput.get(j).getStation());
                    if (loadedInput.get(j).getDepartureLateness().equals("NA")) {
                        tempDetails.setJourneyStatus("COMPLETED");
                    }
                    found = true;
                    trainDriverDetails.add(tempDetails);
                } else {
                    j++;
                }
            }
            i = j + 1;
        }

        for (DriverAndDelayEntry k : loadedInput) {
            TrainDelayDetails temp = new TrainDelayDetails(k.getTrainId(), k.getStation(), k.getActualDepartureTime(), k.getDepartureLateness());
            trainDelayDetails.add(temp);
        }

        //OPTIONAL LOGGING:
        /*
        for (TrainDriverDetails t : trainDriverDetails) {
            System.out.println(t.toString());
        }

        System.out.println("----------------------------------------------------");

        for (TrainDelayDetails t : trainDelayDetails) {
            System.out.println(t.toString());
        }
        */
    }
}
