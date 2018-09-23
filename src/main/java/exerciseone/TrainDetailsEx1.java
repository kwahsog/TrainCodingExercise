package exerciseone;

import exerciseone.traindetails.TrainRequestProcessor;

import java.util.Scanner;

/**
 * Main class to provide solution for Exercise 1.
 */
public class TrainDetailsEx1 {

    /**
     * Load data in from text file and open console for user input.
     * @param args ignored.
     */
    public static void main (String args[]) {

        String inputFile = "src/main/resources/data/TrainDetailsFeed.txt";
        TrainRequestProcessor trainRequestProcessor = new TrainRequestProcessor();
        trainRequestProcessor.loadContent(inputFile);

        String userInput;

        System.out.println("Loading resources...");
        System.out.println("Enter the train type, followed by a comma, followed by the gear number to return the maximum speed for a train.");
        System.out.println("For example: 156A,1");
        System.out.println("Enter the gear type to return the best train type with the lowest energy consumption.");
        System.out.println("For example: 1");
        System.out.println("Enter exit to quit.");
        try (Scanner sc = new Scanner(System.in)) {
            while(sc.hasNextLine() && !((userInput = sc.nextLine()).equals("exit"))) {
                System.out.println(trainRequestProcessor.processInput(userInput));
            }
        } finally {
            System.out.println("Program closing.");
        }
    }
}
