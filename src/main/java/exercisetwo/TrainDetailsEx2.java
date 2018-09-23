package exercisetwo;

import exercisetwo.stationdemand.TrainRouteProcessor;

import java.util.List;
import java.util.Scanner;

/**
 * Solution to Exercise 2.
 */
public class TrainDetailsEx2 {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Start console to process user's inputs.
     * @param args ignored.
     */
    public static void main (String args[]) {

        TrainRouteProcessor trainRouteProcessor = new TrainRouteProcessor();
        String userInput;

        System.out.println("Please enter a list of stations on the route, in order, each station with a comma between.");
        System.out.println("For example: Waterloo,Surbiton,Esher,Hersham,Walton-on-Thames,Woking");

        userInput = scanner.nextLine();
        trainRouteProcessor.addInitialStations(userInput);

        System.out.println("----------------");
        List<String> allStations = trainRouteProcessor.getStationsInOrder();
        int i = 0;

        System.out.println("Please enter a comma delimited list of passnger numbers for each station on the previously entered route.");
        System.out.println("The current starting station is: " + allStations.get(i));

        while(scanner.hasNextLine() && !((userInput = scanner.nextLine()).equals("exit"))) {
            trainRouteProcessor.addStationInformation(allStations.get(i), userInput);
            i++;
            if ( i >= allStations.size()) {
                break;
            }
            System.out.println("The current starting station is: " + allStations.get(i));
        }

        System.out.println("----------------");
        System.out.println("Printing a matrix of the stations and data entered:");
        trainRouteProcessor.printStationMatrix();

        System.out.println("----------------");
        System.out.println("Printing the stations with the maximum demand:");
        trainRouteProcessor.printMaxDemand();

        System.out.println("----------------");
        System.out.println("Please enter the minimum demand for investigation (as an integer):");
        userInput = scanner.nextLine();
        trainRouteProcessor.printMinimumDemand(userInput);
    }
}
