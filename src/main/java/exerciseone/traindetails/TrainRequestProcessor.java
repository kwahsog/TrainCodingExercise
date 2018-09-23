package exerciseone.traindetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to process data from file feed and process users inputs.
 */
public class TrainRequestProcessor {

    private List<Train> trains;

    /**
     * Default constructor.
     */
    public TrainRequestProcessor() {
        trains = new ArrayList<>();
    }

    /**
     * Return list of all trains from the loaded in data.
     * @return arraylist of trains.
     */
    public List<Train> getTrains() {
        return trains;
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
                content.add(line.split("-"));
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred loading the file");
        } catch (IOException e) {
            System.out.println("An error has occurred loading the file");
        }

        this.processContent(content);
    }

    /**
     * Convert raw string data into an array of trains.
     * @param content raw data array.
     */
    public void processContent(List<String[]> content) {
        try {
            for (int i = 1; i < content.size(); i++) { //ignore header
                Train tempTrain = new Train(content.get(i)[0], Integer.parseInt(content.get(i)[1]), Integer.parseInt(content.get(i)[2]), Integer.parseInt(content.get(i)[3]));
                trains.add(tempTrain);
            }
        } catch (Exception e) {
            System.out.println("An error has occurred loading the file");
        }
    }

    /**
     * Classify message based on users input.
     * @param userInput user's string input.
     * @return enum representing the type of the users input.
     */
    private CommandType getCommandType(String userInput) {
        if (userInput.contains(",")) {
            return CommandType.MAXSPEED;
        }
        int temp = 0;
        try {
            temp = Integer.parseInt(userInput);
            return CommandType.TRAINTYPEANDENERGY;
        } catch (NumberFormatException ex) {
            return CommandType.INVALID;
        }
    }

    /**
     * Classify user input then process request as required, returning result of the request.
     * @param userInput user's input.
     * @return result of the request.
     */
    public String processInput(String userInput) {

        CommandType commandType = this.getCommandType(userInput);

        if (commandType == CommandType.MAXSPEED) {
            return this.processMaxSpeedRequest(userInput);
        } else if (commandType == CommandType.TRAINTYPEANDENERGY) {
            return this.processTrainAndEnergyRequest(userInput);
        }

        return "No details found";
    }

    /**
     * Process request for max speed.
     * @param userInput user's input.
     * @return result of the request.
     */
    private String processMaxSpeedRequest(String userInput) {

        Train bestTrain = null;

        String[] inputArray = userInput.split(",");
        if (inputArray.length != 2) {
            return "No details found";
        }
        for (Train train : trains) {
            if (train.getTrainType().equals(inputArray[0]) && Integer.parseInt(inputArray[1]) == train.getGear()) {
                if (bestTrain == null) {
                    bestTrain = train;
                } else if (train.getSpeedKMPH() > bestTrain.getSpeedKMPH()) {
                    bestTrain = train;
                }
            }
        }
        if (bestTrain != null) {
            return bestTrain.toStringMaxSpeedRequest();
        } else {
            return "No details found";
        }
    }

    /**
     * Process request for best train and it's energy consumption.
     * @param userInput user's input.
     * @return result of the request.
     */
    private String processTrainAndEnergyRequest(String userInput) {
        Train bestTrain = null;
        int gear = 0;
        try {
            gear = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return "No details found";
        }
        for (Train train : trains) {
            if (train.getGear() == gear) {
                if (bestTrain == null) {
                    bestTrain = train;
                } else if (train.getEnergyKHW() < bestTrain.getEnergyKHW()) {
                    bestTrain = train;
                }
            }
        }
        if (bestTrain != null) {
            return bestTrain.toStringTrainAndEnergyRequest();
        } else {
            return "No details found";
        }
    }
}
